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

public class User {
    

    public String userName;
    public String userType;
    private String Password;
    private String confirmPass;
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
         System.out.println("Enter your password: ");
         setpassword(input.next());
         System.out.println("Confirm password: ");
         setconfirmPass(input.next());
         System.out.println("Register as: 1) Admin 2) Casheir 3) Customer ");
         userType=input.next();
         
         if(getpassword().equals(getconfirmPass())){ 
          File file=new File("userInfo.txt");
          Scanner readFile = new Scanner(file);
          boolean checkUsername=false;
           while (readFile.hasNext()) {
            final String lineFromFile = readFile.nextLine();
            if (lineFromFile.equals(userName)) {
                //found a match
                System.out.println("Username already registered" );
                checkUsername=true;
                break;
            }
            readFile.close();
           }
           if(checkUsername==false){
               try{
                   PrintWriter writeToFile=new PrintWriter(file);
                   writeToFile.write(userName);
                   writeToFile.write(getpassword());
                   writeToFile.write(userType);
                   System.out.println("Registered Successfully");
                   writeToFile.close();
               }
               catch(FileNotFoundException e){
                   System.out.println(e);
               }
           }
         } 
         else {
         System.out.println("Confirmation doesn't match password, try again ");
         signUp(); 
         }
    }
}
         

     
    public void logIn()
    {
    Scanner userInput2 = new Scanner(System.in);

    System.out.println("Enter user name: ");
    String userName1 = userInput2.next();

    System.out.println("Enter user type: ");
    String userType1 = userInput2.next();

    int pin1;

    try 
    {
        System.out.println("Enter pin: ");
        pin1 = Integer.parseInt(userInput2.next());
    } catch (NumberFormatException e)
    {
        System.out.println("Invalid input for pin. Please enter a valid integer.");
        userInput2.close();
        return;
    }

    if (checkUserData(userName1, userType1, pin1)) 
    {
        System.out.println("Login successful!");
    } else 
    {
        System.out.println("Login failed. Invalid credentials.");
    }

}
  
}    
    



