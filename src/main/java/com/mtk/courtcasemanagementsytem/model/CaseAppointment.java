package com.mtk.courtcasemanagementsytem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class CaseAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate casedDate;
    private LocalDate appointmentDate;
    private String givenOrders;//Appointed or Decided
    private String shortDescription;
    @ManyToOne
    @JoinColumn(name = "caseId")
    private Cases cases;

    @ManyToOne
    @JoinColumn(name = "benchId")
    private Bench bench;
    @OneToMany(mappedBy = "caseAppointment",cascade = CascadeType.ALL)//, orphanRemoval=true)
    private List<CaseAppointmentJudges> caseAppointmentJudgesList;

}
