
package project.trials;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Sue 
 */
public class Cashier extends User
{
    public String cashierUserName;
    public String CashierUserType;
    private String CashierPassword;   
    private String CashierConfirmPassword;

    public ArrayList <Products> cartProducts; //retrieve from Class product
    public ArrayList<Cashier> CashiersDataList; // Add cashiers should be in class admin 
    String cashierFileName="cashierData.txt";

    public String getCashierPassword() {
        return CashierPassword;
    }

    public void setCashierPassword(String CashierPassword) {
        this.CashierPassword = CashierPassword;
    }

    public String getCashierConfirmPassword() {
        return CashierConfirmPassword;
    }

    public void setCashierConfirmPassword(String CashierConfirmPassword) {
        this.CashierConfirmPassword = CashierConfirmPassword;
    }
    
    
    
    
    
    public Cashier(){}
    
    public Cashier(String cashierUserName, String CahierUserType, String pin) {
        this.cashierUserName = cashierUserName;
        this.CashierUserType = CahierUserType;
        CashierPassword=pin;
        this.cartProducts = new ArrayList<>();
    }

    
    @Override
    public void createFile() {
        
           try
           {
             File userDataFile=new File (cashierFileName);
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

         try (BufferedReader reader = new BufferedReader(new FileReader(cashierFileName)))
         {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    String userName1 = parts[0];
                    String userType1 = parts[1];
                    String password1= parts[2];
                      
                    // Create a new User object and add it to  userDataList(arraylist)
                    Cashier cashier1 = new Cashier(userName1, userType1, password1);
                    CashiersDataList.add(cashier1);
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
    public void writeToFile() {
        

         try (BufferedReader reader = new BufferedReader(new FileReader(cashierFileName)))
         {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    String userName1 = parts[0];
                    String userType1 = parts[1];
                    String password1= parts[2];
                      
                    // Create a new User object and add it to  userDataList(arraylist)
                    Cashier currentCashier = new Cashier(userName1, userType1, password1);
                    CashiersDataList.add(currentCashier);
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
public boolean checkUserData(String userName, String userType, String password) {
    for (Cashier  c : CashiersDataList) {
        if (c.cashierUserName.equals(userName) && c.CashierUserType.equals(userType) && c.getCashierPassword().equals(password)) {
            return true;
        }
    }
    return false;
}


//user name repetiotion in the same file 
 @Override
    public boolean checkUserName(String userName)
    {
            for (Cashier  c : CashiersDataList) 
            {
               if( c.cashierUserName.equals(userName))
               return true;
            }
            return false;

    }


@Override
public boolean logIn() {
    Scanner userInput2 = new Scanner(System.in);
    System.out.println("Enter user name: ");
    this.cashierUserName = userInput2.next(); 
    System.out.println("Enter user type: ");
    this.CashierUserType = userInput2.next();  
    System.out.println("Enter password: ");
    setCashierPassword(userInput2.next()); 
        return checkUserData(this.cashierUserName, this.CashierUserType, getCashierPassword());
}


@Override
public void signUp()
    {
        Scanner userInput3 = new Scanner(System.in);

        while (true) {
            System.out.println("Enter user name:");
            cashierUserName = userInput3.next();

            if (checkUserName(cashierUserName)) {
                System.out.println("Already registered user name, try another one");
            } else {
                break; // Exit the loop if the user name is not already registered
            }
        }

        System.out.println("Enter user type:");
        CashierUserType = userInput3.next();

        System.out.println("Enter password:");
        setCashierPassword(userInput3.next());

        System.out.println("Confirm password: ");
        setCashierConfirmPassword(userInput3.next());

        if (getCashierConfirmPassword().equals(getCashierPassword())) {
            Cashier currentCashier = new Cashier(cashierUserName, CashierUserType, getCashierPassword());
            CashiersDataList.add(currentCashier);
            System.out.println("Registered successfully!");
        } else {
            System.out.println("Confirmation doesn't match password, try again ");
            signUp();
        }
    
    
    }
    
    
    
    
    
    
