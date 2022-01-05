package cn.est.service;
import  cn.est.po.Malfunction;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface MalfunctionService {

    public Malfunction getMalfunctionById(Long id);

    public List<Malfunction>	getMalfunctionListByMap(Map<String,Object> param);

    public Integer getMalfunctionCountByMap(Map<String,Object> param);

    public Integer qdtxAddMalfunction(Malfunction malfunction);

    public Integer qdtxModifyMalfunction(Malfunction malfunction);

    public Integer qdtxDeleteMalfunctionById(Long id);

    public Integer qdtxBatchDeleteMalfunction(String ids);

    public Page<Malfunction> queryMalfunctionPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
