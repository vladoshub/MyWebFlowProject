package ru.mmtr.vocabulary;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mmtr.dao.KeysDao;
import ru.mmtr.dao.KeysDaoImpl;
import ru.mmtr.entity.Keys;
import ru.mmtr.entity.Words;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
@Component("Library")
public class Library {

    @Value("nameFile")
    private String nameFile;
    private String regexVocFirstLib;
    private String regexVocSecondLib;
    private KeysDao keysDao;
    private List<String> print = new ArrayList<>();



    /*public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
*/
    // private Map<String, String> states = new HashMap<String, String>();//будем хранить тут наш словарь


    @Autowired
    public Library(InfoBase infoBase, SessionFactory ses) {
        this.nameFile = infoBase.getFileName();
        this.regexVocFirstLib = infoBase.getRegexVocFirstLib();
        this.regexVocSecondLib = infoBase.getRegexVocSecondLib();
        keysDao = new KeysDaoImpl(ses);
    }


 /*   public void readAllFromTxt() { //-	инициализировать мапу словарем
        String[] word;
        try (FileInputStream fstream = new FileInputStream(nameFile);) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.matches(regexVocFirstLib) || strLine.matches(regexVocSecondLib)) {
                    word = strLine.split("_");
                    states.put(word[0], word[1]);
                }
            }

        } catch (Exception e) {
            Console.outError(e);
        }


    }
    */

    public List<String> printAll() { //-	чтение списка пар из файла
      /*  try {
            for (Map.Entry<String, String> pair : states.entrySet()) {
                Console.outConsole(pair.getKey(), pair.getValue());
            }
        } catch (Exception e) {
            Console.outError(e);
        }
        */
        print.clear();
        for (Keys k : keysDao.getKeysList()) {
            for (Words w : k.getWords()) {
                print.add("key: " + k.getKey() + " - " + "word: " + w.getWord());
            }
            if (print==null)
                print.add(0,"List null");
            else
                print.add(0,"Operation is Ok");
        }
        return print;
    }

    public List<String> readFromTxt(String key) {//-	поиск записи по ключу

        List<String> readFromTxt = new ArrayList<String>();
     /*   try {
            Console.outConsole(key, states.get(key));
        } catch (Exception e) {
            Console.outError(e);
        }
        */

        if (print != null) print.clear();
        try {
            for (Words w : keysDao.getWordsByKey(key)) {
                print.add("key: " + key + " - " + "word: " + w.getWord());
            }
            if (print == null)
                print.add(0,"not match");
            else
                print.add(0,"Operation is Ok");
            return print;
        } catch (Exception e) {
            print.add(0,"Operation is denied");
            return print;
        }


    }

    public String deleteFromTxt(String key) {//-	удаление записи по ключу
       /* for (Iterator<Map.Entry<String, String>> it = states.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            if (entry.getKey().equals(key)) {
                it.remove();
            }
        }
        saveToTxt();
        */
       try {
           keysDao.deleteByKey(key);
           return "Word is deleted";
       }
       catch (Exception e){
           return "error in datebase";
       }


    }

    public String addToTxt(String key, String value) {//--	добавление записей
        // states.put(key, value);
        //saveToTxt();
        try {
            keysDao.AddKey(key, value);
            return "Word is added";
        }
        catch (Exception e) {
            return "error in datebase";
        }
        //readAllFromTxt();
    }

  /*  public void saveToTxt() {//сохранить мапу в документ
        try (PrintWriter pw = new PrintWriter(nameFile)) {
            for (Map.Entry<String, String> entry : states.entrySet()) {
                pw.println(entry.getKey() + "_" + entry.getValue());
            }
        } catch (Exception e) {
            Console.outError(e);

        }


    }
    */

}