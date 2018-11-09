/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.VideoService.video;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author wdrdr
 */
@Entity
@Table(name = "Video")
public class Video implements Serializable{

    @Id
    @JsonProperty("video_id")
    private String video_id;
    @JsonProperty("video_name")
    private String videoName;
    @Lob
    @JsonProperty("video_description")
    private String videoDescription;

    @JsonProperty("video_duration")
    private int videoDuration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("video_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date videoDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonProperty("video_starttime")
    private Date videoStartTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("video_endtime")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date videoEndTime;

    @JsonProperty("video_thumbnail")
    private String videoThumbnail;

    @Embedded
    @JsonProperty("room")
    private Room room;
    
    @Embedded
    @JsonProperty("teacher")
    private Teacher teacher;
    
    @Embedded
    @JsonProperty("player")
    private Player player;

    public Video() {

    }

    public Video(String videoId, String videoName, String videoDescription, int videoDuration, Date videoDate, Date videoStartTime, Date videoEndTime, String videoThumbnail, Player player) {
        this.video_id = videoId;
        this.videoName = videoName;
        this.videoDescription = videoDescription;
        this.videoDuration = videoDuration;
        this.videoDate = videoDate;
        this.videoStartTime = videoStartTime;
        this.videoEndTime = videoEndTime;
        this.videoThumbnail = videoThumbnail;
        this.player = player;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public int getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(int videoDuration) {
        this.videoDuration = videoDuration;
    }

    public Date getVideoDate() {
        return videoDate;
    }

    public void setVideoDate(Date videoDate) {
        this.videoDate = videoDate;
    }

    public Date getVideoStartTime() {
        return videoStartTime;
    }

    public void setVideoStartTime(Date videoStartTime) {
        this.videoStartTime = videoStartTime;
    }

    public Date getVideoEndTime() {
        return videoEndTime;
    }

    public void setVideoEndTime(Date videoEndTime) {
        this.videoEndTime = videoEndTime;
    }

    public String getVideoThumbnail() {
        return videoThumbnail;
    }

    public void setVideoThumbnail(String videoThumbnail) {
        this.videoThumbnail = videoThumbnail;
    }

    @Override
    public String toString() {
        return "Video{" + "videoId=" + video_id + ", videoName=" + videoName + ", videoDescription=" + videoDescription + ", videoDuration=" + videoDuration + ", videoDate=" + videoDate + ", videoStartTime=" + videoStartTime + ", videoEndTime=" + videoEndTime + ", videoThumbnail=" + videoThumbnail + ", player=" + player + '}';
    }

}
