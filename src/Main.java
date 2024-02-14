import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operators = {"+", "-", "*", "/"};
        String[] regexOperators = {"\\+", "-", "\\*", "/"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение:");
        String expression = scanner.nextLine();

        int expressionIndex = -1;
        for (int i = 0; i <= expression.length(); i++) {
            if (expression.contains(operators[i])) {
                expressionIndex = i;
                break;
            }
        }
        if (expressionIndex == -1) {
            System.out.println("Некоррекное выражение");
            return;
        }
        String[] numbers = expression.split(regexOperators[expressionIndex]);
        int a, b;
        a = Integer.parseInt(numbers[0]);
        b = Integer.parseInt(numbers[1]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            System.out.println("Некоррекное выражение");
            return;
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