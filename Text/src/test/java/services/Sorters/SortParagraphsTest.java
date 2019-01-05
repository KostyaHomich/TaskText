package services.Sorters;

import elements.Element;
import elements.Paragraph;
import elements.Text;
import org.junit.Test;
import services.Converters.ConverterParagraphToSentence;
import services.Converters.ConverterSentenceToWord;
import services.Converters.ConverterTextToParagraph;

import java.util.List;

public class SortParagraphsTest {

    @Test
    public void sortBySentence() {
        String text=  "    \nBye."+
                "\nIt has survived not only (five) centuries, " +
                        "but also the leap into electronic typesetting, " +
                        "remaining essentially unchanged." +

                        "    \nIt was popularised in the 5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) " +
                        "with the release of Letraset sheets containing Lorem Ipsum passages," +
                        " and more recently with desktop publishing software like" +
                        " Aldus PageMaker including versions of Lorem Ipsum." +

                        "    \nIt is a long established fact that a reader will" +
                        " be distracted by the readable content of a page when looking" +
                        " at its layout!The point of using Ipsum is that it has a more or less normal" +
                        " distribution of letters, as opposed to using Content here," +
                        " content here, making it look like readable English." +

                        "    \nIt is a established fact that a reader will be of" +
                        " a page when looking at its layout.";

        ConverterTextToParagraph converterTextToParagraph=new ConverterTextToParagraph();
        ConverterParagraphToSentence converterParagraphToSentence=new ConverterParagraphToSentence();
        ConverterSentenceToWord converterSentenceToWord=new ConverterSentenceToWord();

        converterTextToParagraph.setNextConverter(converterParagraphToSentence);
        converterParagraphToSentence.setNextConverter(converterSentenceToWord);

        Text txt=converterTextToParagraph.convert(new Text(),text);

        System.out.println("After sort "+txt.print());

        List<Element> txtSorted=SortParagraphs.sortBySentence(txt);
        txt.setElements(txtSorted);

        System.out.println("Before sort "+txt.print());

    }
}