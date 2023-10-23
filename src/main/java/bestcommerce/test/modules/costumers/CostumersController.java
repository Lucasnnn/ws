package bestcommerce.test.modules.costumers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Costumers")
@RequestMapping("/costumers")
public class CostumersController {
    @Autowired
    private CostumersService costumersService;

    @PostMapping("/create")
    public Costumers createCostumer(@RequestBody Costumers costumer) {
        return costumersService.createCostumer(costumer);
    }

    @GetMapping("/listAll")
    public List<Costumers> getAllCostumers() {
        return costumersService.getAllCostumers();
    }

}
