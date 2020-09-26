package codes.nk.partymanagement.controller;

import codes.nk.partymanagement.model.Guest;
import codes.nk.partymanagement.repository.GuestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public ModelAndView listGuests(){
        ModelAndView modelAndView = new ModelAndView("GuestsList");
        modelAndView.addObject(new Guest());
        modelAndView.addObject("guests",guestRepository.findAll());
        return modelAndView;
    }

    @PostMapping
    public String save(Guest guest){
        this.guestRepository.save(guest);
        return "redirect:/guests";
    }
}
