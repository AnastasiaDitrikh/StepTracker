
public class StepTracker {
    int stepsAim = 10000;
    Converter converter = new Converter();
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days = new int[30];
    }

     void saveSteps(int numberMonth, int numberDay, int  amountSteps) {
                  monthToData[numberMonth].days[numberDay - 1] = amountSteps;
            }
    int changeStepsAim(int newStepsAim) {
        return (stepsAim = newStepsAim);
           }

    void printStatistic(int numberMonth) {
        int steps=0;
        int maxSteps=0;
        System.out.println("Koличество пройденных шагов по дням:");
        for (int i=0;i<monthToData[numberMonth].days.length;i++){
            steps+=monthToData[numberMonth].days[i];
            if (monthToData[numberMonth].days[i]>maxSteps){
                maxSteps=monthToData[numberMonth].days[i];     }
            System.out.print((i+1)+" день: "+monthToData[numberMonth].days[i]+", ");
        }
        double averageSteps=steps/30.0;
        System.out.println();
        System.out.println("Общее количество шагов за месяц:"+steps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Среднее количество шагов: "+averageSteps);
        System.out.println("Пройденная дистанция: "+ converter.countDistance(steps));
        System.out.println("Количество сожженых килокалорий: "+converter.countCalories(steps));
        System.out.println("Лучшая серия: "+findBestSeria(numberMonth));

    }
    int findBestSeria(int numberMonth) {
        int counterBestSeria=0;
        int counter=0;
        for (int i=0;i<monthToData[numberMonth].days.length;i++){
            if (monthToData[numberMonth].days[i]>=stepsAim) {
                counter += 1;
                if (counter >= counterBestSeria) {
                    counterBestSeria = counter;
                }
            }else {
                counter = 0;}
        }
        return counterBestSeria; }//теперь этот метод находит и возвращает
}