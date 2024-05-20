Names:                                    B.N:
_Alaa Abd El_Nasser Mohamed Fouad   14
_Ekram Ahmed                        11
_Alaa Khaled Taha                   13
_Alaa Ahmed Mobarek                 12
_Amira El_Sayed El_Demerdash        17


**Main Components:**

The project consists of various controllers (`AdminController`, `ApprovalSystemAdminController`, `DepositUserController`, `HomeAdminController`, `HomeUserController`, `ItemApprovalSystemAdminController`, `ItemCompanyController`, `itemController`) each handling different functionalities of the stock trading system. These controllers likely correspond to different views or screens within the application, such as administration panels, user dashboards, approval systems, etc.

**FXML Files:**

Each controller is associated with an FXML file, which defines the layout and structure of the corresponding view. For example, `Admin.fxml`, `ApprovalSystemAdmin.fxml`, `DepositUser.fxml`, `HomeAdmin.fxml`, `HomeUser.fxml`, `ItemApprovalSystem.fxml`, `ItemCompany.fxml`, `item.fxml` are the FXML files for the respective controllers.

**Functionality:**

- `AdminController`: Handles administrative tasks like managing users, stocks, stock orders, and approval systems.
- `HomeAdminController`: Deals with the home screen for administrators, allowing them to start or end their session.
- `HomeUserController`: Provides functionality for regular users, such as displaying transaction history, time updates, etc.
- `DepositUserController`: Facilitates depositing money into user accounts.
- `ApprovalSystemAdminController`: Manages the approval system for transactions, allowing administrators to approve or reject pending transactions.
- `ItemCompanyController`: Handles displaying stocks for a particular company.
- `itemController`: A generic controller used for individual items within the application.

**Database Operations:**

The project likely interacts with a database to store and retrieve data related to users, transactions, stocks, etc. Database operations are encapsulated in classes like `UserDB`, `StockDB`, and `OrdersDB`.

**Dynamic Content Loading:**

The project utilizes dynamic content loading techniques, where items such as transactions, stock items, etc., are loaded dynamically based on user interactions or database queries. This is evident in methods like `addNewItem`, `addStocks`, etc., which dynamically add items to the UI.

**User Interface and Interaction:**

The UI is built using JavaFX components like buttons, labels, text fields, etc., arranged in FXML files. User interaction is handled through event handlers defined in the controllers, responding to button clicks, text input, etc.

