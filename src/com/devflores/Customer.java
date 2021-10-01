package com.devflores;

public class Customer {

    private Integer pin;
    private Long accountNumber;

    public Customer(Integer pin, Long accountNumber) {
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }


}
