package cn.est.service;
import  cn.est.po.PayOrder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface PayOrderService {

    public PayOrder getPayOrderById(Long id);

    public List<PayOrder>	getPayOrderListByMap(Map<String,Object> param);

    public Integer getPayOrderCountByMap(Map<String,Object> param);

    public Integer qdtxAddPayOrder(PayOrder payOrder);

    public Integer qdtxModifyPayOrder(PayOrder payOrder);

    public Integer qdtxDeletePayOrderById(Long id);

    public Integer qdtxBatchDeletePayOrder(String ids);

    public Page<PayOrder> queryPayOrderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
