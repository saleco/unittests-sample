package com.example.unittestssample.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.unittestssample.model.SampleRest;
import com.example.unittestssample.repositories.SampleRestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleRestServiceImpl implements SampleRestService {

    protected final SampleRestRepository sampleRestRepository;

    @Override
    public List<SampleRest> getAll(boolean isValid) {
        if(isValid) {
            return sampleRestRepository.findAll();
        } else {
            return Arrays.asList(SampleRest.builder().value("invalid").build());
        }
    }


    @Override
    public SampleRest getById(String id) {
        return sampleRestRepository.findById(id)
                                   .orElseThrow(() -> new RuntimeException("Sample Rest not found for the id: " + id));

    }
}
