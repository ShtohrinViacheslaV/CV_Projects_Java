package cv.conroller.processors;

import java.util.Properties;
import java.io.FileOutputStream;
import java.io.IOException;

import cv.dao.LoginDAO;
import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ProcessorWelcome extends Processor {

    private Properties properties;
    private LoginDAO loginDAO;

    public ProcessorWelcome(Properties properties, LoginDAO loginDAO) {
        this.loginDAO = new LoginDAO(); // Initialize the LoginDAO instance
        actionToPerform = "welcome";
        this.properties = properties;
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("Welcome processor.....");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (properties.containsKey(username) && properties.getProperty(username).equals(password)) {
            // Якщо користувач існує у файлі properties і відповідний пароль співпадає, то зберегти ім'я користувача в сесії
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            System.out.println("Account .....");
            loginDAO.logUserLogin(username);

            return new ProcessorResult("/pages/template.jsp", true, null);
        } else {
            // Якщо користувача немає у файлі properties або пароль неправильний, то додати нового користувача до файлу properties
            properties.setProperty(username, password);
            try (FileOutputStream out = new FileOutputStream(getClass().getClassLoader().getResource("cv.properties").getFile())) {
                properties.store(out, null);
                System.out.println("Registration .....");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Registration not .....");
            }

            // Перенаправити користувача на сторінку входу
            return new ProcessorResult("/pages/welcome.jsp", true, null);
        }
    }
}
//package cv.conroller.processors;
//
//import java.util.Properties;
//
//import cv.dao.LoginDAO;
//import cv.model.ProcessorResult;
//import jakarta.servlet.http.HttpServletRequest;
//
//public class ProcessorWelcome extends Processor {
//
//    private Properties properties;
//    private LoginDAO loginDAO;
//
//
//    public ProcessorWelcome(Properties properties) {
//        this.loginDAO = loginDAO;
//        actionToPerform = "welcome";
//        this.properties = properties;
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        System.out.println("Welcome processor.....");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        if (properties.containsKey(username) && properties.getProperty(username).equals(password)) {
//            // Якщо користувач існує у файлі properties і відповідний пароль співпадає, то зберегти ім'я користувача в сесії
//            request.getSession().setAttribute("username", username);
//            System.out.println("Account .....");
//            loginDAO.logUserLogin(username);
//
//            return new ProcessorResult("/pages/template.jsp", true, null);
//        } else {
//            System.out.println("Invalid .....");
//            // Якщо користувача немає у файлі properties або пароль неправильний, то вивести помилку
//            String errorMessage = "Invalid username or password";
//            return new ProcessorResult("/pages/welcome.jsp", true, errorMessage);
//        }
//    }
//}


//package cv.conroller.processors;
//
//import cv.model.ProcessorResult;
//import jakarta.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class ProcessorWelcome extends Processor {
//
//    private Properties properties;
//
//    public ProcessorWelcome() {
//        actionToPerform = "welcome";
//        loadProperties();
//    }
//
//    private void loadProperties() {
//        properties = new Properties();
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream("cv.properties")) {
//            properties.load(input);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        System.out.println("Welcome processor.....");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        // Перевірка логіну та паролю користувача з файлу cv.properties
//        String storedPassword = properties.getProperty(username);
//        if (storedPassword != null && storedPassword.equals(password)) {
//            // Якщо логін та пароль співпадають, перенаправити користувача на головну сторінку
//            request.getSession().setAttribute("username", username);
//            return new ProcessorResult("/pages/template.jsp", true, null);
//        } else {
//            // Якщо логін та пароль не співпадають, повернути повідомлення про помилку
//            String errorMessage = "Invalid username or password";
//            return new ProcessorResult("/pages/welcome.jsp", true, errorMessage);
//        }
//    }
//}

//package cv.conroller.processors;
//
//import cv.dao.UsernameDAO;
//import cv.model.ProcessorResult;
//import jakarta.servlet.http.HttpServletRequest;
//
//public class ProcessorWelcome extends Processor {
//    private UsernameDAO usernameDAO;
//
//    public ProcessorWelcome(UsernameDAO usernameDAO) {
//        actionToPerform = "welcome";
//        this.usernameDAO = usernameDAO;
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        System.out.println("Welcome processor.....");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        // Перевірка чи існує користувач з введеним іменем та паролем в базі даних
//        boolean validUser = usernameDAO.isValidUser(username, password);
//
//        if (validUser) {
//            // Якщо користувач знайдений, встановити сесію та перенаправити на головну сторінку
//            request.getSession().setAttribute("username", username);
//            System.out.println("validUser processor.....");
//
//            return new ProcessorResult("/pages/template.jsp", true, null);
//
//        } else {
//            // Якщо користувач не знайдений, повернути повідомлення про помилку
//            String errorMessage = "Invalid username or password";
//            return new ProcessorResult("/pages/index.jsp", true, errorMessage);
//        }
//    }
//}
//
//
//
////package cv.conroller.processors;
////
////import cv.dao.UsernameDAO; // Імпорт класу для взаємодії з базою даних для перевірки користувача
////import cv.model.ProcessorResult;
////import jakarta.servlet.http.HttpServletRequest;
////
////public class ProcessorWelcome extends Processor {
////    private UsernameDAO usernameDAO; // Поле для взаємодії з базою даних
////
////    public ProcessorWelcome(UsernameDAO usernameDAO) {
////        actionToPerform = "welcome";
////        this.usernameDAO = usernameDAO; // Ініціалізуємо змінну для взаємодії з базою даних через конструктор
////    }
////
////    @Override
////    public ProcessorResult handle(HttpServletRequest request) {
////        System.out.println("Welcome processor.....");
////        String username = request.getParameter("username");
////        String password = request.getParameter("password");
////
////        // Перевірка чи існує користувач з введеним іменем та паролем в базі даних
////        boolean validUser = usernameDAO.isValidUser(username, password);
////
////        if (validUser) {
////            // Якщо користувач знайдений, встановити сесію
////            request.getSession().setAttribute("username", username);
////            // Перенаправити на головну сторінку або будь-яку іншу сторінку
////            return new ProcessorResult("/pages/template.jsp", true, null);
////        } else {
////            // Якщо користувач не знайдений, повернути повідомлення про помилку
////            String errorMessage = "Invalid username or password";
////            return new ProcessorResult("/pages/welcome.jsp", true, errorMessage);
////        }
////    }
////}
