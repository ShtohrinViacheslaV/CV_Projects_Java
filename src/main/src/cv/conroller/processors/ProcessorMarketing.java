package cv.conroller.processors;

import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;

public class ProcessorMarketing extends Processor {

    public ProcessorMarketing() {
        actionToPerform = "marketing";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("Marketing processor.....");
        return new ProcessorResult("/cv_marketing.jsp", true, null);
    }
}
