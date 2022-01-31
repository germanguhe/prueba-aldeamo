package com.aldeamo.bar.services;

import com.aldeamo.bar.models.ArraysModel;
import com.aldeamo.bar.repositories.ArrayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class IArrayService implements ArrayService {

    private final ArrayRepository arrayRepository;

    @Override
    public int[] getResult(int iterations, long array_id) {
        ArraysModel arraysModel = arrayRepository.findById(array_id).get();

        String [] splittedArray = arraysModel.getInputArray().split(",");

        List<Integer> inputList = Arrays.stream(splittedArray)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < iterations; i++) {
            for (int j = inputList.size(); j -- > 0; ) {
                if(inputList.get(j) % PRIME_NUMBERS[i] == 0){
                    resultList.add(inputList.get(j));
                    inputList.remove(j);
                }
            }
        }
        resultList.addAll(inputList);
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
