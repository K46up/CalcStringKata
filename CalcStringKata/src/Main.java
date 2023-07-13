import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        while (true){
            String input = scanner.nextLine();
            String result = Calculator.calc(input); // присваиваем строке возвращенную строку из метода калк в классе мейн
            System.out.println(result);
        }
    }
}
