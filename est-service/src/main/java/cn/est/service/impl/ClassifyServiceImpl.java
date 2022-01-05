package cn.est.service.impl;
import cn.est.dto.Result;
import cn.est.mapper.BrandClassifyRelationMapper;
import cn.est.mapper.BrandMapper;
import cn.est.mapper.ClassifyMapper;
import cn.est.mapper.ModelMapper;
import cn.est.po.Brand;
import cn.est.po.BrandClassifyRelation;
import cn.est.po.Classify;
import cn.est.po.Model;
import cn.est.service.BrandClassifyRelationService;
import cn.est.service.BrandService;
import cn.est.service.ClassifyService;
import cn.est.dto.Page;
import cn.est.service.ModelService;
import cn.est.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

    public Classify getClassifyById(Long id){
        return classifyMapper.getClassifyById(id);
    }

    public List<Classify>	getClassifyListByMap(Map<String,Object> param){
        return classifyMapper.getClassifyListByMap(param);
    }

    public Integer getClassifyCountByMap(Map<String,Object> param){
        return classifyMapper.getClassifyCountByMap(param);
    }

    public Integer qdtxAddClassify(Classify classify){
            classify.setCreatdTime(new Date());
            return classifyMapper.insertClassify(classify);
    }

    public Integer qdtxModifyClassify(Classify classify){
        classify.setUpdatedTime(new Date());
        return classifyMapper.updateClassify(classify);
    }

    public Integer qdtxDeleteClassifyById(Long id){
        return classifyMapper.deleteClassifyById(id);
    }

    public Integer qdtxBatchDeleteClassify(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return classifyMapper.batchDeleteClassify(param);
    }

    public Page<Classify> queryClassifyPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = classifyMapper.getClassifyCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Classify> classifyList = classifyMapper.getClassifyListByMap(param);
        page.setList(classifyList);
        return page;
     }

    @Resource
    private BrandMapper brandMapper;
    @Resource
    private BrandClassifyRelationMapper brandClassifyRelationMapper;
    @Resource
    private ModelMapper modelMapper;

    @Override
    public Result getTree() {
        List<Classify> Classifys = classifyMapper.getClassifyListByMap(null);
        for (Classify classify:Classifys){
            Long classifyId = classify.getId();
            Map params = new HashMap();
            params.put("classifyId",classifyId);
            List<BrandClassifyRelation> cbr = brandClassifyRelationMapper.getBrandClassifyRelationListByMap(params);
            List<Brand> brandList = new ArrayList<>();
            classify.setGetBrandList(brandList);

            for (BrandClassifyRelation cb:cbr){
                Long brandId = cb.getBrandId();
                Brand brand = brandMapper.getBrandById(brandId);
                brandList.add(brand);
                Map params1 = new HashMap();
                params1.put("classifyId",classifyId);
                params1.put("brandId",brandId);
                List<Model> modelList = modelMapper.getModelListByMap(params1);
                brand.setModelList(modelList);
            }
        }
        return ResultUtils.returnDataSuccess(Classifys);
    }


}
