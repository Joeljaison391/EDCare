package com.edcare.Companion.repository;

import com.edcare.Companion.model.AnalysisResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnalysisResultRepository extends MongoRepository<AnalysisResult, String> {
}
