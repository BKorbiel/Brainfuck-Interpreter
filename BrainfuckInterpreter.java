import java.util.Scanner;

public class BrainfuckInterpreter {
    public static int DATA_SIZE = 30000;
    private int data_pointer = 0;
    private byte []data;

    public void BrainfuckInterpreter() {
        data = new byte [DATA_SIZE];
        for (int i = 0; i < DATA_SIZE; i++) {
            data[i] = 0;
        }
    }

    public void interpretCode(String source) {
        Scanner input = new Scanner(System.in);
        for (int operation_pointer = 0; operation_pointer < source.length(); operation_pointer++) {
            char operation = source.charAt(operation_pointer);
            switch (operation) {
                case '>':
                    data_pointer++;
                    if (data_pointer >= DATA_SIZE) {
                        data_pointer = DATA_SIZE - 1;
                    }
                    break;
                case '<':
                    data_pointer--;
                    if (data_pointer<0) {
                        data_pointer = 0;
                    }
                    break;
                case '+':
                    data[data_pointer]++;
                    break;
                case '-':
                    data[data_pointer]--;
                    break;
                case '.':
                    System.out.print(data[data_pointer]);
                    break;
                case ',':
                    data[data_pointer] = input.nextByte();
                    break;
                case '[':
                    if (data[data_pointer] == 0) {
                        int position = operation_pointer;
                        int level = 1;
                        while (level > 0) {
                            operation_pointer++;
                            if (operation_pointer >= source.length()) {
                                System.out.print("Error. The matching parenthesis for the parenthesis at position " + position + " cannot be found.");
                                return;
                            }
                            if (source.charAt(operation_pointer) == '[') {
                                level++;
                            } else if (source.charAt(operation_pointer) == ']') {
                                level--;
                            }
                        }
                    }
                    break;
                case ']':
                    if (data[data_pointer] != 0) {
                        int position = operation_pointer;
                        int level = 1;
                        while (level > 0) {
                            operation_pointer--;
                            if (operation_pointer < 0) {
                                System.out.print("Error. The matching parenthesis for the parenthesis at position " + position + " cannot be found.");
                                return;
                            }
                            if (source.charAt(operation_pointer) == ']') {
                                level++;
                            } else if (source.charAt(operation_pointer) == '[') {
                                level--;
                            }
                        }
                    }
                    break;
            }
        }

    }
}
