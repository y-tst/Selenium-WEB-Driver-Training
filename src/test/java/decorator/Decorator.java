package decorator;

public class Decorator implements  Widget{

    private Widget widget;

    public Decorator(Widget widget) {
        this.widget = widget;
    }

    public void draw() {
        widget.draw();
    }
}
