
import javafx.scene.control.Alert;

import java.sql.*;
//import application.databaseController;

//public class loginDB {

//        public static void signup(String username, String password, String email, String gender,double balance,String country){
//            databaseController.getConnection();
//            Connection connection=null;
//            PreparedStatement preparedStatement=null;
//            PreparedStatement insertuser;
//            ResultSet resultSet=null;
//            try {
//                Class.forName("org.sqlite.JDBC");
//                // Open a connection to the database
//                String url = "jdbc:sqlite:database.db";
//                connection = DriverManager.getConnection(url);
//                preparedStatement =connection.prepareStatement("SELECT * FROM user WHERE username=?");
//                preparedStatement.setString(1,username);
//                resultSet=preparedStatement.executeQuery();
//                if(resultSet.next()){
//                    System.out.println("User already exists");
//                    Alert alert=new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("You can't use this username");
//                    alert.show();
//                }else{insertuser=connection.prepareStatement("INSERT INTO user (username ,password,email,gender,balance ,country)  VALUES (?,?,?,?,?,?)");
//                    insertuser.setString(1,username);
//                    insertuser.setString(2,password);
//                    insertuser.setString(3,email);
//                    insertuser.setString(4,gender);
//                    insertuser.setDouble(5,balance);
//                    insertuser.setString(6,country);
//
//                }
//
//            }catch(Exception e){
//                e.printStackTrace();
//            }finally{
//                if(resultSet!=null){
//                    try{
//                        resultSet.close();
//                    }catch(SQLException e){
//                        e.printStackTrace();
//                    }
//                }
//                if(preparedStatement!=null){
//                    try{
//                        preparedStatement.close();
//                    }catch(SQLException e){
//                        e.printStackTrace();
//                    }
//                }
//                if(connection!=null){
//                    try{
//                        connection.close();
//                    }catch(SQLException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        public static void signin(String username, String password){
//            Connection connection=null;
//            PreparedStatement preparedStatement=null;
//            ResultSet resultSet=null;
//            try{
//                Class.forName("org.sqlite.JDBC");
//                // Open a connection to the database
//                String url = "jdbc:sqlite:database.db";
//                connection = DriverManager.getConnection(url);
//                preparedStatement =connection.prepareStatement("SELECT password FROM user WHERE username=?");
//                preparedStatement.setString(1,username);
//                resultSet=preparedStatement.executeQuery();
//                if(! resultSet.next()){
//                    System.out.println("User does not exist");
//                    Alert alert=new Alert(Alert.AlertType.ERROR);
//                    alert.setContentText("user does not exist");
//                    alert.show();
//
//                }else{
//                    while(resultSet.next()){
//                        String retreivedpassword=resultSet.getString("password");
//                        if(retreivedpassword.equals(password)){
//                            System.out.println("Password Matched");
//                        }
//                        else{
//                            System.out.println("Wrong password");
//                            Alert alert=new Alert(Alert.AlertType.ERROR);
//                            alert.setContentText("Wrong password");
//                            alert.show();
//                        }
//                    }
//
//                }
//
//
//            }catch(SQLException | ClassNotFoundException e){
//                e.printStackTrace();
//            } finally{
//                if(resultSet!=null){
//                    try{
//                        resultSet.close();
//                    }catch(SQLException e){
//                        e.printStackTrace();
//                    }
//                }
//                if(preparedStatement!=null){
//                    try{
//                        preparedStatement.close();
//                    }catch(SQLException e){
//                        e.printStackTrace();
//                    }
//                }
//                if(connection!=null){
//                    try{
//                        connection.close();
//                    }catch(SQLException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }

//    }


