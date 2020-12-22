package whu.zhj.zhjweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import whu.zhj.zhjweb.entity.User;
import whu.zhj.zhjweb.mapper.base.BaseMapper;

/**
 * @author zhj
 * UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
