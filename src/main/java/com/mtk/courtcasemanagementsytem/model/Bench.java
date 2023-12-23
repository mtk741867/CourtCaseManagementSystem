package com.mtk.courtcasemanagementsytem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Bench {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String benchName;
    private int maxNumberOfJudges;
    @OneToMany(mappedBy = "bench",cascade = CascadeType.ALL)//, orphanRemoval=true)
    private List<CaseAppointment> caseAppointmentList;
}
