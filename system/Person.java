package system;

public interface Person {

        // Account Management
        void createAccount(String username, String password, String email);

        // Order Management
        void addOrder(stocks stock, int quantity, double price);
        void deleteOrder(order order);
        void executeBuyOrder(stocks stock, double price);

        // Deposit/Withdrawal
        void requestDeposit(double amount);
        void requestWithdrawal(double amount);

        // Financial Actions
        void listTransactions();

        // Transaction History
        void viewTransactionHistory();

        // Price History
        void viewPriceHistory(stocks stock);

//    // Premium Features
//    void subscribeForNotifications(Stocks stock);
//    void viewLineChart(Stocks stock);

        // Market Performance Tracking
        void trackMarketPerformance();


    }

