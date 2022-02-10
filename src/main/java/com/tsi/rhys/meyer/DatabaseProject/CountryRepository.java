package com.tsi.rhys.meyer.DatabaseProject;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    @Query(
            value = "select * from country where country_id = 2",
            nativeQuery = true)
    Collection<Country> findCountryByID();

}
