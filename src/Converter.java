public class Converter {


    void convertToKm(int allStep){
        int kilometers = ((int) (allStep*0.75)/ 1000);
        System.out.println("Ты прошел: " + kilometers + " км");
    }
    void convertStepsToKilocalories(int allStep){
        int kilocalories = (50*allStep)/1000;
        System.out.println("Ого, ты сжог: "+kilocalories+" Килокалорий");
    }
}
