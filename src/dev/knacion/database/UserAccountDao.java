package dev.knacion.database;

import dev.knacion.model.UserAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDao {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/customer_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    private static Connection connection;

    public UserAccountDao() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<UserAccount> getAllUsers() {
        List<UserAccount> userList = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user_table");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                userList = new ArrayList<>();
                userList.add(new UserAccount(username, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static UserAccount getUser(String username, String password) {
        UserAccount user = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer_db.user_table WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");
                user = new UserAccount(dbUsername, dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        super.finalize();
    }
}
