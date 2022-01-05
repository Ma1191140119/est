package cn.est.service.impl;
import cn.est.mapper.PayOrderMapper;
import cn.est.po.PayOrder;
import cn.est.service.PayOrderService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class PayOrderServiceImpl implements PayOrderService {

    @Autowired
    private PayOrderMapper payOrderMapper;

    public PayOrder getPayOrderById(Long id){
        return payOrderMapper.getPayOrderById(id);
    }

    public List<PayOrder>	getPayOrderListByMap(Map<String,Object> param){
        return payOrderMapper.getPayOrderListByMap(param);
    }

    public Integer getPayOrderCountByMap(Map<String,Object> param){
        return payOrderMapper.getPayOrderCountByMap(param);
    }

    public Integer qdtxAddPayOrder(PayOrder payOrder){
            payOrder.setCreatdTime(new Date());
            return payOrderMapper.insertPayOrder(payOrder);
    }

    public Integer qdtxModifyPayOrder(PayOrder payOrder){
        payOrder.setUpdatedTime(new Date());
        return payOrderMapper.updatePayOrder(payOrder);
    }

    public Integer qdtxDeletePayOrderById(Long id){
        return payOrderMapper.deletePayOrderById(id);
    }

    public Integer qdtxBatchDeletePayOrder(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return payOrderMapper.batchDeletePayOrder(param);
    }

    public Page<PayOrder> queryPayOrderPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = payOrderMapper.getPayOrderCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<PayOrder> payOrderList = payOrderMapper.getPayOrderListByMap(param);
        page.setList(payOrderList);
        return page;
     }


}
