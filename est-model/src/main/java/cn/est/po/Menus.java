package cn.est.po;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
/***
*   菜单
*/
public class Menus implements Serializable {
    //
    private Long id;
    //菜单编号
    private String menuCode;
    //菜单名称名称
    private String menuName;
    //访问地址
    private String url;
    //状态（0:无效,1:有效）
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
    public void setMenuCode (String  menuCode){
        this.menuCode=menuCode;
    }
    public  String getMenuCode(){
        return this.menuCode;
    }
    public void setMenuName (String  menuName){
        this.menuName=menuName;
    }
    public  String getMenuName(){
        return this.menuName;
    }
    public void setUrl (String  url){
        this.url=url;
    }
    public  String getUrl(){
        return this.url;
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
