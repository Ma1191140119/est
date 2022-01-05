package cn.est.service;
import  cn.est.po.Store;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface StoreService {

    public Store getStoreById(Long id);

    public List<Store>	getStoreListByMap(Map<String,Object> param);

    public Integer getStoreCountByMap(Map<String,Object> param);

    public Integer qdtxAddStore(Store store);

    public Integer qdtxModifyStore(Store store);

    public Integer qdtxDeleteStoreById(Long id);

    public Integer qdtxBatchDeleteStore(String ids);

    public Page<Store> queryStorePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
