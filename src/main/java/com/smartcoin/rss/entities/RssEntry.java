package com.smartcoin.lms.entities;

import com.sun.syndication.feed.synd.SyndEntry;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class RssEntry {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link;

    private String description;

    private Date publishedDate;

    private Date created_at;

    private Date updated_at;

    private Date deleted_at;



    public static RssEntry convert(SyndEntry entry)
    {
        RssEntry rssEntry = new RssEntry();
        rssEntry.setTitle(entry.getTitle());
        rssEntry.setLink(entry.getLink());
        rssEntry.setDescription(entry.getDescription().getValue());
        rssEntry.setPublishedDate(entry.getPublishedDate());
        return rssEntry;
    }

    public static List<RssEntry> convertList(List<SyndEntry> entries)
    {
        List<RssEntry> rssEntries = new ArrayList<>();
        for (SyndEntry e :entries)
        {
            rssEntries.add(RssEntry.convert(e));
        }
        return rssEntries;
    }



}
