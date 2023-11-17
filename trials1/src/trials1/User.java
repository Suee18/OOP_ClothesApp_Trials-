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
    public int pin;
   
    
    
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
    Scanner userInput1 = new Scanner(System.in);
    System.out.println("Enter user name: ");
    userName = userInput1.next();
    System.out.println("Enter type(Admin-Cashier-Customer): ");
    userType = userInput1.next();
    System.out.println("Enter pin:");
    pin = userInput1.nextInt();

    try 
    {
        FileWriter writeToUserData1 = new FileWriter("userData.txt", true);
        writeToUserData1.write(userName + " " + userType + " " + pin + "\n");
        writeToUserData1.close();
    } 
    catch (IOException e) 
    {
        System.out.println("Error in file" + e);
    }

}
     private boolean checkUserData(String userName, String userType, int pin) 
     {
    try (Scanner userDataFileLooper = new Scanner(new File("userData.txt"))) 
    {
        while (userDataFileLooper.hasNextLine()) 
        {
            String line = userDataFileLooper.nextLine();
            String[] userData = line.split(" ");

            if (userData.length == 3) 
            { 
                String storedUsername = userData[0];
                String storedUserType = userData[1];
                int storedPin;
                try
                {
                    storedPin = Integer.parseInt(userData[2]);
                } catch (NumberFormatException e) 
                {
                    System.out.println("Error parsing pin from file: " + e);
                    continue; 
                }

                if (userName.equals(storedUsername) && userType.equals(storedUserType) && pin == storedPin) 
                {
                    return true;
                }
            }
        }
    } catch (FileNotFoundException e) 
    {
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
    



