package com.emzaz.crsystem.service;

import com.emzaz.crsystem.model.Result;
import com.emzaz.crsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    @Override
    public void saveResult(Result result) {
        this.resultRepository.save(result);
    }

    @Override
    public Result getResultById(Long id) {
        Optional <Result> optional = resultRepository.findById(id);
        Result result = null;

        if (optional.isPresent()) {
            result = optional.get();
        } else {
            throw new RuntimeException("Result not found for id :: " +id);
        }

        return result;
    }

    @Override
    public void deleteResultById(Long id) {
        this.resultRepository.deleteById(id);
    }
}
