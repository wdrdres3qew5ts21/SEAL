/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.VideoService.video;

import java.util.HashMap;
import java.util.LinkedList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author wdrdr
 */
@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/sparta")
    public ResponseEntity<Video> helloWorld() {
        System.out.println("Try To Sparta Video Service !!!");
        //ResponseEntity<Map> video = videoService.fetchVideoAPI("https://ngelearning.sit.kmutt.ac.th/api/v0/video/8380");
        ResponseEntity<Video> video = videoService.fetchVideoAPI("https://ngelearning.sit.kmutt.ac.th/api/v0/video/8380");
        System.out.println(video);
//        System.out.println(video.getBody().get("room"));
//        System.out.println(((Map<String, Object>)video.getBody().get("room")).get("room_id"));
//        System.out.println(((Map<String, Object>)video.getBody().get("player")).get("subtitle_available").getClass());
        return video;
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

}
