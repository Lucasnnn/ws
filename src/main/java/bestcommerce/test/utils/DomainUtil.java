package bestcommerce.test.utils;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bestcommerce.test.Exceptions.DomainException;
import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.modules.Customers.CustomersDao;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class DomainUtil {

    @Autowired
    private CustomersDao customersDao;

    public void verifyOwner(HttpServletRequest request, Principal principal) {
        Customers own = getOwner(request);

        long idOwn = Long.parseLong(principal.getName());

        if (!own.getOwner().getId().equals(idOwn)) {
            throw new DomainException();
        }
    }

    public Customers getOwner(HttpServletRequest request) {
        Customers own = getCustomer(request);

        if (own == null) {
            throw new DomainException();
        }

        return own;
    }

    private Customers getCustomer(HttpServletRequest request) {
        String originHeader = request.getHeader("Origin");
        Customers customer = customersDao.findByDomain(originHeader);

        return customer;
    }
}
