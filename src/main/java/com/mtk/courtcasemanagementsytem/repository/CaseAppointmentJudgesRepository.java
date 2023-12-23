package com.mtk.courtcasemanagementsytem.repository;

import com.mtk.courtcasemanagementsytem.model.CaseAppointmentJudges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseAppointmentJudgesRepository extends JpaRepository<CaseAppointmentJudges,Long> {
}
