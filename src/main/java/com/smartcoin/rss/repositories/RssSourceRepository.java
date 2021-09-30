package com.smartcoin.lms.repositories;

import com.smartcoin.lms.entities.RssSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RssSourceRepository extends JpaRepository<RssSource,Long> {
    List<RssSource> findRssSourceByFiltrable(Boolean filtrable);
}
