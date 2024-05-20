package system;

public class transactions {

        private String deposite_withdrawel;
        private String status;
        private int orderid;
        private double money;
        private String date;
        private int userid;
        // Constructor to initialize all variables
        public transactions(String deposite_withdrawel, String status, int orderid, double money,String date,int userid) {
            this.deposite_withdrawel = deposite_withdrawel;
            this.status = status;
            this.orderid = orderid;
            this.money = money;
            this.date = date;
            this.userid = userid;
        }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeposite_withdrawel() {
            return deposite_withdrawel;
        }

        public void setDeposite_withdrawel(String deposite_withdrawel) {
            this.deposite_withdrawel = deposite_withdrawel;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getOrderId() {
            return orderid;
        }

        public void setOrderId(int orderid) {
            this.orderid = orderid;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }
}
