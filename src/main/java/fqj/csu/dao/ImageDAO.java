package fqj.csu.dao;

import fqj.csu.model.Image;
import fqj.csu.model.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface ImageDAO {

    String TABLE_NAME = " image ";
    String INSERT_FIELDS = " user_id, name, path, created_date, predict ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    //向image表中插入数据
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userId},#{name},#{path},#{createdDate},#{predict})"})
    int addImage(Image image);

    //通过id取出image
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id = #{id}"})
    Image selectById(int id);

    //更新预测值，初始化预测值为0表示尚未预测
    @Update({"update ", TABLE_NAME, " set predict=#{predict} where id=#{id}"})
    void updatePredict(@Param("predict") int predict, @Param("id") int id);
}
