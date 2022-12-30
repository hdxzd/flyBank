package com.hailei.mapper;

import com.hailei.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select bank_id,bank_name,id_card,phone,gender,birth_date,money from Bank")
    @ResultMap("AdminResultMap")
    List<User> selectAll();

    /**
     * 添加数据
     * @param user
     */
    @Insert("insert into Bank values(null,#{bank_name},#{password},#{id_card},#{phone},#{gender},#{birth_date},#{money})")
    void add(User user);


    /**
     * 删除
     * @param bank_id
     */
    @Delete("delete from Bank where id=#{bank_id}")
    void deleteById(int bank_id);

    /**
     * 修改
     * @param user
     */
    @Update("update Bank set bank_name = #{bank_name}, password = #{password},id_card = #{id_card},phone = #{phone},gender = #{gender} , birth_date = #{birth_date} where bank_id = #{bank_id}")
    void updateById(User user);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from Bank limit #{begin} , #{size}")
    @ResultMap("AdminResultMap")
    List<User> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from Bank ")
    int selectTotalCount();



    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    List<User> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") User user);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(User user);
}
