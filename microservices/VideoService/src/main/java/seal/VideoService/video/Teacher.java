/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.VideoService.video;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Embeddable;

/**
 *
 * @author wdrdr
 */
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
