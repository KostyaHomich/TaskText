package services.Converters;

import elements.Text;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void convert() {
        String text=
                "It has survived not only (five) centuries, " +
                        "but also the leap into 13<<2 electronic typesetting, " +
                        "remaining essentially unchanged." +

                        "    It was popularised in the 5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) " +
                        "with the release of Letraset sheets containing Lorem Ipsum passages," +
                        " and more recently with desktop publishing software like" +
                        " Aldus PageMaker including versions of Lorem Ipsum." +

                        "    It is a long established fact that a reader will" +
                        " be distracted by the readable content of a page when looking" +
                        " at its layout. The point of using Ipsum is that it has a more or less normal" +
                        " distribution of letters, as opposed to using Content here," +
                        " content here, making it look like readable English." +

                        "    It is a established fact that a reader will be of" +
                        " a page when looking at its layout." +

                        "    Bye.";

        ConverterTextToParagraph converterTextToParagraph=new ConverterTextToParagraph();
        ConverterParagraphToSentence converterParagraphToSentence=new ConverterParagraphToSentence();
        ConverterSentenceToWord converterSentenceToWord=new ConverterSentenceToWord();

        converterTextToParagraph.setNextConverter(converterParagraphToSentence);
        converterParagraphToSentence.setNextConverter(converterSentenceToWord);

        Text txt=converterTextToParagraph.convert(new Text(),text);

        System.out.println(txt.print());

    }
}