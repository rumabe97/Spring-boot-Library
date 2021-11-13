package com.xbidi.spring.content.lending.infrastructure.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LendingCategoriesInputDTO extends LendingInputDTO {
    private List<String> idCategories;
}
