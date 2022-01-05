package cn.est.service;
import  cn.est.po.Model;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ModelService {

    public Model getModelById(Long id);

    public List<Model>	getModelListByMap(Map<String,Object> param);

    public Integer getModelCountByMap(Map<String,Object> param);

    public Integer qdtxAddModel(Model model);

    public Integer qdtxModifyModel(Model model);

    public Integer qdtxDeleteModelById(Long id);

    public Integer qdtxBatchDeleteModel(String ids);

    public Page<Model> queryModelPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
