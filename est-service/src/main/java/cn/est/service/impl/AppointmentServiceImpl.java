package cn.est.service.impl;
import cn.est.mapper.AppointmentMapper;
import cn.est.po.Appointment;
import cn.est.service.AppointmentService;
import cn.est.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    public Appointment getAppointmentById(Long id){
        return appointmentMapper.getAppointmentById(id);
    }

    public List<Appointment>	getAppointmentListByMap(Map<String,Object> param){
        return appointmentMapper.getAppointmentListByMap(param);
    }

    public Integer getAppointmentCountByMap(Map<String,Object> param){
        return appointmentMapper.getAppointmentCountByMap(param);
    }

    public Integer qdtxAddAppointment(Appointment appointment){
            appointment.setCreatdTime(new Date());
            return appointmentMapper.insertAppointment(appointment);
    }

    public Integer qdtxModifyAppointment(Appointment appointment){
        appointment.setUpdatedTime(new Date());
        return appointmentMapper.updateAppointment(appointment);
    }

    public Integer qdtxDeleteAppointmentById(Long id){
        return appointmentMapper.deleteAppointmentById(id);
    }

    public Integer qdtxBatchDeleteAppointment(String ids){
        Map<String,List<String>> param=new HashMap<String,List<String>>();
        String[] paramArrays=ids.split(",");
        List<String> idList=new ArrayList<String>();
            for (String temp:paramArrays){
                idList.add(temp);
            }
        param.put("ids",idList);
        return appointmentMapper.batchDeleteAppointment(param);
    }

    public Page<Appointment> queryAppointmentPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize){
        Integer total = appointmentMapper.getAppointmentCountByMap(param);
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<Appointment> appointmentList = appointmentMapper.getAppointmentListByMap(param);
        page.setList(appointmentList);
        return page;
     }


}
