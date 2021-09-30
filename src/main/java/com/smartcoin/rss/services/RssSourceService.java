package com.smartcoin.lms.services;

import com.smartcoin.lms.entities.RssSource;

import java.util.List;

public interface RssSourceService {

    RssSource addSource(RssSource rssSource);
    RssSource editSource(RssSource rssSource);
    RssSource deleteSource(RssSource rssSource);
    List<RssSource> getAll();
    List<RssSource> getByFiltrable(Boolean filtrable);
    RssSource getById(Long id);


}
