package cn.est.service;
import  cn.est.po.MaintainOrderFlow;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface MaintainOrderFlowService {

    public MaintainOrderFlow getMaintainOrderFlowById(Long id);

    public List<MaintainOrderFlow>	getMaintainOrderFlowListByMap(Map<String,Object> param);

    public Integer getMaintainOrderFlowCountByMap(Map<String,Object> param);

    public Integer qdtxAddMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow);

    public Integer qdtxModifyMaintainOrderFlow(MaintainOrderFlow maintainOrderFlow);

    public Integer qdtxDeleteMaintainOrderFlowById(Long id);

    public Integer qdtxBatchDeleteMaintainOrderFlow(String ids);

    public Page<MaintainOrderFlow> queryMaintainOrderFlowPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
