package com.mtk.courtcasemanagementsytem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Judges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String judgeName;
    @OneToMany(mappedBy = "judges",cascade = CascadeType.ALL)//, orphanRemoval=true)
    private List<CaseAppointmentJudges> caseAppointmentJudgesList;

}
