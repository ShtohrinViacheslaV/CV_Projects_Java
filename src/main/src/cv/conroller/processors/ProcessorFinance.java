package cv.conroller.processors;

import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;

public class ProcessorFinance extends Processor {

    public ProcessorFinance() {
        actionToPerform = "finance";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("Finance processor.....");
        return new ProcessorResult("pages/cv_finance.jsp", true, null);
    }
}
