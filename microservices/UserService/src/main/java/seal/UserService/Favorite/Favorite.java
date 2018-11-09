package seal.UserService.Favorite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Favorite")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Favorite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Column(name = "user_id")
    private Long user_id;

    @NotBlank
    @Column(name = "subject_id")
    private int subject_id;

    @NotBlank
    @Column(name = "created_at")
    private String created_at;

    @NotBlank
    @Column(name = "updated_at")
    private String updated_at;

    public Favorite() {
        super();
    }

    public Favorite(@NotBlank Long user_id, @NotBlank int subject_id) {
        this.user_id = user_id;
        this.subject_id = subject_id;
    }

    public Long getUserId() {
        return user_id;
    }

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public int getSubjectId() {
        return subject_id;
    }

    public void setSubjectId(int subject_id) {
        this.subject_id = subject_id;
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