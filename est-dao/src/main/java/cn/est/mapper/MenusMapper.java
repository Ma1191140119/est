package cn.est.mapper;
import  cn.est.po.Menus;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface MenusMapper {

	public Menus getMenusById(@Param(value = "id") Long id);

	public List<Menus>	getMenusListByMap(Map<String,Object> param);

	public Integer getMenusCountByMap(Map<String,Object> param);

	public Integer insertMenus(Menus menus);

	public Integer updateMenus(Menus menus);

	public Integer deleteMenusById(@Param(value = "id") Long id);

	public Integer batchDeleteMenus(Map<String,List<String>> params);

}
