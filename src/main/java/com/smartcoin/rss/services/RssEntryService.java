package com.smartcoin.lms.services;

import com.smartcoin.lms.entities.RssEntry;

import java.util.List;

public interface RssEntryService {

    RssEntry addRssEntry(RssEntry rssEntry);
    RssEntry editRssEntry(RssEntry rssEntry);
    RssEntry deleteRssEntry(RssEntry rssEntry);
    List<RssEntry> getAll();
    RssEntry getById(Long id);
}
