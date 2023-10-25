package bestcommerce.test.modules.users;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bestcommerce.test.Exceptions.EmailAlreadyTakenException;
import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.utils.DomainUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@Tag(name = "Users")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private DomainUtil domain;

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user, HttpServletRequest request) {
        Customers own = domain.getCustomer(request);

        if (own == null) {
            return ResponseEntity.badRequest().body("Not valid domain !");
        }

        try {
            Users check = usersService.getByEmailCustomer(user.getEmail(), own.getId());

            if (check != null) {
                if (check.getPassword().equals(user.getPassword())) {
                    return ResponseEntity.ok(check.getToken());
                } else {
                    return ResponseEntity.badRequest().body("Password incorrect !!!");
                }
            } else {
                return ResponseEntity.badRequest().body("Email not registered !!!");
            }
        } catch (EmailAlreadyTakenException e) {
            return ResponseEntity.badRequest().body("Error in login !!!");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody Users user, HttpServletRequest request) {
        Customers own = domain.getCustomer(request);

        if (own == null) {
            return ResponseEntity.badRequest().body("Not valid domain !");
        }

        try {
            user.setCustomer(own);
            usersService.createUser(user);

            return ResponseEntity.ok("User created a success.");
        } catch (EmailAlreadyTakenException e) {
            return ResponseEntity.badRequest().body("Email in use !!!");
        }
    }
}
