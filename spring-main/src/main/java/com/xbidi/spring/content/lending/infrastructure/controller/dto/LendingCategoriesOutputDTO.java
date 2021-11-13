package com.xbidi.spring.content.lending.infrastructure.controller.dto;

import com.xbidi.spring.content.lending.domain.Lending;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LendingCategoriesOutputDTO extends LendingOutputDTO {
    private List<String> idCategories;

    public LendingCategoriesOutputDTO(Lending user, List<String> idCategories){
        super(user);
        this.idCategories = idCategories;
    }
}
