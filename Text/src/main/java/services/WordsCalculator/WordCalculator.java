package services.WordsCalculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class WordCalculator {

    public String calculateWord(String text)
    {
        String buff=text;
        if(checkWord(text))
        {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");

            try {
                buff=engine.eval(text).toString();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
        return buff;
    }
    private boolean checkWord(String text) {
        return text.contains("<<") || text.contains(">>");
    }

}
