package cn.est.mapper;
import  cn.est.po.SmsLog;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface SmsLogMapper {

	public SmsLog getSmsLogById(@Param(value = "id") Long id);

	public List<SmsLog>	getSmsLogListByMap(Map<String,Object> param);

	public Integer getSmsLogCountByMap(Map<String,Object> param);

	public Integer insertSmsLog(SmsLog smsLog);

	public Integer updateSmsLog(SmsLog smsLog);

	public Integer deleteSmsLogById(@Param(value = "id") Long id);

	public Integer batchDeleteSmsLog(Map<String,List<String>> params);

}
