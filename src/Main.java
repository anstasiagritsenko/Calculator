import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operators = {"+", "-", "*", "/"};
        String[] regexOperators = {"\\+", "-", "\\*", "/"};
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        int operatorCount = 0;
        for (String operator : operators) {
            while (expression.contains(operator)) {
                operatorCount++;
                expression = expression.replaceFirst(operator, "");
            }
        }
        if (operatorCount > 1) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        int expressionIndex = -1;

        for (int i = 0; i <= expression.length(); i++) {
            if (expression.contains(operators[i])) {
                expressionIndex = i;
                break;
            }
        }

        if (expressionIndex == -1) {
            throw new IllegalArgumentException("Некорректное выражение");
        }
        String[] numbers = expression.split(regexOperators[expressionIndex]);
        if (numbers.length > 2) {
            throw new IllegalArgumentException("Некорректное выражение");
        }
        int a, b;
        a = Integer.parseInt(numbers[0]);
        b = Integer.parseInt(numbers[1]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Некорректное выражение");
        }
        if (expressionIndex == 0) {
            System.out.println(a + b);
        }
        if (expressionIndex == 1) {
            System.out.println(a - b);
        }
        if (expressionIndex == 2) {
            System.out.println(a * b);
        }
        if (expressionIndex == 3) {
            System.out.println(a / b);
        }
    }
}
