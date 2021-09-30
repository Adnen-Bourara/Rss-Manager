package com.smartcoin.lms.services.impl;

import com.smartcoin.lms.entities.RssEntry;
import com.smartcoin.lms.repositories.RssEntryRepository;
import com.smartcoin.lms.services.RssEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RssEntryServiceImpl implements RssEntryService {

    @Autowired
    private RssEntryRepository rssEntryRepository;

    @Override
    public RssEntry addRssEntry(RssEntry rssEntry) {
        rssEntry.setCreated_at(new Date());
        return rssEntryRepository.save(rssEntry);
    }

    @Override
    public RssEntry editRssEntry(RssEntry rssEntry) {
        rssEntry.setUpdated_at(new Date());
        return rssEntryRepository.save(rssEntry);
    }

    @Override
    public RssEntry deleteRssEntry(RssEntry rssEntry) {
        rssEntry.setDeleted_at(new Date());
        return rssEntryRepository.save(rssEntry);
    }

    @Override
    public List<RssEntry> getAll() {
        return rssEntryRepository.findAll();
    }

    @Override
    public RssEntry getById(Long id) {
        return rssEntryRepository.findById(id).get();
    }
}
