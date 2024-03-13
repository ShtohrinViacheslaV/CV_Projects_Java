package cv.conroller.processors;

import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;

public class ProcessorIT extends Processor {

    public ProcessorIT() {
        actionToPerform = "it";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("IT processor.....");
        return new ProcessorResult("/cv_it.jsp", true, null);
    }
}
