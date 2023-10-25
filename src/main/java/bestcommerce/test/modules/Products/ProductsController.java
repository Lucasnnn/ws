package bestcommerce.test.modules.Products;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bestcommerce.test.Exceptions.DomainException;
import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.utils.DomainUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@Tag(name = "Products")
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private DomainUtil domain;

    @Autowired
    private ProductsService productsService;

    @PostMapping("/create")
    public Products createProdcut(@RequestBody Products product, HttpServletRequest request, Principal principal) {
        Customers own = domain.getCustomer(request);

        if (own == null) {
            throw new DomainException();
        }

        long idOwn = Long.parseLong(principal.getName());

        if (!own.getOwner().getId().equals(idOwn)) {
            throw new DomainException();
        }

        return productsService.createProduct(product);
    }

    @GetMapping("/listAll")
    public List<Products> listAll(HttpServletRequest request) {
        Customers own = domain.getCustomer(request);

        if (own == null) {
            throw new DomainException();
        }

        return productsService.listAllByCustomer(own.getId());
    }

}
