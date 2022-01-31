package com.shivaprasad.springbootjobscheduler.repository;

import com.shivaprasad.springbootjobscheduler.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
}
