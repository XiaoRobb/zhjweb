package whu.zhj.zhjweb.service;

import org.springframework.stereotype.Service;
import whu.zhj.zhjweb.mapper.UserRightMapper;

import javax.annotation.Resource;

/**
 * @author admin
 */
@Service
public class UserRightService {
    @Resource
    private UserRightMapper userRightMapper;
}
