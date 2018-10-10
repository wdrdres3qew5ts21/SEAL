package seal.SubjectService.Nge.Subject;

public class Subject {

    private String subject_id;
    private String subject_name;
    private String subject_code;
    private String subject_descrition;

    public Subject() {
    }

    public Subject(String subject_id, String subject_name, String subject_code, String subject_descrition) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.subject_descrition = subject_descrition;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return this.subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_code() {
        return this.subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getSubject_descrition() {
        return this.subject_descrition;
    }

    public void setSubject_descrition(String subject_descrition) {
        this.subject_descrition = subject_descrition;
    }


}