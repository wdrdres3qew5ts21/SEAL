package seal.VideoService.video;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class VideoController {

    @Autowired
    private VideoAdapter videoAdapter;

    @GetMapping("/video/{id}")
    public ResponseEntity<Video> findVideoByIs(@PathVariable String id) {
        ResponseEntity<Video> video = videoAdapter.findVideoById(id);
        return video;
    }

    @GetMapping("/videos")
    public ResponseEntity<List> findAllVideo() {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<List> videosResponse = videoAdapter.findAllVideo();
        return videosResponse;
    }

    @GetMapping("/subject/{id}/videos")
    public ResponseEntity<List> findVideoFromSubjectId(@PathVariable String id) {
        ResponseEntity<List> videosFromSubjectResponse = videoAdapter.findVideoFromSubjectId(id);
        return videosFromSubjectResponse;
    }

}
