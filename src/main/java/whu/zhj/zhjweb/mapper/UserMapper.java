package whu.zhj.zhjweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import whu.zhj.zhjweb.entity.User;
import whu.zhj.zhjweb.entity.UserEx;
import whu.zhj.zhjweb.mapper.base.BaseMapper;

/**
 * @author zhj
 * UserMapper.xml
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return 用户对象
     */
    public User selectUserByUserName(@Param("userName") String userName);

    /**
     * 根据用户名查找用户具体信息
     * @param userName 用户名
     * @return 用户具体信息对象
     */
    public UserEx selectUserExByUserName(@Param("userName") String userName);
}
