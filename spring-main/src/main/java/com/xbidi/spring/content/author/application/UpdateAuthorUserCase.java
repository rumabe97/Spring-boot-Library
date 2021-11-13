package com.xbidi.spring.content.author.application;

import com.xbidi.spring.content.author.application.port.UpdatedAuthorPort;
import com.xbidi.spring.content.author.domain.Author;
import com.xbidi.spring.content.author.infrastructure.repository.port.FindAuthorPort;
import com.xbidi.spring.content.author.infrastructure.repository.port.SaveAuthorPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateAuthorUserCase implements UpdatedAuthorPort {
    private FindAuthorPort findAuthorPort;
    private SaveAuthorPort saveAuthorPort;

    @Override
    public Author update(String idAuthor, Author updatedValuesAuthor) throws Exception {
        Author currentAuthor = findAuthorPort.findById(idAuthor);
        currentAuthor.updateWith(updatedValuesAuthor);
        Author updatedAuthor = saveAuthorPort.save(currentAuthor);
        return updatedAuthor;
    }
}
