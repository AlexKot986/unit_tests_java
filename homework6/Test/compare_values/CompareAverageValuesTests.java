package compare_values;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CompareAverageValuesTests {

    CompareAverageValues compareAverageValues;
    List<Integer> first;
    List<Integer> second;

    @BeforeEach
    void setUp() {
        compareAverageValues = new CompareAverageValues();
        first = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        second = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    void firstCompareAverageValuesTest() {
        first.add(10);

        String result = compareAverageValues.getResult(first, second);

        assertThat(result).isEqualTo("Первый список имеет большее среднее значение");
    }
    @Test
    void secondCompareAverageValuesTest() {
        first.add(-1);

        String result = compareAverageValues.getResult(first, second);

        assertThat(result).isEqualTo("Второй список имеет большее среднее значение");
    }
    @Test
    void thirdCompareAverageValuesTest() {
        String result = compareAverageValues.getResult(first, second);

        assertThat(result).isEqualTo("Средние значения равны");
    }
    @Test
    void zeroSizeCompareAverageValuesTest() {
        List<Integer> zeroSize = new ArrayList<>();

        assertThatThrownBy(() -> compareAverageValues.getResult(first, zeroSize))
                .isInstanceOf(ArgumentAccessException.class)
                .hasMessage("Список не должен быть пустым!");
    }
    @Test
    void nullCompareAverageValuesTest() {
        List<Integer> nullList = null;

        assertThatThrownBy(() -> compareAverageValues.getResult(first, nullList))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Список не должен быть равным null!");
    }

}
