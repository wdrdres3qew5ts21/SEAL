package seal.VideoService.comment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
    
    public List<Comment> getCommentByVideoId(String videoId) {
        return commentRepository.findByVideoId(videoId);
    }
    
    public Comment saveCommentFromController(Comment comment) {
        return commentRepository.save(comment);
    }
}
