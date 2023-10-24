package bestcommerce.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.modules.Customers.CustomersDao;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class DomainUtil {

    @Autowired
    private CustomersDao customersDao;

    public Customers getCustomer(HttpServletRequest request) {
        String originHeader = request.getHeader("Origin");
        Customers customer = customersDao.findByDomain(originHeader);

        return customer;
    }
}
