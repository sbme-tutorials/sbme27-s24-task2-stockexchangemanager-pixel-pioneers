package system;

import DataBase.ordersDB;
import DataBase.userDB;

import java.sql.SQLException;

public class users  {

        private String userName;
        private int id;
        private String password;
        private String email;
        private String gender;
        private double account_balance;
        private String country;
    public users(){

    }
        public users(int id ,String userName, String password, String email, String gender, double account_balance, String country) {
        this.id=id;
        this.userName = userName;
            this.password = password;
            this.email = email;
            this.gender = gender;
            this.account_balance = account_balance;
            this.country = country;
        }
        public String getUserName() {
        return userName;
        }
        public void setUserName(String userName) {
        this.userName = userName;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getGender() {
            return gender;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(String gender) {
            this.gender = gender;
        }
        public double getAccount_balance() {
            return account_balance;
        }
        public void setAccount_balance(double account_balance) {
            this.account_balance = account_balance;
        }
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        users user;
        public void setuser(users user){
        this.user=user;
        }
        public users getuser(users user){
            return user;
        }
    public void deposit(int id,int amount, String time) throws Exception {

        ordersDB.addOrder(id,"deposite", amount, time);



    }

    public void withdraw(int id,double amount,String time ,double balance) throws Exception {
        if (amount <= balance) {

            ordersDB.addOrder(id,"withdraw", amount, time);

            System.out.println("Successfully withdrew $" + amount + " from your account");
    }


}}
