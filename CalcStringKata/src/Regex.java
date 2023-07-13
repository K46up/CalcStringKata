import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static String foundSymbol (String input) {

        String sign = "\" [+-/*] ";

        // компилируем регулярное выражение
        Pattern patternSign = Pattern.compile(sign);

        // создаем Matcher объект для поиска соответствий
        Matcher matcherSign = patternSign.matcher(input);

        // ищем первое соответствие и присваиваем символ в отдельную строку
        String foundSymbol = "";

        if (matcherSign.find()) {
            foundSymbol = matcherSign.group();
        }

        return foundSymbol;
    }

    public static String arithmeticSign (String input) {

        String arithmeticSign = "\"";
        Pattern patternArithmeticSign = Pattern.compile(arithmeticSign);
        Matcher matcherArithmeticSign = patternArithmeticSign.matcher(input);
        String foundSymbolArithmeticSign = "";

        if (matcherArithmeticSign.find()) {
            foundSymbolArithmeticSign = matcherArithmeticSign.group();
        }

        return foundSymbolArithmeticSign;
    }
}
