package fqj.csu.dao;

import fqj.csu.model.User;
import org.apache.ibatis.annotations.*;



@Mapper
//与底层数据库中user表以及model中的User类的交互
public interface UserDAO {
        // 注意空格
        String TABLE_NAME = " user ";
        String INSERT_FIELDS = " name, password, salt, head_url ";
        String SELECT_FIELDS = " id, " + INSERT_FIELDS;

        //向user表中插入数据
        @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
                ") values (#{name},#{password},#{salt},#{headUrl})"})
        int addUser(User user);

        //通过id取出user
        @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id = #{id}"})
        User selectById(int id);

        //通过name取出user
        @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where name = #{name}"})
        User selectByName(String name);

        //通过id更新密码
        @Update({"update ", TABLE_NAME, "set password = #{password} where id = #{id}"})
        void updatePassword(User user);

        //通过id删除记录
        @Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
        void deleteById(int id);
}
