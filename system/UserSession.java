package system;

public class UserSession {
    private int userId;
    private String username;
    private double balance;

    public UserSession(int userId, String username,double balance) {
        this.userId = userId;
        this.username = username;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    public double getBalance() {
        return balance;
    }
}
