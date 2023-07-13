import java.io.IOException;

public class Calculator {
    public static String calc (String input) throws IOException {

        int secondInt = 0; // для последующего деления и умножения
        int lengthString;  // присваиваем длину строки в кейсах
        String result;

        String[] words = input.split(" [+-/*] ");

        //проверка на кол-во элементов в массиве
        if ((words.length != 2)) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *)");
        }
        //строки с кавычками
        String strAQuote = words[0];
        String strBQuote = words[1];

        // Удаление кавычек из строк
        String strA = strAQuote.replaceAll("\"", "");
        String strB = strBQuote.replaceAll("\"", "");

        StringBuilder stringBuilderA = new StringBuilder(strA);
        StringBuilder stringBuilderB = new StringBuilder(strB);
        StringBuilder stringBuilderN = new StringBuilder();  // пустая строка для записи перемножения


        //проверка первого элемента на число
        if(strAQuote.matches("\\d+")){
            throw new IOException("Первым аргументом выражения, подаваемого на вход, должна быть строка!!!");
        }

        //проверка на количество символов в строке
        if(stringBuilderA.length() > 10 | stringBuilderA.length() < 1| stringBuilderB.length() > 10 |
                stringBuilderB.length() < 1){
            throw new IOException("Строки должны быть длинной не более 10 символов!!!");
        }

        //проверка второго элемента на число и диапозон <иначе> строка -> число
        if(strBQuote.matches("\\d+") && !strBQuote.matches("^[1-9]$|^10$")){
            throw new IOException("Введенные числа должны быть в диапозоне от 1 до 10 включительно!!!!!!");
        } else if (strBQuote.matches("^[1-9]$|^10$")){
            secondInt = Integer.parseInt(strBQuote);
        }

        String foundSymbol = Regex.foundSymbol(input);
        String foundSymbolArithmeticSign = Regex.arithmeticSign(strBQuote);

        //проверка на неподдерживаемые операции
        if ((foundSymbolArithmeticSign.equals("\"") && (foundSymbol.equals("\" * ") || foundSymbol.equals("\" / ")))
                || (!foundSymbolArithmeticSign.equals("\"") &&
                        (foundSymbol.equals("\" + ") || foundSymbol.equals("\" - ")))) {
            throw new IOException("Калькулятор умеет выполнять операции сложения строк, вычитания строки из строки, " +
                    "умножения строки на число и деления строки на число. Другие виды операций не доступны");
        }

        switch (foundSymbol){
            case "\" + ":
                stringBuilderA.append(stringBuilderB);
                result = stringBuilderA.toString();
                break;
            case "\" - ":
                result = strA.replaceAll(strB, "");
                break;
            case "\" / ":
                lengthString = stringBuilderA.length()/secondInt;
                result = stringBuilderA.substring(0,lengthString);

                break;
            case "\" * ":
                for (int i = 0; i < secondInt; i++) {
                    stringBuilderN.append(stringBuilderA);
                }
                result = stringBuilderN.toString();
                break;
            default:
                throw new IOException("Строка не является математической операцией!!!");
        }

        if(result.length() > 40){
            result = result.substring(0,40) + "...";
        }
        // Добавление кавычек к результату
        return "\"" + result + "\"";
    }
}
