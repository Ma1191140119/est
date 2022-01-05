package cn.est.service.impl;
import cn.est.mapper.BrandClassifyRelationMapper;
import cn.est.po.BrandClassifyRelation;
import cn.est.service.BrandClassifyRelationService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class BrandClassifyRelationServiceImpl implements BrandClassifyRelationService {

    @Autowired
    private BrandClassifyRelationMapper brandClassifyRelationMapper;

    public BrandClassifyRelation getBrandClassifyRelationById(Long id){
        return brandClassifyRelationMapper.getBrandClassifyRelationById(id);
    }

    public List<BrandClassifyRelation>	getBrandClassifyRelationListByMap(Map<String,Object> param){
        return brandClassifyRelationMapper.getBrandClassifyRelationListByMap(param);
    }

    public Integer getBrandClassifyRelationCountByMap(Map<String,Object> param){
        return brandClassifyRelationMapper.getBrandClassifyRelationCountByMap(param);
    }

    public Integer qdtxAddBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation){
            brandClassifyRelation.setCreatdTime(new Date());
            return brandClassifyRelationMapper.insertBrandClassifyRelation(brandClassifyRelation);
    }

    public Integer qdtxModifyBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation){
        brandClassifyRelation.setUpdatedTime(new Date());
        return brandClassifyRelationMapper.updateBrandClassifyRelation(brandClassifyRelation);
    }

    public Integer qdtxDeleteBrandClassifyRelationById(Long id){
        return brandClassifyRelationMapper.deleteBrandClassifyRelationById(id);
    }

    public Integer qdtxBatchDeleteBrandClassifyRelation(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return brandClassifyRelationMapper.batchDeleteBrandClassifyRelation(param);
    }

    public Page<BrandClassifyRelation> queryBrandClassifyRelationPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = brandClassifyRelationMapper.getBrandClassifyRelationCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<BrandClassifyRelation> brandClassifyRelationList = brandClassifyRelationMapper.getBrandClassifyRelationListByMap(param);
        page.setList(brandClassifyRelationList);
        return page;
     }


}
