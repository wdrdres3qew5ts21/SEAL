package seal.UserService.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityNotFoundException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    private UserRepository userRepository;

    private String INCORRECT_USERID_INPUT_FORMAT = "USER ID ต้องเป็นตัวเลขรหัสนักศึกษาเท่านั้น";
    private String NOT_FOUND_USERID = "ไม่พบ USERID ในระบบ";
    private String NOT_FOUND_PASSWORD = "กรอก PASSWORD ผิด";

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> user = userService.getAllUsers();
        return new ResponseEntity<List<User>>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/user/login")
    public ResponseEntity<HashMap> signInByStudentId(@RequestBody Map<String, String> user_input, HttpServletResponse response) {
        Long userId;
        String password;
        HashMap<String, Object> responseData = new HashMap();
        User user = null;
        try {
            userId = Long.parseLong(user_input.get("id").toString());
            password = user_input.get("password").toString();
        } catch (NumberFormatException numberFmtException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INCORRECT_USERID_INPUT_FORMAT);
        }
        user = userService.getUserById(userId);

        System.out.println(user);
        if (user != null) {
            String userPassword = user.getPassword();
            if (userPassword.equals(password)) {
                String token = tokenAuthenticationService.createTokenUser(user);
                //response.addCookie(new Cookie("cookie_token", token));
                response.addHeader("Authorization", "Bearer " + token);
                System.out.println(response.getHeaderNames());
                responseData.put("status", true);
                responseData.put("jwtToken",  token);
                responseData.put("user", user);
                return new ResponseEntity<HashMap>(responseData, HttpStatus.OK);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_PASSWORD);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_USERID);
    }
}
