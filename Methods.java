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

  /* Plugboard code */
  public static void plugboardMod(int[][] plugboard){
    Scanner input = new Scanner(System.in);
    boolean finish = false;
    char letterOne, letterTwo;
    int letterOnePos, letterTwoPos;
    while (!finish) {
      switch (plugMenu()) {
        case 1:
          do {
            System.out.println("Insert the first letter to connect");
            letterOne = input.nextLine().charAt(0);
            System.out.println("Insert the second letter to connect");
            letterTwo = input.nextLine().charAt(0);
            if (letterOne < 'a' || letterOne > 'z' || letterTwo < 'a' || letterTwo > 'z' || letterOne == letterTwo) {
              System.out.println("Insert only valid different lowercase letters");
            }
          } while (letterOne < 'a' || letterOne > 'z' || letterTwo < 'a' || letterTwo > 'z' || letterOne == letterTwo);
          letterOnePos = letterOne - 97;
          letterTwoPos = letterTwo - 97;
          plugboard[letterOnePos][letterTwoPos] = 1;
          plugboard[letterTwoPos][letterOnePos] = 1;
        break;
        case 2:
        do {
          System.out.println("Insert the first letter to disconnect");
          letterOne = input.nextLine().charAt(0);
          System.out.println("Insert the second letter to disconnect");
          letterTwo = input.nextLine().charAt(0);
          if (letterOne < 'a' || letterOne > 'z' || letterTwo < 'a' || letterTwo > 'z' || letterOne == letterTwo) {
            System.out.println("Insert only valid different lowercase letters");
          }
        } while (letterOne < 'a' || letterOne > 'z' || letterTwo < 'a' || letterTwo > 'z' || letterOne == letterTwo);
        letterOnePos = letterOne - 97;
        letterTwoPos = letterTwo - 97;
        if (plugboard[letterOnePos][letterTwoPos] != 1) {
          System.out.println("Letters already disconnected");
        }else{
          plugboard[letterOnePos][letterTwoPos] = 0;
          plugboard[letterTwoPos][letterOnePos] = 0;
        }
        break;
        case 3:
          printPlug(plugboard);
        break;
        case 0:
          System.out.println("Exiting menu...");
          finish = true;
        break;
      }
    }
  }

  public static void printPlug(int[][] plugboard){
    char a = 'a';
    System.out.print("  ");
    for (int i = 0; i < 26; i++) {
      System.out.print((char) (a + i));
    }
    System.out.println();
    System.out.print("  ");
    for (int i = 0; i < 26; i++) {
      System.out.print('-');
    }
    System.out.println();
    for (int i = 0; i < plugboard.length; i++) {
      System.out.print((char) (a + i));
      System.out.print('|');
      for (int j = 0;j < plugboard[0].length; j++) {
        System.out.print(plugboard[i][j]);
      }
      System.out.println();
    }
  }

  public static int plugMenu(){
    Scanner input = new Scanner(System.in);
    System.out.println("Choose the operation");
    System.out.println("1) Connect letters");
    System.out.println("2) Disconnect letters");
    System.out.println("3) DIplay plugboard");
    System.out.println("0) Exit the menu");
    int choice;
    do {
      choice = input.nextInt();
      if (choice < 0 || choice > 3) {
        System.out.println("Insert a valid operation");
      }
    } while (choice < 0 || choice > 3);
    return choice;
  }

}
