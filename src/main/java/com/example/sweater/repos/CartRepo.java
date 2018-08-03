package com.example.sweater.repos;

import com.example.sweater.domain.Cart;
import com.example.sweater.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(Long id);

    @Query("delete from Cart c where ")
    void deleteGoodInCart(Long id);

}
