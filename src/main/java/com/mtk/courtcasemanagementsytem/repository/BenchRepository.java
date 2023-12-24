package com.mtk.courtcasemanagementsytem.repository;

import com.mtk.courtcasemanagementsytem.model.Bench;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenchRepository extends JpaRepository<Bench,Long> {
    List<Bench> findByBenchNameContainingOrId(String benchName, Long id);

}
