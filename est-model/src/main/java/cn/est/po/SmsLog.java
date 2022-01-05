package cn.est.po;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
/***
*   短信记录
*/
public class SmsLog implements Serializable {
    //
    private Long id;
    //短信类型（0：注册、登录验证码,1：修改密码,2：订单状态通知信息）
    private Integer codeType;
    //接收短信手机号
    private String phone;
    //短信内容
    private String message;
    //失败原因
    private String failInfo;
    //状态（1:成功2:失败）
    private Integer status;
    //创建人
    private Long createdUserId;
    //修改人
    private Long updatedUserId;
    //创建时间
    private Date creatdTime;
    //修改时间
    private Date updatedTime;
    //是否删除(0:否,1:是)
    private Integer isDelete;
    //get set 方法
    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setCodeType (Integer  codeType){
        this.codeType=codeType;
    }
    public  Integer getCodeType(){
        return this.codeType;
    }
    public void setPhone (String  phone){
        this.phone=phone;
    }
    public  String getPhone(){
        return this.phone;
    }
    public void setMessage (String  message){
        this.message=message;
    }
    public  String getMessage(){
        return this.message;
    }
    public void setFailInfo (String  failInfo){
        this.failInfo=failInfo;
    }
    public  String getFailInfo(){
        return this.failInfo;
    }
    public void setStatus (Integer  status){
        this.status=status;
    }
    public  Integer getStatus(){
        return this.status;
    }
    public void setCreatedUserId (Long  createdUserId){
        this.createdUserId=createdUserId;
    }
    public  Long getCreatedUserId(){
        return this.createdUserId;
    }
    public void setUpdatedUserId (Long  updatedUserId){
        this.updatedUserId=updatedUserId;
    }
    public  Long getUpdatedUserId(){
        return this.updatedUserId;
    }
    public void setCreatdTime (Date  creatdTime){
        this.creatdTime=creatdTime;
    }
    public  Date getCreatdTime(){
        return this.creatdTime;
    }
    public void setUpdatedTime (Date  updatedTime){
        this.updatedTime=updatedTime;
    }
    public  Date getUpdatedTime(){
        return this.updatedTime;
    }
    public void setIsDelete (Integer  isDelete){
        this.isDelete=isDelete;
    }
    public  Integer getIsDelete(){
        return this.isDelete;
    }
}
