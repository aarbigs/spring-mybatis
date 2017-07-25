package mybatis.mappers;

import mybatis.mymodel.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

/**
 * Created by aaron on 7/24/17.
 */
@Mapper
public interface UserMapper {

    String GET_ALL_ACTIVE_USERS = "SELECT * FROM `mybatis-test`.Users where isActive =1";
    String GET_BY_ID = "SELECT * FROM `mybatis-test`.Users where id = #{id}";

    @Select(GET_ALL_ACTIVE_USERS)
    public ArrayList<User> getAllUsers();

    String INSERT_USER = "Insert into `mybatis-test`.Users (first_name, last_name, isActive) values (#{first_name},#{last_name}, #{isActive})";
    String GET_BY_FIRST_NAME = "SELECT * FROM `mybatis-test`.Users where first_name = #{first_name}";
    String UPDATE_USER = "UPDATE `mybatis-test`.Users set first_name=#{first_name}, last_name=#{last_name}, isActive=#{isActive} where id=#{id}";
    String DELETE_USER = "UPDATE `mybatis-test`.Users SET isActive=0 WHERE id=#{id}";

    @Insert(INSERT_USER)
    public void addNew(User user);

    @Select (GET_BY_FIRST_NAME)
    public User getUserByFirstName(String first_name);

    @Update(UPDATE_USER)
    public void updateUserById (User user);

    @Update(DELETE_USER)
    public int deleteUserById (int id);







}
