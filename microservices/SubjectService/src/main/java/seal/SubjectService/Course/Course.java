package seal.SubjectService.Course;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import seal.SubjectService.Subject.Subject;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Courses")
public class Course {

  @Id
  private String id;
  
  private String name;
  
  private String code;
  
  private String descrption;

  @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "course"
  )
  private List<Subject> subjects;

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

  public Course() {
  }

  public Course(String id, String name, String code, String descrption, List<Subject> subjects, Date createdAt, Date updatedAt) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.descrption = descrption;
    this.subjects = subjects;
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

  public List<Subject> getSubjects() {
    return this.subjects;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
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