package cn.est.service;
import  cn.est.po.MaintainOrder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface MaintainOrderService {

    public MaintainOrder getMaintainOrderById(Long id);

    public List<MaintainOrder>	getMaintainOrderListByMap(Map<String,Object> param);

    public Integer getMaintainOrderCountByMap(Map<String,Object> param);

    public Integer qdtxAddMaintainOrder(MaintainOrder maintainOrder);

    public Integer qdtxModifyMaintainOrder(MaintainOrder maintainOrder);

    public Integer qdtxDeleteMaintainOrderById(Long id);

    public Integer qdtxBatchDeleteMaintainOrder(String ids);

    public Page<MaintainOrder> queryMaintainOrderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
