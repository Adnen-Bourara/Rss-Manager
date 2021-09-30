package com.smartcoin.lms.services.impl;

import com.smartcoin.lms.entities.KeyWord;
import com.smartcoin.lms.repositories.KeyWordRepository;
import com.smartcoin.lms.services.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KeyWordServiceImpl implements KeyWordService {

    @Autowired
    private KeyWordRepository keyWordRepository;

    @Override
    public KeyWord addKeyWord(KeyWord keyWord) {
        keyWord.setCreated_at(new Date());
        return keyWordRepository.save(keyWord);
    }

    @Override
    public KeyWord editKeyWord(KeyWord keyWord) {
        keyWord.setUpdated_at(new Date());
        return keyWordRepository.save(keyWord);
    }

    @Override
    public KeyWord deleteKeyWord(KeyWord keyWord) {
        keyWord.setDeleted_at(new Date());
        return keyWordRepository.save(keyWord);
    }

    @Override
    public List<KeyWord> getAll() {
        return keyWordRepository.findAll();
    }

    @Override
    public KeyWord getById(Long id){
        return keyWordRepository.findById(id).get();
    }
}
