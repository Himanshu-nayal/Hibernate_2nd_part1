package com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Enitiy;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("ch")
@Table(name = "bankcheck")
@PrimaryKeyJoinColumn(name = "b_id")

public class Check extends Payment {
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    private String checkNumber;
}
