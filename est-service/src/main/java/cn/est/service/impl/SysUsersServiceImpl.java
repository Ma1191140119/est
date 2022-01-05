package cn.est.service.impl;
import cn.est.mapper.SysUsersMapper;
import cn.est.po.SysUsers;
import cn.est.service.SysUsersService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class SysUsersServiceImpl implements SysUsersService {

    @Autowired
    private SysUsersMapper sysUsersMapper;

    public SysUsers getSysUsersById(Long id){
        return sysUsersMapper.getSysUsersById(id);
    }

    public List<SysUsers>	getSysUsersListByMap(Map<String,Object> param){
        return sysUsersMapper.getSysUsersListByMap(param);
    }

    public Integer getSysUsersCountByMap(Map<String,Object> param){
        return sysUsersMapper.getSysUsersCountByMap(param);
    }

    public Integer qdtxAddSysUsers(SysUsers sysUsers){
            sysUsers.setCreatdTime(new Date());
            return sysUsersMapper.insertSysUsers(sysUsers);
    }

    public Integer qdtxModifySysUsers(SysUsers sysUsers){
        sysUsers.setUpdatedTime(new Date());
        return sysUsersMapper.updateSysUsers(sysUsers);
    }

    public Integer qdtxDeleteSysUsersById(Long id){
        return sysUsersMapper.deleteSysUsersById(id);
    }

    public Integer qdtxBatchDeleteSysUsers(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return sysUsersMapper.batchDeleteSysUsers(param);
    }

    public Page<SysUsers> querySysUsersPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = sysUsersMapper.getSysUsersCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<SysUsers> sysUsersList = sysUsersMapper.getSysUsersListByMap(param);
        page.setList(sysUsersList);
        return page;
     }


}
