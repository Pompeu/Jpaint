
package jpaint.view;

import javax.swing.JButton;


public class MyJButton extends JButton {

    private int index = 0;

    public MyJButton(String text, int index) {
        super(text);
        setIndex(index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
