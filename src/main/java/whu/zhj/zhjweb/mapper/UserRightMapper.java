package whu.zhj.zhjweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import whu.zhj.zhjweb.entity.UserRight;
import whu.zhj.zhjweb.mapper.base.BaseMapper;

/**
 * @author zhj
 * UserRightMapper
 */
@Mapper
public interface UserRightMapper extends BaseMapper<UserRight> {
}
