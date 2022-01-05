package cn.est.service.impl;
import cn.est.mapper.StoreMapper;
import cn.est.po.Store;
import cn.est.service.StoreService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    public Store getStoreById(Long id){
        return storeMapper.getStoreById(id);
    }

    public List<Store>	getStoreListByMap(Map<String,Object> param){
        return storeMapper.getStoreListByMap(param);
    }

    public Integer getStoreCountByMap(Map<String,Object> param){
        return storeMapper.getStoreCountByMap(param);
    }

    public Integer qdtxAddStore(Store store){
            store.setCreatdTime(new Date());
            return storeMapper.insertStore(store);
    }

    public Integer qdtxModifyStore(Store store){
        store.setUpdatedTime(new Date());
        return storeMapper.updateStore(store);
    }

    public Integer qdtxDeleteStoreById(Long id){
        return storeMapper.deleteStoreById(id);
    }

    public Integer qdtxBatchDeleteStore(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return storeMapper.batchDeleteStore(param);
    }

    public Page<Store> queryStorePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = storeMapper.getStoreCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Store> storeList = storeMapper.getStoreListByMap(param);
        page.setList(storeList);
        return page;
     }


}
