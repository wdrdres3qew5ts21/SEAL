package seal.VideoService.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Room {    
    @JsonProperty("room_id")
    private int id;

    @JsonProperty("room_name")
    private String name;

    @JsonProperty("room_place")
    private String place;

    public Room() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
