// ProcessorDeleteCV.java
package cv.conroller.processors;

import cv.dao.CVDAO;
import cv.model.ProcessorResult;

import jakarta.servlet.http.HttpServletRequest;

public class ProcessorDeleteCV extends Processor {

    private final CVDAO cvDAO;

    public ProcessorDeleteCV(CVDAO cvDAO) {
        this.cvDAO = cvDAO;
        actionToPerform = "deleteCV";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        cvDAO.deleteCV(id);
        return new ProcessorResult("/cv/cvservlet?action=showAllCV", false, null);
    }
}
