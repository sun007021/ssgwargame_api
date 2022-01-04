package com.example.ssgwargame_api.repository;

import com.example.ssgwargame_api.domain.Problems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemsRepository extends JpaRepository<Problems, Long> {
}
