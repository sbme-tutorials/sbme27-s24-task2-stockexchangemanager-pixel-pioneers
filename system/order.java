package system;

import DataBase.ordersDB;

public class order {
    private String name;
    private String type;
    private String date;
    private  String company;
    private int num;
    public order(){

    }
    public order(String name, String type, String date, String company, int num) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.company = company;
        this.num = num;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
