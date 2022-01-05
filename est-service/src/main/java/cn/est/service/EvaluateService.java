package cn.est.service;
import  cn.est.po.Evaluate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface EvaluateService {

    public Evaluate getEvaluateById(Long id);

    public List<Evaluate>	getEvaluateListByMap(Map<String,Object> param);

    public Integer getEvaluateCountByMap(Map<String,Object> param);

    public Integer qdtxAddEvaluate(Evaluate evaluate);

    public Integer qdtxModifyEvaluate(Evaluate evaluate);

    public Integer qdtxDeleteEvaluateById(Long id);

    public Integer qdtxBatchDeleteEvaluate(String ids);

    public Page<Evaluate> queryEvaluatePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
