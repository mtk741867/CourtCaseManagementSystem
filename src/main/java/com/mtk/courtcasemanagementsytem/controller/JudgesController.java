package com.mtk.courtcasemanagementsytem.controller;

import com.mtk.courtcasemanagementsytem.model.Judges;
import com.mtk.courtcasemanagementsytem.repository.BenchRepository;
import com.mtk.courtcasemanagementsytem.repository.JudgesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class JudgesController {
    @Autowired
    JudgesRepository judgesRepository;

    @RequestMapping(value = "/judges/new", method = RequestMethod.GET)
    public String newJudges(Model model){
        model.addAttribute("judges", new Judges());
        return "judges/new";
    }
    @RequestMapping(value = "/judges/new", method = RequestMethod.POST)
    public String saveJudges(Model model, Judges judges){
        judgesRepository.save(judges);
        model.addAttribute("judges", judges);
        return "redirect:/judges/list";

    }
    @RequestMapping(value = "/judges/list", method = RequestMethod.GET)
    public String findAllJudges(Model model){

        List<Judges> judges= judgesRepository.findAll();
        model.addAttribute("judges", judges);
        return "judges/list";
    }
    @RequestMapping(value = "/judges/edit/{id}", method = RequestMethod.GET)
    public String editJudges(Model model,@PathVariable Long id){
        Judges judges= judgesRepository.findById(id).orElse(null);
        model.addAttribute("judges", judges);
        return "judges/edit";
    }

    @RequestMapping(value = "/judges/edit", method = RequestMethod.POST)
    public String updateJudges(Model model,Judges judges){
        judgesRepository.save(judges);
        model.addAttribute("judges", judges);
        return "redirect:/judges/list";
    }

    @RequestMapping(value = "/judges/delete/{id}", method = RequestMethod.GET)
    public String deleteJudges(@PathVariable Long id){
        judgesRepository.deleteById(id);
        return "redirect:/judges/list";
    }
}
