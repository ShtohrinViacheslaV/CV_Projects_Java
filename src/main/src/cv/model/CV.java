package cv.model;

public class CV {
    private String name;
    private String hobby;
    private String education;
    private String work_experience;
    private String skills;

    public CV(String name, String hobby, String education, String work_experience, String skills) {
        this.name = name;
        this.hobby = hobby;
        this.education = education;
        this.work_experience = work_experience;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "CV{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                ", education='" + education + '\'' +
                ", work_experience='" + work_experience + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public String getEducation() {
        return education;
    }

    public String getWork_experience() {
        return work_experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
