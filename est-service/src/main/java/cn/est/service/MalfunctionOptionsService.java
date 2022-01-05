package cn.est.service;
import  cn.est.po.MalfunctionOptions;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface MalfunctionOptionsService {

    public MalfunctionOptions getMalfunctionOptionsById(Long id);

    public List<MalfunctionOptions>	getMalfunctionOptionsListByMap(Map<String,Object> param);

    public Integer getMalfunctionOptionsCountByMap(Map<String,Object> param);

    public Integer qdtxAddMalfunctionOptions(MalfunctionOptions malfunctionOptions);

    public Integer qdtxModifyMalfunctionOptions(MalfunctionOptions malfunctionOptions);

    public Integer qdtxDeleteMalfunctionOptionsById(Long id);

    public Integer qdtxBatchDeleteMalfunctionOptions(String ids);

    public Page<MalfunctionOptions> queryMalfunctionOptionsPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
