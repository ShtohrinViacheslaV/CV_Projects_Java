package cv.conroller.processors;

import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;

public class ProcessorMainPage extends Processor {

    public ProcessorMainPage() {
        actionToPerform = "mainpage";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("Main page processor.....");
        String username = (String) request.getSession().getAttribute("username"); // Отримати ім'я користувача з сесії
        return new ProcessorResult("pages/template.jsp", true, username); // Передати ім'я користувача в якості параметра
    }
}
////ProcessorMainPage.java
//
//package cv.conroller.processors;
//
//import cv.model.ProcessorResult;
//import jakarta.servlet.http.HttpServletRequest;
//
//public class ProcessorMainPage extends Processor {
//
//    public ProcessorMainPage() {
//        actionToPerform = "mainpage";
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        System.out.println("Main page processor.....");
//        String username = request.getParameter("username");
//        request.getSession().setAttribute("username", username);
//        return new ProcessorResult("pages/template.jsp", true, null);
//    }
//}
