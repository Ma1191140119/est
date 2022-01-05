package cn.est.service.impl;
import cn.est.mapper.EvaluateMapper;
import cn.est.po.Evaluate;
import cn.est.service.EvaluateService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    public Evaluate getEvaluateById(Long id){
        return evaluateMapper.getEvaluateById(id);
    }

    public List<Evaluate>	getEvaluateListByMap(Map<String,Object> param){
        return evaluateMapper.getEvaluateListByMap(param);
    }

    public Integer getEvaluateCountByMap(Map<String,Object> param){
        return evaluateMapper.getEvaluateCountByMap(param);
    }

    public Integer qdtxAddEvaluate(Evaluate evaluate){
            evaluate.setCreatdTime(new Date());
            return evaluateMapper.insertEvaluate(evaluate);
    }

    public Integer qdtxModifyEvaluate(Evaluate evaluate){
        evaluate.setUpdatedTime(new Date());
        return evaluateMapper.updateEvaluate(evaluate);
    }

    public Integer qdtxDeleteEvaluateById(Long id){
        return evaluateMapper.deleteEvaluateById(id);
    }

    public Integer qdtxBatchDeleteEvaluate(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return evaluateMapper.batchDeleteEvaluate(param);
    }

    public Page<Evaluate> queryEvaluatePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = evaluateMapper.getEvaluateCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Evaluate> evaluateList = evaluateMapper.getEvaluateListByMap(param);
        page.setList(evaluateList);
        return page;
     }


}
