import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("TestData.txt");
        file.write("2");
        file.write("\n");
        file.write("3");
        file.close();
        }
       /* File file = new File("TestData.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }*/
}





