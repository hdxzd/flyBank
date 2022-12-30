package com.hailei.mapper;

import com.hailei.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    /**
     * 根据用户名和密码查询用户对象
     * @param bank_name
     * @param password
     * @return
     */
    @Select("select money from Bank where bank_name = #{bank_name} and password = #{password}")
    User select(@Param("bank_name") String bank_name,@Param("password")  String password);

    /**
     * 根据用户名查询用户对象
     * @param bank_name
     * @return
     */
    @Select("select * from Bank where bank_name = #{bank_name }")
    User selectByUsername(String bank_name);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into Bank values(null,#{bank_name},#{password},#{id_card},#{phone},#{gender},#{birth_date},null)")
    void add(User user);
}
