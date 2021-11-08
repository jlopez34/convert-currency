package com.jayatech.challenge.exchange.repository;

import com.jayatech.challenge.exchange.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    List<Exchange> findByUserId(String userId);
}
