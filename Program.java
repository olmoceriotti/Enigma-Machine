public class Program{
  public static void main(String[] args) {
    boolean exit = false;
    int [][] plugboard = new int[26][26];
    char [][] rotors = new char[3][26];
    int [] rotNumber = new int[3];
    int [] rotPosition = new int[3];
    while (!exit) {
      switch (Methods.menu()) {
        case 1:
          Rotors.modifier(rotors, rotNumber, rotPosition);
        break;
        case 2:
          Plugboard.modifier(plugboard);
        break;
        case 3:
        break;
        case 4:
        break;
        case 0:
          System.out.println("Processing...");
          exit = true;
        break;
      }
      System.out.println("Program exited");
    }
  }
}
