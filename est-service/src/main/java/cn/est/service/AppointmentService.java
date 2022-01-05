package cn.est.service;
import  cn.est.po.Appointment;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.est.dto.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface AppointmentService {

    public Appointment getAppointmentById(Long id);

    public List<Appointment>	getAppointmentListByMap(Map<String,Object> param);

    public Integer getAppointmentCountByMap(Map<String,Object> param);

    public Integer qdtxAddAppointment(Appointment appointment);

    public Integer qdtxModifyAppointment(Appointment appointment);

    public Integer qdtxDeleteAppointmentById(Long id);

    public Integer qdtxBatchDeleteAppointment(String ids);

    public Page<Appointment> queryAppointmentPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize);

}
