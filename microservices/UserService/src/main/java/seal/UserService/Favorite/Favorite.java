package seal.UserService.Favorite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import seal.UserService.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Favorites")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Favorite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private User user;

    @NotBlank
    @Column(name = "subject_id")
    private String subjectId;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;

    private boolean isSomeThingUpdate;

    public Favorite() {

    }

    public Favorite(long id, User user, String subjectId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.user = user;
        this.subjectId = subjectId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = "" + subjectId;
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

    public boolean isIsSomeThingUpdate() {
        return isSomeThingUpdate;
    }

    public void setIsSomeThingUpdate(boolean isSomeThingUpdate) {
        this.isSomeThingUpdate = isSomeThingUpdate;
    }

    @Override
    public String toString() {
        return "Favorite{" + "id=" + id + ", user=" + user + ", subjectId=" + subjectId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isSomeThingUpdate=" + isSomeThingUpdate + '}';
    }

}
