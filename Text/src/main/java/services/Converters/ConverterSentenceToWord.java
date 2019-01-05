package services.Converters;

import elements.Text;
import elements.parts_sequence.Word;
import services.WordsCalculator.WordCalculator;

public class ConverterSentenceToWord implements Converter {

    private Converter converter;


    public void setNextConverter(Converter nextConverter) {
        this.converter = nextConverter;

    }

    public Text convert(Text text, String txt) {


        Text wordList = new Text();
        String[] words = (txt + " ").split(" ");//"\\p{P}?[ \\t\\n\\r]+"
        WordCalculator wordCalculator=new WordCalculator();

        for (String word : words) {
            wordCalculator.calculateWord(word);

            if (converter != null) {
                wordList.add(this.converter.convert(new Text(), wordCalculator.calculateWord(word) + " "));
            } else {
                wordList.add(new Word(wordCalculator.calculateWord(word) + " "));
            }
        }

        return wordList;
    }
}
