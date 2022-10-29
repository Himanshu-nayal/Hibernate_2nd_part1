package com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Repos;

import com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Enitiy.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentRepo extends CrudRepository<Payment,Integer> {
}
