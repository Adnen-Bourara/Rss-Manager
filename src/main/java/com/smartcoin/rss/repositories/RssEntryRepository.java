package com.smartcoin.lms.repositories;

import com.smartcoin.lms.entities.RssEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssEntryRepository extends JpaRepository<RssEntry,Long> {
}
