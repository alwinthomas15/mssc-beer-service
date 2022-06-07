package com.springframework.msscbeerservice.web.controller;

import com.springframework.msscbeerservice.services.BeerService;
import com.springframework.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/beer")
public class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
    // Should we return BeerDto or ResponseEntity?
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }



}
