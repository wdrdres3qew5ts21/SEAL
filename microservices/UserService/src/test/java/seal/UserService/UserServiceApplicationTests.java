package seal.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import seal.UserService.User.User;
import seal.UserService.User.UserRepository;
import seal.UserService.User.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes=UserService.class)
public class UserServiceApplicationTests {

    @Autowired
    private UserService userService;
    
    @Mock
    private UserRepository userRepository;
    private List<User> users;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() throws Exception{
        this.userService = new UserService(userRepository);
        users = new ArrayList<>();
        users.add(new User(1l,"firstname", "lastname", "department", "faculty", 3, "image"));
    }    

    @Test
    public void listUsers() {
        when(userRepository.findAll()).thenReturn(users);

        int usersResponse = userService.getAllUsers().size();

        assertThat(usersResponse).isGreaterThanOrEqualTo(1);;
    }
}
