package com.mycompany.worldmap.controller;

import com.mycompany.worldmap.model.Country;
import com.mycompany.worldmap.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("v1.0/")
public class CountryController {

  @Autowired
  private CountryService countryService;

  @GetMapping("country")
  public Flux<Country> getCountryInformation(@RequestParam("code") String code){
    Country result = countryService.getCountry(code.toUpperCase());
    return Flux.just(result);
  }
}
