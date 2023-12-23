package com.mtk.courtcasemanagementsytem.controller;

import com.mtk.courtcasemanagementsytem.model.Bench;
import com.mtk.courtcasemanagementsytem.model.CaseAppointment;
import com.mtk.courtcasemanagementsytem.model.Cases;
import com.mtk.courtcasemanagementsytem.repository.BenchRepository;
import com.mtk.courtcasemanagementsytem.repository.CaseAppointmentRepository;
import com.mtk.courtcasemanagementsytem.repository.CasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CaseAppointmentController {
    @Autowired
    CaseAppointmentRepository caseAppointmentRepository;

    @Autowired
    CasesRepository casesRepository;

    @Autowired
    BenchRepository benchRepository;
    @RequestMapping(value = "/caseAppointment/new", method = RequestMethod.GET)
    public String newCaseAppointment(Model model){
        CaseAppointment caseAppointment=new CaseAppointment();
        model.addAttribute("caseAppointment", caseAppointment);
        //cases
        List<Cases>casesList= casesRepository.findAll();
        model.addAttribute("cases",casesList);
        //bench
        List<Bench>benchList= benchRepository.findAll();
        model.addAttribute("bench",benchList);
        return "caseAppointment/new";
    }
    @RequestMapping(value = "/caseAppointment/new", method = RequestMethod.POST)
    public String saveCaseAppointment(Model model, CaseAppointment caseAppointment){

        caseAppointmentRepository.save(caseAppointment);

        model.addAttribute("caseAppointment", caseAppointment);
        return "redirect:/caseAppointment/list";

    }
    @RequestMapping(value = "/caseAppointment/list", method = RequestMethod.GET)
    public String findAllCaseAppointment(Model model){

        List<CaseAppointment> caseAppointment= caseAppointmentRepository.findAll();

        model.addAttribute("caseAppointment", caseAppointment);

        return "caseAppointment/list";
    }
    @RequestMapping(value = "/caseAppointment/edit/{id}", method = RequestMethod.GET)
    public String editCaseAppointment(Model model,@PathVariable Long id){
        CaseAppointment caseAppointment= caseAppointmentRepository.findById(id).orElse(null);
        model.addAttribute("caseAppointment", caseAppointment);
        //cases
        List<Cases>casesList= casesRepository.findAll();
        model.addAttribute("cases",casesList);
        //bench
        List<Bench>benchList= benchRepository.findAll();
        model.addAttribute("bench",benchList);
        return "caseAppointment/edit";
    }


    @RequestMapping(value = "/caseAppointment/edit", method = RequestMethod.POST)
    public String updateCaseAppointment(Model model,CaseAppointment caseAppointment){
        caseAppointmentRepository.save(caseAppointment);
        model.addAttribute("caseAppointment", caseAppointment);
        return "redirect:/caseAppointment/list";
    }

    @RequestMapping(value = "/caseAppointment/delete/{id}", method = RequestMethod.GET)
    public String deleteCaseAppointment(@PathVariable Long id){
        caseAppointmentRepository.deleteById(id);
        return "redirect:/caseAppointment/list";
    }
}
