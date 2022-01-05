package cn.est.mapper;
import  cn.est.po.Parets;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ParetsMapper {

	public Parets getParetsById(@Param(value = "id") Long id);

	public List<Parets>	getParetsListByMap(Map<String,Object> param);

	public Integer getParetsCountByMap(Map<String,Object> param);

	public Integer insertParets(Parets parets);

	public Integer updateParets(Parets parets);

	public Integer deleteParetsById(@Param(value = "id") Long id);

	public Integer batchDeleteParets(Map<String,List<String>> params);

}
