package ru.mmtr.web.converter;

import ru.mmtr.entity.Word;
import ru.mmtr.web.dto.WordsDto;


public class WordsConverter {

    public static WordsDto convertToDto(Long id) {
        WordsDto wordsDto = new WordsDto();
        wordsDto.setId(id);
        wordsDto.setValidate(false);
        return wordsDto;
    }
}
