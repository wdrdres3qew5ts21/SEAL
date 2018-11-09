package seal.UserService.Favorite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import seal.UserService.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Favorites")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Favorite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Column(name = "user_id")
    private User user;

    @NotBlank
    @Column(name = "subject_id")
    private String subjectId;

    @NotBlank
    @Column(name = "created_at")
    private String created_at;

    @NotBlank
    @Column(name = "updated_at")
    private String updated_at;

    public Favorite() {
        super();
    }

    public Favorite(User user, String subjectId) {
        this.user = user;
        this.subjectId = subjectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getCreateAt() {
        return created_at;
    }

    public void setCreateAt(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdateAt() {
        return updated_at;
    }

    public void setUpdateAt(String updated_at) {
        this.updated_at = updated_at;
    }
}