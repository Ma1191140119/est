package cn.est.service.impl;
import cn.est.mapper.MenusMapper;
import cn.est.po.Menus;
import cn.est.service.MenusService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private MenusMapper menusMapper;

    public Menus getMenusById(Long id){
        return menusMapper.getMenusById(id);
    }

    public List<Menus>	getMenusListByMap(Map<String,Object> param){
        return menusMapper.getMenusListByMap(param);
    }

    public Integer getMenusCountByMap(Map<String,Object> param){
        return menusMapper.getMenusCountByMap(param);
    }

    public Integer qdtxAddMenus(Menus menus){
            menus.setCreatdTime(new Date());
            return menusMapper.insertMenus(menus);
    }

    public Integer qdtxModifyMenus(Menus menus){
        menus.setUpdatedTime(new Date());
        return menusMapper.updateMenus(menus);
    }

    public Integer qdtxDeleteMenusById(Long id){
        return menusMapper.deleteMenusById(id);
    }

    public Integer qdtxBatchDeleteMenus(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return menusMapper.batchDeleteMenus(param);
    }

    public Page<Menus> queryMenusPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = menusMapper.getMenusCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Menus> menusList = menusMapper.getMenusListByMap(param);
        page.setList(menusList);
        return page;
     }


}
