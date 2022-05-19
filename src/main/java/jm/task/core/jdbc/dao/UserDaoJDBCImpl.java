package jm.task.core.jdbc.dao;

/*
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Util util = new Util();
    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Statement statement = util.connection.createStatement();
            statement.execute("create table if not exists UsersTable" +
                    "(id bigint NOT NULL PRIMARY KEY AUTO_INCREMENT, name varchar(255) NOT NULL, lastName varchar(255), age int)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Statement statement = util.connection.createStatement();
            statement.execute("drop table UsersTable");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement statement = util.connection.prepareStatement("insert into UsersTable(name, lastName, age) values (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            PreparedStatement statement = util.connection.prepareStatement("delete from UsersTable where id =?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        User user = null;
        try {
            Statement statement = util.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM UsersTable");
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
                for (User users : userList)
                    System.out.println(users);
            }
            */
/*while (resultSet.next()) {
                userList.add(new User(resultSet.getString("name"), resultSet.getString("lastName"), resultSet.getByte("age")));
            }*//*

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Statement statement = util.connection.createStatement();
            statement.executeUpdate("truncate table UsersTable");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/
