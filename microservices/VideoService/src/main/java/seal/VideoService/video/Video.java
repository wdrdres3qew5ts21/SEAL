package seal.VideoService.video;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import seal.VideoService.comment.Comment;

public class Video implements Serializable{
    @JsonProperty("video_id")
    private String id;

    @JsonProperty("video_name")
    private String name;

    @JsonProperty("video_description")
    private String description;

    @JsonProperty("video_duration")
    private int duration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("video_date")
    private Date date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("video_endtime")
    private Date endTime;

    @JsonProperty("video_thumbnail")
    private String thumbnail;

    @JsonProperty("room")
    private Room room;
    
    @JsonProperty("teacher")
    private Teacher teacher;
    
    @JsonProperty("player")
    private Player player;

    public Video() {
    }

    public Video(String id, String name, String description, int duration, Date date, Date startTime, Date endTime, String thumbnail, Room room, Teacher teacher, Player player) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.thumbnail = thumbnail;
        this.room = room;
        this.teacher = teacher;
        this.player = player;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    
}
