package com.example.unittestssample.services;

import java.util.List;

import com.example.unittestssample.model.SampleRest;

public interface SampleRestService {
    List<SampleRest> getAll(boolean isValid);

    SampleRest getById(String id);
}
