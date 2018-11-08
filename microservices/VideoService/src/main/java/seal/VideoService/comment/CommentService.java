package seal.VideoService.comment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    
    @Autowired
    CommentRepository commentRepository;
    
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
    
}
