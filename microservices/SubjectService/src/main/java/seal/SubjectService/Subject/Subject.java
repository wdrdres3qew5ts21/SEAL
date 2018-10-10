package seal.SubjectService.Subject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import seal.SubjectService.Course.Course;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Subjects")
public class Subject implements Serializable {
  @Id
  private String id;
  
  private String name;
  
  private String code;
  
  private String descrption;

  @ManyToOne
  @JoinColumn(name = "course_id", nullable = false)
  private Course course;

  @Column(name = "created_at",
    nullable = false,
    updatable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;

  @Column(name = "updated_at",
    nullable = false,
    updatable = true
  )
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date updatedAt;

  public Subject() {
  }

  public Subject(String id, String name, String code, String descrption, Course course, Date createdAt, Date updatedAt) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.descrption = descrption;
    this.course = course;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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

  public String getDescrption() {
    return this.descrption;
  }

  public void setDescrption(String descrption) {
    this.descrption = descrption;
  }

  public Course getCourse() {
    return this.course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}