package ru.mmtr.web.converter;

import ru.mmtr.entity.Key;
import ru.mmtr.web.dto.KeysDto;


public class KeysConverter {
    public KeysConverter() {
    }

    public static KeysDto convertToDto(Long id) {
        KeysDto keysDto = new KeysDto();
        keysDto.setId(id);
        keysDto.setValidate(true);
        return keysDto;
    }
}
