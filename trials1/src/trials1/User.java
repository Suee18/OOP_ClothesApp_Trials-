/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package trials1;


package JavaApplication3;
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

    public void setPassword(String Password){
        this.Password= Password;
    }
    public String getPassword(){
        return Password;
    }
    public void setconfirmPass(String confirmPass){
        this.confirmPass=confirmPass;
    }
    public String getconfirmPass(){
        return confirmPass;
    }
   
    
    //done 
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

                    // Create a new User object and add it to  userDataList
                    User newUser = new User(userName1, userType1, password1);
                    userDataList.add(newUser);
                } else {
                    System.out.println("Invalid data format in the file.");
                }
            }

            System.out.println("User data read from file successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e);
        }
    }

    
        
    
    
    
    
    
    public void writeToFile(){
        
       try (FileWriter writer = new FileWriter ("userData.txt"))
       {
           //looping through the  arraylist 
        for (User u : userDataList) 
        {
            //writing its contents on a file
            writer.write(u.getUserName()+" "+u.getUserType()+" "+u.getPassword()+"\n");
            
        }
        System.out.println("User data saved to file successfully.");
    } catch (IOException e) {
       System.out.println(e);
    }
}
        
    
    
    
    //done
     public void signUp()
     {
            Scanner userInput2 = new Scanner(System.in);
            System.out.println("Enter user name: ");
            String userName1 = userInput2.next();
            System.out.println("Enter user type: ");
            String userType1 = userInput2.next();
            System.out.println("Enter password: ");
            String password1 = userInput2.next();
            
            //taking data from user
            //creating an object and putting it in the array list 

          User u1  = new User(userName1, userType1, password1);
          //adding object to arraylist
          userDataList.add(u1);
         
     }

    //private boolean checkUserData(String userName, String userType, String password) 
    //{return 0;
    //}


    public void logIn()
    {
    Scanner userInput2 = new Scanner(System.in);
    System.out.println("Enter user name: ");
    String userName1 = userInput2.next();
    System.out.println("Enter user type: ");
    String userType1 = userInput2.next();
    System.out.println("Enter password: ");
    String password1 = userInput2.next();

    //if (checkUserData(userName1, userType1, password1)) 
    //{
      //  System.out.println("Login successful!");
    //} else 
    //{
      //  System.out.println("Login failed. Invalid credentials.");
    //}

    //}
    }
}
    


