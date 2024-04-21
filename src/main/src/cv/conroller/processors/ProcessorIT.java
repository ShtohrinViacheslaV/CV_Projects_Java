// ProcessorIT.java

package cv.conroller.processors;

import cv.model.CV;
import cv.model.ProcessorResult;
import cv.dao.CVDAO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class ProcessorIT extends Processor {

    private final CVDAO cvDAO;


    public ProcessorIT(CVDAO cvDAO) {
        this.cvDAO = cvDAO;
        actionToPerform = "it";

    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("IT processor.....");
        List<CV> itCVs = cvDAO.getCVsByProfessionId(1); // Отримати всі резюме для IT (profession_id = 1)
        request.setAttribute("itCVs", itCVs); // Передати список резюме в атрибут запиту
        return new ProcessorResult("pages/cv_it.jsp", true, null);
    }
}
