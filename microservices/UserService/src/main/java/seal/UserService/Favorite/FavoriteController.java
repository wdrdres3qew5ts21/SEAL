package seal.UserService.Favorite;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;
import seal.UserService.Filter.TokenAuthenticationService;
@CrossOrigin(origins = "*")
@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorites/user/{user_id}")
    public ResponseEntity<List<Favorite>> getAllFavorite(@PathVariable(name = "user_id") Long userId, HttpServletRequest request) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        List<Favorite> favorites = favoriteService.getFavoriteByUserId(userId);
        return new ResponseEntity<List<Favorite>>(favorites, HttpStatus.OK);
    }
    
    @PutMapping("/user/{user_id}/read/notification")
    public ResponseEntity<Favorite> userReadNotification(@PathVariable(name = "user_id") Long userId, @RequestBody Favorite favorite, HttpServletRequest request){
        TokenAuthenticationService.validateJWTAuthentication(request);
        return new ResponseEntity<Favorite>(favoriteService.userReadNotification(userId, favorite), HttpStatus.OK);
    }
    
    @PutMapping("/subject/{subject_id}/updatefile")
    public ResponseEntity<List<Favorite>> subjectFileHadBeenUpdateByTeacher(@PathVariable(name = "subject_id") int subjectId, HttpServletRequest request){
        Claims user = TokenAuthenticationService.validateJWTAuthentication(request);
        TokenAuthenticationService.validateIsUserRoleTeacher(user);
        return new ResponseEntity<List<Favorite>>(favoriteService.subjectFileHadBeenUpdateByTeacher(subjectId), HttpStatus.OK);
    }
    
    @PostMapping("/favorite/user/{user_id}/subject")
    public ResponseEntity<Favorite> createFavorite(@PathVariable(name = "user_id") Long userId,  @Valid @RequestBody Favorite favorite, HttpServletRequest request) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        Favorite favorite_object = favoriteService.createFavorite(userId, favorite);
        return new ResponseEntity<Favorite>(favorite_object, HttpStatus.OK);
    }

    @DeleteMapping("/favorite/{user_id}/{favorite_id}")
    public ResponseEntity<Favorite> deleteFavorite(@PathVariable(name = "favorite_id") Long id,  @PathVariable(name = "user_id") Long userId, HttpServletRequest request) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        Favorite favorite_object = favoriteService.deleteFavoriteById(userId, id);
        return new ResponseEntity<Favorite>(favorite_object, HttpStatus.OK);
    }
}