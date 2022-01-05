package cn.est.service;
import  cn.est.po.EvaluateDetail;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface EvaluateDetailService {

    public EvaluateDetail getEvaluateDetailById(Long id);

    public List<EvaluateDetail>	getEvaluateDetailListByMap(Map<String,Object> param);

    public Integer getEvaluateDetailCountByMap(Map<String,Object> param);

    public Integer qdtxAddEvaluateDetail(EvaluateDetail evaluateDetail);

    public Integer qdtxModifyEvaluateDetail(EvaluateDetail evaluateDetail);

    public Integer qdtxDeleteEvaluateDetailById(Long id);

    public Integer qdtxBatchDeleteEvaluateDetail(String ids);

    public Page<EvaluateDetail> queryEvaluateDetailPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
