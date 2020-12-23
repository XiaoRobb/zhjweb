package whu.zhj.zhjweb.mapper.base;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhj
 * Mapper接口
 */
@Mapper
public interface BaseMapper<T> {

    /**
     * 总记录条数
     * @return 总记录条数
     */
    int totalRecordCount();

    /**
     * 根据id选择一条记录
     * @param id 数据库中的id
     * @param <V> 返回的记录的类型
     * @return 返回一条记录对象
     */
    <V extends T> V selectOne(@Param("id") Object id);

    /**
     * 根据map中的条件选择多条记录
     * @param map 条件字典
     * @param <V> 返回记录的类型
     * @return 返回多条记录对象组成的List
     */
    <V extends T> List<V> select(@Param("map") Map<String, Object> map);

    /**
     * 插入一条记录
     * @param record 要插入的记录对象
     * @return 返回插入记录返回码
     */
    int insert(T record);

    /**
     * 更新一条记录
     * @param record 要更新的记录对象
     * @return 返回更新记录返回码
     */
    int update(T record);


    /**
     * 根据主键删除记录
     * @param id 主键
     * @return 返回删除记录返回码
     */
    int delete(@Param("id") Object id);
}
