package cn.est.service;
import cn.est.dto.Result;
import  cn.est.po.Classify;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ClassifyService {

    public Classify getClassifyById(Long id);

    public List<Classify>	getClassifyListByMap(Map<String,Object> param);

    public Integer getClassifyCountByMap(Map<String,Object> param);

    public Integer qdtxAddClassify(Classify classify);

    public Integer qdtxModifyClassify(Classify classify);

    public Integer qdtxDeleteClassifyById(Long id);

    public Integer qdtxBatchDeleteClassify(String ids);

    public Page<Classify> queryClassifyPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

    public Result getTree();
}
