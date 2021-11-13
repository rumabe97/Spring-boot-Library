package com.xbidi.spring.content.user.infrastructure.controller.dto;

import com.xbidi.spring.content.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserCategoriesOutputDTO extends UserOutputDTO{
    private List<String> idCategories;

    public UserCategoriesOutputDTO(User user, List<String> idCategories){
        super(user);
        this.idCategories = idCategories;
    }
}
