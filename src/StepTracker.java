import java.util.Scanner;

class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    int goalOfSteps=10000;

    Converter converter= new Converter();

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
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = monthData.days[day - 1] + steps;
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
    // пришлось переделать вызов статистики из-за создания файла с массивом дней
    public void printStatistics(Scanner scanner) {
        System.out.println("Введите месяц от 1 до 12:");
        int month = scanner.nextInt();
       if (month < 1 ||month > 12) {
            System.out.println("Ошибка, повтори ввод:");
            return;
        }
        System.out.println();
        monthToData[month - 1].printDaysAndStepsFromMonth();
        System.out.println("Статистика за " + month + " месяц.");
        System.out.println();
        monthToData[month-1].sumStepsFromMonth();
        System.out.println();
        monthToData[month-1].maxSteps();
        System.out.println("Среднее количество шагов составило: " + monthToData[month - 1].sumStepsFromMonth() / monthToData[month - 1].days.length);
        monthToData[month-1].bestSeries(goalOfSteps); //выводит сколько дней ты выполнял цель
        System.out.println();
        converter.convertStepsToKilocalories(monthToData[month-1].sumStepsFromMonth());
        converter.convertToKm(monthToData[month-1].sumStepsFromMonth());
    }
}