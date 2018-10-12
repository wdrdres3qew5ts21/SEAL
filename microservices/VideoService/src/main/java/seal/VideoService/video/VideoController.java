/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.VideoService.video;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author wdrdr
 */
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;
    
    @GetMapping("/")
    public String home(){
        return "helloWrold!!!";
    }
    
    
    @GetMapping("/video/{id}")
    public ResponseEntity<Video> helloWorld(@PathVariable String id) {
        ResponseEntity<Video> video = videoService.findVideoById(id);
        return video;
    }

    @GetMapping("/videos")
    public ResponseEntity<List> getTest() {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<List> responseEntity = videoService.findAllVideo();
        return responseEntity;
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
