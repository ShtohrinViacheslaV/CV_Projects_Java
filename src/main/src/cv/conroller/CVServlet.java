package cv.conroller;

import cv.dao.CVDAO;
import cv.conroller.processors.*;
import cv.dao.LoginDAO;
import cv.model.CV;
import cv.model.ProcessorResult;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "CVServlet", urlPatterns = "/cvservlet")
public class CVServlet extends HttpServlet {
    private List<Processor> processorList = new ArrayList<>();
    private List<CV> allCVs; // Поле для зберігання всіх резюме

    private CVDAO cvDAO; // Додаємо змінну cvDAO для взаємодії з базою даних
    private Properties properties;
    private LoginDAO loginDAO;


    @Override
    public void init() throws ServletException {
        super.init();
        cvDAO = new CVDAO(); // Ініціалізуємо cvDAO
        allCVs = cvDAO.getAllCVs(); // Завантажуємо всі резюме при старті сервлета
        loadProperties();

        processorList.add(new ProcessorWelcome(properties, loginDAO));
        processorList.add(new ProcessorRegistration(properties));
        processorList.add(new ProcessorMainPage());
        processorList.add(new ProcessorIT(cvDAO));
        processorList.add(new ProcessorMarketing(cvDAO));
        processorList.add(new ProcessorFinance(cvDAO));
        processorList.add(new ProcessorLogOut());
        processorList.add(new ProcessorShowAllCV(cvDAO)); // Передаємо cvDAO у конструктор процесора
        processorList.add(new ProcessorAddCV(cvDAO)); // Передаємо cvDAO у конструктор процесора
        processorList.add(new ProcessorEditCV(cvDAO)); // Передаємо cvDAO у конструктор процесора
        processorList.add(new ProcessorDeleteCV(cvDAO)); // Передаємо cvDAO у конструктор процесора
        processorList.add(new ProcessorUpdateCV(cvDAO)); // Додайте новий процесор оновлення CV



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");



        if (action == null || action.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/pages/template.jsp");
            return;
        }

        System.out.println("In servlet for action: " + action);

        for (Processor processor : processorList) {
            if (processor.canHandle(action)) {
                ProcessorResult processorResult = processor.handle(req);
                if (processorResult.isForward()) {
                    req.getRequestDispatcher(processorResult.getUrl()).forward(req, resp);
                } else {
                    resp.sendRedirect(processorResult.getUrl());
                }
                return;
            }
        }
        resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
    }
    private void loadProperties() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cv.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//package cv.conroller;
//
//import cv.conroller.processors.*;
//import cv.dao.CVDAO;
//import cv.model.CV;
//import cv.model.ProcessorResult;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "CVServlet", urlPatterns = "/cvservlet")
//public class CVServlet extends HttpServlet {
//
//    private List<Processor> processorList = new ArrayList<>();
//    private CVDAO cvDAO;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        cvDAO = new CVDAO();
//
//        processorList.add(new ProcessorMainPage());
//        processorList.add(new ProcessorIT());
//        processorList.add(new ProcessorMarketing());
//        processorList.add(new ProcessorFinance());
//        processorList.add(new ProcessorLogOut());
//        processorList.add(new ProcessorShowAllCV(cvDAO));
//        processorList.add(new ProcessorAddCV(cvDAO));
//        processorList.add(new ProcessorEditCV(cvDAO));
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        handleRequest(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        handleRequest(req, resp);
//    }
//
//    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//
//        if (action == null || action.isEmpty()) {
//            resp.sendRedirect(req.getContextPath() + "/pages/template.jsp");
//            return;
//        }
//
//        System.out.println("In servlet for action: " + action);
//
//        for (Processor processor : processorList) {
//            if (processor.canHandle(action)) {
//                ProcessorResult processorResult = processor.handle(req);
//                if (processorResult.isForward()) {
//                    req.getRequestDispatcher(processorResult.getUrl()).forward(req, resp);
//                } else {
//                    resp.sendRedirect(processorResult.getUrl());
//                }
//                return;
//            }
//        }
//        resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
//    }
//}




////// CVServlet.java
//////package cv.conroller;
//////
//////import cv.dao.CVDAO;
//////import cv.conroller.processors.*;
//////import cv.model.ProcessorResult;
//////
//////import jakarta.servlet.ServletException;
//////import jakarta.servlet.annotation.WebServlet;
//////import jakarta.servlet.http.HttpServlet;
//////import jakarta.servlet.http.HttpServletRequest;
//////import jakarta.servlet.http.HttpServletResponse;
//////
//////import java.io.IOException;
//////import java.io.PrintWriter;
//////import java.sql.*;
//////import java.util.ArrayList;
//////import java.util.List;
//////
//////@WebServlet(name = "CVServlet", urlPatterns = "/cvservlet")
//////public class CVServlet extends HttpServlet {
//////
//////    private List<Processor> processorList = new ArrayList<>();
//////    private CVDAO cvDAO;
//////
//////    @Override
//////    public void init() throws ServletException {
//////        super.init();
//////        cvDAO = new CVDAO();
//////
//////        processorList.add(new ProcessorMainPage());
//////        processorList.add(new ProcessorIT());
//////        processorList.add(new ProcessorMarketing());
//////        processorList.add(new ProcessorFinance());
//////        processorList.add(new ProcessorLogOut());
//////        processorList.add(new ProcessorShowAllCV(cvDAO));
//////        processorList.add(new ProcessorAddCV(cvDAO));
//////        processorList.add(new ProcessorEditCV(cvDAO));
//////    }
//////
//////    @Override
//////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//////        handleRequest(req, resp);
//////    }
//////
//////    @Override
//////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//////        handleRequest(req, resp);
//////
//////    }
//////
//////
//////    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//////        String action = req.getParameter("action");
//////
//////        if (action == null || action.isEmpty()) {
//////            resp.sendRedirect(req.getContextPath() + "/pages/template.jsp");
//////            return;
//////        }
//////
//////        System.out.println("In servlet for action: " + action);
//////
//////        for (Processor processor : processorList) {
//////            if (processor.canHandle(action)) {
//////                ProcessorResult processorResult = processor.handle(req);
//////                if (processorResult.isForward()) {
//////                    req.getRequestDispatcher(processorResult.getUrl()).forward(req, resp);
//////                } else {
//////                    resp.sendRedirect(processorResult.getUrl());
//////                }
//////                return;
//////            }
//////        }
//////        resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
//////    }
//////}
//////        PrintWriter pw = resp.getWriter();
//////        Connection conn = null;
//////
//////        try {
//////            Class.forName("org.h2.Driver");
//////            conn = DriverManager.getConnection("jdbc:h2:~/cv1", "root", "root");
//////            Statement stmt = conn.createStatement();
//////            ResultSet rs = stmt.executeQuery("SELECT name FROM Username");
//////
//////            while (rs.next()) {
//////                pw.println(rs.getString("name"));
//////            }
//////
//////            rs.close();
//////            stmt.close();
//////        } catch (ClassNotFoundException | SQLException e) {
//////            // Log the exception or provide a more meaningful error message
//////            throw new ServletException("Error retrieving data from database", e);
//////        }
//////        finally{
//////            try {
//////                conn.close();
//////            } catch (SQLException e) {
//////                throw new RuntimeException(e);
//////            }
//////        }
//////    }
////
////
////
////package cv.conroller;
////
////import cv.dao.CVDAO;
////import cv.conroller.processors.*;
////        import cv.model.ProcessorResult;
////
////import jakarta.servlet.ServletException;
////import jakarta.servlet.annotation.WebServlet;
////import jakarta.servlet.http.HttpServlet;
////import jakarta.servlet.http.HttpServletRequest;
////import jakarta.servlet.http.HttpServletResponse;
////
////import java.io.IOException;
////import java.util.ArrayList;
////import java.util.List;
////
////@WebServlet(name = "CVServlet", urlPatterns = "/cvservlet")
////public class CVServlet extends HttpServlet {
////
////    private List<Processor> processorList = new ArrayList<>();
////    private CVDAO cvDAO;
////
////    @Override
////    public void init() throws ServletException {
////        super.init();
////        cvDAO = new CVDAO();
////
////        processorList.add(new ProcessorMainPage());
////        processorList.add(new ProcessorIT());
////        processorList.add(new ProcessorMarketing());
////        processorList.add(new ProcessorFinance());
////        processorList.add(new ProcessorLogOut());
////        processorList.add(new ProcessorShowAllCV(cvDAO));
////        processorList.add(new ProcessorAddCV(cvDAO));
////        processorList.add(new ProcessorEditCV(cvDAO));
////    }
////
////    @Override
////    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        handleRequest(req, resp);
////    }
////
////    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        handleRequest(req, resp);
////    }
////
////    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String action = req.getParameter("action");
////
////        if (action == null || action.isEmpty()) {
////            resp.sendRedirect(req.getContextPath() + "/pages/template.jsp");
////            return;
////        }
////
////        System.out.println("In servlet for action: " + action);
////
////        for (Processor processor : processorList) {
////            if (processor.canHandle(action)) {
////                ProcessorResult processorResult = processor.handle(req);
////                if (processorResult.isForward()) {
////                    req.getRequestDispatcher(processorResult.getUrl()).forward(req, resp);
////                } else {
////                    resp.sendRedirect(processorResult.getUrl());
////                }
////                return;
////            }
////        }
////        resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
////    }
////}
////
//package cv.conroller;
//
//import cv.conroller.processors.Processor;
//import cv.dao.CVDAO;
//import cv.dao.ProfessionDAO;
//import cv.dao.UsernameDAO;
//import cv.model.CV;
//import cv.model.Profession;
//import cv.model.Username;
//import cv.conroller.processors.*;
//import cv.model.ProcessorResult;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "CVServlet", urlPatterns = "/cvservlet")
//public class CVServlet extends HttpServlet {
//
//    private List<Processor> processorList = new ArrayList<>();
//    private CVDAO cvDAO;
//    private ProfessionDAO professionDAO;
//    private UsernameDAO usernameDAO;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        cvDAO = new CVDAO();
//        professionDAO = new ProfessionDAO();
//        usernameDAO = new UsernameDAO();
//
//        processorList.add(new ProcessorMainPage());
//        processorList.add(new ProcessorIT());
//        processorList.add(new ProcessorMarketing());
//        processorList.add(new ProcessorFinance());
//        processorList.add(new ProcessorLogOut());
//        processorList.add(new ProcessorShowAllCV(cvDAO));
//        processorList.add(new ProcessorAddCV(cvDAO, professionDAO));
//        processorList.add(new ProcessorEditCV(cvDAO, professionDAO));
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        handleRequest(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        handleRequest(req, resp);
//    }
//
//    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//
//        if (action == null || action.isEmpty()) {
//            resp.sendRedirect(req.getContextPath() + "/pages/template.jsp");
//            return;
//        }
//
//        System.out.println("In servlet for action: " + action);
//
//        for (Processor processor : processorList) {
//            if (processor.canHandle(action)) {
//                ProcessorResult processorResult = processor.handle(req);
//                if (processorResult.isForward()) {
//                    req.getRequestDispatcher(processorResult.getUrl()).forward(req, resp);
//                } else {
//                    resp.sendRedirect(processorResult.getUrl());
//                }
//                return;
//            }
//        }
//        resp.sendRedirect(req.getContextPath() + "/pages/index.jsp");
//    }
//}
