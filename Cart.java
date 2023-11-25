package project.trials;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cart {
    public String customerName;
    public String cashierName;
    public String userID;
    public String cashierID;
    public String items;
    public String CartFilePath = "Cart.txt" ;
    public ArrayList<Cart> CartList;
    // Default constructor
    public Cart() {
        // Initialization of variables or any other setup can be done here
    }

    // Parameterized constructor
    public Cart(String customerName, String cashierName, String userID, String cashierID, String items) {
        this.customerName = customerName;
        this.cashierName = cashierName;
        this.userID = userID;
        this.cashierID = cashierID;
        this.items = items;
    }
public void createCartFile() {
        
           try
           {
             File CartFile=new File (CartFilePath);
             if(CartFile.createNewFile())
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
    
 
    public void readCartFromFile() 
    {

         try (BufferedReader reader = new BufferedReader(new FileReader(CartFilePath)))
         {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 5) {
                    
                    String customerName1 = parts[0];
                    String cashierName1=parts[1];
                    String userID1=parts[2];
                    String cashierID1=parts[3];
                    String items1=parts[4];                                        
                    // Create a new User object and add it to  userDataList(arraylist)
                    Cart Cart1 = new Cart(customerName1,cashierName1, userID1,  cashierID1,  items1);
                    CartList.add(Cart1);
                } else {
                    System.out.println("Invalid data format in the file.");
                }
            }

            System.out.println("User data read from file into arraylist successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e);
        } 
    }

    
    public void writeCartintoFile() {

       try (FileWriter writer = new FileWriter (CartFilePath))
       {
           //looping through the  arraylist 
        for (Cart c1: CartList) 
        {
            //writing its contents on a file
            writer.write(c1.customerName+" "+c1.cashierName+" "+c1.userID+" "+c1.cashierID +" "+c1.items+"\n");

        }
        System.out.println("User data saved to file successfully.");
    } catch (IOException e)
    {
       System.out.println(e);
    
            }
    }
}
