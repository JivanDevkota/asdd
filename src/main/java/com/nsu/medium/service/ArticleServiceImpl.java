package com.nsu.medium.service;

import com.nsu.medium.dtos.ArticleDto;
import com.nsu.medium.entity.Article;
import com.nsu.medium.repo.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Value("${upload-dir}")
    private String uploadDir;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArticleDto createArticle(ArticleDto articleDto, MultipartFile file) throws IOException {

        String filePath = uploadDir + "/" + file.getOriginalFilename();
        File destFile = new File(filePath);
        destFile.getParentFile().mkdirs();
        file.transferTo(destFile);
        Article article = modelMapper.map(articleDto, Article.class);
        article.setFileName(file.getOriginalFilename());
        article.setFileType(file.getContentType());
        article.setFilePath(filePath);
        article.setCreateTime(LocalDateTime.now());
        if (articleDto.getTags() != null) {
            Set<String> tags = articleDto.getTags().stream()
                    .map(String::trim)
                    .collect(Collectors.toSet());
            article.setTags(tags);
        }

        Article savedArticle = articleRepository.save(article);
        return modelMapper.map(savedArticle, ArticleDto.class);
    }

    public List<ArticleDto> getAllArticle(){
        List<Article> articleList = articleRepository.findAll();
        return articleList.stream()
                .map(article -> modelMapper.map(article,ArticleDto.class)).collect(Collectors.toList());
    }

    public ArticleDto getArticleById(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
        }
        return null;
    }

}


