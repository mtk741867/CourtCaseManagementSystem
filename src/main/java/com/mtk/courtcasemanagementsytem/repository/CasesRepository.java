package com.mtk.courtcasemanagementsytem.repository;

import com.mtk.courtcasemanagementsytem.model.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasesRepository extends JpaRepository<Cases,Long> {
    List<Cases> findByPlaintiffNameContainingOrDefendantNameContainingOrId(String plaintiff,String defendant, Long id);
    //List<Cases> findByPlaintiffNameContaining(String plaintiffName)
    //List<Cases> findByDefendantNameContaining(String defendantName);

}
