package koios.ivana.josipovgablec.controller;


import koios.ivana.josipovgablec.model.Booking;
import koios.ivana.josipovgablec.model.MenuItem;
import koios.ivana.josipovgablec.repository.BookingRepository;
import koios.ivana.josipovgablec.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4201") // usmjeravam ga na angular frontend
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/menu")
    public List<MenuItem> getMenu() {
        return menuRepository.findAll();
    }

}
