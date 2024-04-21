//ProcessorFinance.java

package cv.conroller.processors;

import cv.model.CV;
import cv.model.ProcessorResult;
import cv.dao.CVDAO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class ProcessorFinance extends Processor {

    private final CVDAO cvDAO;

    public ProcessorFinance(CVDAO cvDAO) {
        this.cvDAO = cvDAO;
        actionToPerform = "finance";

    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("Finance processor.....");
        List<CV> financeCVs = cvDAO.getCVsByProfessionId(2); // Отримати всі резюме для IT (profession_id = 1)
        request.setAttribute("financeCVs", financeCVs); // Передати список резюме в атрибут запиту
        return new ProcessorResult("pages/cv_finance.jsp", true, null);
    }
}
