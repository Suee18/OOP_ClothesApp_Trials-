package project.trials;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sue
 */
 abstract public class User 
{//updated
    public String userName;
    public String userType;
    private String Password;
    private String confirmPass;
       
    public  ArrayList<User> userDataList = new ArrayList<>();
    public  ArrayList<String> userLoginData = new ArrayList<>();

    
    public User(){}
    
    public User(String userName, String userType, String Password) {
        this.userName = userName;
        this.userType = userType;
        this.Password = Password;
    }

    
    public String getUserName() 
    {
        return userName;
    }

    public String getUserType() {
        return userType;
    }
    public void setpassword(String Password){
        this.Password= Password;
    }
    public String getpassword(){
        return Password;
    }
    public void setconfirmPass(String confirmPass){
        this.confirmPass=confirmPass;
    }
    public String getconfirmPass(){
        return confirmPass;
    }
   
    public abstract void createFile();
    public abstract void readFromFile();
    public abstract void writeToFile();

    public abstract void signUp();
     
    public abstract boolean checkUserData(String userName,String userType1,String password);
   
    public abstract boolean logIn();
   
    
   

 }
  


