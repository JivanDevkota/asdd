package com.nsu.medium.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsu.medium.dtos.ArticleDto;
import com.nsu.medium.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createArticle(@ModelAttribute ArticleDto articleDto,
                                           @RequestParam("file") MultipartFile file)
            throws IOException {
        try {
            ArticleDto createdArticle = articleService.createArticle(articleDto,file);
            return ResponseEntity.ok(createdArticle);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticle());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable Long id) {
        ArticleDto articleDto = articleService.getArticleById(id);
        if (articleDto != null) {
            return ResponseEntity.ok(articleDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
