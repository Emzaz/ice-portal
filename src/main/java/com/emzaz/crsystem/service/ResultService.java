package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Result;

import java.util.List;

public interface ResultService {

    List<Result> getAllResults();
    void saveResult(Result result);
    Result getResultById(Long id);
    void deleteResultById(Long id);
}
