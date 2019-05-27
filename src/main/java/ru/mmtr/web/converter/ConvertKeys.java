package ru.mmtr.web.converter;

import ru.mmtr.entity.Keys;
import ru.mmtr.web.dto.KeysDto;

public class ConvertKeys {
    static KeysDto convertToDto(Keys keys,boolean valid){
         KeysDto keysDto = new KeysDto();
         keysDto.setId(keys.getId());
         keysDto.setKey(keys.getKey());
         keysDto.setWords(keys.getWords());
         keysDto.setValidate(valid);
         return keysDto;
    }
    static KeysDto convertToDto(Keys keys){
        KeysDto keysDto = new KeysDto();
        keysDto.setId(keys.getId());
        keysDto.setKey(keys.getKey());
        keysDto.setWords(keys.getWords());
        keysDto.setValidate(true);
        return keysDto;
    }
}
