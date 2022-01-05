package cn.est.controller;

import cn.est.constants.Constants;
import cn.est.dto.Result;
import cn.est.po.Users;
import cn.est.service.UsersService;
import cn.est.utils.RedisUtils;
import cn.est.utils.ResultUtils;
import cn.est.utils.StringUtil;
import cn.est.utils.UrlUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sheng
 * @date 2022/1/4 - 9:06
 */
@RestController
@RequestMapping("/api/user")
public class LoginController {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UsersService usersService;

    @PostMapping("/login/sms")
    public Result loginSms(String phone, String sms) {
        //1.校验phone，sms
        if (StringUtil.isBlank(phone)) {
            return ResultUtils.returnFail("手机号不符合要求");
        }
        if (StringUtil.isBlank(sms)) {
            return ResultUtils.returnFail("验证码不能为空");
        }
        //2.验证验证码是否正确
        //2.1从redis中取验证码
        String codeKey = StringUtil.formatKeyWithPrefix(Constants.RedisKey.PREFIX_SMS, phone, Constants.Sms.SmsType.REGIST_OR_LOGIN + "");
        String code = redisUtils.getValue(codeKey);
        if (StringUtil.isBlank(code)) {
            return ResultUtils.returnFail("验证码不存在或者已经过期，请重新发送");
        }
        //2.2判断验证码是否一致
        if (!code.equals(sms)) {
            return ResultUtils.returnSuccess("验证码不正确");
        }
        //3.1从数据库中查询是否有此用户
        Map param = new HashMap();
        param.put("account", phone);
        List<Users> usersList = usersService.getUsersListByMap(param);
        Users user = new Users();
        if (usersList != null && usersList.size() > 0) {
            user = usersList.get(0);
        } else {
            user = new Users();
            user.setAccount(phone);
            user.setUserName(phone);
            user.setCreatdTime(new Date());
            Integer integer = usersService.qdtxAddUsers(user);
        }
        //tokenKey:token
        //tokenUsers
        String token = StringUtil.createToken();
        redisUtils.set(token, JSONObject.toJSONString(user));
        redisUtils.delete(codeKey);//删除之前的验证码
        //3.2存在：登录,不存在：注册
        return ResultUtils.returnDataSuccess(StringUtil.createSimpleMap("token", token));
    }

    @GetMapping("login/wechat")
    public void loginWeChat(HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder("https://open.weixin.qq.com/connect/qrconnect?" +
                "appid=wx9168f76f000a0d4c" +
                "&redirect_uri=" + URLEncoder.encode("http://localhost:8080/api/user/login/callback") +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=STATE#wechat_redirect");
        response.sendRedirect(sb.toString());
    }

    @GetMapping("login/callback")
    public void loginWeChat(String code, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder("https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=wx9168f76f000a0d4c" +
                "&secret=8ba69d5639242c3bd3a69dffe84336c1" +
                "&code=" + code +
                "&grant_type=authorization_code");
        String loadURL = UrlUtils.loadURL(sb.toString());
        JSONObject jsonObject = JSONObject.parseObject(loadURL);
        String access_token = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");
        sb=new StringBuilder("https://api.weixin.qq.com/sns/userinfo+" +
                "?access_token="+access_token+
                "openid="+openid);
        loadURL = UrlUtils.loadURL(sb.toString());
        jsonObject = JSONObject.parseObject(loadURL);
        System.out.println("loadURL:"+loadURL);
        String nickname = jsonObject.getString("nickname");
        String headimgurl = jsonObject.getString("headimgurl");
        Map param = new HashMap();
        param.put("openId",openid);
        List<Users> usersList = usersService.getUsersListByMap(param);
        Users user = new Users();
        if (usersList != null && usersList.size() > 0) {
            user = usersList.get(0);
        } else {
            user = new Users();
            user.setOpenId(openid);
            user.setAccount(nickname);
            user.setUserName(nickname);
            user.setFaceUrl(headimgurl);
            Integer integer = usersService.qdtxAddUsers(user);
        }
        redisUtils.set(access_token, JSONObject.toJSONString(user));
        response.sendRedirect("/?token="+access_token);
    }

}
