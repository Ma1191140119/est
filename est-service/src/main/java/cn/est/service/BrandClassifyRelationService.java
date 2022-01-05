package cn.est.service;
import  cn.est.po.BrandClassifyRelation;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface BrandClassifyRelationService {

    public BrandClassifyRelation getBrandClassifyRelationById(Long id);

    public List<BrandClassifyRelation>	getBrandClassifyRelationListByMap(Map<String,Object> param);

    public Integer getBrandClassifyRelationCountByMap(Map<String,Object> param);

    public Integer qdtxAddBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation);

    public Integer qdtxModifyBrandClassifyRelation(BrandClassifyRelation brandClassifyRelation);

    public Integer qdtxDeleteBrandClassifyRelationById(Long id);

    public Integer qdtxBatchDeleteBrandClassifyRelation(String ids);

    public Page<BrandClassifyRelation> queryBrandClassifyRelationPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
