package com.mtk.courtcasemanagementsytem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plaintiffName;
    private String defendantName;
    private String fileType;// civil, criminal
    private  String caseLevel;// direct,appeal
    private  String caseType;// short reason/title for the case in civil or criminal code
    @OneToMany(mappedBy = "cases",cascade = CascadeType.ALL)//, orphanRemoval=true)
    private List<CaseAppointment> caseAppointmentList;
}
