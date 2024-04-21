//// ProcessorEditCV.java

package cv.conroller.processors;

import cv.dao.CVDAO;
import cv.model.CV;
import cv.model.ProcessorResult;
import jakarta.servlet.http.HttpServletRequest;

public class ProcessorEditCV extends Processor {

    private final CVDAO cvDAO;

    public ProcessorEditCV(CVDAO cvDAO) {
        this.cvDAO = cvDAO;
        actionToPerform = "editCV";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        String action = request.getParameter("action");
            System.out.println("Edit processor.....");
            int id = Integer.parseInt(request.getParameter("id"));
            CV cv = cvDAO.getCVById(id);
            if (cv != null) {
                System.out.println("editCV processor.....");
                request.setAttribute("cv", cv);
                return new ProcessorResult("/pages/editCV.jsp", true, null);
            }

        return new ProcessorResult("/pages/showAllCV.jsp", true, null);
    }

}


//package cv.conroller.processors;
//
//import cv.dao.CVDAO;
//import cv.model.CV;
//import cv.model.ProcessorResult;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//public class ProcessorEditCV extends Processor {
//
//    private final CVDAO cvDAO;
//
//    public ProcessorEditCV(CVDAO cvDAO) {
//        this.cvDAO = cvDAO;
//        actionToPerform = "editCV";
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        String action = request.getParameter("action");
//        if ("editCV".equals(action)) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            CV cv = cvDAO.getCVById(id);
//            if (cv != null) {
//                request.setAttribute("cv", cv);
//            }
//            return new ProcessorResult("/pages/editCV.jsp", true, null);
//
//        }
//        else if ("updateCV".equals(action)) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            String name = request.getParameter("name");
//            String professionIdString = request.getParameter("profession_id");
//            int professionId = 0; // Default value or any other default value
//            if (professionIdString != null && !professionIdString.isEmpty()) {
//                professionId = Integer.parseInt(professionIdString);
//            }
//            String email = request.getParameter("email");
//            String education = request.getParameter("education");
//            String workExperience = request.getParameter("work_experience");
//            String skills = request.getParameter("skills");
//
//            CV cv = new CV(id, name, professionId, email, education, workExperience, skills);
//            cvDAO.updateCV(cv);
//            return new ProcessorResult("/cvservlet?action=showAllCV", false, null);
//        }
//        return new ProcessorResult("/pages/index.jsp", true, null);
//    }
//}

//package cv.conroller.processors;
//
//import cv.model.CV;
//import cv.dao.CVDAO;
//import cv.model.ProcessorResult;
//import jakarta.servlet.http.HttpServletRequest;
//
//public class ProcessorEditCV extends Processor {
//
//    private final CVDAO cvDAO;
//
//    public ProcessorEditCV(CVDAO cvDAO) {
//        this.cvDAO = cvDAO;
//        actionToPerform = "editCV";
//
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        int professionId = Integer.parseInt(request.getParameter("professionId"));
//        String email = request.getParameter("email");
//        String education = request.getParameter("education");
//        String workExperience = request.getParameter("workExperience");
//        String skills = request.getParameter("skills");
//
//        CV updatedCV = new CV(id, name, professionId, email, education, workExperience, skills);
//        cvDAO.updateCV(updatedCV);
//
//        // Set the URL and other parameters for ProcessorResult
//        ProcessorResult result = new ProcessorResult("index.jsp", true, null);
//        return result;
//    }
//
//    @Override
//    public boolean canHandle(String action) {
//        return "editCV".equals(action);
//    }
//}
//package cv.conroller.processors;
//
//import cv.dao.CVDAO;
//import cv.dao.ProfessionDAO;
//import cv.model.CV;
//import cv.model.ProcessorResult;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//public class ProcessorEditCV extends Processor {
//
//    private final CVDAO cvDAO;
//
//
//    public ProcessorEditCV(CVDAO cvDAO) {
//        this.cvDAO = cvDAO;
//        actionToPerform = "editCV";
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String professionIdString = request.getParameter("profession_id");
//        int professionId = 0; // Значення за замовчуванням або будь-яке інше значення за замовчуванням
//        if (professionIdString != null && !professionIdString.isEmpty()) {
//            professionId = Integer.parseInt(professionIdString);
//        }
//        String email = request.getParameter("email");
//        String education = request.getParameter("education");
//        String workExperience = request.getParameter("work_experience");
//        String skills = request.getParameter("skills");
//
//        CV cv = new CV(id, name, professionId, email, education, workExperience, skills);
//
//        CVDAO cvDAO = new CVDAO();
//
//        cvDAO.updateCV(cv);
//        return new ProcessorResult("/pages/editCV.jsp", true, null);
//    }
//}
