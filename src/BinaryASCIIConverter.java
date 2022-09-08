import java.util.Scanner;

public class BinaryASCIIConverter {

    private static Scanner sc = new Scanner(System.in);
    private static boolean run = true;

    public static void run(){
        while (run){
            System.out.println( // showing the user what their options are
                    """
                    1. Text to binary
                    2. Binary to text
                    3. Quit
                    Enter Choice:\s
                    """
            );
            int choice = sc.nextInt();
            sc.nextLine(); // Buffer

            switch (choice) { //checking what the user wants to do
                case 1 -> textToBinary();
                case 2 -> binaryToText();
                case 3 -> run = false;
                default -> System.out.println("Invalid input");
            }
        }

    }

    private static void binaryToText() {
        System.out.println("Enter binary: "); //receiving the binary
        String binary = sc.nextLine();
        String wholeText = "";

        for (int i = 0; i < binary.length(); i+= 9){ //looping through every binary number by increasing by 9 everytime (8bits + a space)
            int num = 128; // reseting to the first value of binary
            int chara = 0;
            for (int j=0; j<8; j++){ //here its looping 8 times for every bit in a binary
                if (binary.charAt(j+i) == '1'){ //checking whether or not it has this value
                    chara += num;
                }
                num /= 2; //going to the next power of 2
            }
            wholeText += (char)chara; //adding the character to the text
        }
        System.out.println(wholeText); //showing the user

    }

    private static void textToBinary() {
        System.out.println("Enter text: "); //recieving the text
        String text = sc.nextLine();
        String wholeBinary = "";

        for (int i = 0; i<text.length(); i++) { //looping through the text
            int ascii = text.charAt(i); //accesing every character
            String binary = "";

            int num = 128; //reseting to the first binary number
            for (int j = 0; j < 8; j++) { // looping 8 time for every but
                if (ascii >= num) { //checking if the value of ascii is bigger than the power of 2
                    ascii -= num; // subtracting that so that I cna move one
                    binary += "1";// adding it to the binary
                }
                else {
                    binary += "0"; //adding a 0 because it isn't part of it
                }
                num /= 2; // going to the next power of 2
            }
            wholeBinary += binary + " ";
        }
        System.out.println(wholeBinary); //showing the user
    }
}
