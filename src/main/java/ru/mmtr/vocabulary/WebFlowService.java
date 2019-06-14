package ru.mmtr.vocabulary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mmtr.entity.Keys;
import ru.mmtr.flow.Out;
import ru.mmtr.web.converter.ConverterKeys;
import ru.mmtr.web.converter.ConverterWords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component("ChangeOps")

public class WebFlowService {


    private ServiceWorker serviceWorker;
    public Out out;


    @Autowired
    public WebFlowService(ServiceWorker serviceWorker) {
        this.serviceWorker = serviceWorker;
    }


    private Out createOutKeys(List<Keys> keys) {
        Out out = new Out();
        if (keys != null && keys.size() != 0) {
            out.setKeys(keys);
        } else
            out.setOutMess("no match");
        return out;
    }


    public Out delFromWebByKey(Long id, Integer typeOfVoc) throws IOException {
        return printKeys(typeOfVoc, serviceWorker.delByKey(id), id, true);
    }

    public Out delFromWebByWord(Long id, Integer typeOfVoc, Long idKey) throws IOException {
        return printKeys(typeOfVoc, serviceWorker.delByWord(id), id, idKey);
    }

    public Out updateByKeyFromWeb(Long id, String newKey, Integer typeOfVoc) throws IOException {
        return printKeys(typeOfVoc, serviceWorker.updateByKey(id, newKey, typeOfVoc), id, true);
    }

    public Out updateByWordFromWeb(Long id, String newWord, Integer typeOfVoc, Long idKey) throws IOException {
        return printKeys(typeOfVoc, serviceWorker.updateByWord(id, newWord, typeOfVoc), id, idKey);
    }

    public Out searchFromWebByKey(String key, Integer typeOfVoc) throws IOException {
        return createOutKeys(serviceWorker.searchByKey(key, typeOfVoc));
    }

    public Out searchFromWebByWords(String word, Integer typeOfVoc) throws IOException {
        return createOutKeys(serviceWorker.searchByWord(word, typeOfVoc));
    }

    public Out addFromWeb(String key, String word, Integer voc) throws IOException {


        return printKeysAfterAddKey(voc, serviceWorker.add(voc, key, word));

    }

    public Out addFromWebToKey(Long id, String word, Integer voc) throws IOException {
        return printKeys(voc, serviceWorker.addToKey(voc, id, word), id, true);

    }

    public Out printKeys(Integer typeOfVoc) throws IOException {
        out = new Out();
        out.setOutMess("");
        out.setKeys(serviceWorker.printKeys(typeOfVoc));
        return out;
    }

    public Out editManyWordsInKey(Integer typeOfVoc, Long id, String words) throws IOException {
        List<String> regWords = new ArrayList<String>();
        String masW[] = words.split("#_#");
        if (masW.length == 1)
            return printKeys(typeOfVoc, serviceWorker.addToKey(typeOfVoc, id, masW[0]), id, true);
        for (int i = 0; i < masW.length; i++) {
            regWords.add(masW[i]);
        }
        return printKeys(typeOfVoc, serviceWorker.addToKey(typeOfVoc, id, regWords), id, true);
    }

    public Out addManyWordsAndKey(String key, String word, Integer voc) throws IOException {
        List<String> regKey = new ArrayList<String>();
        String masK[] = word.split("#_#");
        if (masK.length == 1)
            return printKeysAfterAddKey(voc, serviceWorker.add(voc, key, masK[0]));
        for (int i = 0; i < masK.length; i++) {
            regKey.add(masK[i]);
        }
        return printKeysAfterAddKey(voc, serviceWorker.add(voc, key, regKey));
    }

    public Out printKeys(Integer typeOfVoc, String inPut, Long id, boolean isKey) throws IOException {

        out = new Out();

        out.setKeys(serviceWorker.printKeys(typeOfVoc));
        out.setOutMess(inPut);
        if (isKey)
            out.setKeysDtos(ConverterKeys.convertToDto(id));
        else
            out.setWordsDtos(ConverterWords.convertToDto(id));
        return out;
    }

    public Out printKeys(Integer typeOfVoc, String inPut) throws IOException {
        out = new Out();
        out.setKeys(serviceWorker.printKeys(typeOfVoc));
        out.setOutMess(inPut);
        return out;
    }

    public Out printKeysAfterAddKey(Integer typeOfVoc, String inPut) throws IOException {
        out = new Out();
        out.setKeys(serviceWorker.printKeys(typeOfVoc));
        out.setOutMess(inPut);
        out.setAddKeyValid(true);
        return out;
    }

    public Out printKeys(Integer typeOfVoc, String inPut, Long id, Long idKey) throws IOException {

        out = new Out();

        out.setKeys(serviceWorker.printKeys(typeOfVoc));

        out.setOutMess(inPut);
        if (idKey != null) {
            out.setKeysDtos(ConverterKeys.convertToDto(idKey));
        }
        if (id != null) {
            out.setWordsDtos(ConverterWords.convertToDto(id));
        }
        return out;
    }

}
