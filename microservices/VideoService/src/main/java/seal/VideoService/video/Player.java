package seal.VideoService.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    @JsonProperty("hls_url")
    private String hlsUrl;

    @JsonProperty("spritesheet_frame")
    private int spritesheetFrame;

    @JsonProperty("spritesheet_file")
    private String spritesheetFile;

    @JsonProperty("subtitle_available")
    private int subtitleAvailable;

    @JsonProperty("subtitle_file")
    private String subtitleFile;

    public Player() {

    }

    public String getHlsUrl() {
        return hlsUrl;
    }

    public void setHlsUrl(String hlsUrl) {
        this.hlsUrl = hlsUrl;
    }

    public int getSpritesheetFrame() {
        return spritesheetFrame;
    }

    public void setSpritesheetFrame(int spritesheetFrame) {
        this.spritesheetFrame = spritesheetFrame;
    }

    public String getSpritesheetFile() {
        return spritesheetFile;
    }

    public void setSpritesheetFile(String spritesheetFile) {
        this.spritesheetFile = spritesheetFile;
    }

    public int getSubtitleAvailable() {
        return subtitleAvailable;
    }

    public void setSubtitleAvailable(int subtitleAvailable) {
        this.subtitleAvailable = subtitleAvailable;
    }

    public String getSubtitleFile() {
        return subtitleFile;
    }

    public void setSubtitleFile(String subtitleFile) {
        this.subtitleFile = subtitleFile;
    }

    @Override
    public String toString() {
        return "Player{" + "hlsUrl=" + hlsUrl + ", spritesheetFrame=" + spritesheetFrame + ", spritesheetFile=" + spritesheetFile + ", subtitleAvailable=" + subtitleAvailable + ", subtitleFile=" + subtitleFile + '}';
    }

    
}
