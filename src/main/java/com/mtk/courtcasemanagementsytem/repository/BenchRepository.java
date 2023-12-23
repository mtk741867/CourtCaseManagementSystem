package com.mtk.courtcasemanagementsytem.repository;

import com.mtk.courtcasemanagementsytem.model.Bench;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenchRepository extends JpaRepository<Bench,Long> {
}
