package com.mtk.courtcasemanagementsytem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CaseAppointmentJudges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "judgeId")
    private Judges judges;

    @ManyToOne
    @JoinColumn(name = "caseAppointmentId")
    private CaseAppointment caseAppointment;

}
