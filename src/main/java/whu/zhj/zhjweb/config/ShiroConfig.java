package whu.zhj.zhjweb.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import whu.zhj.zhjweb.realm.UserRealm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhj
 * Shiro配置类
 */

@Configuration
public class ShiroConfig {

    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    @Bean(name = "getDefaultWebSecurityManager")
    @DependsOn("userRealm")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm((Realm) userRealm);
        return securityManager;

    }

    @Bean
    @DependsOn("getDefaultWebSecurityManager")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //没有认证后跳到的页面
        shiroFilterFactoryBean.setLoginUrl("/log");
        /*
         *          shiro的内置过滤器
         *          anon：无需认证就可以访问 默认
         *          authc：必须认证了才能访问
         *          user：必须拥有记住我功能才能访问
         *          perms：必须拥有对某个的权限才能访问
         *          role：拥有某个角色权限才能访问
         */
        //添加内置过滤器
        //拦截
        Map<String,String> filterChinaDefinitionMap = new LinkedHashMap<>();
        filterChinaDefinitionMap.put("/api/users/zhj", "authc");
        //add请求必须认证才能访问
        filterChinaDefinitionMap.put("/add","authc");
        filterChinaDefinitionMap.put("/del","authc");
        //授权，没有授权会被拦截
        filterChinaDefinitionMap.put("/add","perms[user:id]");
        filterChinaDefinitionMap.put("/del","perms[user:delete]");
        //未授权的跳转url
        shiroFilterFactoryBean.setUnauthorizedUrl("/Unauthorized");
        //把设置好的过滤设置到ShiroFilterFactoryBean
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChinaDefinitionMap);

        return shiroFilterFactoryBean;

    }
}