package services.Converters;

import elements.Text;

public interface Converter<T> {

    void setNextConverter(Converter nextConverter);

    Text convert(Text text, String txt);
}
