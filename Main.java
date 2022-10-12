import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public String input;
    public InputStreamReader readerStream;

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the email ID to look up the person");
        Main demo = new Main();
        demo.run();
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        scanner.close();
        try {
            URL page = new URL("https://www.southampton.ac.uk/people/"+input);
            readerStream = new InputStreamReader(page.openStream());
            BufferedReader reader = new BufferedReader(readerStream);
            String line;
            while ((line = reader.readLine()) != null){
                if (line.contains("og:title")){
                    String name = line.substring(35,line.indexOf(">")-3);
                    System.out.println("That person is "+name);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}