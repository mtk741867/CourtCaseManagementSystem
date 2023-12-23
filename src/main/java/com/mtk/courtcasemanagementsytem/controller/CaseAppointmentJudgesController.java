package com.mtk.courtcasemanagementsytem.controller;

import com.mtk.courtcasemanagementsytem.model.CaseAppointment;
import com.mtk.courtcasemanagementsytem.model.CaseAppointmentJudges;
import com.mtk.courtcasemanagementsytem.model.Judges;
import com.mtk.courtcasemanagementsytem.repository.CaseAppointmentJudgesRepository;
import com.mtk.courtcasemanagementsytem.repository.CaseAppointmentRepository;
import com.mtk.courtcasemanagementsytem.repository.JudgesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CaseAppointmentJudgesController {
    @Autowired
    CaseAppointmentJudgesRepository caseAppointmentJudgesRepository;

    @Autowired
    CaseAppointmentRepository caseAppointmentRepository;

    @Autowired
    JudgesRepository judgesRepository;
    @RequestMapping(value = "/caseAppointmentJudges/new", method = RequestMethod.GET)
    public String newCaseAppointmentJudges(Model model){
        CaseAppointmentJudges caseAppointmentJudges=new CaseAppointmentJudges();
        model.addAttribute("caseAppointmentJudges", caseAppointmentJudges);
        //CaseAppointment
        List<CaseAppointment>caseAppointmentList= caseAppointmentRepository.findAll();
        model.addAttribute("caseAppointment",caseAppointmentList);
        //Judges
        List<Judges>judgesList= judgesRepository.findAll();
        model.addAttribute("judges",judgesList);
        return "caseAppointmentJudges/new";
    }
    @RequestMapping(value = "/caseAppointmentJudges/new", method = RequestMethod.POST)
    public String saveCaseAppointmentJudges(Model model, CaseAppointmentJudges caseAppointmentJudges){

        caseAppointmentJudgesRepository.save(caseAppointmentJudges);

        model.addAttribute("caseAppointmentJudges", caseAppointmentJudges);
        return "redirect:/caseAppointmentJudges/list";

    }
    @RequestMapping(value = "/caseAppointmentJudges/list", method = RequestMethod.GET)
    public String findAllCaseAppointmentJudges(Model model){

        List<CaseAppointmentJudges> caseAppointmentJudges= caseAppointmentJudgesRepository.findAll();

        model.addAttribute("caseAppointmentJudges", caseAppointmentJudges);

        return "caseAppointmentJudges/list";
    }
    @RequestMapping(value = "/caseAppointmentJudges/edit/{id}", method = RequestMethod.GET)
    public String editCaseAppointmentJudges(Model model,@PathVariable Long id){
        CaseAppointmentJudges caseAppointmentJudges= caseAppointmentJudgesRepository.findById(id).orElse(null);
        model.addAttribute("caseAppointmentJudges", caseAppointmentJudges);
        //CaseAppointment
        List<CaseAppointment>caseAppointmentList= caseAppointmentRepository.findAll();
        model.addAttribute("caseAppointment",caseAppointmentList);
        //Judges
        List<Judges>judgesList= judgesRepository.findAll();
        model.addAttribute("judges",judgesList);
        return "caseAppointmentJudges/edit";
    }


    @RequestMapping(value = "/caseAppointmentJudges/edit", method = RequestMethod.POST)
    public String updateCaseAppointmentJudges(Model model,CaseAppointmentJudges caseAppointmentJudges){
        caseAppointmentJudgesRepository.save(caseAppointmentJudges);
        model.addAttribute("caseAppointmentJudges", caseAppointmentJudges);
        return "redirect:/caseAppointmentJudges/list";
    }

    @RequestMapping(value = "/caseAppointmentJudges/delete/{id}", method = RequestMethod.GET)
    public String deleteCaseAppointmentJudges(@PathVariable Long id){
        caseAppointmentJudgesRepository.deleteById(id);
        return "redirect:/caseAppointmentJudges/list";
    }
}
