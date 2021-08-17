package com.mycompany.worldmap.controller;

import com.mycompany.worldmap.model.Country;
import com.mycompany.worldmap.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1.0/")
public class BookmarkController {

  @Autowired
  BookmarkService bookmarkService;

  @GetMapping("bookmark")
  public Country getBookmarkCountry(){
    return bookmarkService.getBookmarkedCountry().getCountry();
  }

  @PutMapping("bookmark")
  public ResponseEntity<String> bookmarkCountry(@RequestParam("code") String code) {
      bookmarkService.bookmarkCountry(code.toUpperCase());
     return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("bookmark")
  public ResponseEntity<String> deleteBookmarkedCountry(@RequestParam("code") String code){
    bookmarkService.unbBookmarkCountry(code);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
