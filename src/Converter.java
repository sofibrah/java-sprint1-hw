public class Converter {
    double step = 0.75;
    double calories = 50;

    void convertToKm(double allStep){
        double meters = allStep * step;
        double kilometers = meters / 1000;
        System.out.println("Вы прошли: " + kilometers + " км");
    }
    void convertStepsToKilocalories(double allStep){
        double calories = allStep * this.calories;
        double kilocalories = calories/1000;
        System.out.println("Килокалорий сгорело: "+kilocalories);
    }
}