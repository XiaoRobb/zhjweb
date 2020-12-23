package whu.zhj.zhjweb.entity;


/**
 * @author zhj
 * UserEx 用户具体信息类，包含用户基本信息和权限等信息
 */
public class UserEx extends User{
    /**
     * 用户权限Id
     */
    private String rightIds;

    /**
     * 用户权限名称
     */
    private String rightNames;

    public UserEx(){

    }

    public UserEx(String rightIds, String rightNames) {
        this.rightIds = rightIds;
        this.rightNames = rightNames;
    }

    public UserEx(UserEx userEx) {
        this.rightIds = userEx.rightIds;
        this.rightNames = userEx.rightNames;
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
