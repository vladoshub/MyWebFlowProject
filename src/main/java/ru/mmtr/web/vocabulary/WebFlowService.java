package ru.mmtr.web.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.entity.Key;
import ru.mmtr.flow.Out;
import ru.mmtr.service.ServiceWorkerImpl;
import ru.mmtr.web.converter.KeysConverter;
import ru.mmtr.web.converter.WordsConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component("WebFlowService")

public class WebFlowService {


    private ServiceWorkerImpl serviceWorkerImpl;
    @Autowired
    public WebFlowService(ServiceWorkerImpl serviceWorkerImpl) {
        this.serviceWorkerImpl = serviceWorkerImpl;
    }


    private Out createOutKeys(List<Key> keys) {
        Out out = new Out();
        if (keys != null && keys.size() != 0) {
            out.setKeys(keys);
        } else
            out.setOutMess("no match");
        return out;
    }

    public Out delKeyById(Long id, Integer typeOfVoc) throws IOException {
        return findKeys(typeOfVoc, serviceWorkerImpl.deleteKeyById(id), id, true);
    }

    public Out delWordById(Long id, Integer typeOfVoc, Long idKey) throws IOException {
        return findKeys(typeOfVoc, serviceWorkerImpl.deleteWordById(id), id, idKey);
    }

    public Out updateKey(Long id, String newKey, Integer typeOfVoc) throws IOException {
        return findKeys(typeOfVoc, serviceWorkerImpl.updateByKey(id, newKey, typeOfVoc), id, true);
    }

    public Out updateWord(Long id, String newWord, Integer typeOfVoc, Long idKey) throws IOException {
        return findKeys(typeOfVoc, serviceWorkerImpl.updateByWord(id, newWord, typeOfVoc), id, idKey);
    }

    public Out searchByKey(String key, Integer typeOfVoc) throws IOException {
        return createOutKeys(serviceWorkerImpl.searchByKey(key, typeOfVoc));
    }

    public Out searchByWords(String word, Integer typeOfVoc) throws IOException {
        return createOutKeys(serviceWorkerImpl.searchByWord(word, typeOfVoc));
    }

    public Out addKey(String key, String word, Integer voc) throws IOException {
        return findKeysAfterAddKey(voc, serviceWorkerImpl.add(voc, key, word));
    }

    public Out addWord(Long id, String word, Integer voc) throws IOException {
        return findKeys(voc, serviceWorkerImpl.addToKey(voc, id, word), id, true);

    }

    public Out findKeys(Integer typeOfVoc) throws IOException {
        Out out = new Out();
        out.setOutMess("");
        out.setKeys(serviceWorkerImpl.printKeys(typeOfVoc));
        return out;
    }

    public Out editManyWordsInKey(Integer typeOfVoc, Long id, String words) throws IOException {
        List<String> regWords = new ArrayList<String>();
        String masW[] = words.split("#_#");
        if (masW.length == 1)
            return findKeys(typeOfVoc, serviceWorkerImpl.addToKey(typeOfVoc, id, masW[0]), id, true);
        for (int i = 0; i < masW.length; i++) {
            regWords.add(masW[i]);
        }
        return findKeys(typeOfVoc, serviceWorkerImpl.addToKey(typeOfVoc, id, regWords), id, true);
    }

    public Out addManyWordsAndKey(String key, String word, Integer voc) throws IOException {
        List<String> regKey = new ArrayList<String>();
        String masK[] = word.split("#_#");
        if (masK.length == 1)
            return findKeysAfterAddKey(voc, serviceWorkerImpl.add(voc, key, masK[0]));
        for (int i = 0; i < masK.length; i++) {
            regKey.add(masK[i]);
        }
        return findKeysAfterAddKey(voc, serviceWorkerImpl.add(voc, key, regKey));
    }

    public Out findKeys(Integer typeOfVoc, String inPut, Long id, boolean isKey) throws IOException {

        Out out = new Out();

        out.setKeys(serviceWorkerImpl.printKeys(typeOfVoc));
        out.setOutMess(inPut);
        if (isKey)
            out.setKeysDto(KeysConverter.convertToDto(id));
        else
            out.setWordsDto(WordsConverter.convertToDto(id));
        return out;
    }

    public Out findKeys(Integer typeOfVoc, String inPut) throws IOException {
        Out out = new Out();
        out.setKeys(serviceWorkerImpl.printKeys(typeOfVoc));
        out.setOutMess(inPut);
        return out;
    }

    public Out findKeysAfterAddKey(Integer typeOfVoc, String inPut) throws IOException {
        Out out = new Out();
        out.setKeys(serviceWorkerImpl.printKeys(typeOfVoc));
        out.setOutMess(inPut);
        out.setAddKeyValid(true);
        return out;
    }

    public Out findKeys(Integer typeOfVoc, String inPut, Long id, Long idKey) throws IOException {
        Out out = new Out();
        out.setKeys(serviceWorkerImpl.printKeys(typeOfVoc));
        out.setOutMess(inPut);
        if (idKey != null) {
            out.setKeysDto(KeysConverter.convertToDto(idKey));
        }
        if (id != null) {
            out.setWordsDto(WordsConverter.convertToDto(id));
        }
        return out;
    }

}
