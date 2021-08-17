package com.mycompany.worldmap.repository;

import com.mycompany.worldmap.model.BookmarkCountry;
import com.mycompany.worldmap.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkCountry, Integer> {
    BookmarkCountry findBookmarkCountryByCountry(Country country);
}
