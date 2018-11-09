package seal.VideoService.video;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoService {
    private static final String VIDEO_URL = "https://ngelearning.sit.kmutt.ac.th/api/v0/video/";
    private static final String SUBJECT_URL = "https://ngelearning.sit.kmutt.ac.th/api/v0/subject/";
    
    public ResponseEntity<Video> findVideoById(String videoID) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Video> video = rest.getForEntity(VIDEO_URL + videoID, Video.class);
        return video;
    }

    public ResponseEntity<List> findAllVideo() {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<List> videoList = rest.getForEntity(SUBJECT_URL + "2/videos", List.class);
        return videoList;
    }

    public ResponseEntity<List> findVideoFromSubjectId(String id) {
        RestTemplate rest = new RestTemplate();
        return rest.getForEntity(SUBJECT_URL + id + "/videos", List.class);
    }
}
