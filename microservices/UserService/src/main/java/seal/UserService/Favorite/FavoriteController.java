package seal.UserService.Favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;
@CrossOrigin(origins = "*")
@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorites/user/{user_id}")
    public ResponseEntity<List<Favorite>> getAllFavorite(@PathVariable(name = "user_id") Long userId) {
        List<Favorite> favorites = favoriteService.getFavoriteByUserId(userId);
        return new ResponseEntity<List<Favorite>>(favorites, HttpStatus.OK);
    }

    @PostMapping("/favorite/user/{user_id}/subject")
    public ResponseEntity<Favorite> createFavorite(@PathVariable(name = "user_id") Long userId,  @Valid @RequestBody Favorite favorite) {
        Favorite favorite_object = favoriteService.createFavorite(userId, favorite);
        return new ResponseEntity<Favorite>(favorite_object, HttpStatus.OK);
    }

    @DeleteMapping("/favorite/{favorite_id:[\\d]}")
    public ResponseEntity<Favorite> deleteFavorite(@PathVariable(name = "favorite_id") Long id) {
        Favorite favorite_object = favoriteService.deleteFavoriteById(id);
        return new ResponseEntity<Favorite>(favorite_object, HttpStatus.OK);
    }
}