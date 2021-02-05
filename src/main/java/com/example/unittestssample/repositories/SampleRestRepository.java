package com.example.unittestssample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unittestssample.model.SampleRest;

public interface SampleRestRepository extends JpaRepository<SampleRest, String> {
}
