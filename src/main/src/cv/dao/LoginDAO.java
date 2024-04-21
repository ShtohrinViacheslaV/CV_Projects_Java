//// UsernameDAO.java
//
//package cv.dao;
//import cv.model.Username;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UsernameDAO {
//    private static final String JDBC_URL = "jdbc:h2:~/cv1";
//    private static final String JDBC_USERNAME = "root";
//    private static final String JDBC_PASSWORD = "root";
//    private static final String INSERT_SQL = "INSERT INTO Username (Name, Email, Password) VALUES (?, ?, ?)";
//    private static final String SELECT_BY_EMAIL_SQL = "SELECT * FROM Username WHERE Email=?";
//    private static final String SELECT_BY_ID_SQL = "SELECT * FROM Username WHERE ID=?";
//
//    public void addUsername(Username username) {
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
//             PreparedStatement statement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, username.getName());
//            statement.setString(2, username.getEmail());
//            statement.setString(3, username.getPassword());
//            statement.executeUpdate();
//
//            ResultSet rs = statement.getGeneratedKeys();
//            if (rs.next()) {
//                int id = rs.getInt(1);
//                username.setId(id);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Username getUsernameByEmail(String email) {
//        Username username = null;
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL_SQL)) {
//            statement.setString(1, email);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    username = new Username(resultSet.getInt("ID"),
//                            resultSet.getString("Name"),
//                            resultSet.getString("Email"),
//                            resultSet.getString("Password"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return username;
//    }
//
//    public Username getUsernameById(int id) {
//        Username username = null;
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
//            statement.setInt(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    username = new Username(resultSet.getInt("ID"),
//                            resultSet.getString("Name"),
//                            resultSet.getString("Email"),
//                            resultSet.getString("Password"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return username;
//    }
//}
package cv.dao;

import java.sql.*;

public class LoginDAO {

    public void logUserLogin(String username) {
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Login (username, login_time) VALUES (?, ?)")) {

            preparedStatement.setString(1, username);
            preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//    public boolean isValidUser(String username, String password) {
//        boolean isValid = false;
//        Connection conn = null;
//        PreparedStatement stmtUsername = null;
//        PreparedStatement stmtPassword = null;
//        ResultSet rsUsername = null;
//        ResultSet rsPassword = null;
//
//        try {
//            // Отримання з'єднання з базою даних
//            conn = ConnectionManager.getConnection();
//
//            // Підготовка SQL-запиту для перевірки користувача за іменем
//            String sqlUsername = "SELECT * FROM Username WHERE name = ?";
//            stmtUsername = conn.prepareStatement(sqlUsername);
//            stmtUsername.setString(1, username);
//            rsUsername = stmtUsername.executeQuery();
//
//            // Якщо знайдено користувача з вказаним іменем, перевіряємо пароль
//            if (rsUsername.next()) {
//                // Підготовка SQL-запиту для перевірки пароля
//                String sqlPassword = "SELECT * FROM Username WHERE password = ?";
//                stmtPassword = conn.prepareStatement(sqlPassword);
//                stmtPassword.setString(1, password);
//                rsPassword = stmtPassword.executeQuery();
//
//                // Якщо знайдено користувача з вказаним паролем, встановлюємо isValid на true
//                if (rsPassword.next()) {
//                    System.out.println("DB true");
//                    isValid = true;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("DB false");
//            // Обробка помилок доступу до бази даних
//        } finally {
//            // Закриття ресурсів
//            try {
//                if (rsUsername != null) rsUsername.close();
//                if (rsPassword != null) rsPassword.close();
//                if (stmtUsername != null) stmtUsername.close();
//                if (stmtPassword != null) stmtPassword.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                // Обробка помилок при закритті з'єднання
//            }
//        }
//
//        return isValid;
//    }

//
//    public void addUsername(Username username) {
//        try (Connection conn = ConnectionManager.getConnection();
//             PreparedStatement statement = conn.prepareStatement(INSERT_SQL)) {
//            statement.setString(1, username.getName());
//            statement.setString(2, username.getEmail());
//            statement.setString(3, username.getPassword());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Username getUsernameByEmail(String email) {
//        Username username = null;
//        try (Connection connection = ConnectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL_SQL)) {
//
//            statement.setString(1, email);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    username = new Username(
//                            resultSet.getInt("ID"),
//                            resultSet.getString("Name"),
//                            resultSet.getString("Email"),
//                            resultSet.getString("Password"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return username;
//    }
//
//    public Username getUsernameById(int id) {
//        Username username = null;
//        try (Connection connection = ConnectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_SQL)) {
//
//            statement.setInt(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    username = new Username(
//                            resultSet.getInt("ID"),
//                            resultSet.getString("Name"),
//                            resultSet.getString("Email"),
//                            resultSet.getString("Password"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return username;
//    }
//}
