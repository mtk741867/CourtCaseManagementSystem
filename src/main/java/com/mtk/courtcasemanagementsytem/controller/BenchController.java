package com.mtk.courtcasemanagementsytem.controller;

import com.mtk.courtcasemanagementsytem.model.Bench;
import com.mtk.courtcasemanagementsytem.repository.BenchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class BenchController {
    @Autowired
    BenchRepository benchRepository;

    @RequestMapping(value = "/bench/new", method = RequestMethod.GET)
    public String newBench(Model model){
        model.addAttribute("bench", new Bench());
        return "bench/new";
    }
    @RequestMapping(value = "/bench/new", method = RequestMethod.POST)
    public String saveBench(Model model, Bench bench){
        benchRepository.save(bench);
        model.addAttribute("bench", bench);
        return "redirect:/bench/list";

    }
    @RequestMapping(value = "/bench/list", method = RequestMethod.GET)
    public String findAllBench(Model model){

        List<Bench> bench= benchRepository.findAll();
        model.addAttribute("bench", bench);
        return "bench/list";
    }
    @RequestMapping(value = "/bench/edit/{id}", method = RequestMethod.GET)
    public String editBench(Model model,@PathVariable Long id){
        Bench bench= benchRepository.findById(id).orElse(null);
        model.addAttribute("bench", bench);
        return "bench/edit";
    }

    @RequestMapping(value = "/bench/edit", method = RequestMethod.POST)
    public String updateBench(Model model,Bench bench){
        benchRepository.save(bench);
        model.addAttribute("bench", bench);
        return "redirect:/bench/list";
    }

    @RequestMapping(value = "/bench/delete/{id}", method = RequestMethod.GET)
    public String deleteBench(@PathVariable Long id){
        benchRepository.deleteById(id);
        return "redirect:/bench/list";
    }
}
