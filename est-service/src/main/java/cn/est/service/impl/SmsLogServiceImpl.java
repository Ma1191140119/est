package cn.est.service.impl;
import cn.est.mapper.SmsLogMapper;
import cn.est.po.SmsLog;
import cn.est.service.SmsLogService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class SmsLogServiceImpl implements SmsLogService {

    @Autowired
    private SmsLogMapper smsLogMapper;

    public SmsLog getSmsLogById(Long id){
        return smsLogMapper.getSmsLogById(id);
    }

    public List<SmsLog>	getSmsLogListByMap(Map<String,Object> param){
        return smsLogMapper.getSmsLogListByMap(param);
    }

    public Integer getSmsLogCountByMap(Map<String,Object> param){
        return smsLogMapper.getSmsLogCountByMap(param);
    }

    public Integer qdtxAddSmsLog(SmsLog smsLog){
            smsLog.setCreatdTime(new Date());
            return smsLogMapper.insertSmsLog(smsLog);
    }

    public Integer qdtxModifySmsLog(SmsLog smsLog){
        smsLog.setUpdatedTime(new Date());
        return smsLogMapper.updateSmsLog(smsLog);
    }

    public Integer qdtxDeleteSmsLogById(Long id){
        return smsLogMapper.deleteSmsLogById(id);
    }

    public Integer qdtxBatchDeleteSmsLog(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return smsLogMapper.batchDeleteSmsLog(param);
    }

    public Page<SmsLog> querySmsLogPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = smsLogMapper.getSmsLogCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<SmsLog> smsLogList = smsLogMapper.getSmsLogListByMap(param);
        page.setList(smsLogList);
        return page;
     }


}
