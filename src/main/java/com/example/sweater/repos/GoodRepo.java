package com.example.sweater.repos;

import com.example.sweater.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodRepo extends JpaRepository<Good, Long> {
    List<Good> findByTag(String tag);
}
