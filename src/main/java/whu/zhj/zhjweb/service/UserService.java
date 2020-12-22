package whu.zhj.zhjweb.service;

import org.springframework.stereotype.Service;
import whu.zhj.zhjweb.entity.User;
import whu.zhj.zhjweb.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhj
 * UserService
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户Id获取用户
     * @param userId 用户Id
     * @return 用户对象
     */
    public User getUserById(Integer userId){
        try {
            return userMapper.selectOne(userId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
