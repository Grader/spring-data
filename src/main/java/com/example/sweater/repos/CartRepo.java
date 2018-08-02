package com.example.sweater.repos;

import com.example.sweater.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}
