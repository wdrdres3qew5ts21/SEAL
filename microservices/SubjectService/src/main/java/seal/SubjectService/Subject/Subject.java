package seal.SubjectService.Subject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject {

    @JsonProperty("subject_id")
    private String id;
    @JsonProperty("subject_name")
    private String name;
    @JsonProperty("subject_code")
    private String code;
    @JsonProperty("subject_description")
    private String descrition;

    public Subject() {
    }

    public Subject(String id, String name, String code, String descrition) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.descrition = descrition;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescrition() {
        return this.descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }
}