package com.Himanshu.TTN.JPQLAndNativeSql.Entity;

import javax.persistence.*;

    @Entity
    @Table(name = "employee1")
    public class Employee1 {
         // firstName, lastName, salary, age
        // empId, empFirstName, empLastName, empSalary, empAge.

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "empid")
        private int id;
        @Column(name = "empFirstName")
        private String firstName;
        @Column(name = "empLastName")
        private String lastName;

        @Column(name = "empSalary")
        private long salary;
        @Column(name = "empAge")
        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public long getSalary() {
            return salary;
        }

        public void setSalary(long salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


