import java.util.Scanner;
public class Plugboard{
  public static void modifier(int[][] plugboard){
    Scanner input = new Scanner(System.in);
    boolean finish = false;
    char letterOne, letterTwo;
    int letterOnePos, letterTwoPos;
    while (!finish) {
      switch (menu()) {
        case 1:
          boolean alreadyCon = false;
          do {
            System.out.println("Insert the first letter to connect");
            letterOne = input.nextLine().charAt(0);
            System.out.println("Insert the second letter to connect");
            letterTwo = input.nextLine().charAt(0);
            if (letterOne < 'A' || letterOne > 'Z' || letterTwo < 'A' || letterTwo > 'Z' || letterOne == letterTwo) {
              System.out.println("Insert only valid different uppercase letters");
            }
          } while (letterOne < 'A' || letterOne > 'Z' || letterTwo < 'A' || letterTwo > 'Z' || letterOne == letterTwo);
          letterOnePos = letterOne - 65;
          letterTwoPos = letterTwo - 65;
          for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
              if (plugboard[letterOnePos][i] == 1 || plugboard[i][letterOnePos] == 1) {
                alreadyCon = true;
              }
              if (plugboard[letterTwoPos][i] == 1 || plugboard[i][letterTwoPos] == 1) {
                alreadyCon = true;
              }
            }
          }
          if (!alreadyCon) {
            plugboard[letterOnePos][letterTwoPos] = 1;
            plugboard[letterTwoPos][letterOnePos] = 1;
          }else{
            System.out.println("Letters already connected");
          }

        break;
        case 2:
        do {
          System.out.println("Insert the first letter to disconnect");
          letterOne = input.nextLine().charAt(0);
          System.out.println("Insert the second letter to disconnect");
          letterTwo = input.nextLine().charAt(0);
          if (letterOne < 'A' || letterOne > 'Z' || letterTwo < 'A' || letterTwo > 'Z' || letterOne == letterTwo) {
            System.out.println("Insert only valid different uppercase letters");
          }
        } while (letterOne < 'A' || letterOne > 'Z' || letterTwo < 'A' || letterTwo > 'Z' || letterOne == letterTwo);
        letterOnePos = letterOne - 65;
        letterTwoPos = letterTwo - 65;
        if (plugboard[letterOnePos][letterTwoPos] != 1) {
          System.out.println("Letters already disconnected");
        }else{
          plugboard[letterOnePos][letterTwoPos] = 0;
          plugboard[letterTwoPos][letterOnePos] = 0;
        }
        break;
        case 3:
          print(plugboard);
        break;
        case 0:
          System.out.println("Exiting menu...");
          finish = true;
        break;
      }
    }
  }

  public static void print(int[][] plugboard){
    char a = 'A';
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

  public static int menu(){
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
