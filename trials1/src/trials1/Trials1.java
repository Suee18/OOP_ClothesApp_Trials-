/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trials1;
import java.util.Scanner;


public class Trials1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        User user1 = new User();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter choice (1)sign up(2)Log in: ");
        int x = userInput.nextInt();
        if (x==1){
        user1.signUp();
        
        }
        else if (x==2){
        user1.logIn();
        }    }
    
}
