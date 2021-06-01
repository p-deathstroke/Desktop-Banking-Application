
package com.bank.pro;

import com.bank.exceptions.InvalidAccountNumberException;
import com.bank.main.Customer;
import com.bank.model.DBConfig;
import java.sql.SQLException;

public class B {

    private DBConfig db;
    
   public B(){
        db = new DBConfig();
    
}
    public boolean checkAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException, InvalidAccountNumberException {
            //go to Db and call the method which checks account number
           boolean status = db.checkAccoutNumber(accountNumber);
            if (status== true){
                return true; 
            }
            throw new  InvalidAccountNumberException();
    }

    public Customer fetchCustomerDetails(String accountNumber) throws ClassNotFoundException, SQLException {
        Customer c =db.fecthCustomerDetails(accountNumber);
        return c;
    }

    
}
