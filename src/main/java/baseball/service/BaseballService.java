package baseball.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballService {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> compareNumbers(final List<Integer> correctNumbers, final List<Integer> inputNumbers) {
        List<Integer> matchedNumbers = matchNumbers(correctNumbers, inputNumbers);

        // 이전 결과 초기화
        result = List.of(0, 0);

        // 같은 숫자가 있다면 위치 비교
        if (!matchedNumbers.isEmpty()) {
            result = matchPosition(matchedNumbers, correctNumbers, inputNumbers);
        }

        return result;
    }

    private List<Integer> matchNumbers(final List<Integer> correctNumbers, List<Integer> inputNumbersList) {
        return correctNumbers.stream().filter(inputNumbersList::contains).collect(Collectors.toList());
    }

    private List<Integer> matchPosition(final List<Integer> matchedNumbers, final List<Integer> correctNumbers,
                                        final List<Integer> inputNumbersList) {
        List<Integer> result = new ArrayList<>();
        int strike = 0;
        int ball = 0;

        for (Integer matchedNumber : matchedNumbers) {
            if (correctNumbers.indexOf(matchedNumber) == inputNumbersList.indexOf(matchedNumber)) {
                strike++;
                continue;
            }
            ball++;
        }

        result.add(strike);
        result.add(ball);

        return result;
    }
}

