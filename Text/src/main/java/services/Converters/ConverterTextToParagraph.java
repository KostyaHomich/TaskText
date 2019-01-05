package services.Converters;

import elements.Paragraph;
import elements.Text;

public class ConverterTextToParagraph implements Converter {
    private Converter converter;

    public void setNextConverter(Converter nextConverter) {
        this.converter = nextConverter;

    }

    public Text convert(Text text, String txt) {

        Text paragraphList = new Text();

        String[] paragraphs = txt.split("    ");
        for (String paragraph : paragraphs) {

            if (converter != null) {
                paragraphList.add(this.converter.convert(new Text(), paragraph));
            } else {

                paragraphList.add(new Paragraph(paragraph));
            }

        }


        return paragraphList;
    }
}
