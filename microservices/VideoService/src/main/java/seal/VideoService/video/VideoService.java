/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.VideoService.video;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    
    public VideoService() {
       
    }

    @PostConstruct
    public void init(){
        syncAllVideoWhenStartFromElearning();
    }
    
    public ResponseEntity<Video> findVideoById(String videoID) {
//        System.out.println("inside service video");
//        ResponseEntity<Video> video = rest.getForEntity(videoUrlId + videoID, Video.class);
//        videoRepository.save(video.getBody());
//        System.out.println("------ Find by ID  --------");
//        System.out.println(video.getBody());
        return new ResponseEntity<Video>(videoRepository.findById(videoID).get(),HttpStatus.OK);
    }

    public ResponseEntity<List> findAllVideo() {
//        ResponseEntity<ArrayList> videoList = rest.getForEntity("https://ngelearning.sit.kmutt.ac.th/api/v0/subject/2/videos", ArrayList.class);
//        System.out.println(videoList.getBody());
        return new ResponseEntity<List>(videoRepository.findAll(), HttpStatus.OK);
    }

    
    public void syncAllVideoWhenStartFromElearning() {
        System.out.println("Initialize sync video from E-Learning");
        ResponseEntity<Video[]> videoList = rest.getForEntity("https://ngelearning.sit.kmutt.ac.th/api/v0/subject/2/videos", Video[].class);
        System.out.println(videoList.getBody());
        //ArrayList<HashMap<String, Object>> videos = videoList.getBody();
        //ObjectMapper om = new ObjectMapper();
        System.out.println("--------------------");
        //        System.out.println("Video List Hash map : " + videos);
        //        Gson gson = new Gson();
        //        JsonElement jsonElement = gson.toJsonTree(videos.get(0));
        //        Video pojo = gson.fromJson(jsonElement, Video.class);
        Video[] videoArray = videoList.getBody();
        for (Video video : videoArray) {
            int videoId = Integer.parseInt(video.getVideo_id());
            System.out.println(videoId);
            RestTemplate rest = new RestTemplate();
            Video videoPojo = rest.getForObject("https://ngelearning.sit.kmutt.ac.th/api/v0/video/"+videoId,Video.class);
            System.out.println("POJO Fetch : "+videoPojo);
            videoRepository.save(videoPojo);
        }
    }

    

}
