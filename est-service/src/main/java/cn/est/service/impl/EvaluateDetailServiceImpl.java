package cn.est.service.impl;
import cn.est.mapper.EvaluateDetailMapper;
import cn.est.po.EvaluateDetail;
import cn.est.service.EvaluateDetailService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class EvaluateDetailServiceImpl implements EvaluateDetailService {

    @Autowired
    private EvaluateDetailMapper evaluateDetailMapper;

    public EvaluateDetail getEvaluateDetailById(Long id){
        return evaluateDetailMapper.getEvaluateDetailById(id);
    }

    public List<EvaluateDetail>	getEvaluateDetailListByMap(Map<String,Object> param){
        return evaluateDetailMapper.getEvaluateDetailListByMap(param);
    }

    public Integer getEvaluateDetailCountByMap(Map<String,Object> param){
        return evaluateDetailMapper.getEvaluateDetailCountByMap(param);
    }

    public Integer qdtxAddEvaluateDetail(EvaluateDetail evaluateDetail){
            evaluateDetail.setCreatdTime(new Date());
            return evaluateDetailMapper.insertEvaluateDetail(evaluateDetail);
    }

    public Integer qdtxModifyEvaluateDetail(EvaluateDetail evaluateDetail){
        evaluateDetail.setUpdatedTime(new Date());
        return evaluateDetailMapper.updateEvaluateDetail(evaluateDetail);
    }

    public Integer qdtxDeleteEvaluateDetailById(Long id){
        return evaluateDetailMapper.deleteEvaluateDetailById(id);
    }

    public Integer qdtxBatchDeleteEvaluateDetail(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return evaluateDetailMapper.batchDeleteEvaluateDetail(param);
    }

    public Page<EvaluateDetail> queryEvaluateDetailPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = evaluateDetailMapper.getEvaluateDetailCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<EvaluateDetail> evaluateDetailList = evaluateDetailMapper.getEvaluateDetailListByMap(param);
        page.setList(evaluateDetailList);
        return page;
     }


}
