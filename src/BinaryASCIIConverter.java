import java.util.Scanner;

public class BinaryASCIIConverter {

    private static Scanner sc = new Scanner(System.in);
    private static boolean run = true;

    public static void run(){
        while (run){
            System.out.println(
                    """
                    1. Text to binary
                    2. Binary to text
                    3. Quit
                    Enter Choice:\s
                    """
            );
            int choice = sc.nextInt();
            sc.nextLine(); // Buffer

            if (choice == 1){
                textToBinary();
            }
            else if(choice ==2){
                binaryToText();
            }
            else if(choice == 3){
                run = false;
            }
        }

    }

    private static void binaryToText() {
        System.out.println("Enter binary: ");
        String binary = sc.nextLine();
        String wholeText = "";

        for (int i = 0; i < binary.length(); i+= 9){
            int num = 128;
            int chara = 0;
            for (int j=0; j<8; j++){
                if (binary.charAt(j+i) == '1'){
                    chara += num;
                }
                num /= 2;
            }
            wholeText += (char)chara;
        }
        System.out.println(wholeText);

    }

    private static void textToBinary() {
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        String wholeBinary = "";

        for (int i = 0; i<text.length(); i++) {
            int ascii = text.charAt(i);
            String binary = "";

            int num = 128;
            for (int j = 0; j < 8; j++) {
                if (ascii >= num) {
                    ascii -= num;
                    binary += "1";
                }
                else {
                    binary += "0";
                }
                num /= 2;
            }
            wholeBinary += binary + " ";
        }
        System.out.println(wholeBinary);
    }
}
