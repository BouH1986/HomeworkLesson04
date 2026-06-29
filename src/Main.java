import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        while (true) {
            // Выводим информацию о возможных операциях пользователю

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;
                    case 2:
                        // действия при выборе второй операции
                        //...
                        break;
                    case 3:
                        // действия при выборе третьей операции
                        //...
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }
                //...
            }
        }
        System.out.println("Программа завершена!");

    }
}
