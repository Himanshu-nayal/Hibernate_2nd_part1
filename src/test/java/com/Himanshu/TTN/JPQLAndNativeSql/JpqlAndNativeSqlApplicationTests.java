package com.Himanshu.TTN.JPQLAndNativeSql;

import com.Himanshu.TTN.JPQLAndNativeSql.Entity.Employee1;
import com.Himanshu.TTN.JPQLAndNativeSql.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class JpqlAndNativeSqlApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void TestInsertEmployee() {
		Employee1 emp1 = new Employee1();
		Employee1 emp2 = new Employee1();
		Employee1 emp3 = new Employee1();
		Employee1 emp4 = new Employee1();
		Employee1 emp5 = new Employee1();

		emp1.setFirstName("Himanhu");
		emp1.setLastName("Nayal");
		emp1.setSalary(5000);
		emp1.setAge(22);

		emp2.setFirstName("kamlesh");
		emp2.setLastName("bisht");
		emp2.setSalary(45000);
		emp2.setAge(23);

		emp3.setFirstName("Aman");
		emp3.setLastName("singh");
		emp3.setSalary(4000);
		emp3.setAge(22);

		emp4.setFirstName("ankush");
		emp4.setLastName("Singh");
		emp4.setSalary(35000);
		emp4.setAge(21);

		emp5.setFirstName("abhishekh");
		emp5.setLastName("Kumar");
		emp5.setSalary(15000);
		emp5.setAge(50);

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);
		employeeRepository.save(emp4);
		employeeRepository.save(emp5);
	}
	@Test
	public void testFindAllPartial(){
		System.out.println( employeeRepository.findAllEmployeePartial());
	}
	@Test
	public void testFindEmployee(){
		System.out.println(employeeRepository.findAllEmployee());
	}
	@Test
	public void testFindEmployeeByAvgSalary(){
		List<Object[]> objects = employeeRepository.findAllEmployeeWithAvgSalary();
		for (Object[] obj:objects)
		{
			System.out.println(obj[0]);
			System.out.println(obj[1]);

		}
	}
	@Test
	public void testFindByNameEmployee(){
		System.out.println(employeeRepository.findByFristName("Himanshu"));
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteByNameEmp(){
		employeeRepository.deleteBYNameEmp("Himanshu");
	}


	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateByAvgSalary(){
		int salary=3000;
		int avgSalary=employeeRepository.findAvgSalary();
		employeeRepository.updateBySalary(salary,avgSalary);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteBySalary(){
		System.out.println(employeeRepository.deleteBySalary(2000));
	}


	@Test
	public void testFindAgeGreater(){
		employeeRepository.findAgeGreaterThen(32);
	}


	//Display the id, first name, age of all employees where last name ends with "singh"
	@Test
	public void testFindNameByNQ(){
		List<Object[]> objects1 = employeeRepository.findNameBYNQ();
		for (Object[] obj1:objects1){
			System.out.println(obj1[0]);
			System.out.println(obj1[1]);
			System.out.println(obj1[2]);

		}
	}
	//Delete all employees with age greater than 45(Should be passed as a parameter)

	@Test
	@Rollback(value = false)
	@Transactional
	public void testDeleteEmployeeAgeNQ(){
		employeeRepository.deleteByAgeNQ(47);
	}


}



