package seal.VideoService.video;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Embeddable;

@Embeddable
public class Teacher {
    
    @JsonProperty("teacher_id")
    private int teacherId;
    
    @JsonProperty("teacher_name")
    private String teacherName;

    public Teacher() {
        
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherId=" + teacherId + ", teacherName=" + teacherName + '}';
    }
    
}
