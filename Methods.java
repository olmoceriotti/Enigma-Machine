import java.util.Scanner;
public class Methods{

  public static int menu(){
    Scanner input = new Scanner(System.in);
    int choice;
    System.out.println("Insert number of choosen operation");
    System.out.println("1) Set up rotors");
    System.out.println("2) Set up plugboard");
    System.out.println("3) Decrypt message");
    System.out.println("4) Crypt message");
    System.out.println("0) Exit the program");
    do {
      choice = input.nextInt();
      if (choice < 0 || choice > 4) {
        System.out.println("Operation not available");
      }
    } while (choice < 0 || choice > 4);
    return choice;
  }
}
