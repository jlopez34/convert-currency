package com.jayatech.challenge.exchange.domain.model;

import com.opengamma.strata.collect.ArgChecker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "tbl_exchanges")
public class Exchange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column
    private String userId;

    @Column
    private String currencyFrom;

    @Column
    private double valueFrom;

    @Column
    private String currencyTo;

    @Column
    private double valueTo;

    @Column
    private double rate;

    @Column
    private String base;

    @Column
    private LocalDateTime dateTime;

    public static Exchange of(Exchange exchange) {
        ArgChecker.notNull(exchange, "exchange");
        Exchange dto = new Exchange();
        BeanUtils.copyProperties(exchange, dto);
        return dto;
    }
}
