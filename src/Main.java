
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                inputSaveSteps(scanner, stepTracker);//переименовала
            } else if (userInput == 2) {
                getStatistic(scanner, stepTracker);
            } else if (userInput == 3) {
                inputStepsAim (scanner, stepTracker);
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов");
        System.out.println("0 - Выход");
    }


    public static void inputSaveSteps(Scanner scanner, StepTracker stepTracker) {
        while (true) {
            System.out.println("За какой месяц Вы хотите ввести сведения: 0-ЯНВ., 1-ФЕВ., 2-МАРТ, 3-АПР., 4-МАЙ, 5-ИЮНЬ, 6-ИЮЛЬ, 7-АВГ., 8-СЕН.,9-ОКТ., 10-НОЯБ., 11-ДЕК.?");
            int numberMonth = scanner.nextInt();
            System.out.println("Введите порядковый номер дня в месяце:");
            int numberDay = scanner.nextInt();
            System.out.println("Введите количество шагов:");
            int amountSteps = scanner.nextInt();
            if (isValidUserInput(numberMonth, numberDay, amountSteps)) {
                stepTracker.saveSteps(numberMonth, numberDay, amountSteps);
                break;
            } else {
                System.out.println("Параметры введены некорректно. Введите новые значения."); //решила проверку оставить здесь и для остальных перенесла в main, чтобы создавался бесконечный цикл, пока не введется корректное значение(без отправки в основное меню) ранее, при некорректном значении в методе changeStepsAim() ,был выброс в основное меню, надеюсь, ты со мной согласишься
            }
        }
    }

    public static boolean isValidUserInput(int numberMonth, int numberDay , int amountSteps) {
        return ((numberMonth >= 0 && numberMonth < 12) && (numberDay > 0 && numberDay < 31) && (amountSteps > 0));
    } //перенесла из StepTracker()

    public static void getStatistic(Scanner scanner, StepTracker stepTracker) {
        while (true) {
            System.out.println("Введите номер месяца:0-ЯНВ., 1-ФЕВ., 2-МАРТ, 3-АПР., 4-МАЙ, 5-ИЮНЬ, 6-ИЮЛЬ, 7-АВГ., 8-СЕН.,9-ОКТ., 10-НОЯБ., 11-ДЕК.");
            int numberMonth = scanner.nextInt();
            if (numberMonth >= 0 && numberMonth < 12) {//введена проверка, если номер месяца введен некорректно
                stepTracker.printStatistic(numberMonth);
                break;
            } else {
                System.out.println("Месяц введен неверно.");
            }
        }
    }

    public static void inputStepsAim (Scanner scanner, StepTracker stepTracker) {
        while (true) {
            System.out.println("Укажите Вашу новую цель:");
                    int newStepsAim = scanner.nextInt();
                        if (newStepsAim < 0){
                System.out.println("Целевое количество шагов не может быть отрицательным!");
            } else {
                System.out.println("Изменения внесены. Ваша новая цель: " + stepTracker.changeStepsAim(newStepsAim) + " шагов");
                break;
            }
        }
}

}










