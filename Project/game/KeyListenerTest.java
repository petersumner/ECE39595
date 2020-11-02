package game;

import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyListenerTest implements KeyListener {
    
    JFrame frame;
    JTextField tf;
    JLabel lbl;
    JButton btn;

    public KeyListenerTest(){
        frame = new JFrame();
        lbl = new JLabel();
        tf = new JTextField();
        tf.addKeyListener(this);
        btn = new JButton("Clear");
        JPanel panel = new JPanel();
        panel.add(tf);
        panel.add(btn);

        frame.setLayout(new BorderLayout());
        frame.add(lbl, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        lbl.setText("You typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        lbl.setText("You pressed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        lbl.setText("You released: " + e.getKeyCode());
    }

    public static void main(String args[]){
        new KeyListenerTest();
    }
}
