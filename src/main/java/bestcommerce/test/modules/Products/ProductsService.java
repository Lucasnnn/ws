package bestcommerce.test.modules.Products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    private ProductsDao productsDao;

    public Products createProduct(Products product) {
        return productsDao.save(product);
    }

    public List<Products> listAllByCustomer(Long CustomerId) {
        return productsDao.findAllByCustomer(CustomerId);
    }

    public List<Products> listByCategory(Long OwnerId, Long CategoryId) {
        return productsDao.findAllByCategory(OwnerId, CategoryId);
    }

    public int deleteById(Long ProductId) {
        return productsDao.removeById(ProductId);
    }
}
