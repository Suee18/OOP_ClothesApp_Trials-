
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.trials;
import java.util.Scanner;

/**
 *
 * @author sue
 */


public class ProjectTrials 
{

    
    void  AdminMainMenu (Admin LoggedInAdmin)
    {
        Scanner AInput = new Scanner(System.in);
        int Achoice;
        do
        {
        System.out.println("""
                           Chose a number:
                           -Managing user-
                           (1)Add user
                           (2)Remove user
                           (3)searchfor user
                           (4)edit exisiting user
                           -Managing Products-
                           (5)Add product
                           (6)Remove product
                           (7)search for product
                           (8)edit exisiting product
                            Press ZERO to terminate.
                           """);
         Achoice=AInput.nextInt();
        
            //Admin adds user
            switch (Achoice) 
            {
                case 1 -> LoggedInAdmin.addUser();
                case 2 -> LoggedInAdmin.removeUser();
                case 3 -> LoggedInAdmin.searchUser();
                case 4 -> LoggedInAdmin.editUser();
                case 5 -> LoggedInAdmin.addProducts();
                case 6 -> LoggedInAdmin.removeProducts();
                case 7 -> LoggedInAdmin.searchProducts();
                case 8 -> LoggedInAdmin.editProducts();
                default -> System.out.println("Invalid input, try again"); 
                
            }

        } while (Achoice!=0);
        
         System.out.println("Terminating program");
    }


//    void CashierMainMenu (Cashier LoggedInCashier)
//    {
//        System.out.println("Enter a choice:");
//        
//    }

    
    
    /**
     *
     * @param args
     */
    
    
    public static void main(String[] args) 
    {
                   int count=0;
                   int choice1, choice2;

        //Files creation and objects intialization
         ProjectTrials trial= new ProjectTrials();

           Admin adminObj = new Admin();
           adminObj.createFile();
           adminObj.readFromFile();  

            Cashier cashierObj = new Cashier();
            cashierObj.createFile();
            cashierObj.readFromFile();

        
           Products productsObj = new Products();
           productsObj.createProductFile();
           productsObj.readFromProductFile();

       
           Customer customerObj = new Customer();
           customerObj.createFile();
           customerObj.readFromFile();

         
         
        //Detecting user type
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose a number\n (1)Admin \n(2)Cashier\n(3)Customer\n");
        choice1= userInput.nextInt();
        
        
        
            //ADMIN
         if (choice1 == 1)
         {
        System.out.println("(1)Sign up\t(2)log in");
        choice2 = userInput.nextInt();
        do {
            if (choice2 == 1) {
                adminObj.signUp();
                System.out.println("Now, Log in");
                if (adminObj.logIn()) {
                    System.out.println("Logged in successfully\nMain menu");
                    trial.AdminMainMenu(adminObj);
                    adminObj.writeToFile();
                    break;
                } else {
                    count++;
                    System.out.println("Wrong credentials. Try again");
                }
            } else if (choice2 == 2)
            {
                if (adminObj.logIn()) 
                {
                    System.out.println("Logged in successfully\nMain menu");
                    trial.AdminMainMenu(adminObj);
                    adminObj.writeToFile();
                    break;
                } else {
                    count++;
                    System.out.println("Wrong credentials. Try again");
                }
            }

            if (count >= 5) {
                System.out.println("Exceeded number of login trials");
                break;
            }

            System.out.println("(1)Sign up\t(2)log in");
            choice2 = userInput.nextInt();

        } while (true);
    }        


        
        // CASHIER
        if (choice1 == 2) 
        {
            System.out.println("(1)Sign up\t(2)log in");
            choice2 = userInput.nextInt();

            do 
            {
                if (choice2 == 1) 
                {
                    cashierObj.signUp();
                    System.out.println("Now, Log in");

                    if (cashierObj.logIn()) 
                    {
                        System.out.println("Logged in successfully\nMain menu");
                        // CASHIER MAIN MENU:  trial.CashierMainMenu(cashierObj);
                        break;
                    } else 
                    {
                        count++;
                     System.out.println("Wrong credentials. Try again");

                    }

                } else if (choice2 == 2) {
                    if (cashierObj.logIn()) {
                        System.out.println("Logged in successfully\nMain menu");
                        // trial.AdminMainMenu(adminObj);
                        break;
                    } else {
                        count++;
                        System.out.println("Wrong credentials. Try again");
                    }
                }

                if (count >= 5) {
                    System.out.println("Exceeded number of login trials");
                    break;
                }

                System.out.println("(1)Sign up\t(2)log in");
                choice2 = userInput.nextInt();

            } while (true);
        }

        
        
                // CUSTOMER
        if (choice1 == 3) 
        {
            System.out.println("(1)Sign up\t(2)log in");
            choice2 = userInput.nextInt();

            do {
                if (choice2 == 1) 
                {
                    customerObj.signUp();
                    System.out.println("Now, Log in");

                    if (customerObj.logIn()) {
                        System.out.println("Logged in successfully\nMain menu");

                        // Customer MAIN MENU
                        break;
                    } else {
                        count++;
                    }

                } else if (choice2 == 2) 
                {
                    customerObj.logIn();
                    if (customerObj.logIn())
                    {
                        System.out.println("Logged in successfully\nMain menu");
                        // Customer MAIN MENU 
                        //waiting for customer class to be implemented
                        break;
                    } else 
                    {
                        count++;
                        System.out.println("Wrong credentials. Try again");
                    }
                }

                if (count >= 5) 
                {
                    System.out.println("Exceeded number of login trials");
                    break;
                }

                System.out.println("(1)Sign up\t(2)log in");
                choice2 = userInput.nextInt();

            } while (true);
        }


    }
    //DO NOT FORGET TO WRITE TO FILE  
}
