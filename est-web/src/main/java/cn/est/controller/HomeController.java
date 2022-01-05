package cn.est.controller;

import cn.est.dto.Result;
import cn.est.service.BrandClassifyRelationService;
import cn.est.service.BrandService;
import cn.est.service.ClassifyService;
import cn.est.service.ModelService;
import cn.est.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sheng
 * @date 2022/1/5 - 9:02
 */
@RestController
public class HomeController {
    @Resource
    private ClassifyService classifyService;

    @GetMapping("/api/home/classifyTree")
    public Result getTree(){
        return classifyService.getTree();
    }
}
