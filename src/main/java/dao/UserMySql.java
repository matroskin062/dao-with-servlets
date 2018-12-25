package dao;

import entities.User;

import java.sql.*;
import java.util.ArrayList;

public class UserMySql implements UserDao {

    private final String INSERT = "insert into test_table(name, age) values (?,?)";
    private final String GET_BY_ID = "select * from test_table where id=?";
    private final String GET_ALL = "select * from test_table";
    private final String DELETE = "delete from test_table where id=?";
    private final String UPDATE = "update test_table set name=?, age=? where id=?";

    private final String url = "jdbc:mysql://localhost:3306/lab1DB";
    private final String user = "root";
    private final String pass = "dopeclub";

    private Connection connection;
    private PreparedStatement statement;

    public UserMySql(){
        try{
            connection = DriverManager.getConnection(url, user, pass);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

//    public void closeConnection() {
//        if(connection != null){
//            try{
//                connection.close();
//            }catch (SQLException ex){
//                ex.printStackTrace();
//            }
//        }
//    }

    public void insert(User entity) {
        if(connection != null){
            try{
                statement = connection.prepareStatement(INSERT);
                statement.setInt(1, entity.getId());
                statement.setString(1, entity.getName());
                statement.setInt(2, entity.getAge());
                statement.executeUpdate();
                ResultSet set = connection.prepareStatement("SELECT LAST_INSERT_ID() id").executeQuery();
                set.first();
                entity.setId(set.getInt("id"));
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public User getById(int id) {
        if(connection != null){
            try {
                statement = connection.prepareStatement(GET_BY_ID);
                statement.setInt(1, id);

                ResultSet rs = statement.executeQuery();
                if(rs.next()){
                    User user = new User (
                                rs.getString("name"),
                                rs.getInt("age")
                            );
                    user.setId(rs.getInt("id"));
                    return user;
                }

            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return null;
    }

    public void update(User entity) {
        if (connection != null){
            try{
                statement = connection.prepareStatement(UPDATE);
                statement.setString(1, entity.getName());
                statement.setInt(2, entity.getAge());
                statement.setInt(3, entity.getId());
                statement.executeUpdate();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void delete(User entity) {
        if (connection != null){
            try{
                statement = connection.prepareStatement(DELETE);
                statement.setInt(1, entity.getId());
                statement.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public ArrayList<User> getAll() {
        ArrayList<User> res = new ArrayList<User>();

        if (connection != null){
            Statement statement = null;
            try{
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(GET_ALL);
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int age = resultSet.getInt(3);
                    res.add(new User(id, name, age));
                }
                return res;
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public void truncate(){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE test_table");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
