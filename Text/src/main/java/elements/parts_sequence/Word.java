package elements.parts_sequence;

import elements.Element;

public class Word implements Element {


    private String text;

    public Word(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String print() {
        return text;
    }

    @Override
    public int getLength() {
        return text.length();
    }
}