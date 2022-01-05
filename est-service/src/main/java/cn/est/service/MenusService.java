package cn.est.service;
import  cn.est.po.Menus;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface MenusService {

    public Menus getMenusById(Long id);

    public List<Menus>	getMenusListByMap(Map<String,Object> param);

    public Integer getMenusCountByMap(Map<String,Object> param);

    public Integer qdtxAddMenus(Menus menus);

    public Integer qdtxModifyMenus(Menus menus);

    public Integer qdtxDeleteMenusById(Long id);

    public Integer qdtxBatchDeleteMenus(String ids);

    public Page<Menus> queryMenusPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
