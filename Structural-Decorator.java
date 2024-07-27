// Component Interface: The base interface for the text
interface Text {
    String getText();
}

// Concrete Component: The base implementation of the text
class PlainText implements Text {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

// Decorator: An abstract class implementing the component interface and containing a reference to a component object
abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public String getText() {
        return decoratedText.getText();
    }
}

// Concrete Decorators: Concrete implementations of the decorator that add specific formatting
class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<b>" + decoratedText.getText() + "</b>";
    }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<i>" + decoratedText.getText() + "</i>";
    }
}

class UnderlineDecorator extends TextDecorator {
    public UnderlineDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String getText() {
        return "<u>" + decoratedText.getText() + "</u>";
    }
}

// Client: The part of your application that uses the component interface
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create base text
        Text text = new PlainText("Hello, World!");

        // Apply decorators
        Text boldText = new BoldDecorator(text);
        Text italicText = new ItalicDecorator(boldText);
        Text underlinedText = new UnderlineDecorator(italicText);

        // Print the formatted text
        System.out.println(underlinedText.getText());
    }
}
