package ru.mmtr.web.converter;

import ru.mmtr.entity.Keys;
import ru.mmtr.web.dto.KeysDto;


public class ConverterKeys {
    public ConverterKeys() {

    }

    public static KeysDto convertToDto(Keys keys, boolean valid) {
        KeysDto keysDto = new KeysDto();
        keysDto.setId(keys.getId());
        keysDto.setKey(keys.getKey());
        keysDto.setWords(keys.getWords());
        keysDto.setValidate(valid);
        return keysDto;
    }

    public static KeysDto convertToDto(Keys keys) {
        KeysDto keysDto = new KeysDto();
        keysDto.setId(keys.getId());
        keysDto.setKey(keys.getKey());
        keysDto.setWords(keys.getWords());
        keysDto.setValidate(true);
        return keysDto;
    }

    public static KeysDto convertToDto(Long id) {
        KeysDto keysDto = new KeysDto();
        keysDto.setId(id);
        keysDto.setValidate(true);
        return keysDto;
    }
}
