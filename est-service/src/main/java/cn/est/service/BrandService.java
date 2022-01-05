package cn.est.service;
import  cn.est.po.Brand;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface BrandService {

    public Brand getBrandById(Long id);

    public List<Brand>	getBrandListByMap(Map<String,Object> param);

    public Integer getBrandCountByMap(Map<String,Object> param);

    public Integer qdtxAddBrand(Brand brand);

    public Integer qdtxModifyBrand(Brand brand);

    public Integer qdtxDeleteBrandById(Long id);

    public Integer qdtxBatchDeleteBrand(String ids);

    public Page<Brand> queryBrandPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
