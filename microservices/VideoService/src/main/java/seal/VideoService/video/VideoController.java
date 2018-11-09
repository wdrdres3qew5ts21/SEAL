package seal.VideoService.video;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
public class VideoController {

    @Autowired
    private VideoAdapter videoAdapter;

    @RequestMapping(path = "/video/{id)", method = RequestMethod.GET)
    public ResponseEntity<Video> findVideoByIs(@PathVariable String id) {
        Video video = videoAdapter.findVideoById(id);
        return new ResponseEntity<Video>(video, HttpStatus.OK);
    }

    @RequestMapping(path = "/videos", method = RequestMethod.GET)
    public ResponseEntity<List<Video>> findAllVideo() {
        List<Video> videosResponse = videoAdapter.findAllVideo();
        return new ResponseEntity<List<Video>>(videosResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/subject/{id}/videos", method = RequestMethod.GET)
    public ResponseEntity<List<Video>> findVideoFromSubjectId(@PathVariable String id) {
        List<Video> videosFromSubjectResponse = videoAdapter.findVideoFromSubjectId(id);
        return new ResponseEntity<List<Video>>(videosFromSubjectResponse, HttpStatus.OK);
    }

}
