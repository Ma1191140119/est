package cn.est.service.impl;

import cn.est.mapper.UsersMapper;
import cn.est.po.Users;
import cn.est.service.UsersService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public Users getUsersById(Long id) {
        return usersMapper.getUsersById(id);
    }

    public List<Users> getUsersListByMap(Map<String, Object> param) {
        return usersMapper.getUsersListByMap(param);
    }

    public Integer getUsersCountByMap(Map<String, Object> param) {
        return usersMapper.getUsersCountByMap(param);
    }

    public Integer qdtxAddUsers(Users users) {
        users.setIsAuthentication(0);
        users.setIsDelete(0);
        users.setCreatdTime(new Date());
        return usersMapper.insertUsers(users);
    }

    public Integer qdtxModifyUsers(Users users) {
        users.setUpdatedTime(new Date());
        return usersMapper.updateUsers(users);
    }

    public Integer qdtxDeleteUsersById(Long id) {
        return usersMapper.deleteUsersById(id);
    }

    public Integer qdtxBatchDeleteUsers(String ids) {
        Map<String, List<String>> param = new HashMap<String, List<String>>();
        String[] paramArrays = ids.split(",");
        List<String> idList = new ArrayList<String>();
        for (String temp : paramArrays) {
            idList.add(temp);
        }
        param.put("ids", idList);
        return usersMapper.batchDeleteUsers(param);
    }

    public Page<Users> queryUsersPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize) {
        Integer total = usersMapper.getUsersCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Users> usersList = usersMapper.getUsersListByMap(param);
        page.setList(usersList);
        return page;
    }


}
