import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;


class WordCounter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("---------------------------------- Welcome to Word Counter Project by -CodSoft ----------------------------------");
        System.out.println();
        
        System.out.println("1. Enter the text manually");
        System.out.println("2. Read from file");
        System.out.println();
        
        System.out.print("Choose the option from above : ");
        int choose =  sc.nextInt();
        System.out.println();

        String inputText = "";

        switch (choose) {
            case 1:
                System.out.print("Enter the text : ");
                Scanner scanner = new Scanner(System.in);
                inputText = scanner.nextLine();
                break;

            case 2:
                System.out.print("Enter the file path : ");
                Scanner scan = new Scanner(System.in);
                String filepath = scan.nextLine();
                
                try{
                    inputText = readFromFile(filepath);
                } 
                catch(IOException e){
                   System.out.println("Error reading the file: " + e.getMessage() );
                   System.exit(1);
                }
                break;
        
            default:
            System.out.println("Invalid Choose, Please Try again...");
            System.exit(1);
            break;
        }

        int word = wordCount(inputText);
        System.out.println();
        System.out.println("The Total Counting Words are : "+word);
    }

    private static int wordCount(String inputText) {
        String words[] = inputText.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    private static String readFromFile(String filePath) throws IOException{
        StringBuilder content = new StringBuilder();
        try(BufferedReader br= new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine())!=null){
                content.append(line).append("\n");
            }
        }
        return content.toString();

    }
}