package cn.est.service;
import  cn.est.po.Parets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ParetsService {

    public Parets getParetsById(Long id);

    public List<Parets>	getParetsListByMap(Map<String,Object> param);

    public Integer getParetsCountByMap(Map<String,Object> param);

    public Integer qdtxAddParets(Parets parets);

    public Integer qdtxModifyParets(Parets parets);

    public Integer qdtxDeleteParetsById(Long id);

    public Integer qdtxBatchDeleteParets(String ids);

    public Page<Parets> queryParetsPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
