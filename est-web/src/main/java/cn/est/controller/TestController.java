package cn.est.controller;

import cn.est.dto.Result;
import cn.est.utils.RedisUtils;
import cn.est.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sheng
 * @date 2021/12/31 - 9:40
 */
@Api("这是Redis测试接口")
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "测试Redis",notes = "测试Redis")
    @RequestMapping(value = "/testReids",method = RequestMethod.POST)
    @ResponseBody
    public Result testRedis(){
        redisUtils.set("name","123456");
        Object value=redisUtils.get("name");
        return ResultUtils.returnDataSuccess(value);
    }
}
