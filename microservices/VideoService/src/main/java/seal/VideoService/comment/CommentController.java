package seal.VideoService.comment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @RequestMapping(path = "/comments",method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getAllCommentInSystem() {
        List<Comment> comment = commentService.getAllComment();
        return new ResponseEntity<List<Comment>>(comment, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/comments/video/{videoId}", method = RequestMethod.POST)
    public ResponseEntity<Comment> saveCommentFromUserToSystem(@PathVariable String videoId, @RequestBody Comment commentData) {
        Comment commentObject = commentService.saveCommentFromController(commentData);
        return new ResponseEntity<Comment>(commentObject,HttpStatus.OK);
    }
}
