package com.jayatech.challenge.exchange.repository;

import com.jayatech.challenge.exchange.domain.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    List<Exchange> findByUserId(String userId);
}
