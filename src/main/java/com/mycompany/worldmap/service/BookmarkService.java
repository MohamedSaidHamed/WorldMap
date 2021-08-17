package com.mycompany.worldmap.service;

import com.mycompany.worldmap.model.BookmarkCountry;

public interface BookmarkService {

  BookmarkCountry getBookmarkedCountry();

  void bookmarkCountry(String countryCode);

  void unbBookmarkCountry(String countryCode);
}
