package com.smartcoin.lms.services;

import com.smartcoin.lms.entities.KeyWord;
import com.smartcoin.lms.entities.RssSource;

import java.util.List;

public interface KeyWordService {
    KeyWord addKeyWord(KeyWord keyWord);
    KeyWord editKeyWord(KeyWord keyWord);
    KeyWord deleteKeyWord(KeyWord keyWord);
    List<KeyWord> getAll();
    KeyWord getById(Long id);
}
