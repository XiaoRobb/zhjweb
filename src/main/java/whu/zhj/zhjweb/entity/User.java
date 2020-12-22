package whu.zhj.zhjweb.entity;

/**
 * @author zhj
 * 用户类
 */
public class User {

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户密码盐值
     */
    private String salt;

    /**
     * 用户昵称
     */
    private String nickName;

    public User(){

    }

    public User(Integer userId, String userName, String password, String salt, String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.nickName = nickName;
    }

    public User(User user){
        this.userId = user.userId;
        this.userName = user.userName;
        this.password = user.password;
        this.salt = user.salt;
        this.nickName = user.nickName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
