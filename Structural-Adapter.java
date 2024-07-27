// Target Interface: The interface expected by the client (your application)
interface Shape {
    void draw(int x, int y, int width, int height);
}

// Adaptee: The third-party library's interface
class LegacyRectangle {
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        System.out.println("Drawing rectangle from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
    }
}

// Adapter: Implements the Target interface and translates the calls to the Adaptee
class RectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw(int x, int y, int width, int height) {
        int x2 = x + width;
        int y2 = y + height;
        legacyRectangle.drawRectangle(x, y, x2, y2);
    }
}

// Client: The part of your application that uses the Target interface
public class AdapterPatternExample {
    public static void main(String[] args) {
        Shape rectangle = new RectangleAdapter(new LegacyRectangle());
        rectangle.draw(10, 20, 30, 40);
    }
}
