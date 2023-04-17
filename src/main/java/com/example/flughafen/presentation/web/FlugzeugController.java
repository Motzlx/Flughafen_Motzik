package com.example.flughafen.presentation.web;


import com.example.flughafen.model.Flugzeug;
import com.example.flughafen.persistence.FlughafenRepository;
import com.example.flughafen.service.FlughafenService;
import com.example.flughafen.service.FlugzeugService;
import com.example.flughafen.service.forms.AddFlugzeugForm;
import com.example.flughafen.service.forms.EditFlugzeugForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Controller
@RequestMapping(FlugzeugController.BASE_ROUTE)
public class FlugzeugController implements ControllerSupport {
    private final FlughafenRepository flughafenRepository;

    final static String BASE_ROUTE = "/api/flugzeuge";

    public final FlugzeugService flugzeugService;

    public final FlughafenService flughafenService;


    @GetMapping
    public String getAllFlugzeuge(Model model) {

        List<Flugzeug> flugzeugs = flugzeugService.getAllFlugzeug();
        log.debug("Found {} flugzeuge in getAllFlugzeug()", flugzeugs.size());

        if(flugzeugs.size()==1) {
            model.addAttribute("Flugzeug", flugzeugs);
            return template("detail");
        }
        model.addAttribute("flugzeuge", flugzeugs);
        return template("index");
    }

    @GetMapping("/{id}")
    public String getFlugzeug(@PathVariable Long id, Model model) {

        Optional<Flugzeug> flugzeug = flugzeugService.findFlugzeugById(id);
        if(flugzeug.isEmpty()) return redirect(BASE_ROUTE);
        model.addAttribute("flugzeug", flugzeug.get());
        return template("detail");
    }

    public String showAddFlugzeugForm(Model model) {

        populateFlughafens(model);
        model.addAttribute("AddFlugzeugForm", new AddFlugzeugForm());
        return template("addForm");

    }

    @PostMapping("/{id}/add")
    public String handleAddFlugzeugForm(Model model, @Valid @ModelAttribute AddFlugzeugForm addFlugzeugForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            populateFlughafens(model);
            return template("addForm");
        }
        flugzeugService.createFlugzeug(addFlugzeugForm.getFlugzeugBezeichnung(),
                                        addFlugzeugForm.getNumOfPassangers(),
                                        addFlugzeugForm.getFuelInLitres(),
                                        addFlugzeugForm.getIso2Code(),
                                        addFlugzeugForm.getCountryName(),
                                        addFlugzeugForm.getFlughafenName());
        return redirect(BASE_ROUTE);
    }


    @GetMapping("/{id}/edit")
    public String showEditFlugzeugForm(Model model, @PathVariable Long id) {

        Optional<Flugzeug> flugzeug = flugzeugService.findFlugzeugById(id);

        if(flugzeug.isPresent()) {
            Flugzeug fz = flugzeug.get();
            model.addAttribute("id", id);
            model.addAttribute("editFlugzeugForm", EditFlugzeugForm.builder().flugzeugBezeichnung(fz.getFlugzeugType())

                    .fuelInLitres(fz.getFuelInLitres()).numOfPassangers(fz.getFuelInLitres())
                    .build());
            populateFlughafens(model);
            return template("editForm");
        }
        else {
            return redirect(BASE_ROUTE);
        }


    }

    @PostMapping("/{id}/edit")
    public String handleEditFlughafenForm(Model model, @PathVariable Long id, @Valid @ModelAttribute EditFlugzeugForm editFlugzeugForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            populateFlughafens(model);
            return template("editForm");
        }

        flugzeugService.updateFlugzeug(editFlugzeugForm.getFlugzeugBezeichnung(),editFlugzeugForm.getFuelInLitres(),editFlugzeugForm.getFuelInLitres(), editFlugzeugForm.getId());

        return redirect(BASE_ROUTE);

    }

    @GetMapping("/{id}/delete")
    public String deleteFlugzeug(@PathVariable Long id) {

        flugzeugService.deleteById(id);
        return redirect(BASE_ROUTE);
    }





    private void populateFlughafens(Model model) {
        model.addAttribute("flughaefen", flughafenService.getAllFlugenhafen());
    }


    @Override
    public String getTemplateBaseDir() {
        return null;
    }

    @Override
    public String redirect(String route) {
        return ControllerSupport.super.redirect(route);
    }

    @Override
    public String forward(String route) {
        return ControllerSupport.super.forward(route);
    }

    @Override
    public String template(String name) {
        return ControllerSupport.super.template(name);
    }
}
