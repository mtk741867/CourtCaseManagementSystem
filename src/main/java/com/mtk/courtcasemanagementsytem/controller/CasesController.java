package com.mtk.courtcasemanagementsytem.controller;

import com.mtk.courtcasemanagementsytem.model.Cases;
import com.mtk.courtcasemanagementsytem.repository.CasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CasesController {
    @Autowired
    CasesRepository casesRepository;


    @RequestMapping(value = "/cases/new", method = RequestMethod.GET)
    public String newCasesForm(Model model){
        model.addAttribute("cases", new Cases());
        return "cases/new";
    }
    @RequestMapping(value = "/cases/new", method = RequestMethod.POST)
    public String saveCases(Model model, Cases cases){
        casesRepository.save(cases);
        model.addAttribute("cases", cases);
        return "redirect:/cases/list";

    }
    @RequestMapping(value = "/cases/list", method = RequestMethod.GET)
    public String findAllCases(Model model){

        List<Cases> cases= casesRepository.findAll();
        model.addAttribute("cases", cases);
        return "cases/list";
    }
    @RequestMapping(value = "/cases/edit/{id}", method = RequestMethod.GET)
    public String editCases(Model model,@PathVariable Long id){
        Cases cases= casesRepository.findById(id).orElse(null);
        model.addAttribute("cases", cases);
        return "cases/edit";
    }

    @RequestMapping(value = "/cases/edit", method = RequestMethod.POST)
    public String updateCases(Model model,Cases cases){
        casesRepository.save(cases);
        model.addAttribute("cases", cases);
        return "redirect:/cases/list";
    }

    @RequestMapping(value = "/cases/delete/{id}", method = RequestMethod.GET)
    public String deleteCases(@PathVariable Long id){
        casesRepository.deleteById(id);
        return "redirect:/cases/list";
    }

    /*@RequestMapping(value = "/cases/list", method = RequestMethod.POST)
    public String SearchCases(Model model,@RequestParam Long caseid){
        Cases cases= casesRepository.findById(caseid).orElse(null);
        model.addAttribute("cases", cases);
        return "cases/list";
    }*/
    @RequestMapping(value = "/cases/list", method = RequestMethod.POST)
    public String SearchCasesByName(Model model,@RequestParam String caseid,@RequestParam String plaintiffName,@RequestParam String defendantName){
        if(!caseid.equals("")) {
            Long id=Long.parseLong(caseid);
            Cases cases= casesRepository.findById(id).orElse(null);
            model.addAttribute("cases", cases);
            return "cases/list";
        } else if (!plaintiffName.equals("")) {
            List<Cases> cases = casesRepository.findByPlaintiffNameContaining(plaintiffName);
            model.addAttribute("cases", cases);
            return "cases/list";
        }else {
            List<Cases> cases = casesRepository.findByDefendantNameContaining(defendantName);
            model.addAttribute("cases", cases);
            return "cases/list";
        }
       // model.addAttribute("cases", cases);
        //return "cases/list";
    }

}
