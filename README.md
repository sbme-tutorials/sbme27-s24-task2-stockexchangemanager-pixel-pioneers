Names:                                    B.N:
_Alaa Abd El_Nasser Mohamed Fouad   14
_Ekram Ahmed                        11
_Alaa Khaled Taha                   13
_Alaa Ahmed Mobarek                 12
_Amira El_Sayed El_Demerdash        17

*/
/
/
*
**Main Components:**

##The project consists of various controllers (`AdminController`, `ApprovalSystemAdminController`, `DepositUserController`, `HomeAdminController`, `HomeUserController`, `ItemApprovalSystemAdminController`, `ItemCompanyController`, `itemController`) each handling different functionalities of the stock trading system. These controllers likely correspond to different views or screens within the application, such as administration panels, user dashboards, approval systems, etc.

**FXML Files:**

##Each controller is associated with an FXML file, which defines the layout and structure of the corresponding view. For example, `Admin.fxml`, `ApprovalSystemAdmin.fxml`, `DepositUser.fxml`, `HomeAdmin.fxml`, `HomeUser.fxml`, `ItemApprovalSystem.fxml`, `ItemCompany.fxml`, `item.fxml` are the FXML files for the respective controllers.

**Functionality:**

-** `AdminController`: Handles administrative tasks like managing users, stocks, stock orders, and approval systems.
- **`HomeAdminController`: Deals with the home screen for administrators, allowing them to start or end their session.
- **`HomeUserController`: Provides functionality for regular users, such as displaying transaction history, time updates, etc.
- **`DepositUserController`: Facilitates depositing money into user accounts.
- **`ApprovalSystemAdminController`: Manages the approval system for transactions, allowing administrators to approve or reject pending transactions.
- **`ItemCompanyController`: Handl![Screenshot 2024-05-20 220544](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681![Screenshot 2024-05-20 213419](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681/3a2ee733-dd2d-4b2c-b728-7405a33982f0)
![Screenshot 2024-05-20 213856](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681/f0022447-5695-4692-884b-f7a8c79bd2cc)
![Screenshot 2024-05-20 220148](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681/02e8872d-380b-4b84-8f0d-6a3cc9d1bb96)
![Screenshot 2024-05-20 220207](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681/ec71d9bc-57e5-483c-b1cc-93bff9bd5144)
![Screenshot 2024-05-20 220322](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681/ea319c18-db24-426f-a1cd-5d54c3ef26ef)
![Screenshot 2024-05-20 220340](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681/e3f0ce37-dbe8-49a0-b10e-81a9cc15c19b)
![Screenshot 2024-05-20 220420](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681/3e673aa7-9519-4881-8f01-510f5737baa6)
![Screenshot 2024-05-20 220544](https://github.com/sbme-tutorials/sbme27-s24-task2-stockexchangemanager-pixel-pioneers/assets/148906681/560e8bf9-1ef7-42b9-82d3-3e61144983ff)
/6ea69c52-e5d2-4b25-a55f-1a0844c1c851)
es displaying stocks for a particular company.
- **`itemController`: A generic controller used for individual items within the application.

**Database Operations:**

#The project likely interacts with a database to store and retrieve data related to users, transactions, stocks, etc. Database operations are encapsulated in #classes like `UserDB`, `StockDB`, and `OrdersDB`.

**Dynamic Content Loading:**

#The project utilizes dynamic content loading techniques, where items such as transactions, stock items, etc., are loaded dynamically based on user interactions #or database queries. This is evident in methods like `addNewItem`, `addStocks`, etc., which dynamically add items to the UI.

**User Interface and Interaction:**

#The UI is built using JavaFX components like buttons, labels, text fields, etc., arranged in FXML files. User interaction is handled through event handlers #defined in the controllers, responding to button clicks, text input, etc.

