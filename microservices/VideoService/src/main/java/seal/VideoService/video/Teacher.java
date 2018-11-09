package seal.VideoService.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Teacher {
    @JsonProperty("teacher_id")
    private int id;
    
    @JsonProperty("teacher_name")
    private String name;

    public Teacher() {
    }

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
    
    
}
