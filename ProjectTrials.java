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

    /**
     * @param args the command line arguments
     */
//    
//    void AdminMainMenu (  Admin LoggedInAdmin)
//    {
//        Scanner AInput = new Scanner(System.in);
//        //1 add user remaining 
//        System.out.println("""
//                           Chose a number:
//                           Managing user:
//                           (1)Add user
//                           (2)Remove user
//                           (3)searchfor user
//                           (4)edit exisiting user
//                           Managing Products 
//                           (5)Add product
//                           (6)Remove product
//                           (7)searchfor product
//                           (8)edit exisiting product
//                           
//                           """);
//        int Achoice=AInput.nextInt();
//        
//        //Admin adds user 
//        if (Achoice==1)
//        {
//            //LoggedInAdmin.addUser();
//        }
//        //Admin Removes user
//        if (Achoice==2)
//        {
//            LoggedInAdmin.removeUser();
//        }
//        //Admin 
//        if (Achoice==3)
//        {
//            LoggedInAdmin.searchUser();
//        } if (Achoice==4)
//        {
//            LoggedInAdmin.editUser();
//        }
//        if (Achoice==5)
//        {
//   
//        }
//        if (Achoice==6)
//        {
//        }
//        if (Achoice==7)
//        {
//        }
//        if (Achoice==8)
//        {
//        }
//        
//        else System.out.println("Invalid input");
//        //need redirecting here
//    }


//    void CashierMainMenu (Cashier LoggedInCashier)
//    {
//        System.out.println("Enter a choice:");
//        
//    }
    
    
    public static void main(String[] args) 
    {

       // int count=0;
        //Files creation
           Admin adminObj = new Admin();
           adminObj.createFile();
           adminObj.readFromFile();  

        //FRIDAY
        //        Cashier cashierObj = new Cashier();
        //        cashierObj.createFile();
        //        cashierObj.readFromFile();

        //MOE
        //        Products productsObj = new Products();
        //        productsObj.createProductFile();
        //        productsObj.readFromProductFile();

        
        //FRIDAY
        //Customer customerObj = new Customer();
        //customerObj.createFile();
        //customerObj.readFromFile();

        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Choose a number\n (1)sign up as an admin \n(2)Sign up as a cashier\n(3)Sign up as a customer\n (4)Log in:\n ");
        int x;
        x= userInput.nextInt();
                //        String usertypee;       
                //        String FilePath;

        
        
            if (x == 1) 
            {
                // usertypee="admin";                
                // FilePath="adminData.txt";

               
                adminObj.signUp();
                adminObj.writeToFile();
                
                
            } 
            if(x==2)
            {
            }
             

    }
    
    //Shorcuts 
}
