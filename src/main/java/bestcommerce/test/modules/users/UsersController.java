package bestcommerce.test.modules.users;

import java.security.Principal;

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

    @PostMapping("/logim")
    public ResponseEntity<String> login(@RequestBody Users user, HttpServletRequest request, Principal principal) {
        Customers own = domain.getCustomer(request);

        System.out.println(principal.getName());

        return ResponseEntity.ok("Usuário criado com sucesso");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody Users user, HttpServletRequest request) {
        Customers own = domain.getCustomer(request);

        if (own == null) {
            return null;
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
