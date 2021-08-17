package com.mycompany.worldmap.service;

import com.mycompany.worldmap.exception.CountryServiceException;
import com.mycompany.worldmap.model.BookmarkCountry;
import com.mycompany.worldmap.model.Country;
import com.mycompany.worldmap.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

  @Autowired
  BookmarkRepository bookmarkRepository;

  @Autowired
  CountryService countryService;

  @Override
  public BookmarkCountry getBookmarkedCountry() {
    return bookmarkRepository.findAll().get(0);
  }

  @Override
  public void bookmarkCountry(String countryCode) {
    if (countryCode.isBlank()) {
      throw new CountryServiceException("Country cannot be empty");
    }
    BookmarkCountry bookmarkCountry;
    Country country = countryService.getCountry(countryCode);

    List<BookmarkCountry> bookmarkCountryList = bookmarkRepository.findAll();
    if(bookmarkCountryList.isEmpty()){
      bookmarkCountry = new BookmarkCountry();
    }else{
      bookmarkCountry = bookmarkCountryList.get(0);
    }
    bookmarkCountry.setCountry(country);
    bookmarkCountry.setActive(true);
    bookmarkRepository.save(bookmarkCountry);
  }

  @Override
  public void unbBookmarkCountry(String countryCode) {
    if(countryCode.isBlank()){
      throw new CountryServiceException("Country cannot be null");
    }
    Country country = countryService.getCountry(countryCode);
    BookmarkCountry bookmarkedCountry = bookmarkRepository.findBookmarkCountryByCountry(country);
    bookmarkRepository.delete(bookmarkedCountry);
  }
}
