package whu.zhj.zhjweb.realm;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Bean;
import whu.zhj.zhjweb.entity.Right;
import whu.zhj.zhjweb.entity.User;
import whu.zhj.zhjweb.service.RightService;
import whu.zhj.zhjweb.service.UserRightService;
import whu.zhj.zhjweb.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhj
 * UserRealm
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    @Resource
    private RightService rightService;

    /**
     * 授权
     * @param principalCollection xxx
     * @return xxx
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 构建授权信息的实体类（授权信息包括授权角色和权限集合）
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取当前用户的对象的session
        Session session = SecurityUtils.getSubject().getSession();
        //获取用户信息
        User user = (User) session.getAttribute("user");
        //查找添加用户对应的权限信息
        List<Right> rights = rightService.getRightsByUserId(user.getUserId());
        if(rights != null){
            for (Right right :
                    rights) {
                if(!StringUtils.isEmpty(right.getPermission())){
                    simpleAuthorizationInfo.addStringPermission(right.getPermission());
                }
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到用户名
        String userName = (String) authenticationToken.getPrincipal();
        //在数据库中验证用户名是否正确
        User user;
        if(StringUtils.isEmpty(userName) || (user = userService.getUserExByUserName(userName)) == null){
            //用户不存在
            throw new UnknownAccountException("用户名或密码错误");
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", user);

        return new SimpleAuthenticationInfo(
                user.getUserName(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                this.getName()
        );
    }
}
