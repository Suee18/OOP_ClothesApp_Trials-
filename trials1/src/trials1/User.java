/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package trials1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;

public class User 
{
    

    public String userName;
    public String userType;
    private String Password;
    private String confirmPass;
    
    public User(){}
    
    public User(String userName, String userType, String Password) {
        this.userName = userName;
        this.userType = userType;
        this.Password = Password;
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
   
    
    
    public void createFile()
    {
           try
           {
             File userDataFile=new File ("userData.txt");
             if(userDataFile.createNewFile())
             {
             System.out.println("File created succefully!");
             
             }
             else 
             {
                 System.out.println("File already exists");
             
             }
         }
         catch(IOException e)
         {
         System.out.println("File is not created"+e);
         }   
    }
    
    
    
    
    
     public void signUp()
     {
          
         Scanner input = new Scanner(System.in);
         System.out.println("Enter your Usermane: ");
         userName=input.next();
         System.out.println("Register as: 1) Admin 2) Casheir 3) Customer ");
         userType=input.next();
         
         System.out.println("Enter your password: ");
         setpassword(input.next());
         System.out.println("Confirm password: ");
         setconfirmPass(input.next());

         
         if(getpassword().equals(getconfirmPass()))
         { 
         if(checkUserData(userName,userType,Password))
           {
              System.out.println("Already registred");
              return;
          }
             
          Scanner readFile = new Scanner("userData.txt");
               
        try (BufferedWriter writerToUserData = new BufferedWriter(new FileWriter("userData.txt", true))) 
        {
            // Write data to the file
            writerToUserData.write(userName+" "+userType+" "+getpassword());
            writerToUserData.newLine(); // Add a new line


            System.out.println("Write operation successful!");
        }
        catch (IOException e) 
        {
            System.err.println("Error writing to file: " + e);
        }
        
        
         }
           
        
         else
         {
         System.out.println("Confirmation doesn't match password, try again ");
         signUp(); 
         }
    
          }
     
         
         
         
         
         
         
         
         
             private List<User> userDataList = new ArrayList<>();

    private boolean checkUserData(String userName, String userType, String password) {

        try (Scanner userDataFileLooper = new Scanner(new File("userData.txt"))) 
        {
            while (userDataFileLooper.hasNextLine()) {
                String line = userDataFileLooper.nextLine();
                String[] userDataArray = line.split(" ");

                if (userDataArray.length == 3) {
                    
                        String storedUsername = userDataArray[0];
                        String storedUserType = userDataArray[1];
                        String storedPassword = userDataArray[2];
                        

                        // Create a UserData instance and add it to the userDataList
                        User userData = new User(storedUsername, storedUserType, storedPassword);
                        userDataList.add(userData);

                        if (userName.equals(storedUsername) && userType.equals(storedUserType) && password.equals(storedPassword)) {
                            return true;
                        }
                    
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't open userData file." + e);
        }
        return false;
    }

     
     
     
     
     
     
     
     
     
    public void logIn()
    {
    Scanner userInput2 = new Scanner(System.in);
    System.out.println("Enter user name: ");
    String userName1 = userInput2.next();
    System.out.println("Enter user type: ");
    String userType1 = userInput2.next();
    System.out.println("Enter password: ");
    String password1 = userInput2.next();

    if (checkUserData(userName1, userType1, password1)) 
    {
        System.out.println("Login successful!");
    } else 
    {
        System.out.println("Login failed. Invalid credentials.");
    }

}
  
}    
    


