package com.Himanshu.TTN.JPQLAndNativeSql.Repository;

import com.Himanshu.TTN.JPQLAndNativeSql.Entity.Employee1;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee1,Integer> {

    @Query("from Employee1")
    List<Employee1> findAllEmployee();

    @Query("from Employee1 e where e.age>:age ")
    List<Employee1> findAgeGreaterThen(@Param("age") int age);


    @Query("select e.firstName,e.lastName,e.age from Employee1 e")
    List<Object[]> findAllEmployeePartial() ;

    @Query("select e.firstName,e.lastName from Employee1 e where e.salary>(select avg(y.salary) from Employee1 y)")
    List<Object[]> findAllEmployeeWithAvgSalary();

    @Query("from Employee1 where empFirstName= :firstName")
    List<Employee1> findByFristName(@Param("firstName")String firstName);

    @Query("from Employee1  where score> :min and score< :max")
    List<Employee1> findMinAndMax(@Param("min")int min , @Param("max")int max);


    @Query("select avg(salary) from Employee1")
    int findAvgSalary();

    @Modifying
    @Query(value = "delete from Employee1 where firstName=:fName")
    List<Employee1> deleteBYNameEmp(@Param("fName") String name);

    @Modifying
    @Query("UPDATE Employee1 SET salary= :salary where salary< :avgSalary")
    List<Employee1> updateBySalary(@Param("salary") int salary, @Param("avgSalary") int avgSalary);

    @Query(value = "select e.empid,e.empFirstName, e.empAge from employee1 e where e.empLastName LIKE= :%singh%",nativeQuery = true)
    List<Object[]> findNameBYNQ();
    @Modifying
    @Query("delete from Employee1 e where e.salary< :min")
    List<Employee1> deleteBySalary(@Param("min") int min);

    @Modifying
    @Query(value = "delete from Employee1 where e.empage > 45",nativeQuery = true)
    List<Employee1> deleteByAgeNQ(@Param("age") int age);
}


