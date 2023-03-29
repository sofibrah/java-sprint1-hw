import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker= new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command==1){
                stepTracker.saveSteps();
            }else if (command == 2){
                stepTracker.monthState();
            }else if(command == 3){
                stepTracker.changeGoal();
            }else if(command==4){
                System.out.println("Пока!");
                scanner.close(); //нужно разобраться зачем нужна эта команда и что она делает
            return;
            }else {
                System.out.println("Такой команды нет");
            }
        }
    }
    static void printMenu(){
        System.out.println("Добро пожаловать в меню! Выберите нужную вам команду:");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}