package cn.est.controller;

import cn.est.constants.Constants;
import cn.est.dto.Result;
import cn.est.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sheng
 * @date 2021/12/31 - 11:29
 */
@RestController
public class SmsController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SendSms sendSms;
    @PostMapping("/api/sms/verifyCode")
    public Result verifyCode(String phone, Integer codeType) {
        //判断手机号的格式是否合法
        if (StringUtil.isBlank(phone)) {
            return ResultUtils.returnFail("手机号不允许为空");
        }
        //codeType是否合法
        if (codeType == null) {
            return ResultUtils.returnFail("codeType不合法");
        }
        if (codeType==Constants.Sms.SmsType.REGIST_OR_LOGIN){//注册登录验证码
            String codeKey = StringUtil.formatKeyWithPrefix(Constants.RedisKey.PREFIX_SMS,phone,Constants.Sms.SmsType.REGIST_OR_LOGIN+"");
            String code = redisUtils.getValue(codeKey);
            if(!StringUtil.isBlank(code)) {
                return ResultUtils.returnFail("60秒内不能重复发送");
            }
            code = MathUtils.random();
            boolean b = sendSms.sendSms(phone, code, false);
            if (!b) {
                return ResultUtils.returnFail("发送失败");
            }
            boolean set = redisUtils.set(codeKey, code, 60*5);
            if (set) {
                return ResultUtils.returnSuccess();
            } else {
                return ResultUtils.returnFail();
            }
        }
        return ResultUtils.returnSuccess();
    }

}
