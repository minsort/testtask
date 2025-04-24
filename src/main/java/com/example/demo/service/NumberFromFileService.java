package com.example.demo.service;

import com.example.demo.dto.RequestDto;
import com.example.demo.util.ExcelReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NumberFromFileService {

    private final ExcelReader excelReader;

    public Integer getNumber(RequestDto requestDto) {
        List<Integer> numbers = excelReader.readExcel(requestDto.path()).stream()
                .filter(d -> d == d.intValue())
                .map(Double::intValue)
                .toList();

        return searchMinNumber(numbers);
    }

    private Integer searchMinNumber(List<Integer> numbers) {
        int minNumber = Integer.MAX_VALUE;

        for (Integer number : numbers) {
            if (number < minNumber) {
                minNumber = number;
            }
        }
        return minNumber;
    }
}
