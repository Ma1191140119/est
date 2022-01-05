package cn.est.service;
import  cn.est.po.Users;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface UsersService {

    public Users getUsersById(Long id);

    public List<Users>	getUsersListByMap(Map<String,Object> param);

    public Integer getUsersCountByMap(Map<String,Object> param);

    public Integer qdtxAddUsers(Users users);

    public Integer qdtxModifyUsers(Users users);

    public Integer qdtxDeleteUsersById(Long id);

    public Integer qdtxBatchDeleteUsers(String ids);

    public Page<Users> queryUsersPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
