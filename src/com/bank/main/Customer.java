
package com.bank.main;
public class Customer {
    private int id;
    private String name;
    private String email;
    private String contactnumber;
    private String address ;
    private String accountNumber;
    private String balance;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }
      public void setAddress(String address) {
        this.address = address;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactnumber() {
        return contactnumber;
    }


    public String getAddress() {
        return address;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBalance() {
        return balance;
    }
    
}
