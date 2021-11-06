package com.jayatech.challenge.exchange.repository;

import com.jayatech.challenge.exchange.dto.ExchangeDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<ExchangeDto, Long> {

    List<ExchangeDto> findByUserId(String userId);
}
