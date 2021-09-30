package com.smartcoin.lms.controllers;

import com.smartcoin.lms.entities.RssEntry;
import com.smartcoin.lms.entities.RssSource;
import com.smartcoin.lms.services.RssEntryService;
import com.smartcoin.lms.services.RssSourceService;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;

@RestController
@CrossOrigin("*")
public class RssSourceController {

    @Autowired
    private RssSourceService rssSourceService;

    @Autowired
    private RssEntryService rssEntryService;

    @PostMapping ("/RssSource/Create")
    public Object createSource(@RequestBody RssSource rssSource) {
        try {
            URL feedSource = new URL(rssSource.getLink());
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedSource));
            rssSource.setTitle(feed.getTitle());
            rssSource.setTitle(feed.getImage().getUrl());
            rssSource = rssSourceService.addSource(rssSource);
         //   List<SyndEntry> entries =  feed.getEntries();
            return ResponseEntity.status(HttpStatus.CREATED).body(rssSource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("error");
        }
    }

    @PutMapping("/RssSource/Update")
    public Object updateSource(@RequestBody RssSource rssSource) {
        try {
            URL feedSource = new URL(rssSource.getLink());
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedSource));
            rssSource.setTitle(feed.getTitle());
            rssSource.setTitle(feed.getImage().getUrl());
            rssSource = rssSourceService.editSource(rssSource);
            return ResponseEntity.status(HttpStatus.CREATED).body(rssSource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("error");
        }
    }


    @DeleteMapping("/RssSource/Delete/{id}")
    public Object deleteRss(@PathVariable Long id)
    {
        RssSource rssSource = rssSourceService.getById(id);
        rssSource = rssSourceService.deleteSource(rssSource);
        return ResponseEntity.status(HttpStatus.CREATED).body(rssSource);
    }

    @GetMapping("/RssSource/GetAll")
    public Object getAll()
    {
        List<RssSource> rssSource = rssSourceService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(rssSource);
    }

    @GetMapping("/RssSource/{id}")
    public Object getById(@PathVariable Long id)
    {
        RssSource rssSource = rssSourceService.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(rssSource);
    }




}
