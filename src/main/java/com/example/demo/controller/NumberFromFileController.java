package com.example.demo.controller;

import com.example.demo.dto.RequestDto;
import com.example.demo.service.NumberFromFileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class NumberFromFileController {
    private final NumberFromFileService numberFromFileService;

    @PostMapping("/file")
    @Operation(description = "Получение числа из файла")
    public Integer getNumberFromFile(@RequestBody RequestDto requestDto) {
        return numberFromFileService.getNumber(requestDto);
    }
}
