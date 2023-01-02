package com.hailei.mapper;

import com.hailei.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    /**
     * 根据用户名和密码查询用户对象
     * @param bank_name
     * @param land_pwd
     * @return
     */
    @Select("select money from Bank where bank_name = #{bank_name} and land_pwd = #{land_pwd}")
    User select(@Param("bank_name") String bank_name,@Param("land_pwd")  String land_pwd);

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
    @Insert("insert into Bank values(null,#{bank_name},#{land_pwd},#{pay_pwd},#{id_card},#{phone},#{gender},#{birth_date},null)")
    void add(User user);
}
