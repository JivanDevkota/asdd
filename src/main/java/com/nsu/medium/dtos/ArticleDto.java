package com.nsu.medium.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private String file;
    private String links;
    private Set<TagsDto>tags;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
