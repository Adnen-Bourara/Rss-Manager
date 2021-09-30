package com.smartcoin.lms.services.impl;

import com.smartcoin.lms.entities.RssSource;
import com.smartcoin.lms.repositories.RssSourceRepository;
import com.smartcoin.lms.services.RssSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RssSourceServiceImpl implements RssSourceService {

    @Autowired
    private RssSourceRepository rssSourceRepository;

    @Override
    public RssSource addSource(RssSource rssSource) {
        rssSource.setCreated_at(new Date());
        return rssSourceRepository.save(rssSource);
    }

    @Override
    public RssSource editSource(RssSource rssSource) {
        rssSource.setUpdated_at(new Date());
        return rssSourceRepository.save(rssSource);
    }

    @Override
    public RssSource deleteSource(RssSource rssSource) {
        rssSource.setDeleted_at(new Date());
        return rssSourceRepository.save(rssSource);
    }

    @Override
    public List<RssSource> getAll() {

        return rssSourceRepository.findAll();
    }

    @Override
    public List<RssSource> getByFiltrable(Boolean filtrable) {
        return rssSourceRepository.findRssSourceByFiltrable(filtrable);
    }

    @Override
    public RssSource getById(Long id ) {

        return rssSourceRepository.findById(id).get();
    }
}
