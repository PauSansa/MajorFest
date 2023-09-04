package com.sansa.majorfest.service;

import com.sansa.majorfest.document.FestivityDocument;
import com.sansa.majorfest.repository.FestivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.sansa.majorfest.document.BarItem;
import com.sansa.majorfest.document.Concert;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FestivityService {
    private final FestivityRepository festivityRepository;

    public List<FestivityDocument> findAll(){
        return festivityRepository.findAll();
    }

}
