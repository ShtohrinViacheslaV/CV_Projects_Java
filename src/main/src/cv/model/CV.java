package cv.model;

public class CV {
    private int id;
    private String name;
    private int profession_id;
    private String email;
    private String education;
    private String work_experience;
    private String skills;

    public CV(int id, String name, int profession_id, String email, String education, String work_experience, String skills) {
        this.id = id;
        this.name = name;
        this.profession_id = profession_id;
        this.email = email;
        this.education = education;
        this.work_experience = work_experience;
        this.skills = skills;
    }

    public CV() {

    }


    // Додайте геттери та сеттери для всіх полів

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfession_id() {
        return profession_id;
    }

    public void setProfession_id(int profession_id) {
        this.profession_id = profession_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}


////CV.java
//
//package cv.model;
//
//public class CV {
//
//    private int id;
//    private String name;
//    private int profession_id;
//    private String email;
//    private String education;
//    private String work_experience;
//    private String skills;
//
//
//    public CV(int id, String name, int profession_id, String email,
//              String education, String work_experience, String skills) {
//        this.id = id;
//        this.name = name;
//        this.profession_id = profession_id;
//        this.email = email;
//        this.education = education;
//        this.work_experience = work_experience;
//        this.skills = skills;
//    }
//
//
//    @Override
//    public String toString() {
//        return "CV{" +
//                "name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", education='" + education + '\'' +
//                ", work_experience='" + work_experience + '\'' +
//                ", skills='" + skills + '\'' +
//                '}';
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getProfession_id() {
//        return profession_id;
//    }
//
//    public void setProfession_id(int profession_id) {
//        this.profession_id = profession_id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getEducation() {
//        return education;
//    }
//
//    public void setEducation(String education) {
//        this.education = education;
//    }
//
//    public String getWork_experience() {
//        return work_experience;
//    }
//
//    public void setWork_experience(String work_experience) {
//        this.work_experience = work_experience;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
//
//
//}


// CV.java
//package cv.model;
//
//public class CV {
//    private int id;
//    private String name;
//    private int professionId;
//    private String email;
//    private String education;
//    private String workExperience;
//    private String skills;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getProfessionId() {
//        return professionId;
//    }
//
//    public void setProfessionId(int professionId) {
//        this.professionId = professionId;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getEducation() {
//        return education;
//    }
//
//    public void setEducation(String education) {
//        this.education = education;
//    }
//
//    public String getWorkExperience() {
//        return workExperience;
//    }
//
//    public void setWorkExperience(String workExperience) {
//        this.workExperience = workExperience;
//    }
//
//    public String getSkills() {
//        return skills;
//    }
//
//    public void setSkills(String skills) {
//        this.skills = skills;
//    }
//
//    public CV(String name, int professionId, String email, String education, String workExperience, String skills) {
//        this.name = name;
//        this.professionId = professionId;
//        this.email = email;
//        this.education = education;
//        this.workExperience = workExperience;
//        this.skills = skills;
//    }
//
//    // Геттери та сеттери для полів класу
//}
//
//
//
//
