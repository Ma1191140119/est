package cn.est.service.impl;
import cn.est.mapper.BrandMapper;
import cn.est.po.Brand;
import cn.est.service.BrandService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public Brand getBrandById(Long id){
        return brandMapper.getBrandById(id);
    }

    public List<Brand>	getBrandListByMap(Map<String,Object> param){
        return brandMapper.getBrandListByMap(param);
    }

    public Integer getBrandCountByMap(Map<String,Object> param){
        return brandMapper.getBrandCountByMap(param);
    }

    public Integer qdtxAddBrand(Brand brand){
            brand.setCreatdTime(new Date());
            return brandMapper.insertBrand(brand);
    }

    public Integer qdtxModifyBrand(Brand brand){
        brand.setUpdatedTime(new Date());
        return brandMapper.updateBrand(brand);
    }

    public Integer qdtxDeleteBrandById(Long id){
        return brandMapper.deleteBrandById(id);
    }

    public Integer qdtxBatchDeleteBrand(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return brandMapper.batchDeleteBrand(param);
    }

    public Page<Brand> queryBrandPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = brandMapper.getBrandCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Brand> brandList = brandMapper.getBrandListByMap(param);
        page.setList(brandList);
        return page;
     }


}
