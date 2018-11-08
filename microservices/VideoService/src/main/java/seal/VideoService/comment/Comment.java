package seal.VideoService.comment;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user-id")
    @NotBlank
    private String userId;

    @Column(name = "video-id")
    @NotBlank
    private int videoId;

    @Column(name = "comment")
    @NotBlank
    private String comment;
    
    @Column(name = "create-at")
    
    private Date createAt;
    
    @Column(name = "update-at")
    private Date updateAt;

    public Comment() {

    }

    public Comment(int id, String userId, int videoId, String comment) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
