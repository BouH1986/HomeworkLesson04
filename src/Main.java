import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        while (true) {
            // Выводим информацию о возможных операциях пользователю
            System.out.println();
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String moneyStr; //инициализация строки
            int money;       //инициализация числа 
            int operation = Integer.parseInt(input);
                switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    // действия при выборе второй операции
                    System.out.println("Введите сумму расхода:");
                    moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    money = Integer.parseInt(moneyStr);
                    spendings += money;
                    break;
                case 3:
                    // действия при выборе третьей операции
                    int taxes01 = earnings * 6 / 100;
                    int taxes02 = taxEarningsMinusSpendings(earnings, spendings);
                    if (taxes01<taxes02) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит:      " + taxes01 + " рублей");
                        System.out.println("Налог на другой системе: " + taxes02 + " рублей");
                        System.out.println("Экономия:                " + (taxes02 - taxes01) + " рублей");
                    } else if (taxes02<taxes01) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит:      " + taxes02 + " рублей");
                        System.out.println("Налог на другой системе: " + taxes01 + " рублей");
                        System.out.println("Экономия: " + (taxes01 - taxes02) + " рублей");
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                        System.out.println("Ваш налог составит:      " + taxes01 + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
                }
                //...
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }
}
