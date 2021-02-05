package com.example.unittestssample.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.unittestssample.model.SampleRest;
import com.example.unittestssample.services.SampleRestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sample-rest-controller")
@RequiredArgsConstructor
public class SampleRestController {

    protected final SampleRestService sampleRestService;

    @GetMapping
    public List<SampleRest> getAll() {
        return sampleRestService.getAll(true);
    }

    @GetMapping("/{id}")
    public SampleRest getById(@PathVariable String id) {
        return sampleRestService.getById(id);
    }

}
