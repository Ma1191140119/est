package cn.est.mapper;
import  cn.est.po.SysUsers;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface SysUsersMapper {

	public SysUsers getSysUsersById(@Param(value = "id") Long id);

	public List<SysUsers>	getSysUsersListByMap(Map<String,Object> param);

	public Integer getSysUsersCountByMap(Map<String,Object> param);

	public Integer insertSysUsers(SysUsers sysUsers);

	public Integer updateSysUsers(SysUsers sysUsers);

	public Integer deleteSysUsersById(@Param(value = "id") Long id);

	public Integer batchDeleteSysUsers(Map<String,List<String>> params);

}
