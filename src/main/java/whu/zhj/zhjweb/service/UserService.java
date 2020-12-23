package whu.zhj.zhjweb.service;

import org.springframework.stereotype.Service;
import whu.zhj.zhjweb.entity.User;
import whu.zhj.zhjweb.entity.UserEx;
import whu.zhj.zhjweb.mapper.UserMapper;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @author zhj
 * UserService
 */
@Service
public class UserService extends BaseService<User> {
    @Resource
    private UserMapper userMapper;

    public UserEx getUserExByUserName(String userName){
        try{
            UserEx userEx = userMapper.selectUserExByUserName(userName);
            return userEx;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
