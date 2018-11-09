package seal.UserService.Favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorites/user/{user_id:[\\s]}")
    public ResponseEntity<List<Favorite>> getAllFavorite(@PathVariable(name = "user_id") Long userId) {
        List<Favorite> favorites_object = favoriteService.getFavoriteByUserId(userId);
        return new ResponseEntity<List<Favorite>>(favorites_object, HttpStatus.OK);
    }

    @PostMapping("/favorite/user/{user_id:[\\s]}/subject/{subject_id:[\\d]}")
    public ResponseEntity<Favorite> createFavorite(@PathVariable(name = "user_id") Long userId,
                                                   @PathVariable(name = "subject_id") int subjectId) {
        Favorite favorite_object = favoriteService.createFavorite(userId, subjectId);
        return new ResponseEntity<Favorite>(favorite_object, HttpStatus.OK);
    }

    @DeleteMapping("/favorite/{favorite_id:[\\d]}")
    public ResponseEntity<Favorite> deleteFavorite(@PathVariable(name = "favorite_id") int id) {
        Favorite favorite_object = favoriteService.deleteFavoriteById(id);
        return new ResponseEntity<Favorite>(favorite_object, HttpStatus.OK);
    }
}