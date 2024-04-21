package cv.conroller.processors;

import cv.dao.CVDAO;
import cv.model.CV;
import cv.model.ProcessorResult;

import jakarta.servlet.http.HttpServletRequest;

public class ProcessorUpdateCV extends Processor {

    private final CVDAO cvDAO;

    public ProcessorUpdateCV(CVDAO cvDAO) {
        this.cvDAO = cvDAO;
        actionToPerform = "updateCV";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int professionId = Integer.parseInt(request.getParameter("profession_id"));
        String email = request.getParameter("email");
        String education = request.getParameter("education");
        String workExperience = request.getParameter("work_experience");
        String skills = request.getParameter("skills");

        CV cv = new CV(id, name, professionId, email, education, workExperience, skills);
        cvDAO.updateCV(cv);

        return new ProcessorResult("/cvservlet?action=showAllCV", true, null);
    }
}
