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

    public void searchProduct() {
        // Add code to search for a product in the file
    }

    // Methods for managing users (overriding signUp method from the User class)
    @Override
    public void signUp() {//as an admin and
        // allow the admin to create users
        super.signUp(); // Call the signUp method from the parent class
    }

    public boolean editUser(String searchUsername, String searchUserType, String newUsername, String newUserType, String newPassword) {
    for (User user : userDataList) {
        if (user.userName.equals(searchUsername) && user.userType.equals(searchUserType)) {
            user.userName = newUsername;
            user.userType = newUserType;
            user.setpassword(newPassword);
            return true; // Return true to indicate successful edit
        }
    }
    return false; // Return false if user not found
}


  public boolean removeUser(String removeUsername, String removeUserType) {
    for (int i = 0; i < userDataList.size(); i++) {
        User user = userDataList.get(i);
        if (user.userName.equals(removeUsername) && user.userType.equals(removeUserType)) {
            userDataList.remove(i); // Remove the user
            return true; // Return successful removal
        }
    }
    return false; // Return false if user not found
}


    public User searchUser(String searchUsername, String searchUserType) {
    for (User user : userDataList) {
        if (user.userName.equals(searchUsername) && user.userType.equals(searchUserType)) {
            return user; // Return the user if found
        }
    }
    return null; // Return null if not found
}
  
    public void loadUserDataFromFile() {
        try (Scanner userDataFileLooper = new Scanner(new File("userData.txt"))) {
            while (userDataFileLooper.hasNextLine()) {
                String line = userDataFileLooper.nextLine();
                String[] userDataArray = line.split(" ");

                if (userDataArray.length == 3) {
                    String storedUsername = userDataArray[0];
                    String storedUserType = userDataArray[1];
                    String storedPassword = userDataArray[2];

                    // Create a User instance and add it to the userDataList
                    User userData = new User(storedUsername, storedUserType, storedPassword);
                    userDataList.add(userData);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't open userData file." + e);
        }
    }
}

}
