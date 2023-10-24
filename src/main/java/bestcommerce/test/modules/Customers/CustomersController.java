package bestcommerce.test.modules.Customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Customers")
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @PostMapping("/create")
    public Customers createCustomer(@RequestBody Customers customer) {
        return customersService.createCustomer(customer);
    }

    @GetMapping("/listAll")
    public List<Customers> getAllCustomers() {
        return customersService.getAllCustomers();
    }
}
