package algorithms;

/**
 * Created by kgp on 2017/3/8.
 */
public interface I18nMessage<T extends Number> {


    String getKey();

    void setText(String message);

    T getCode();

    String getText();
}
