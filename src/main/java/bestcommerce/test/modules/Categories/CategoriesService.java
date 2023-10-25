package bestcommerce.test.modules.Categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesDao categoriesDao;

    public Categories createCategory(Categories category) {
        return categoriesDao.save(category);
    }

    public List<Categories> listAllByCustomer(Long CustomerId) {
        return categoriesDao.findAllByCustomer(CustomerId);
    }
}
