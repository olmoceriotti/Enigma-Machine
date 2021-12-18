public class Program{
  public static void main(String[] args) {
    boolean exit = false;
    int [][] plugboard = new int[26][26];
    while (!exit) {
      switch (Methods.menu()) {
        case 1:
        break;
        case 2:
          Methods.plugboardMod(plugboard);
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
