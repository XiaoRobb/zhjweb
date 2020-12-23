package whu.zhj.zhjweb.entity;


import java.util.Date;

/**
 * @author zhj
 * 权限类
 */
public class Right {
    /**
     * 权限Id
     */
    private Integer rightId;

    /**
     * 权限名称
     */
    private String rightName;

    /**
     * 权限类型(0：系统权限，1：菜单权限，2：界面权限，3：方法权限)
     */
    private Integer rightType;

    /**
     * 权限对应的访问地址
     */
    private String url;

    /**
     * 权限对应的前端界面地址
     */
    private String viewPath;

    /**
     * 是否启用（0：启用，1：不启用）
     */
    private Boolean enable;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 方法权限
     */
    private String permission;

    public Right(){

    }

    public Right(Integer rightId, String rightName, Integer rightType, String url, String viewPath, Boolean enable, Date createTime, String permission) {
        this.rightId = rightId;
        this.rightName = rightName;
        this.rightType = rightType;
        this.url = url;
        this.viewPath = viewPath;
        this.enable = enable;
        this.createTime = createTime;
        this.permission = permission;
    }

    public Right(Right right){
        this.rightId = right.rightId;
        this.rightName = right.rightName;
        this.rightType = right.rightType;
        this.url = right.url;
        this.viewPath = right.viewPath;
        this.enable = right.enable;
        this.createTime = right.createTime;
        this.permission = right.permission;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
