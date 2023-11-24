/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.trials;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author sue changes:
 * 
 * getters to access Private members  (not the variables directly)
 * 
 */

public class Admin extends User
{
    
    public String adminUserName;
    public String adminUserType;
    private String adminPassword;
    private String confirmPass;
    public  ArrayList<Admin> adminDataList = new ArrayList<>();
    public String adminFileName= "adminData.txt";   
    public String productsFileName= "productsData.txt";

    Admin() 
    {
    }

     public Admin ( String adminUserName,String adminUserType, String adminPassword)
    {
        this.adminUserName=adminUserName;
        this.adminUserType=adminUserType;
        this.adminPassword=adminPassword;
    }
    

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    
   
  
    
    @Override
    public void createFile()
    {
           try
           {
             File userDataFile=new File (adminFileName);
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

         try (BufferedReader reader = new BufferedReader(new FileReader(adminFileName)))
         {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    String userName1 = parts[0];
                    String userType1 = parts[1];
                    String password1= parts[2];
                      
                    // Create a new User object and add it to  userDataList(arraylist)
                    Admin currentAdmin = new Admin(userName1, userType1, password1);
                    adminDataList.add(currentAdmin);
                } else {
                    System.out.println("Invalid data format in the file.");
                }
            }

            System.out.println("User data read from file into arraylist successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e);
        }    }
    
@Override
    public void writeToFile()

    {

       try (FileWriter writer = new FileWriter ("adminData.txt"))
       {
           //looping through the  arraylist 
        for (Admin a : adminDataList) 
        {
            //writing its contents on a file
            writer.write(a.adminUserName+" "+a.adminUserType+" "+a.getAdminPassword()+"\n");

        }
        System.out.println("User data saved to file successfully.");
    } catch (IOException e)
    {
       System.out.println(e);
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

        for (User user : adminDataList) 
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
            return user; // Return object user if found
        }
    }
    return null; // Return 0 if not found
}

    void addUser() 
    {
    }
    
    
    @Override
      public boolean checkUserData(String userName,String userType1,String password)
    {
        
        if ("admin".equals(userType1))
        { for (Admin admin : adminDataList) 
        {
        if (admin.adminUserName.equals(userName) && admin.adminUserType.equals(userType) && admin.getAdminPassword().equals(password)) {
            return true; // User data found in the list
        }
        }
    }
    return false; // User data not found in the list

    }

    @Override
    public boolean logIn() 
 {
    Scanner userInput2 = new Scanner(System.in);
    System.out.println("Enter user name: ");
     adminUserName= userInput2.next();
    System.out.println("Enter user type: ");
     adminUserType = userInput2.next();
    System.out.println("Enter password: ");
    setAdminPassword( userInput2.next());
    return checkUserData(adminUserName,adminUserType,getAdminPassword());
    }    

    @Override
    public void signUp() 
    
        {
     Scanner userInput3 = new Scanner(System.in);
    System.out.println("Enter user name: ");
    String adminUserName1= userInput3.next();
    System.out.println("Enter user type: ");
    String adminUserType1 = userInput3.next();
    System.out.println("Enter password: ");
    setAdminPassword( userInput3.next());
    Admin CurrentAdmin =new Admin(adminUserName1, adminUserType1, getAdminPassword());
    adminDataList.add(CurrentAdmin);

    System.out.println("Registred successfully!");
    
    }
 
     
        
    
      
      
      
}

