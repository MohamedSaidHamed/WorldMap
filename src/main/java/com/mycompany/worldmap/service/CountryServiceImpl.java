package com.mycompany.worldmap.service;

import com.mycompany.worldmap.exception.CountryServiceException;
import com.mycompany.worldmap.model.Country;
import com.mycompany.worldmap.repository.BookmarkRepository;
import com.mycompany.worldmap.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

  @Autowired
  CountryRepository countryRepository;
  @Autowired
  BookmarkRepository bookmarkRepository;

  @Override
  public Country getCountry(String code) {
    return countryRepository.findById(code).orElseThrow(()->new CountryServiceException("Invalid Country Code"));
  }

}
