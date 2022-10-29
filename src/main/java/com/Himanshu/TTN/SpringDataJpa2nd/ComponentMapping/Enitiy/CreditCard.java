package com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Enitiy;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity

//single_table
//@DiscriminatorValue("cc")
@Table(name = "card")
//joined_per column
@PrimaryKeyJoinColumn(name = "c_id")
public class CreditCard extends Payment {

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private String cardNumber;

}
