package com.sansa.majorfest.controller;

import com.sansa.majorfest.document.FestivityDocument;
import com.sansa.majorfest.service.FestivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/festivity")
public class FestivityController {

    @Autowired
    private FestivityService festivityService;

    @GetMapping
    public List<FestivityDocument> getAll(){
        return festivityService.findAll();
    }
}
