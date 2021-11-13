package com.xbidi.spring.content.user.infrastructure.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserCategoriesInputDTO extends UserInputDTO{
    private List<String> idCategories;
}
