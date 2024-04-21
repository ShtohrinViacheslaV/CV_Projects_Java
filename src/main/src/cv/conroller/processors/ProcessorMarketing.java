//ProcessorMarketing.java

package cv.conroller.processors;

import cv.model.CV;
import cv.model.ProcessorResult;
import cv.dao.CVDAO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class ProcessorMarketing extends Processor {

    private final CVDAO cvDAO;

    public ProcessorMarketing(CVDAO cvDAO) {
        this.cvDAO = cvDAO;
        actionToPerform = "marketing";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("Marketing processor.....");
        List<CV> marketingCVs = cvDAO.getCVsByProfessionId(3); // Отримати всі резюме для IT (profession_id = 1)
        request.setAttribute("marketingCVs", marketingCVs); // Передати список резюме в атрибут запиту
        return new ProcessorResult("pages/cv_marketing.jsp", true, null);
    }
}
