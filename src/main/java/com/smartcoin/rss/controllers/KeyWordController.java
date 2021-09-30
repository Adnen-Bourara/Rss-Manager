package com.smartcoin.lms.controllers;

import com.smartcoin.lms.entities.KeyWord;
import com.smartcoin.lms.services.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class KeyWordController {

    @Autowired
    private KeyWordService keyWordService;

    @PostMapping("/KeyWord/Create")
    public Object createKeyWord(@RequestBody String word)
    {
        KeyWord keyWord = new KeyWord();
        keyWord.setKeyWord(word);
        keyWord = keyWordService.addKeyWord(keyWord);
        return ResponseEntity.status(HttpStatus.CREATED).body(keyWord);
    }

    @PutMapping("/KeyWord/Update")
    public Object updateKeyWord(@RequestBody KeyWord keyWord)
    {
        keyWord = keyWordService.editKeyWord(keyWord);
        return ResponseEntity.status(HttpStatus.CREATED).body(keyWord);
    }

    @DeleteMapping("/KeyWord/Delete/{id}")
    public Object deleteKeyWord(@PathVariable Long id)
    {
        KeyWord keyWord = keyWordService.getById(id);
        keyWord = keyWordService.deleteKeyWord(keyWord);
        return ResponseEntity.status(HttpStatus.CREATED).body(keyWord);
    }

    @GetMapping("/KeyWord/GetAll")
    public Object getAll()
    {
        List<KeyWord> keyWords = keyWordService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(keyWords);
    }

    @GetMapping("/KeyWord/{id}")
    public Object getById(@PathVariable Long id)
    {
        KeyWord keyWord = keyWordService.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(keyWord);
    }


}
