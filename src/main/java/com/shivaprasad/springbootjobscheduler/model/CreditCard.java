package com.shivaprasad.springbootjobscheduler.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CreditCard {

    @Id
    @SequenceGenerator(
            name="credit_seq",
            sequenceName = "credit_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credit_seq"
    )
    private Integer id;
    private Integer cardNumber;
    private LocalDate cardExpiry;
    private Integer cardCVV;
    private String cardType;

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(LocalDate cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public Integer getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(Integer cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
