import JavaApplication3.User;
import java.io.*;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mo
 */
public class Admin extends User{
    Scanner input=new Scanner(System.in);

    public Admin() {
        // Constructor
    }
public void createProductFile(String filename) {
        File productFile = new File(filename);

        if (productFile.exists()) {
            System.out.println("File already exists for products.");
        } else {
            try {
                if (productFile.createNewFile()) {
                    System.out.println("Product file created successfully!");
                } else {
                    System.out.println("File creation failed.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
    // Methods for managing products
    public void addProduct() {
        // Add code to add a product to the file
    }

    public void editProduct() {
        // Add code to edit a product in the file
    }

    public void removeProduct() {
        // Add code to remove a product from the file
    }
//return product details
    public void searchProduct() {
        // Add code to search for a product in the file
    }



      public boolean editUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the username");
        String searchUsername=input.next();
        System.out.println("enter the user type");
        String searchUserType=input.next();
        System.out.println("enter the new username");
        String newUsername=input.next();
        System.out.println("enter the new user type");
        String newUserType=input.next();
        System.out.println("enter the new password");
        String newPassword=input.next();

        for (User user : userDataList) 
        {
        
        if (user.userName.equals(searchUsername) && user.getUserType().equals(searchUserType)) {
             user.userName = newUsername;
            user.userType = newUserType;
            user.setpassword(newPassword);
            return true; // Return true to indicate successful edit
        }
    }
    return false; // Return false if user not found
}


  public boolean removeUser() {
      Scanner input2 = new Scanner(System.in);
      System.out.println("enter the username");
      String removeUsername=input2.next();
      System.out.println("enter the user type");
      String removeUserType=input2.next();
      
    for (int i = 0; i < userDataList.size(); i++) {
        User user = userDataList.get(i);
        if (user.getUserName().equals(removeUsername) && user.getUserType().equals(removeUserType)) 
        {
            userDataList.remove(i); // Remove the user
            return true; // Return successful removal
        }
    }
    return false; // Return false if user not found
}


    public User searchUser()
    {
        Scanner input3 = new Scanner(System.in);
        System.out.println("enter the username");
        String searchUsername=input3.next();
        System.out.println("enter the user type");
        String searchUserType=input3.next();
    for (User user : userDataList)
    {
        if (user.getUserName().equals(searchUsername) && user.getUserType().equals(searchUserType))
        {
            return user; // Return the user if found
        }
    }
    return null; // Return null if not found
}

}
