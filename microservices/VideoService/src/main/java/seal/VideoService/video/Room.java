/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.VideoService.video;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Embeddable;

/**
 *
 * @author wdrdr
 */
@Embeddable
public class Room {

    
    @JsonProperty("room_id")
    private int roomId;
    @JsonProperty("room_name")
    private String roomName;
    @JsonProperty("room_place")
    private String roomPlace;

    public Room() {
        
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomPlace() {
        return roomPlace;
    }

    public void setRoomPlace(String roomPlace) {
        this.roomPlace = roomPlace;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", roomName=" + roomName + ", roomPlace=" + roomPlace + '}';
    }

}
