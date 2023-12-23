package com.mtk.courtcasemanagementsytem.repository;
import com.mtk.courtcasemanagementsytem.model.Judges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgesRepository extends JpaRepository<Judges,Long> {

}
