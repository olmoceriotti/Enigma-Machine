import java.util.Scanner;
public class Rotors{
  public static char[][] init(){
    String[] rotorsInit = {"EKMFLGDQVZNTOWYHXUSPAIBRCJ", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "BDFHJLCPRTXVZNYEIWGAKMUSQO", "ESOVPZJAYQUIRHXLNFTGKDCMWB", "VZBRGITYUPSDNHLXAWMJQOFECK"};
    char[][] rotors = new char[5][26];
    for (int a = 0; a < rotors.length; a++) {
      for(int j = 0; j < rotors[0].length; j++){
        rotors[a][j] = rotorsInit[a].charAt(j);
      }
    }
    return rotors;
  }

  public static void modifier(char [][] chosenRotors, int [] rotNumber, int [] rotPosition){
    Scanner input = new Scanner(System.in);
    char[][] rotors = init();
    boolean exit = false, selected = false;
    int rotNum;
    while(!exit){
      switch (menu()) {
        case 1:
          for (int i = 0; i< 3; i++) {
            System.out.println("Insert wanted rotor");
            do {
              rotNum = input.nextInt() - 1;
              if (rotNum < 0 || rotNum > 4) {
                System.out.println("Insert a valid rotor number");
              }
            } while (rotNum < 0 || rotNum > 4);
            rotNumber[i] = rotNum;
            chosenRotors[i] = rotors[rotNum];
          }
          selected = true;
        break;
        case 2:
        break;
        case 3:
          if (selected) {
            print(chosenRotors);
          }else{
            System.out.println("Select rotors first");
          }
        break;
        case 0:
          System.out.println("Exiting menu...");
          exit = true;
        break;
      }
    }
  }

  public static void print(char[][] chosenRotors){
    for (int i = 0; i < chosenRotors.length; i++) {
      System.out.print("Rotor number " + i + ": ");
      for (int j = 0; j < chosenRotors[0].length; j++) {
        System.out.print(chosenRotors[i][j]);
      }
      System.out.println();
    }
  }

  public static int menu(){
    Scanner input = new Scanner(System.in);
    System.out.println("Choose the operation");
    System.out.println("1) Choose the rotors");
    System.out.println("2) Choose rotors position");
    System.out.println("3) Print chosen rotors");
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
