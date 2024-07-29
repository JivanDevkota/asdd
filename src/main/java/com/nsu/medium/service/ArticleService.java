package com.nsu.medium.service;

import com.nsu.medium.dtos.ArticleDto;
import com.nsu.medium.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto, MultipartFile file)throws IOException;
    public List<ArticleDto> getAllArticle();
    public ArticleDto getArticleById(Long id);
}
