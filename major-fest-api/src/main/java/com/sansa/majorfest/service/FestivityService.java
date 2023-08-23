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
        FestivityDocument festivity = FestivityDocument.builder()
                .uuid(UUID.randomUUID())
                .name("Festival de Verano")
                .description("Un festival para celebrar el verano")
                .date(List.of(LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 16), LocalDate.of(2023, 8, 17)))
                .barItems(List.of(
                        BarItem.builder().name("Cerveza").value(3.50f).build(),
                        BarItem.builder().name("Refresco").value(1.50f).build(),
                        BarItem.builder().name("Comida").value(5.00f).build()
                ))
                .concerts(List.of(
                        Concert.builder().name("Concierto Principal").startTime(new Date()).endTime(new Date()).build(),
                        Concert.builder().name("Concierto Acústico").startTime(new Date()).endTime(new Date()).build()
                ))
                .build();

        festivityRepository.save(festivity);

        return festivityRepository.findAll();
    }

}
