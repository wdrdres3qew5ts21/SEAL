package seal.VideoService.video;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoAdapter {
    private static final String VIDEO_URL = "https://ngelearning.sit.kmutt.ac.th/api/v0/video/";
    private static final String SUBJECT_URL = "https://ngelearning.sit.kmutt.ac.th/api/v0/subject/";
    
    public Video findVideoById(String videoID) {
        RestTemplate rest = new RestTemplate();
        Video video = rest.getForObject(VIDEO_URL + videoID, Video.class);
        return video;
    }

    public List<Video> findAllVideo() {
        RestTemplate rest = new RestTemplate();
        List<Video> videoList = rest.getForObject(SUBJECT_URL + "2/videos", List.class);
        return videoList;
    }

    public List<Video> findVideoFromSubjectId(String id) {
        RestTemplate rest = new RestTemplate();
        List<Video> videoList = rest.getForObject(SUBJECT_URL + id + "/videos", List.class);
        return videoList;
    }
}
