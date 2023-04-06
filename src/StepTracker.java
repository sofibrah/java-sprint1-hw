import java.util.Scanner;
class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    int goalOfSteps=10000;

    public StepTracker() {
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    public void addNewNumberStepsPerDay(Scanner scanner) {
        int day;
        int month;
        int steps;
        while (true) {
            System.out.println("Введи Месяц от 1 до 12");
            int monthNumber = scanner.nextInt();
            if (monthNumber < 1 | monthNumber > 12) {
                System.out.println("Исчисление начинается с 1! Введи месяц от 1 до 12");
            } else {
                month = monthNumber;
                break;
            }
        }
        while (true) {
            System.out.println("Введи день от 1 до 30");
            int dayNumber = scanner.nextInt();
            if (dayNumber < 1 | dayNumber > 30) {
                System.out.println("Исчисление начинается с 1! Введи день от 1 до 30");
            } else {
                day = dayNumber;
                break;
            }
        }
        while (true) {
            System.out.println("Введи количество шагов");
         int stepsNumber = scanner.nextInt();
            if (stepsNumber < 0) {
                System.out.println("Введенная цель должнабыть больше 0!");
            }else {
                steps=stepsNumber;
            break;
            }
        }
        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month-1];
        // Сохранение полученных данных
        monthData.days[day-1] = steps;
    }
    void changeGoal(Scanner scanner) {
        System.out.println("Сейчас твоя цель составляет: " + goalOfSteps);
        System.out.println("Хочешь изменить текущую цель?");
        System.out.println("1.Да");
        System.out.println("2.Нет");
        int command = scanner.nextInt();
        if (command == 1) {
            while (true) {
                System.out.println("Какова новая цель?");
                int goal = scanner.nextInt();
                if (goal < 0) {
                    System.out.println("Ввведенная цель должнабыть положительной!!!");
                } else {
                    goalOfSteps = goal;
                    System.out.println("Поздравляю, твоя новая цель: " + goalOfSteps);
                    break;
                }
            }
        } else if (command == 2) {
            System.out.println("Ты решили не менять цель. Она все еще равна: " + goalOfSteps);
        } else {
            System.out.println(" Такой команды нет ");
        }
    }
    public void printStatistics(Scanner scanner) {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Ошибка ввода. Месяц введен неверно");
            return;
        }
        MonthData monthData = monthToData[month-1];  // Получение соответствующего объекта MonthData из массива
        Converter converter = new Converter();

        System.out.println("Количество шагов по дням: ");
        monthData.printDaysAndStepsFromMonth();
        System.out.println();
       // int sumMonth = monthData.sumStepsFromMonth(); //переменная получения суммы шагов за мес
        //System.out.println("Общее количество шагов за месяц: " + sumMonth);
        System.out.println();
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println();
        System.out.println("Cреднее количество шагов: " + monthData.maxSteps() / monthData.days.length);
        System.out.println();
        converter.convertToKm(monthData.sumStepsFromMonth());
        converter.convertStepsToKilocalories(monthData.sumStepsFromMonth());
        System.out.println();
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalOfSteps));

    }
}