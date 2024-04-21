////ProfessionDAO.java
//
//package cv.dao;
//
//import cv.model.Profession;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProfessionDAO {
//    private static final String JDBC_URL = "jdbc:h2:~/cv1";
//    private static final String JDBC_USERNAME = "root";
//    private static final String JDBC_PASSWORD = "root";
//    private static final String SELECT_ALL_SQL = "SELECT * FROM Profession";
//
//    public List<Profession> getAllProfessions() {
//        List<Profession> professions = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
//
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {
//            while (resultSet.next()) {
//                Profession profession = new Profession(resultSet.getInt("id"), resultSet.getString("name"));
//                professions.add(profession);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // Можна також обробити виняток іншим способом, наприклад, кинути власний виняток DAOException
//        }
//        return professions;
//    }
//}
package cv.dao;

import cv.model.Profession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessionDAO {
//    private static final String DB_URL = "jdbc:h2:~/cv1";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "root";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Profession";

    public List<Profession> getAllProfessions() {
        List<Profession> professions = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_SQL)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Profession profession = new Profession(id, name);
                professions.add(profession);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professions;
    }
}
