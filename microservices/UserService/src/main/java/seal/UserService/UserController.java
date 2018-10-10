package seal.UserService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController{
    
    @Autowired
    private UserService userService;

    @RequestMapping(value="/users" , method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUserList(){
        List<User> listUser = userService.getAllUser();
        return new ResponseEntity<List<User>>(listUser,HttpStatus.OK);
    }

    @RequestMapping(value="/user/{user_id}", method=RequestMethod.GET)
    public ResponseEntity<Optional<User>> getUserByUserId(@PathVariable("user_id") Long id) {
        Optional<User> user = userService.getUserById(id);
        return new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
    }

    @RequestMapping(value="/user" , method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User createUserObject = userService.create(user);
        return new ResponseEntity<User>(createUserObject,HttpStatus.OK);
    }

}