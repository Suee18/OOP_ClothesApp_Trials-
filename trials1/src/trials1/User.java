//updated

package projectfiles;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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

public class User 
{
    

    public String userName;
    public String userType;
    private String Password;
    private String confirmPass;
       
    public String filepath= "userData.txt";
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
         System.out.println("File is not created"+e.getMessage());
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
         if(checkUserData(userName,userType,getpassword()))
           {
              System.out.println("Already registred");
              return;
          }
             
//          Scanner readFile = new Scanner("userData.txt");
               
        try (BufferedWriter writerToUserData = new BufferedWriter(new FileWriter("userData.txt", true))) 
        {
            // Write data to the file
            writerToUserData.write(userName+" "+userType+" "+getpassword());
            writerToUserData.newLine(); // Add a new line


            System.out.println("egistred successfully!");
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
      
         
     
      public void readFromFile(String filepath)
    {
         try (BufferedReader reader = new BufferedReader(new FileReader(filepath)))
         {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    String userName1 = parts[0];
                    String userType1 = parts[1];
                    String password1= parts[2];

                    // Create a new User object and add it to  userDataList(arraylist)
                    User newUser = new User(userName1, userType1, password1);
                    userDataList.add(newUser);
                } else {
                    System.out.println("Invalid data format in the file.");
                }
            }

            System.out.println("User data read from file into arraylist successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e);
        }
    }

    private boolean checkUserData(String userName1,String userType1,String Password1) {
         for(User i:userDataList){
             if(i.userName.equals(userName1)  && i.userType.equals(userType1) && i.Password.equals(Password1) )
             {
                 return true;
             }             
         }
         return false;
    }   
    
//     private boolean checkUserloginData( ArrayList<String> userLoginDat) {
//         for(String data:userLoginDat){
//             if(data.contentEquals(userName)  && data.contentEquals(userType) && data.contentEquals(Password))
//             {
//                 return true;
//             }             
//         }
//         return false;
//    }
     

    
     
    public boolean logIn()
    {
    Scanner userInput2 = new Scanner(System.in);
    System.out.println("Enter user name: ");
    String userName1 = userInput2.next();
    System.out.println("Enter user type: ");
    String userType1 = userInput2.next();
    System.out.println("Enter password: ");
    String password1 = userInput2.next();
    
//    User loginData=new User(userName1,userType1,password1);

    return checkUserData(userName1,userType1,password1);
    }
    
     public void writeToFile(){

       try (FileWriter writer = new FileWriter ("userData.txt"))
       {
           //looping through the  arraylist 
        for (User u : userDataList) 
        {
            //writing its contents on a file
            writer.write(u.userName+" "+u.userType+" "+u.getpassword()+"\n");

        }
        System.out.println("User data saved to file successfully.");
    } catch (IOException e) {
       System.out.println(e);
    }
    }
  
}
