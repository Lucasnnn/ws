package bestcommerce.test.modules.Products;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bestcommerce.test.Exceptions.EmailAlreadyTakenException;
import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.modules.users.Users;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@Tag(name = "Products")
@RequestMapping("/products")
public class ProductsController {

}
