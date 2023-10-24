package bestcommerce.test.modules.Customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {
    @Autowired
    private CustomersDao customersDao;

    public List<Customers> getAllCustomers() {
        return customersDao.findAll();
    }

    public Customers getCustomerById(Long id) {
        return customersDao.findById(id).orElse(null);
    }

    public Customers createCustomer(Customers user) {
        return customersDao.save(user);
    }
}
