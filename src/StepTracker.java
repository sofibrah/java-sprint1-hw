import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    int[][] monthData = new int[12][30];
    int goalOfSteps = 10000;
    int max = 0;

    Converter converter = new Converter();

    public void saveSteps() {
        int day;
        int month;
        int steps;

        while (true) {
            System.out.println("Введите Месяц от 0 до 11");

            int monthNumber = scanner.nextInt();
            if (monthNumber < 0 | monthNumber > 11) {
                System.out.println("Исчисление начинается с 0! Введите месяц от 0 до 11");
            } else {
                month = monthNumber;
                break;
            }
        }
        while (true) {
            System.out.println("Введите день от 0 до 29");

            int dayNumber = scanner.nextInt();

            if (dayNumber < 0 | dayNumber > 29) {
                System.out.println("Исчисление начинается с 0! Введите день от 0 до 29");
            } else {
                day = dayNumber;
                break;
            }
        }
        while (true) {
            System.out.println("Введите количество шагов");
            int stepsNumber = scanner.nextInt();

            if (stepsNumber < 0) {
                System.out.println("Ввведенная цель должнабыть положительной!!!");
            } else {
                steps = stepsNumber;
                break;
            }
        }
        monthData[month][day] = steps;
    }
    public void monthState() {
        int month = 0;

        while (true) {
            System.out.println("Ведите Месяц");
            int monthNumber = scanner.nextInt();

            if (monthNumber < 0 | monthNumber > 11) {
                System.out.println("Введите месяц от 0 до 11");
            } else {
                for (int i = 0; i <= 29; i++) {
                    System.out.print(i + " День: " + monthData[month][i] + ", ");
                }
                break;
            }
        }
        System.out.println();
        sumOfSteps(month);
        averageSteps(month);
        maxSteps(month);
        bestSequenceFinder(month, goalOfSteps);

        converter.convertStepsToKilocalories(sumOfSteps(month));
        converter.convertToKm(sumOfSteps(month));
        System.out.println();
    }
    public void maxSteps(int month) {
        for (int i = 0; i <= 29; i++) {
            if (monthData[month][i] > max) {
                max = monthData[month][i];
            }
        }
        System.out.println("Наибольшее число шагов за месяц: " + max);
    }
    public void averageSteps(int month) {
        double average = sumOfSteps(month) / 30;
        System.out.println("В среднем вы проходили: " + average);
    }
    public double sumOfSteps(int month) {
        double sum = 0;
        for (int i = 0; i <= 29; i++) {
            sum = sum + monthData[month][i];
        }
        System.out.println("Всего шагов пройдено: " + sum);
        return sum;
    }

    public void bestSequenceFinder(int month, int goalOfSteps) {
        int counter = 0;
        int bestSequence = 0;

        for (int i = 0; i <= 29; i++) {
            if (monthData[month][i] >= goalOfSteps) {
                counter++;
                if (counter > bestSequence) {
                    bestSequence = counter;
                }
            } else {
                counter = 0;
            }
        }
        System.out.println("Лучшая серия составила: " + bestSequence + " дней!!!");
    }
    public void changeGoal() {
        System.out.println("Сейчас ваша цель составляет: " + goalOfSteps);
        System.out.println("Хотите изменить текущую цель?");
        System.out.println("1.Да");
        System.out.println("2.Нет");
        int command = scanner.nextInt();
        if (command == 1) {
            while (true) {
                System.out.println("Какова ваша новая цель?");
                int goal = scanner.nextInt();
                if (goal < 0) {
                    System.out.println("Ввведенная цель должнабыть положительной!!!");
                } else {
                    goalOfSteps = goal;
                    System.out.println("Поздравляю, теперь ваша цель: " + goalOfSteps);
                    break;
                }
            }
        } else if (command == 2) {
            System.out.println("Вы решили не менять цель по шагам. Ваша цель все еще: " + goalOfSteps);
        } else {
            System.out.println(" Такой команды нет ");
        }
    }
}