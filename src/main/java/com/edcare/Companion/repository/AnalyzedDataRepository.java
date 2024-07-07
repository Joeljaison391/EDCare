package com.edcare.Companion.repository;


import com.edcare.Companion.model.AnalyzedDataProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyzedDataRepository extends JpaRepository<AnalyzedDataProfile, Long> {
    // Add custom query methods if needed
}
