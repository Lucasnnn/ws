package bestcommerce.test.modules.Products;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.utils.DomainUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@RestController
@Tag(name = "Products")
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private DomainUtil domain;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/listAll")
    public List<Products> listAll(HttpServletRequest request) {
        Customers own = domain.getOwner(request);

        return productsService.listAllByCustomer(own.getId());
    }

    @GetMapping("/listByCategory/{CategoryId}")
    public List<Products> listByCategory(HttpServletRequest request, @PathVariable Long CategoryId) {
        Customers own = domain.getOwner(request);

        return productsService.listByCategory(own.getId(), CategoryId);
    }

    @PostMapping("/create")
    public Products createProdcut(@RequestBody Products product, HttpServletRequest request, Principal principal) {
        domain.verifyOwner(request, principal);

        return productsService.createProduct(product);
    }

    @Transactional
    @DeleteMapping("/deleteById/{ProductId}")
    public boolean deleteById(@PathVariable Long ProductId, HttpServletRequest request, Principal principal) {
        domain.verifyOwner(request, principal);

        int resp = productsService.deleteById(ProductId);

        return (resp == 1);
    }
}
