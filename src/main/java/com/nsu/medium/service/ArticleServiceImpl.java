package com.nsu.medium.service;

import com.nsu.medium.dtos.ArticleDto;
import com.nsu.medium.dtos.TagsDto;
import com.nsu.medium.entity.Article;
import com.nsu.medium.entity.Tags;
import com.nsu.medium.repo.ArticleRepository;
import com.nsu.medium.repo.TagsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ArticleDto createArticle(ArticleDto articleDto) {
        Article article = modelMapper.map(articleDto, Article.class);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Set<TagsDto> tagsDtos = articleDto.getTags();
        Set<Tags> tags = new HashSet<>();
        for (TagsDto tagDto : tagsDtos) {
            Optional<Tags> existingTag = tagsRepository.findByName(tagDto.getName());
            if (existingTag.isPresent()) {
                tags.add(existingTag.get());
            } else {
                Tags newTags = new Tags();
                newTags.setName(tagDto.getName());
                tags.add(tagsRepository.save(newTags));
            }
        }
            Article saveArticle = articleRepository.save(article);
            return modelMapper.map(saveArticle, ArticleDto.class);

        }

    public List<ArticleDto> getAllArticle(){
        List<Article> articleList = articleRepository.findAll();
        return articleList.stream()
                .map(article -> modelMapper.map(article,ArticleDto.class)).collect(Collectors.toList());
    }

}


