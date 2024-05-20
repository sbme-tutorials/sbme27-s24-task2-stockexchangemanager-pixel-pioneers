package system;

import DataBase.stockDB;
import DataBase.userDB;

import java.sql.SQLException;

public class stocks  {

        private String company;
        private String initialPrice;
        private double TradingPrice;
        private int availableStocks;
        private String ProfitPercent;
        private String  dividends;
        private int id;
        private int userid;

        public stocks(){

        }
        public stocks(String company, String initialPrice,double TradingPrice,int availableStocks,String ProfitPercent,int id) {
           this.company = company;
            this.initialPrice=initialPrice;
            this.TradingPrice=TradingPrice;
            this.availableStocks=availableStocks;
            this.ProfitPercent=ProfitPercent;
            this.id=id;

        }
        public stocks(String company,int availableStocks){
            this.company=company;
            this.availableStocks=availableStocks;
        }

    public stocks(String company, int availableStocks, int userid, int id) {
            this.company = company;
            this.availableStocks=availableStocks;
            this.id=id;
            this.userid=userid;

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(String initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getTradingPrice() {
        return TradingPrice;
    }

    public void setTradingPrice(double tradingPrice) {
        this.TradingPrice = tradingPrice;
    }

    public int getAvailableStocks() {
        return availableStocks;
    }

    public void setAvailableStocks(int availableStocks) {
        this.availableStocks = availableStocks;
    }

    public String getProfitPercent() {
        return ProfitPercent;
    }

    public void setProfitPercent(String profitPercent) {
       this.ProfitPercent = profitPercent;
    }

    public String getDividends() {
        return dividends;
    }

    public void setDividends(String dividends) {
        this.dividends = dividends;
    }
    public void decrementAvailableStocks(int quantity,int sid ,int availableStocks) throws SQLException {

        availableStocks -= quantity;
        stockDB.updatestockNumber(id, availableStocks);

    }


    public void incrementAvailableStocks(int quantity) {
        availableStocks += quantity;
    }

//    public boolean validateData() {
//        return initialPrice >= 0 && tradingPrice >= 0 && availableStocks >= 0;
//    }

    public void buy(String company,int quantity, int id,int availableStocks,double accountBalance,double tradingPrice,int stockid) throws SQLException {
        if (quantity <= (availableStocks / 5) && accountBalance >= tradingPrice) {

            stockDB.addstockuser(company, quantity, id, stockid);
            decrementAvailableStocks(quantity, stockid, availableStocks);
            stockDB.addstockuser(company, quantity, id, stockid);

//            userDB.updatestockUser(stockid, );


        }
    }

        // Sell method
//    public void sell(int quantity, double accountBalance) {
//
//        incrementAvailableStocks(quantity);
//        System.out.println("Sold " + quantity + " stocks of " + getCompanyName() + ". Remaining stocks: " + getAvailableStocks());
//    }


    }
