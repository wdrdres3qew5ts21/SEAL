/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.VideoService.video;

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
    VideoRepository videoRepository;

    public ResponseEntity<Video> fetchVideoAPI(String videoUrlYouWantToFetch) {
        RestTemplate rest = new RestTemplate();
        //return rest.getForEntity(videoUrlYouWantToFetch, Map.class);
        return rest.getForEntity(videoUrlYouWantToFetch, Video.class);
    }

}
