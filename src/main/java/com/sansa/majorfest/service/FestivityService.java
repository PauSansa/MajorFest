package com.sansa.majorfest.service;

import com.sansa.majorfest.document.FestivityDocument;
import com.sansa.majorfest.repository.FestivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FestivityService {
    private final FestivityRepository festivityRepository;

    public List<FestivityDocument> findAll(){
        return festivityRepository.findAll();
    }

}
