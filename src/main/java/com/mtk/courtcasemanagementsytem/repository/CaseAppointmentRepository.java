package com.mtk.courtcasemanagementsytem.repository;

import com.mtk.courtcasemanagementsytem.model.CaseAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseAppointmentRepository extends JpaRepository<CaseAppointment,Long> {
}
