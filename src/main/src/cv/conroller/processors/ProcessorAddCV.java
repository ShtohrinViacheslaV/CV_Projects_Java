// ProcessorAddCV.java

package cv.conroller.processors;

import cv.dao.CVDAO;
import cv.model.CV;
import cv.model.ProcessorResult;

import jakarta.servlet.http.HttpServletRequest;

public class ProcessorAddCV extends Processor {

    private final CVDAO cvDAO;

    public ProcessorAddCV(CVDAO cvDAO) {
        this.cvDAO = cvDAO;
        actionToPerform = "addCV";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        String name = request.getParameter("name");

        // Перевіряємо, чи name не є null і не порожній
        if (name != null && !name.isEmpty()) {
            int professionId = Integer.parseInt(request.getParameter("profession_id"));
            String email = request.getParameter("email");
            String education = request.getParameter("education");
            String workExperience = request.getParameter("work_experience");
            String skills = request.getParameter("skills");

            // Перевіряємо, чи всі поля форми заповнені
            if (email.isEmpty() || education.isEmpty() || workExperience.isEmpty() || skills.isEmpty()) {
                // Якщо хоча б одне поле порожнє, повертаємо повідомлення про помилку
                return new ProcessorResult("/pages/addCV.jsp", true, "Please fill in all fields.");
            } else {
                // Якщо всі поля заповнені, створюємо резюме
                CV cv = new CV(0, name, professionId, email, education, workExperience, skills);
                cvDAO.addCV(cv);

                return new ProcessorResult("/pages/addCV.jsp", true, null);
            }
        } else {
            // Якщо name null або порожній, виконуємо необхідні дії
            return new ProcessorResult("/pages/addCV.jsp", true, "Name field is required.");
        }
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
//public class ProcessorAddCV extends Processor {
//
//    private final CVDAO cvDAO;
//
//
//    public ProcessorAddCV(CVDAO cvDAO) {
//        this.cvDAO = cvDAO;
//        actionToPerform = "addCV";
//    }
//
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        //int nextId = cvDAO.getNextAvailableId();
//        String name = request.getParameter("name");
//        String professionIdString = request.getParameter("profession_id");
//        int professionId = 0;
//        if (professionIdString != null && !professionIdString.isEmpty()) {
//            professionId = Integer.parseInt(professionIdString);
//        }
//        String email = request.getParameter("email");
//        String education = request.getParameter("education");
//        String workExperience = request.getParameter("work_experience");
//        String skills = request.getParameter("skills");
//
//        // Створюємо об'єкт резюме з отриманими даними та новим id
//        CV cv = new CV(0, name, professionId, email, education, workExperience, skills);
//
//        // Додаємо резюме до бази даних
//        cvDAO.addCV(cv);
//
//        // Повертаємо результат обробки процесором
//        return new ProcessorResult("/pages/addCV.jsp", true, null);
//
//    }
//}


//// ProcessorAddCV.java
//package cv.conroller.processors;
//
//import cv.dao.CVDAO;
//import cv.model.CV;
//import cv.model.ProcessorResult;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//public class ProcessorAddCV extends Processor {
//
//    private final CVDAO cvDAO;
//
//    public ProcessorAddCV(CVDAO cvDAO) {
//        this.cvDAO = cvDAO;
//        actionToPerform = "addCV";
//    }
//
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        // Отримуємо дані, введені в форму додавання резюме
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        int professionId = Integer.parseInt(request.getParameter("profession_id"));
//        String email = request.getParameter("email");
//        String education = request.getParameter("education");
//        String workExperience = request.getParameter("work_experience");
//        String skills = request.getParameter("skills");
//
//        // Створюємо об'єкт резюме з отриманими даними
//        CV cv = new CV(id, name, professionId, email, education, workExperience, skills);
//
//        // Ініціалізуємо об'єкт DAO для роботи з базою даних
//        CVDAO cvDAO = new CVDAO();
//
//        // Додаємо резюме до бази даних
//        cvDAO.addCV(cv);
//
//        // Повертаємо результат обробки процесором
//        return new ProcessorResult("cvList.jsp", true, null);
//    }
//}



// ProcessorAddCV.java
//package cv.conroller.processors;
//
//import cv.dao.CVDAO;
//import cv.model.CV;
//import cv.model.ProcessorResult;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//public class ProcessorAddCV extends Processor {
//
//    public ProcessorAddCV() {
//        actionToPerform = "addCV";
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//        // Отримуємо дані, введені в форму додавання резюме
//        int
//        String name = request.getParameter("name");
//        int professionId = Integer.parseInt(request.getParameter("profession_id"));
//        String email = request.getParameter("email");
//        String education = request.getParameter("education");
//        String workExperience = request.getParameter("work_experience");
//        String skills = request.getParameter("skills");
//
//        // Створюємо об'єкт резюме з отриманими даними
//        CV cv = new CV(id, name, professionId, email, education, workExperience, skills);
//
//        // Ініціалізуємо об'єкт DAO для роботи з базою даних
//        CVDAO cvDAO = new CVDAO();
//
//        // Додаємо резюме до бази даних, отримуючи нове значення ID
//        int newId = cvDAO.addCV(cv);
//
//        // Повертаємо результат обробки процесором
//        return new ProcessorResult("cvList.jsp", true, null);
//    }
//}



////package cv.conroller.processors;
////
////import cv.dao.CVDAO;
////import cv.model.CV;
////import cv.model.ProcessorResult;
////import jakarta.servlet.http.HttpServletRequest;
////
////import java.util.Objects;
////
////public class ProcessorAddCV extends Processor {
////
////    private final CVDAO cvDAO;
////
////    public ProcessorAddCV(CVDAO cvDAO) {
////        this.cvDAO = cvDAO;
////        actionToPerform = "addCV";
////    }
////
////    @Override
////    public ProcessorResult handle(HttpServletRequest request) {
////        int id = Integer.parseInt(request.getParameter("id"));
////        String name = request.getParameter("name");
////        int professionId = Integer.parseInt(request.getParameter("professionId"));
////        String email = request.getParameter("email");
////        String education = request.getParameter("education");
////        String workExperience = request.getParameter("work_experience");
////        String skills = request.getParameter("skills");
////
////        if (Objects.isNull(name) || Objects.isNull(professionId) || Objects.isNull(email) || Objects.isNull(education) || Objects.isNull(workExperience) || Objects.isNull(skills)) {
////            // Обробка ситуації, коли один з параметрів відсутній
////            return new ProcessorResult("/pages/showAllCV.jsp", true, "/pages/error.jsp");
////        }
////
////        try {
////            CV newCV = new CV(id, name, professionId, email, education, workExperience, skills);
////            cvDAO.addCV(newCV);
////        } catch (NumberFormatException e) {
////            // Обробка ситуації, коли параметр profession_id не може бути перетворений у число
////            return new ProcessorResult("/pages/showAllCV.jsp", true, "/pages/error.jsp");
////        }
////
////        return new ProcessorResult("/pages/showAllCV.jsp", true, "/pages/addCV.jsp");
////    }
////}
//
//package cv.conroller.processors;
//
//import cv.dao.CVDAO;
//import cv.dao.ProfessionDAO;
//import cv.model.CV;
//import cv.model.Profession;
//import cv.model.ProcessorResult;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//import java.util.List;
//
////public class ProcessorAddCV extends Processor {
//
//public class ProcessorAddCV extends Processor {
//
//    private final CVDAO cvDAO;
//
//    public ProcessorAddCV(CVDAO cvDAO) {
//        this.cvDAO = cvDAO;
//        actionToPerform = "addCV";
//    }
//
//    @Override
//    public ProcessorResult handle(HttpServletRequest request) {
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        int professionId = Integer.parseInt(request.getParameter("professionId"));
//        String email = request.getParameter("email");
//        String education = request.getParameter("education");
//        String workExperience = request.getParameter("workExperience");
//        String skills = request.getParameter("skills");
//
//        CV cv = new CV(id, name, professionId, email, education, workExperience, skills);
//        cvDAO.addCV(cv);
//        return new ProcessorResult("/cvservlet?action=showAllCV", false, null);
//    }
//}
