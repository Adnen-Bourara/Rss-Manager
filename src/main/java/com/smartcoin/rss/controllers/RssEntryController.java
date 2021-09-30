package com.smartcoin.lms.controllers;


import com.smartcoin.lms.entities.KeyWord;
import com.smartcoin.lms.entities.RssEntry;
import com.smartcoin.lms.entities.RssSource;
import com.smartcoin.lms.services.KeyWordService;
import com.smartcoin.lms.services.RssEntryService;
import com.smartcoin.lms.services.RssSourceService;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class RssEntryController {

    @Autowired
    private RssSourceService rssSourceService;

    @Autowired
    private KeyWordService keyWordService;

    @Autowired
    private RssEntryService rssEntryService;



    public void updateFiltrable()
    {
        List<KeyWord> keyWords = keyWordService.getAll();
        List<String> words = keyWords.stream().map(w-> w.getKeyWord()).collect(Collectors.toList());
        List<RssSource> rssSources = rssSourceService.getByFiltrable(true);
        for (RssSource source : rssSources) {
            try {
                URL feedSource = new URL(source.getLink());
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedSource));
                List<RssEntry> entries = RssEntry.convertList(feed.getEntries()) ;
                List<RssEntry> filtredentries = new ArrayList<>();
                for ( RssEntry entry : entries)
                {
                    for(String w : words)
                    {
                        if(entry.getTitle().contains(w) || entry.getDescription().contains(w))
                        {
                            filtredentries.add(entry);
                                    break;
                        }
                    }
                }
                for(RssEntry e : filtredentries)
                    rssEntryService.addRssEntry(e);
            }
            catch (Exception e) {
                System.out.println("error source");
            }
        }
        System.out.println("entries 1 updated");
    }

    public void updateNoneFiltrable()
    {
        List<RssSource> rssSources = rssSourceService.getByFiltrable(false);
        for (RssSource source : rssSources) {
            try {
                URL feedSource = new URL(source.getLink());
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedSource));
                  List<RssEntry> entries = RssEntry.convertList(feed.getEntries()) ;
                  for(RssEntry e : entries)
                      rssEntryService.addRssEntry(e);
            }
            catch (Exception e) {
                System.out.println("error source");
            }
        }

        System.out.println("entries 2 updated");
    }



    @GetMapping("/UpdateFeeds")
    public Object updateFeeds()
    {
        this.updateNoneFiltrable();
        this.updateFiltrable();
        List<RssEntry> updatedFeeds = rssEntryService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedFeeds);
    }
}
