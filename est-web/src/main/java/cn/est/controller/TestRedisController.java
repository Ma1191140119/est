package cn.est.controller;

import cn.est.dto.Result;
import cn.est.utils.RedisUtils;
import cn.est.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sheng
 * @date 2021/12/31 - 8:37
 */
@Controller
@RequestMapping("/test")
public class TestRedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/testRedis",method = RequestMethod.POST)
    @ResponseBody
    public Result testRedis(){
        redisUtils.set("name","123456");
        Object value=redisUtils.get("name");
        return ResultUtils.returnDataSuccess(value);
    }
}