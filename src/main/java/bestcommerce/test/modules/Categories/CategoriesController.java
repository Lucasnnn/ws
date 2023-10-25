package bestcommerce.test.modules.Categories;

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
@Tag(name = "Categories")
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private DomainUtil domain;

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("/create")
    public Categories createCategory(@RequestBody Categories category, HttpServletRequest request) {
        Customers own = domain.getCustomer(request);

        if (own == null) {
            throw new DomainException();
        }

        category.setCustomer(own);
        return categoriesService.createCategory(category);
    }

    @GetMapping("/listAll")
    public List<Categories> listAll(HttpServletRequest request) {
        Customers own = domain.getCustomer(request);

        if (own == null) {
            throw new DomainException();
        }

        return categoriesService.listAllByCustomer(own.getId());
    }
}
