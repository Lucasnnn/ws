package bestcommerce.test.modules.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Users")
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @GetMapping("/listAll")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

}
