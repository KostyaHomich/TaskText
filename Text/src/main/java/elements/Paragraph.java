package elements;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Element {
    private List<Element> elements = new ArrayList<Element>();
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public void add(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    public Element getElement(int index) {
        return elements.get(index);
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Element element : elements) {
            stringBuilder.append(element.print());
        }
        return stringBuilder.toString();
    }

    @Override
    public int getLength() {
        return elements.size();
    }

    public String getText() {
        return text;
    }
}
