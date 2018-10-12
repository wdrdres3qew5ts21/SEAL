/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.VideoService.video;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author wdrdr
 */
@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;
    
    private RestTemplate rest = new RestTemplate();
    private String videoUrlId = "https://ngelearning.sit.kmutt.ac.th/api/v0/video/";

    public ResponseEntity<Video> findVideoById(int videoID) {
        System.out.println("inside service video");
        ResponseEntity<Video> video = rest.getForEntity(videoUrlId + videoID, Video.class);
        videoRepository.save(video.getBody());
        System.out.println(video.getBody());
        return video;
    }

    ResponseEntity<ArrayList> findAllVideo() {
        ResponseEntity<ArrayList> videoList = rest.getForEntity("https://ngelearning.sit.kmutt.ac.th/api/v0/subject/2/videos", ArrayList.class);
        System.out.println(videoList.getBody());
        return videoList;
    }
    
    
}
