// CVDAO.java

package cv.dao;

import cv.model.CV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class CVDAO {
    private static final String DB_URL = "jdbc:h2:~/cv1";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

//    public int getNextAvailableId() {
//        String query = "SELECT MAX(id) FROM CV"; // Припустимо, що ідентифікатори генеруються автоматично
//
//        try (Connection connection = ConnectionManager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query);
//             ResultSet resultSet = statement.executeQuery()) {
//
//            if (resultSet.next()) {
//                int maxId = resultSet.getInt(1);
//                return maxId + 1;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return 1; // Повертаємо 1, якщо не вдалося отримати максимальний ідентифікатор
//    }

    public CV getCVById(int id) {
        CV cv = null;
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CV WHERE ID = ?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID");
                String name = rs.getString("Name");
                int profession_id = rs.getInt("Profession_ID");
                String email = rs.getString("Email");
                String education = rs.getString("Education");
                String experience = rs.getString("Experience");
                String skills = rs.getString("Skills");
                cv = new CV(id, name, profession_id, email, education, experience, skills);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cv;
    }

//    public CV getCVById(int id) {
//        CV cv = null;
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CV WHERE ID = ?")) {
//            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//                id = rs.getInt("ID");
//                String name = rs.getString("Name");
//                int profession_id = rs.getInt("Profession_ID");
//                String email = rs.getString("Email");
//                String education = rs.getString("Education");
//                String experience = rs.getString("Experience");
//                String skills = rs.getString("Skills");
//                cv = new CV(id, name, profession_id, email, education, experience, skills);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return cv;
//    }


//    public List<CV> getAllCVs() {
//        List<CV> cvList = new ArrayList<>();
//        try (Connection conn = ConnectionManager.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM CV")) {
//
//            while (rs.next()) {
//                int id = rs.getInt("ID");
//                String name = rs.getString("Name");
//                int profession_id = rs.getInt("Profession_ID");
//                String email = rs.getString("Email");
//                String education = rs.getString("Education");
//                String experience = rs.getString("Experience");
//                String skills = rs.getString("Skills");
//                CV cv = new CV(id, name, profession_id, email, education, experience, skills);
//                cvList.add(cv);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return cvList;
//    }


    public List<CV> getAllCVs() {
        List<CV> cvList = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CV");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                int profession_id = rs.getInt("Profession_ID");
                String email = rs.getString("Email");
                String education = rs.getString("Education");
                String experience = rs.getString("Experience");
                String skills = rs.getString("Skills");
                CV cv = new CV(id, name, profession_id, email, education, experience, skills);
                cvList.add(cv);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cvList;
    }

    public String getProfessionNameById(int professionId) {
        String professionName = "";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT name FROM profession WHERE id = ?")) {

            statement.setInt(1, professionId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                professionName = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professionName;
    }


//    public String getProfessionNameById(int professionId) {
//        String professionName = "";
//        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement statement = connection.prepareStatement("SELECT name FROM profession WHERE id = ?")) {
//            statement.setInt(1, professionId);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                professionName = resultSet.getString("name");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return professionName;
//    }


    public List<CV> getCVsByProfessionId(int professionId) {
        List<CV> cvList = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CV WHERE Profession_ID = ?")) {

            pstmt.setInt(1, professionId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String education = rs.getString("Education");
                String experience = rs.getString("Experience");
                String skills = rs.getString("Skills");
                CV cv = new CV(id, name, professionId, email, education, experience, skills);
                cvList.add(cv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cvList;
    }

//    public List<CV> getCVsByProfessionId(int professionId) {
//        List<CV> cvList = new ArrayList<>();
//        try {
//            Class.forName("org.h2.Driver");
//            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM CV WHERE Profession_ID = ?");
//            pstmt.setInt(1, professionId);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("ID");
//                String name = rs.getString("Name");
//                String email = rs.getString("Email");
//                String education = rs.getString("Education");
//                String experience = rs.getString("Experience");
//                String skills = rs.getString("Skills");
//                CV cv = new CV(id, name, professionId, email, education, experience, skills);
//                cvList.add(cv);
//            }
//            pstmt.close();
//            conn.close();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return cvList;
//    }


    public void addCV(CV cv) {
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO CV (Name, Profession_ID, Email, Education, Experience, Skills) VALUES (?, ?, ?, ?, ?, ?)")) {

            pstmt.setString(1, cv.getName());
            pstmt.setInt(2, cv.getProfession_id());
            pstmt.setString(3, cv.getEmail());
            pstmt.setString(4, cv.getEducation());
            pstmt.setString(5, cv.getWork_experience());
            pstmt.setString(6, cv.getSkills());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void addCV(CV cv) {
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO CV (Name, Profession_ID, Email, Education, Experience, Skills) VALUES (?, ?, ?, ?, ?, ?)")) {
//            pstmt.setString(1, cv.getName());
//            pstmt.setInt(2, cv.getProfession_id());
//            pstmt.setString(3, cv.getEmail());
//            pstmt.setString(4, cv.getEducation());
//            pstmt.setString(5, cv.getWork_experience());
//            pstmt.setString(6, cv.getSkills());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public void updateCV(CV cv) {
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE CV SET Name=?, Profession_ID=?, Email=?, Education=?, Experience=?, Skills=? WHERE ID=?")) {

            pstmt.setString(1, cv.getName());
            pstmt.setInt(2, cv.getProfession_id());
            pstmt.setString(3, cv.getEmail());
            pstmt.setString(4, cv.getEducation());
            pstmt.setString(5, cv.getWork_experience());
            pstmt.setString(6, cv.getSkills());
            pstmt.setInt(7, cv.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    public void updateCV(CV cv) {
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(
//                     "UPDATE CV SET Name=?, Profession_ID=?, Email=?, Education=?, Experience=?, Skills=? WHERE ID=?")) {
//            pstmt.setString(1, cv.getName());
//            pstmt.setInt(2, cv.getProfession_id());
//            pstmt.setString(3, cv.getEmail());
//            pstmt.setString(4, cv.getEducation());
//            pstmt.setString(5, cv.getWork_experience());
//            pstmt.setString(6, cv.getSkills());
//            pstmt.setInt(7, cv.getId());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public void deleteCV(int id) {
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM CV WHERE ID = ?")) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



//    public void deleteCV(int id) {
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM CV WHERE ID = ?")) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

//
////package cv.dao;
////
////import cv.model.CV;
////
////import java.sql.*;
////import java.util.ArrayList;
////import java.util.List;
////
////public class CVDAO {
////    private static final String DB_URL = "jdbc:h2:~/cv1";
////    private static final String DB_USER = "root";
////    private static final String DB_PASSWORD = "root";
////
////    public List<CV> getAllCVs() {
////        List<CV> cvList = new ArrayList<>();
////        try {
////            Class.forName("org.h2.Driver");
////            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
////            Statement stmt = conn.createStatement();
////            ResultSet rs = stmt.executeQuery("SELECT * FROM CV");
////            while (rs.next()) {
////                int id = rs.getInt("ID");
////                String name = rs.getString("Name");
////                int profession_id = rs.getInt("Profession_ID"); // Оновлено, використовуйте правильне ім'я стовпця
////                String email = rs.getString("Email");
////                String education = rs.getString("Education");
////                String experience = rs.getString("Experience"); // Оновлено, використовуйте правильне ім'я стовпця
////                String skills = rs.getString("Skills");
////                CV cv = new CV(id, name, profession_id, email, education, experience, skills); // Оновлено, використовуйте правильні назви параметрів
////                cvList.add(cv);
////            }
////        } catch (SQLException | ClassNotFoundException e) {
////            e.printStackTrace();
////        }
////        return cvList;
////    }
////
////    public void addCV(CV cv) {
////        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
////             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO CV (Name, Profession_ID, Email, Education, Experience, Skills) VALUES (?, ?, ?, ?, ?, ?)")) {
////            pstmt.setString(1, cv.getName());
////            pstmt.setInt(2, cv.getProfession_id());
////            pstmt.setString(3, cv.getEmail());
////            pstmt.setString(4, cv.getEducation());
////            pstmt.setString(5, cv.getWork_experience());
////            pstmt.setString(6, cv.getSkills());
////            pstmt.executeUpdate();
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
////
////    public void updateCV(CV cv) {
////        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
////             PreparedStatement pstmt = conn.prepareStatement(
////                     "UPDATE CV SET Name=?, Profession_ID=?, Email=?, Education=?, Experience=?, Skills=? WHERE ID=?")) {
////            pstmt.setString(1, cv.getName());
////            pstmt.setInt(2, cv.getProfession_id());
////            pstmt.setString(3, cv.getEmail());
////            pstmt.setString(4, cv.getEducation());
////            pstmt.setString(5, cv.getWork_experience());
////            pstmt.setString(6, cv.getSkills());
////            pstmt.setInt(7, cv.getId());
////            pstmt.executeUpdate();
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
////}
