package com.epam.sprdata.repos;

import com.epam.sprdata.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodRepo extends JpaRepository<Good, Long> {
    List<Good> findByTagContaining(String tag);
}
