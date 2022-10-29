package com.Himanshu.TTN.SpringDataJpa2nd;


import com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Enitiy.Check;
import com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Enitiy.CreditCard;
import com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Enitiy.Employee;
import com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Enitiy.Salary;
import com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Repos.EmployeeRepo;
import com.Himanshu.TTN.SpringDataJpa2nd.ComponentMapping.Repos.PaymentRepo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestEntityManager
class SpringDataJpa2ndApplicationTests {

	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	PaymentRepo paymentRepo;

	@Test
	void contextLoads() {
	}


	// created for employee and salary
    @Test
	public void testCreate(){

		Employee employee = new Employee();
		Salary salary=new Salary();
		employee.setFirstName("Himanshu");
		employee.setLastName("Nayal");
		employee.setAge(21);

		salary.setBasicsalary(30000);
		salary.setBonussalary(40000);
		salary.setSpecialallowancesalary(5000);
		employee.setSalary(salary);
		employeeRepo.save(employee);

	}
	@Test
	public void testCreatePayment(){
		CreditCard creditCard=new CreditCard();
		creditCard.setCardNumber("2345678");
		creditCard.setId(100001);
		creditCard.setAmount(230000);
		paymentRepo.save(creditCard);
	}
	@Test
	public void createCheckPayment(){
		Check check=new Check();
		check.setCheckNumber("20200234");
		check.setId(10032);
		check.setAmount(140000);
		paymentRepo.save(check);


	}


}
