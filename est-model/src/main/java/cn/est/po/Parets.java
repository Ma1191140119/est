package cn.est.po;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
/***
*   零配件表
*/
public class Parets implements Serializable {
    //
    private Long id;
    //型号id
    private Long modelId;
    //配件名称
    private String paretsName;
    //价格
    private BigDecimal price;
    //供应商
    private String supplier;
    //图片
    private String img;
    //是否原厂（0:否,1:是,2:未知）
    private Integer isOrign;
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
    public void setModelId (Long  modelId){
        this.modelId=modelId;
    }
    public  Long getModelId(){
        return this.modelId;
    }
    public void setParetsName (String  paretsName){
        this.paretsName=paretsName;
    }
    public  String getParetsName(){
        return this.paretsName;
    }
    public void setPrice (BigDecimal  price){
        this.price=price;
    }
    public  BigDecimal getPrice(){
        return this.price;
    }
    public void setSupplier (String  supplier){
        this.supplier=supplier;
    }
    public  String getSupplier(){
        return this.supplier;
    }
    public void setImg (String  img){
        this.img=img;
    }
    public  String getImg(){
        return this.img;
    }
    public void setIsOrign (Integer  isOrign){
        this.isOrign=isOrign;
    }
    public  Integer getIsOrign(){
        return this.isOrign;
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
