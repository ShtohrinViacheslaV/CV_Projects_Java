package cv.conroller.processors;

import cv.model.CV;
import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class ProcessorShowAllCV extends Processor {

    public ProcessorShowAllCV() {
        actionToPerform = "showAllCV";
    }


    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        List<CV> cvList = new ArrayList<>();
        cvList.add(new CV("Alex", "IT", "IT", "Student jobs at university", "Management"));
        cvList.add(new CV("Leo", "Finance", "Finance", "Student jobs at university", "Finance"));
        cvList.add(new CV("John", "Marketing", "Marketing", "Internship at a marketing agency", "Marketing"));

        request.setAttribute("cvList", cvList);

        return new ProcessorResult("/pages/template.jsp", true, "/pages/showAllCV.jsp");
    }
}
