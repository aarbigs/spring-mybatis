package mybatis.services;

import mybatis.mappers.UserMapper;
import mybatis.mymodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by aaron on 7/24/17.
 */
@Service
public class UserService {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Autowired
    UserMapper userMapper;

    public ArrayList<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    public User getById(int id){
        return null;
    }

    public ArrayList<User> getAllUsersManually(){
        ArrayList<User> indics = new ArrayList<>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("Signing into database...");
            connection = DriverManager.getConnection("jdbc:mysql://localhost?" +
                    "user=root&password=Password&useSSL=false");

            // Statements allow to issue SQL queries to the database
            statement = connection.createStatement();

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("SELECT * FROM `mybatis-test`.Users;");


            try {
                while (resultSet.next()) {

                    User wbi = new User();
                    wbi.setId(resultSet.getInt("id"));
                    wbi.setFirst_name(resultSet.getString("first_name"));
                    wbi.setLast_name(resultSet.getString("last_name"));
                    wbi.setIsActive(resultSet.getInt("isActive"));

                    indics.add(wbi);
                }

            }
            catch(SQLException e){

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return indics;
    }

    public User addNew(User user) {
        userMapper.addNew(user);
        return userMapper.getUserByFirstName(user.getFirst_name());
    }

    public User updateById(User user) {
        userMapper.updateUserById(user);
        return userMapper.getUserByFirstName(user.getFirst_name());
    }

    public int deleteById(int id) {
        return userMapper.deleteUserById(id);

    }
}
