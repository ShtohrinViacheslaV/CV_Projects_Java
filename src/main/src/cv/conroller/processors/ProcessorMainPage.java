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
        String username = request.getParameter("username");
        request.getSession().setAttribute("username", username);
        return new ProcessorResult("pages/template.jsp", true, null);
    }
}
