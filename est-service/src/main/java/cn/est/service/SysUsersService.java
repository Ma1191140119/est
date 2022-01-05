package cn.est.service;
import  cn.est.po.SysUsers;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface SysUsersService {

    public SysUsers getSysUsersById(Long id);

    public List<SysUsers>	getSysUsersListByMap(Map<String,Object> param);

    public Integer getSysUsersCountByMap(Map<String,Object> param);

    public Integer qdtxAddSysUsers(SysUsers sysUsers);

    public Integer qdtxModifySysUsers(SysUsers sysUsers);

    public Integer qdtxDeleteSysUsersById(Long id);

    public Integer qdtxBatchDeleteSysUsers(String ids);

    public Page<SysUsers> querySysUsersPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
