////ProcessorShowAllCV
//package cv.conroller.processors;
//
//import cv.dao.CVDAO;
//import cv.model.CV;
//import cv.model.ProcessorResult;
//import jakarta.servlet.http.HttpServletRequest;
//
//import java.util.List;
//
//public class ProcessorShowAllCV extends Processor {
//
//    private CVDAO cvDAO;
//
//    public ProcessorShowAllCV(CVDAO cvDAO) {
//        this.cvDAO = cvDAO;
//        actionToPerform = "showAllCV";
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        List<CV> cvList = cvDAO.getAllCVs();
//        request.setAttribute("cvList", cvList);
//        return new ProcessorResult("/pages/showAllCV.jsp", true, null);
//        //return new ProcessorResult("/pages/template.jsp", true, "/pages/showAllCV.jsp");
//
//    }
//}
package cv.conroller.processors;

import cv.dao.CVDAO;
import cv.model.CV;
import cv.model.ProcessorResult;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


//

public class ProcessorShowAllCV extends Processor {

    private final CVDAO cvDAO;

    public ProcessorShowAllCV(CVDAO cvDAO) {
        this.cvDAO = cvDAO;
        actionToPerform = "showAllCV";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        List<CV> cvList = cvDAO.getAllCVs();
        request.setAttribute("cvList", cvList);

        return new ProcessorResult("/pages/showAllCV.jsp", true, null);
    }
}
