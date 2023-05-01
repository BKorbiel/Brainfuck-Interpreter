import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        BrainfuckInterpreter BFInterpreter = new BrainfuckInterpreter();
        Scanner input = new Scanner(System.in);
        String sourceCode = "";
        while (input.hasNext()) {
            sourceCode += input.nextLine();
        }
        BFInterpreter.interpretCode(input.next());
    }
}