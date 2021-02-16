package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.sfgpetclinic.services.OwnerService;

@Controller
@RequestMapping({"/owners"})
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"", "/", "/index", "/find"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";

    }
}
