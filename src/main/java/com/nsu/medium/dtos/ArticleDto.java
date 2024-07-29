package com.nsu.medium.dtos;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    private String fileName;
    private String fileType;
    private String filePath;

    private String links;
    private Set<String>tags;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
