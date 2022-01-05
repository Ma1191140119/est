package cn.est.mapper;
import  cn.est.po.Store;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface StoreMapper {
	public Store getStoreById(@Param(value = "id") Long id);

	public List<Store>	getStoreListByMap(Map<String,Object> param);

	public Integer getStoreCountByMap(Map<String,Object> param);

	public Integer insertStore(Store store);

	public Integer updateStore(Store store);

	public Integer deleteStoreById(@Param(value = "id") Long id);

	public Integer batchDeleteStore(Map<String,List<String>> params);

}
