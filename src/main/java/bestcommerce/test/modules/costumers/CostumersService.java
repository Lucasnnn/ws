package bestcommerce.test.modules.costumers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumersService {
    @Autowired
    private CostumersDao costumersDao;

    public List<Costumers> getAllCostumers() {
        return costumersDao.findAll();
    }

    public Costumers getCostumerById(Long id) {
        return costumersDao.findById(id).orElse(null);
    }

    public Costumers createCostumer(Costumers user) {
        return costumersDao.save(user);
    }
}
