package cn.est.po;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
/***
*   系统用户
*/
public class SysUsers implements Serializable {
    //
    private Long id;
    //账号
    private String account;
    //密码
    private String password;
    //盐
    private String salt;
    //用户名
    private String userName;
    //角色(1:系统管理员,2:门店管理员)
    private Integer role;
    //门店id
    private Long shopId;
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
    public void setAccount (String  account){
        this.account=account;
    }
    public  String getAccount(){
        return this.account;
    }
    public void setPassword (String  password){
        this.password=password;
    }
    public  String getPassword(){
        return this.password;
    }
    public void setSalt (String  salt){
        this.salt=salt;
    }
    public  String getSalt(){
        return this.salt;
    }
    public void setUserName (String  userName){
        this.userName=userName;
    }
    public  String getUserName(){
        return this.userName;
    }
    public void setRole (Integer  role){
        this.role=role;
    }
    public  Integer getRole(){
        return this.role;
    }
    public void setShopId (Long  shopId){
        this.shopId=shopId;
    }
    public  Long getShopId(){
        return this.shopId;
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
