package services.Sorters;

import elements.Element;
import elements.Text;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortParagraphs {

    public static List<Element> sortBySentence(Text text) {
        List<Element> txt = text.getElements();
        List<Element> list;


        return text.getElements().stream().sorted(Comparator.comparingInt(Element::getLength)).collect(Collectors.toList());
    }


}
