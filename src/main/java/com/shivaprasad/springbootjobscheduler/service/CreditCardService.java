package com.shivaprasad.springbootjobscheduler.service;

import com.shivaprasad.springbootjobscheduler.model.CreditCard;
import com.shivaprasad.springbootjobscheduler.repository.CreditCardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    List<Integer> cvvs = Arrays.asList(125,258,698,324,698);
    List<String> cardTypes = Arrays.asList("SILVER","GOLD","PLATINUM");

    @Scheduled(cron = "*/5 * * * * *")
    public void addACreditCard()
    {
        CreditCard cc = new CreditCard();
        cc.setCardNumber(new Random().nextInt(90000000));
        cc.setCardExpiry(LocalDate.now());
        cc.setCardCVV(cvvs.get(new Random().nextInt(cvvs.size())));
        cc.setCardType(cardTypes.get(new Random().nextInt(cardTypes.size())));
        creditCardRepository.save(cc);
        System.out.println("Added a new CreditCard to database at "+ LocalDateTime.now() + " cardNumber: "+cc.getCardNumber());
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void fetchCreditCards()
    {
        List<CreditCard> creditCards = creditCardRepository.findAll();
        System.out.println("Fetched Credit Cards at: "+LocalDateTime.now()+" Count is: " + creditCards.size());
        System.out.println("Credit Cards: "+ creditCards);
    }
}
