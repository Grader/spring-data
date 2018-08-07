package com.epam.sprdata.repos;

import com.epam.sprdata.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(Long id);
}
