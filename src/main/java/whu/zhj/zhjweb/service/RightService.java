package whu.zhj.zhjweb.service;

import org.springframework.stereotype.Service;
import whu.zhj.zhjweb.entity.Right;
import whu.zhj.zhjweb.entity.UserRight;
import whu.zhj.zhjweb.mapper.RightMapper;
import whu.zhj.zhjweb.mapper.UserRightMapper;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhj
 * RightService
 */
@Service
public class RightService {
    @Resource
    private RightMapper rightMapper;
    @Resource
    private UserRightMapper userRightMapper;

    //字符串常量
    private static final String RightId = "rightId";

    /**
     * 根据用户Id，查找用户拥有的权限
     * @param userId 用户Id
     * @return 权限数组
     */
    public List<Right> getRightsByUserId(Integer userId){
        if(userId == null){
            return null;
        }
        try{
            UserRight userRight = userRightMapper.selectOne(userId);
            String rightIdsStr = userRight.getRightIds();
            String[] rightIds = rightIdsStr.split(",");
            Map<String, Object> map = new HashMap<>(16);
            map.put(RightId, Arrays.asList(rightIds));
            List<Right> rights = rightMapper.select(map);
            return rights;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
