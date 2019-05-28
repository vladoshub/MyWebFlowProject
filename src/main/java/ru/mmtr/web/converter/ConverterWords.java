package ru.mmtr.web.converter;

import ru.mmtr.entity.Words;
import ru.mmtr.web.dto.WordsDto;



public class ConverterWords {
  public  static  WordsDto convertToDto(Words words, boolean valid) {
        WordsDto wordsDto = new WordsDto();
        wordsDto.setId(words.getId());
        wordsDto.setWord(words.getWord());
        wordsDto.setWord(words.getWord());
        wordsDto.setValidate(valid);
        return wordsDto;
    }

    public static   WordsDto convertToDto(Words words) {
        WordsDto wordsDto = new WordsDto();
        wordsDto.setId(words.getId());
        wordsDto.setWord(words.getWord());
        wordsDto.setWord(words.getWord());
        wordsDto.setValidate(true);
        return wordsDto;
    }
    public static  WordsDto convertToDto(Long id) {
        WordsDto wordsDto = new WordsDto();
        wordsDto.setId(id);
        wordsDto.setValidate(false);
        return wordsDto;
    }
}
