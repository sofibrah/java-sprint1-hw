public class Converter {

    double oneStep = 0.75;
    double calories = 50;
    void convertToKm(int allStep){
        double kilometers =  (allStep*oneStep)/ 1000;
        System.out.println("Ты прошел: " + kilometers + " км");
    }
    void convertStepsToKilocalories(int allStep){
        double kilocalories = (calories*allStep)/1000;
        System.out.println("Ого, ты сжог: "+kilocalories+" Килокалорий");
    }
}
