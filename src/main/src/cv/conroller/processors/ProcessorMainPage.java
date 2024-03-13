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
        return new ProcessorResult("index.jsp", true, null);
    }
}
