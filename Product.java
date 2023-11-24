package project.trials;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SUE
 */
public class product{
    public String productName;
public String PID;

    String productsFileName="productsData.txt";
    static public  ArrayList<product> productsDataList = new ArrayList<>();

    

    public product(String pname,String Pid) {
        this.productName=pname;
        this.PID=Pid;
    }
// Method to add a product to the list
    static public void addProduct(product product) {
        productsDataList.add(product);
    }
static public void setproductlist(ArrayList<product> b){
productsDataList=b;
}
    // Method to get the products list
    static public ArrayList<product> getProductsDataList() {
        return productsDataList;
    }
    
     //@Override 
  public void createProductFile() 
{
        File productFile = new File(productsFileName);

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

    //@Override
    public void readFromProductFile() {

 
         try (BufferedReader reader = new BufferedReader(new FileReader(productsFileName)))
         {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 3) {
                    String name = parts[0];
                    String Id = parts[1];
                      
                    // Create a new User object and add it to  userDataList(arraylist)
                    product product = new product(name,Id);
                    productsDataList.add(product);
                } else 
                {
                    System.out.println("Invalid data format in the file.");
                }
            }

            System.out.println("User data read from file into arraylist successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e);
        }    }

    //@Override
    public void writeToProductFile()
    {
        
       try (FileWriter writer = new FileWriter (productName))
       {
           //looping through the  arraylist 
        for (product p : productsDataList) 
        {
            //writing its contents on a file
            writer.write(p.productName+" "+p.PID+"\n");
        }
        System.out.println("User data saved to file successfully.");
    } catch (IOException e)
    {
       System.out.println(e);
    }

    }

}
