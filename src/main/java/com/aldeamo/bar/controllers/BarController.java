package com.aldeamo.bar.controllers;

import com.aldeamo.bar.services.ArrayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bar")
@RequiredArgsConstructor
public class BarController {

    private final ArrayService arrayService;

    @GetMapping("/{iterations}/{array_id}")
    public int[] getResult(@PathVariable int iterations, @PathVariable long array_id){
        return arrayService.getResult(iterations, array_id);
    }
}
