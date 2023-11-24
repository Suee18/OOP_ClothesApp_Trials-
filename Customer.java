/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.trials;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author shex
 */
public class Customer extends User {
    
    public String  customerUserName;   
    public String  customerUserType;
    private String customerPassword;
    private String customerConfirmPass;
    public  ArrayList<Customer> CustomerDataList = new ArrayList<>();
     public String  CustomerFilePath="customerData.txt";

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerConfirmPass() {
        return customerConfirmPass;
    }

    public void setCustomerConfirmPass(String customerConfirmPass) {
        this.customerConfirmPass = customerConfirmPass;
    }

    
    
    
    public Customer()
    {}   
    public Customer( String  customerUserName, String  customerUserType,String customerPassword)
    {
        
        this. customerUserName= customerUserName;
        this.customerUserType=customerUserType;
        this.customerPassword=customerPassword;
        
    }

    
    
    @Override
    public void createFile() 
    {
           try
           {
             File userDataFile=new File (CustomerFilePath);
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
    
    @Override
    public void readFromFile() 
    {
        

         try (BufferedReader reader = new BufferedReader(new FileReader(CustomerFilePath)))
         {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    String userName1 = parts[0];
                    String userType1 = parts[1];
                    String password1= parts[2];
                      
                    // Create a new User object and add it to  userDataList(arraylist)
                    Customer customer1 = new Customer(userName1, userType1, password1);
                    CustomerDataList.add(customer1);
                } else {
                    System.out.println("Invalid data format in the file.");
                }
            }

            System.out.println("User data read from file into arraylist successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e);
        }   
    }

    @Override
    public void writeToFile()
    {
        

       try (FileWriter writer = new FileWriter ("adminData.txt"))
       {
           //looping through the  arraylist 
        for (Customer customer1 : CustomerDataList) 
        {
            //writing its contents on a file
            writer.write(customer1.customerUserName+" "+customer1.customerUserType+" "+customer1.getCustomerPassword()+"\n");

        }
        System.out.println("User data saved to file successfully.");
    } catch (IOException e)
    {
       System.out.println(e);
    }
    }

    @Override
    public void signUp() 
    {
        
        Scanner userInput3 = new Scanner(System.in);

        while (true) {
            System.out.println("Enter user name:");
            customerUserName = userInput3.next();

            if (checkUserName(customerUserName)) {
                System.out.println("Already registered user name, try another one");
            } else {
                break; // Exit the loop if the user name is not already registered
            }
        }

        System.out.println("Enter user type:");
        customerUserType = userInput3.next();

        System.out.println("Enter password:");
        setCustomerPassword(userInput3.next());

        System.out.println("Confirm password: ");
        setCustomerConfirmPass(userInput3.next());

        if (getCustomerConfirmPass().equals(getCustomerPassword())) {
            Customer currentCustomer = new Customer(customerUserName, customerUserType, getCustomerPassword());
            CustomerDataList.add(currentCustomer);
            System.out.println("Registered successfully!");
        } else 
        {
            System.out.println("Confirmation doesn't match password, try again ");
            signUp();
        }
    }

    @Override
    public boolean logIn()
    {
        
        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Enter user name: ");
        this.customerUserName = userInput2.next(); 
        System.out.println("Enter user type: ");
        this.customerUserType = userInput2.next();  
        System.out.println("Enter password: ");
        setCustomerPassword(userInput2.next()); 
        return checkUserData(this.customerUserName, this.customerUserType, getCustomerPassword());

    }

    @Override
    public boolean checkUserData(String userName, String userType, String password)
    {
        for (Customer c1 : CustomerDataList) 
        {
           if (c1.customerUserName.equals(userName) && c1.customerUserType.equals(userType) && c1.getCustomerPassword().equals(password)) 
           {
               return true;
            }
        }
       return false;

    }

    @Override
    public boolean checkUserName(String userName) 
    {
        for (Customer c1 : CustomerDataList) 
        {
           if( c1.customerUserName.equals(userName))
           return true;
        }
        return false;
    }
   
    
}
