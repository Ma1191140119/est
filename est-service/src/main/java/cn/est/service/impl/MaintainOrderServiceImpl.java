package cn.est.service.impl;
import cn.est.mapper.MaintainOrderMapper;
import cn.est.po.MaintainOrder;
import cn.est.service.MaintainOrderService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class MaintainOrderServiceImpl implements MaintainOrderService {

    @Autowired
    private MaintainOrderMapper maintainOrderMapper;

    public MaintainOrder getMaintainOrderById(Long id){
        return maintainOrderMapper.getMaintainOrderById(id);
    }

    public List<MaintainOrder>	getMaintainOrderListByMap(Map<String,Object> param){
        return maintainOrderMapper.getMaintainOrderListByMap(param);
    }

    public Integer getMaintainOrderCountByMap(Map<String,Object> param){
        return maintainOrderMapper.getMaintainOrderCountByMap(param);
    }

    public Integer qdtxAddMaintainOrder(MaintainOrder maintainOrder){
            maintainOrder.setCreatdTime(new Date());
            return maintainOrderMapper.insertMaintainOrder(maintainOrder);
    }

    public Integer qdtxModifyMaintainOrder(MaintainOrder maintainOrder){
        maintainOrder.setUpdatedTime(new Date());
        return maintainOrderMapper.updateMaintainOrder(maintainOrder);
    }

    public Integer qdtxDeleteMaintainOrderById(Long id){
        return maintainOrderMapper.deleteMaintainOrderById(id);
    }

    public Integer qdtxBatchDeleteMaintainOrder(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return maintainOrderMapper.batchDeleteMaintainOrder(param);
    }

    public Page<MaintainOrder> queryMaintainOrderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = maintainOrderMapper.getMaintainOrderCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<MaintainOrder> maintainOrderList = maintainOrderMapper.getMaintainOrderListByMap(param);
        page.setList(maintainOrderList);
        return page;
     }


}
