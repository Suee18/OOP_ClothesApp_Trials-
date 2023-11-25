
package project;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Adoumy 
 */
public class Cashier extends User
{
    public String cashierUserName;
    public String CashierUserType;
    public String CartFilePath = "Cart.txt" ;
    private String CashierPassword;   
    private String CashierConfirmPassword;

    public ArrayList <product> cartProducts; //retrieve from Class product
    public ArrayList<Cashier> CashiersDataList; // Add cashiers should be in class admin 
    public ArrayList<Cart> UserCart; 
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

       try (FileWriter writer = new FileWriter ("adminData.txt"))
       {
           //looping through the  arraylist 
        for (Cashier c: CashiersDataList) 
        {
            //writing its contents on a file
            writer.write(c.cashierUserName+" "+c.CashierUserType+" "+c.getCashierPassword()+"\n");

        }
        System.out.println("User data saved to file successfully.");
    } catch (IOException e)
    {
       System.out.println(e);
    
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
 //@Override
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
public void createCart() {
         try
           {
             File CartDataFile=new File (CartFilePath);
             if(CartDataFile.createNewFile())
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

   
   public ArrayList<product> AllProducts=product.getProductsDataList() ;
    public void addProductToCart( String ProductName) { 
          for(product p1 : AllProducts){
             if(p1.productName.equals(ProductName)){
                 cartProducts.add(p1);
             }
             else{
             System.out.println("Product Not Found ");
             }
          }
    }

    public void removeProductFromCart(product ProductName) {
         for(product p2:AllProducts){
             if(ProductName.productName.equals(p2.productName)){
                 cartProducts.remove(p2);
             }
             else{
             System.out.println("Product Not Found ");
             }
          }
     
    }
//    public void calculatePayment() {
//        
//        Path cartFilePath = Path.of(userName + "Cart");
//        try {
//            String cartContent = Files.readString(cartFilePath);
//            int totalProducts = cartContent.length();
//            System.out.println("Total products in the cart: " + totalProducts);
//            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void deleteCart() {
         cartProducts.clear();
    }

    public void displayCarts() {
        if (cartProducts == null) {
            cartProducts = new ArrayList<>(); 
        }
        if (cartProducts.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Products in the cart:");
            for (product p : cartProducts) {
                System.out.println("- " + p.productName);
            }
        }
    }    
}
