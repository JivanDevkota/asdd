package com.nsu.medium.service;

import com.nsu.medium.dtos.ArticleDto;
import org.springframework.stereotype.Service;


public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto);
}
