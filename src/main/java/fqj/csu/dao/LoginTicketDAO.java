package fqj.csu.dao;

import fqj.csu.model.LoginTicket;
import org.apache.ibatis.annotations.*;
//与底层数据库中ticket表以及model中LoginTicket类的交互
@Mapper
public interface LoginTicketDAO {
    String TABLE_NAME = "ticket";
    String INSERT_FIELDS = " user_id, expired, status, ticket, login_time ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    //向ticket表中插入数据
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userId},#{expired},#{status},#{ticket},#{loginTime})"})
    int addTicket(LoginTicket ticket);

    //通过ticket查找数据库中的ticket表，返回LoginTicket类,该类记录数据库中的对应记录
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    //通过ticket将status更新为1，即设置status为无效
    @Update({"update ", TABLE_NAME, " set status=#{status} where ticket=#{ticket}"})
    void updateStatus(@Param("ticket") String ticket, @Param("status") int status);
}



