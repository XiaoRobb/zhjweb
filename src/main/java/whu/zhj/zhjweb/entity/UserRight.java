package whu.zhj.zhjweb.entity;

/**
 * @author zhj
 * 用户权限类
 */
public class UserRight {
    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 权限Id（不同权限以，隔开）
     */
    private String rightIds;

    /**
     * 权限名称（不同权限以，隔开）
     */
    private String rightNames;

    public UserRight(){

    }

    public UserRight(Integer userId, String rightIds, String rightNames) {
        this.userId = userId;
        this.rightIds = rightIds;
        this.rightNames = rightNames;
    }

    public UserRight(UserRight userRight){
        this.userId = userRight.userId;
        this.rightIds = userRight.rightIds;
        this.rightNames = userRight.rightNames;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRightIds() {
        return rightIds;
    }

    public void setRightIds(String rightIds) {
        this.rightIds = rightIds;
    }

    public String getRightNames() {
        return rightNames;
    }

    public void setRightNames(String rightNames) {
        this.rightNames = rightNames;
    }
}
