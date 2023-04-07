public class Converter {
    int convertToKm(int allSteps){
        int kilometers = allSteps * 75 / 100000;
        return kilometers;
    }
    int convertStepsToKilocalories(int allSteps){
        int kilocalories = (50*allSteps)/1000;
        return kilocalories;
    }
}
