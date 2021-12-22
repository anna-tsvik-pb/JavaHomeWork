package com.pb.tsvik.hw12;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person{

    private String fio;
    private LocalDate dateBirth;
    private String phone;
    private String address;
    private LocalDateTime dateTimeChange;

    public Person(String fio, LocalDate dateBirth, String phone, String address, LocalDateTime dateTimeChange) {
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.phone = phone;
        this.address = address;
        this.dateTimeChange = dateTimeChange;
    }


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDateTimeChange() {
        return dateTimeChange;
    }

    public void setDateTimeChange(LocalDateTime dateTimeChange) {
        this.dateTimeChange = dateTimeChange;
    }



    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", dateBirth=" + dateBirth +
                ", phone=[" + phone +
                "], address='" + address + '\'' +
                ", dateTimeChange=" + dateTimeChange +
                '}';
    }
}
