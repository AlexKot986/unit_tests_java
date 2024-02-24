package compare_values;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import java.util.List;

public class CompareAverageValues {
    public String getResult(List<Integer> list1, List<Integer> list2) {
        double value1 = getAverageValue(list1);
        double value2 = getAverageValue(list2);
        if (value1 > value2) {
            return "Первый список имеет большее среднее значение";
        }
        if (value1 < value2) {
            return "Второй список имеет большее среднее значение";
        }
        else {
            return "Средние значения равны";
        }
    }

    private double getAverageValue(List<Integer> list) {
        if (list == null){
            throw new NullPointerException("Список не должен быть равным null!");
        }
        if (list.isEmpty()){
            throw new ArgumentAccessException("Список не должен быть пустым!");
        }

        double sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        return sum / list.size();
    }
}
