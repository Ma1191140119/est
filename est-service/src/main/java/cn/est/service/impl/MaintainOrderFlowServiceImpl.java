package cn.est.service.impl;
import cn.est.mapper.MaintainOrderFlowMapper;
import cn.est.po.MaintainOrderFlow;
import cn.est.service.MaintainOrderFlowService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class MaintainOrderFlowServiceImpl implements MaintainOrderFlowService {

    @Autowired
    private MaintainOrderFlowMapper maintainOrderFlowMapper;

    public MaintainOrderFlow getMaintainOrderFlowById(Long id){
        return maintainOrderFlowMapper.getMaintainOrderFlowById(id);
    }

    public List<MaintainOrderFlow>	getMaintainOrderFlowListByMap(Map<String,Object> param){
        return maintainOrderFlowMapper.getMaintainOrderFlowListByMap(param);
    }

    public Integer getMaintainOrderFlowCountByMap(Map<String,Object> param){
        return maintainOrderFlowMapper.getMaintainOrderFlowCountByMap(param);
    }

    public Integer qdtxAddMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow){
            maintainOrderFlow.setCreatdTime(new Date());
            return maintainOrderFlowMapper.insertMaintainOrderFlow(maintainOrderFlow);
    }

    public Integer qdtxModifyMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow){
        maintainOrderFlow.setUpdatedTime(new Date());
        return maintainOrderFlowMapper.updateMaintainOrderFlow(maintainOrderFlow);
    }

    public Integer qdtxDeleteMaintainOrderFlowById(Long id){
        return maintainOrderFlowMapper.deleteMaintainOrderFlowById(id);
    }

    public Integer qdtxBatchDeleteMaintainOrderFlow(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return maintainOrderFlowMapper.batchDeleteMaintainOrderFlow(param);
    }

    public Page<MaintainOrderFlow> queryMaintainOrderFlowPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = maintainOrderFlowMapper.getMaintainOrderFlowCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<MaintainOrderFlow> maintainOrderFlowList = maintainOrderFlowMapper.getMaintainOrderFlowListByMap(param);
        page.setList(maintainOrderFlowList);
        return page;
     }


}
