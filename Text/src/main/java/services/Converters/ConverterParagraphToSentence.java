package services.Converters;

import elements.Sentence;
import elements.Text;


public class ConverterParagraphToSentence implements Converter {

    private Converter converter;

    public void setNextConverter(Converter nextConverter) {
        this.converter = nextConverter;

    }


    public Text convert(Text text, String txt) {
        Text centenceList = new Text();
        String[] sentences = txt.split("!|\\?|\\.");//"[.?!]"

        for (String sentence : sentences) {

            if (converter != null) {
                centenceList.add(this.converter.convert(new Text(), sentence));
            } else {

                centenceList.add(new Sentence(sentence));
            }
        }
        return centenceList;
    }
}
