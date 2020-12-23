package whu.zhj.zhjweb.service;

import org.springframework.stereotype.Service;
import whu.zhj.zhjweb.mapper.base.BaseMapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhj
 * BaseService
 */
@Service
public abstract class BaseService<T> {

    @Resource
    private BaseMapper<T> baseMapper;

    //字符串常量
    private static final String START = "Start";
    private static final String LENGTH = "Length";

    private static final int INSERT_ERROR = -1;
    private static final int UPDATE_ERROR = -1;
    private static final int DELETE_ERROR = -1;
    /**
     * 获取总数据条数
     * @return 总数据条数
     */
    public int getTotalRecordCount(){
        try{
            int totalRecordCount = baseMapper.totalRecordCount();
            return totalRecordCount;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 根据Id,获得一条数据
     */
    public <V extends T> V getOneById(Object id){
        if(id == null){
            return null;
        }

        try {
            V t = baseMapper.selectOne(id);
            return t;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取数据数组
     * @param start 数据开始位置
     * @param length 数据长度, -1时表示所有数据
     * @param <V> 类型
     * @return 数据对象数组
     */
    public <V extends T> List<V> getList(int start, int length){
        HashMap<String, Object> map = new HashMap<>();
        if(length != -1){
            map.put(START, start);
            map.put(LENGTH, length);
        }
        try{
            List<V> list = baseMapper.select(map);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取所有数据
     * @param <V> 数据类型
     * @return 所有数据数组
     */
    public <V extends T> List<V> getList(){
        return getList(0, -1);
    }

    /**
     * 插入数据
     * @param t 数据对象
     * @return 结果码（-1：失败， 其他：成功插入的条目数）
     */
    public int insert(T t){
        if(t == null){
            return INSERT_ERROR;
        }
        try{
            int ret = baseMapper.insert(t);
            return ret;
        }catch (Exception e){
            e.printStackTrace();
            return INSERT_ERROR;
        }
    }

    /**
     * 更新数据
     * @param t 数据对象
     * @return 更新成功的条数
     */
    public int update(T t){
        if(t == null){
            return UPDATE_ERROR;
        }
        try {
            int ret = baseMapper.update(t);
            return ret;
        }catch (Exception e){
            e.printStackTrace();
            return UPDATE_ERROR;
        }
    }

    /**
     * 根据Id删除数据
     * @param id 数据Id
     * @return 返回删除的条数
     */
    public int deleteById(Object id){
        if(id == null){
            return DELETE_ERROR;
        }
        try {
            int ret = baseMapper.delete(id);
            return ret;
        }catch (Exception e){
            e.printStackTrace();
            return DELETE_ERROR;
        }
    }
}
