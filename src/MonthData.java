 class MonthData {
     int[] days = new int[30];
     //i- это один день
    public void printDaysAndStepsFromMonth() {
         for (int i=0; i<days.length; i++) {
             System.out.println((i + 1) + " день: " + days[i]);
         }
     }
   public   int sumStepsFromMonth() {
         int sumSteps = 0;
         for (int i : days) {
             sumSteps = sumSteps + i;
         }
         System.out.println("Общая сумма шагов: " + sumSteps);
         return sumSteps;
     }
     public int maxSteps() {
         int maxSteps = 0;
         for (int i : days) {
             if (i > maxSteps) {
                 maxSteps = i;
             }
         }
         return maxSteps;
     }
    public int bestSeries(int goalOfSteps) {
         int maxLenth = 0;
         int bestSeries = 0;

         for (int i : days) {
             if (i >= goalOfSteps) {
                 maxLenth++;
             }else if (maxLenth > bestSeries) {
                     bestSeries = maxLenth;
                 }else {
                 maxLenth = 0;
             }
             System.out.println("Лучшый результат составил: " + bestSeries + " дней!!!");
         }
         return maxLenth;
     }
}


