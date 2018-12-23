package seal.UserService.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    public List<Favorite> findByUserId(Long userId);
    
    public List<Favorite> findBySubjectId(String subjectId);
    
}