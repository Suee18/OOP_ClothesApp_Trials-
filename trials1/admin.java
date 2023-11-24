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
   public void addProducts() {
        Scanner input10=new Scanner(System.in);
        System.out.println("enter the product name");
        String pname=input10.next();
        System.out.println("enter the product id");
        String pid=input10.next();
        product a=new product(pname,pid);
        a.addProduct(a);//adding the new product obj to the list
        System.out.println("product added succesfully");
    }

    public void editProducts() {
        Scanner input11=new Scanner(System.in);
        System.out.println("enter the product name");
        String pname=input11.next();
        System.out.println("enter the product id");
        String pid=input11.next();
        //creating a new list and add the original list to it to be accesible
        ArrayList<product> productsnewlist = product.getProductsDataList(); 
        for(product a:productsnewlist){
        if(a.productName.equals(pname)&&a.PID.equals(pid)){
        a.productName=pname;
        a.PID=pid;
        //setting the new list 
        product.setproductlist(productsnewlist);
            System.out.println("product edited succesfully");
            return;
        }
        }
        System.out.println("cant find the product");
        return;
    }

   public void removeProducts() {
        Scanner input13=new Scanner(System.in);
        ArrayList<product> productsnewlist = product.getProductsDataList(); 
        System.out.println("1)search by name    2)search by id");
        short num=input13.nextShort();
        if(num==1){
        System.out.println("enter the product name");
        String pname=input13.next();
        for(product a:productsnewlist){
        if(a.productName.equals(pname)){
            System.out.println("product name:"+a.productName);
            System.out.println("product id:"+a.PID);
            productsnewlist.remove(a);
            product.setproductlist(productsnewlist);
            System.out.println("product removed succesfully");
            return;
        }
        }
        }
        else if(num==2){
            System.out.println("enter the product id");
            String pid=input13.next();
        for(product a:productsnewlist){
        if(a.PID.equals(pid)){
            System.out.println("product name:"+a.productName);
            System.out.println("product id:"+a.PID);
            return;
        }
        }
            
        }
        System.out.println("cant find the product");
        return;
    }
//return product details
    public void searchProducts() {
        Scanner input12=new Scanner(System.in);
        ArrayList<product> productsnewlist = product.getProductsDataList(); 
        System.out.println("1)search by name    2)search by id");
        short num=input12.nextShort();
        if(num==1){
        System.out.println("enter the product name");
        String pname=input12.next();
        for(product a:productsnewlist){
        if(a.productName.equals(pname)){
            System.out.println("product name:"+a.productName);
            System.out.println("product id:"+a.PID);
            return;
        }
        }
        }
        else if(num==2){
            System.out.println("enter the product id");
            String pid=input12.next();
        for(product a:productsnewlist){
        if(a.PID.equals(pid)){
            System.out.println("product name:"+a.productName);
            System.out.println("product id:"+a.PID);
            return;
        }
        }
            
        }
        System.out.println("cant find the product");
        return;
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
        if(searchUserType.equalsIgnoreCase("Admin")){
        for(Admin admin:adminDataList){
        if (this.userName.equalsIgnoreCase(searchUsername)) {
            this.userName=newUsername;
            this.userType=newUserType;
            this.setPassword(newPassword);
            this.setConfirmPass(newPassword);
            return true; // Return true to indicate successful edit
        }
        }
        }
//        else if(searchUserType.equalsIgnoreCase("cashier")){
//        for(Cashier a:Cashierdatalist){
//        if (this.userName.equalsIgnoreCase(searchUsername)) {
//            this.userName=newUsername;
//            this.userType=newUserType;
//            return true; // Return true to indicate successful edit
//        }
//        else if(searchUserType.equalsIgnoreCase("customer")){
//        for(Customer a:CustomerdataList){
//        if (this.userName.equalsIgnoreCase(searchUsername)) {
//            this.userName=newUsername;
//            this.userType=newUserType;
//            return true; // Return true to indicate successful edit
//        }
        
        return false; // Return false if user not found
    }


 public boolean removeUser() {
      Scanner input2 = new Scanner(System.in);
      System.out.println("enter the username");
      String removeUsername=input2.next();
      System.out.println("enter the user type");
      String removeUserType=input2.next();
      //remove admin
      if(removeUserType.equalsIgnoreCase("Admin")){
      for(Admin a:adminDataList){
      if(removeUsername.equalsIgnoreCase(removeUsername)){
      adminDataList.remove(a);
      return true;//user removed
      }
      }
      }
    //remove cashier
    //remove customer
    return false; // Return false if user not found
}


   public Admin searchUser()
    {
        Scanner input3 = new Scanner(System.in);
        System.out.println("enter the username");
        String searchUsername=input3.next();
        System.out.println("enter the user type");
        String searchUserType=input3.next();
        //if admin
        if(searchUserType.equalsIgnoreCase("Admin")){
    for (Admin a :adminDataList )
    {
        if (a.getUserName().equalsIgnoreCase(searchUsername))
        {
            return a; // Return object user if found
        }
    }
        }
        //if cashier
        //if customer
    return null; // Return 0 if not found
}

   void addUser() {
        Scanner input7=new Scanner(System.in);
        System.out.println("enter the username:");
        String username=input7.next();
        
        System.out.println("enter the user type");
        String usertype=input7.next();
       
        System.out.println("enter the user password");
        String password=input7.next();
        if(usertype.equalsIgnoreCase("Admin")){
            Admin a=new Admin(username,usertype,password);
            adminDataList.add(a);
        }
        //else if cashier
        //else if customer
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
 
     
         @Override
    public String getUserName() {
        return this.userName;
    }
    @Override
    public String getUserType() {
        return this.adminUserType;
    }
    @Override
    public void setPassword(String Password) {
        this.adminPassword=Password;
    }
    @Override
    public String getPassword() {
       return this.adminPassword;
    }
    @Override
    public void setconfirmPass(String confirmPass) {
        this.confirmPass= confirmPass;
    }
    @Override
    public String getconfirmPass() {
       return this.confirmPass;
    }
    
      
      
      
}

