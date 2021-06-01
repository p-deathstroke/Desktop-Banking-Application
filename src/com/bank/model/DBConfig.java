
package com.bank.model;

import com.bank.main.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConfig {
    String userDB="root";
    String passwordDB="";
    String url="jdbc:mysql://localhost:3306/myswingdb?useSSL=false";
    String driver="com.mysql.jdbc.Driver";
    
    private Connection con;
    private void dbConnect() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        con = DriverManager.getConnection(url,userDB,passwordDB);
        
    }
    private void dbClose() throws SQLException{
        con.close();
    }
    
     public void createAccount(Customer c) throws ClassNotFoundException, SQLException{
         dbConnect();
         String sql="insert into customer(name,email,contactNumber,address,accountNumber,balance) values(?,?,?,?,?,?)";
         PreparedStatement pstmt=con.prepareStatement(sql);
         pstmt.setString(1,c.getName());
         pstmt.setString(2,c.getEmail());
         pstmt.setString(3,c.getContactnumber());
         pstmt.setString(4,c.getAddress());
         pstmt.setString(5,c.getAccountNumber());
         pstmt.setString(6,c.getBalance());
         pstmt.executeUpdate();
         
         dbClose();
     }

    public boolean checkAccoutNumber(String accountNumber) throws ClassNotFoundException, SQLException {
        dbConnect();
        int count=0;
        String sql ="select * from customer where accountNumber=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,accountNumber);
       ResultSet rst= pstmt.executeQuery();
       while(rst.next()){
            count = 1;
       }
        dbClose();
        if(count==1){
            return true;
        }
        return false;   
        
    }

    public Customer fecthCustomerDetails(String accountNumber) throws ClassNotFoundException, SQLException {
        dbConnect();
        Customer c= new Customer();
        String sql ="select * from customer where accountNumber=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,accountNumber);
        ResultSet rst= pstmt.executeQuery();
        while(rst.next()){
            c.setName(rst.getString(2));
            c.setEmail(rst.getString(3));
            c.setContactnumber(rst.getString(4));
            c.setAddress(rst.getString(5));
            c.setAccountNumber(rst.getString(6));
            c.setBalance(rst.getString(7));
        }
        dbClose();
      return c;
    }
    
    
}
