package decorator;

public class DecoratorDemo {

    public static void main(String[] args) {

        Widget widget = new BorderDecorator(new BorderDecorator(new ScrollDecorator(new TextField(80, 24))));
        widget.draw();
    }
}
