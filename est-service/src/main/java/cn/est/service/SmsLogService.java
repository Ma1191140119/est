package cn.est.service;
import  cn.est.po.SmsLog;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface SmsLogService {

    public SmsLog getSmsLogById(Long id);

    public List<SmsLog>	getSmsLogListByMap(Map<String,Object> param);

    public Integer getSmsLogCountByMap(Map<String,Object> param);

    public Integer qdtxAddSmsLog(SmsLog smsLog);

    public Integer qdtxModifySmsLog(SmsLog smsLog);

    public Integer qdtxDeleteSmsLogById(Long id);

    public Integer qdtxBatchDeleteSmsLog(String ids);

    public Page<SmsLog> querySmsLogPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
