package com.kvv.start;

/**
 * Уровень попроще
 * @author Kukushkin V.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ground_A extends KeyAdapter implements ActionListener {
    private static final int MAX_HOR_VALUE = 450;
    private static final int MAX_VERT_VALUE = 400;
    private static final Color BASE_COLOR = new Color(238, 238, 238);
    private static final String RIGHT_ENABLED   = "Можете нажать на кнопку RIGHT";
    private static final String LEFT_ENABLED    = "Можете нажать на кнопку LEFT";

    static Ground_A mp = new Ground_A();

    private static int j = 0;
    private static ButtonGroup bg = new ButtonGroup();
    private static JRadioButton one   = new JRadioButton();
    private static JRadioButton two   = new JRadioButton();
    private static JRadioButton three = new JRadioButton();
    private static JRadioButton four  = new JRadioButton();
    private static Font textButton = new Font("Arial", Font.ITALIC, 14);
    private static JLabel ask      = new JLabel();
    private static JLabel pictureA = new JLabel(Box.picturesResult[Box.getI()]);
    private static JButton next     = new JButton(Start.FORWARD);
    private static JButton previous = new JButton(Start.BACK);
    private boolean flag = false;

    private static void goBack() {
        if (Box.getI() == Box.manyAsksG1.length - 1)
            next.setEnabled(true);
        if (Box.getI() > 0) {
            Box.setI(Box.getI() - 1);
            if (!Box.isWasPressed[Box.getI()]){
                buttonSetEnabled(true);
                setBaseColor();
                bg.clearSelection();
            }
            if (Box.isWasPressed[Box.getI()]){
                useRememberColor(Box.getI(), 0);
                setSelectJRB();
                buttonSetEnabled(false);
            }
            j = 0;
            buttonSetText(Box.getI(), j);
            pictureA.setIcon(Box.picturesResult[Box.getI()]);
            ask.setText(Box.manyAsksResult[Box.getI()]);
        }
        if (Box.getI() == 0)
            previous.setEnabled(false);
        if (Box.getI() == 0)
            previous.setEnabled(false);
        if (previous.isEnabled())
            previous.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + LEFT_ENABLED + "</font>" + "</html>");
        else
            previous.setToolTipText(null);
        next.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + RIGHT_ENABLED + "</font>" + "</html>");
    }

    private static void goOn() {
        if (Box.getI() == 0)
            previous.setEnabled(true);
        if (Box.getI() < Box.manyAsksG1.length - 1) {
            Box.setI(Box.getI() + 1);
            if (!Box.isWasPressed[Box.getI()]){
                buttonSetEnabled(true);
                setBaseColor();
                bg.clearSelection();
            }
            if (Box.isWasPressed[Box.getI()]){
                useRememberColor(Box.getI(), 0);
                setSelectJRB();
                buttonSetEnabled(false);
            }
            j = 0;
            buttonSetText(Box.getI(), j);
            pictureA.setIcon(Box.picturesResult[Box.getI()]);
            ask.setText(Box.manyAsksResult[Box.getI()]);
        }
        if (Box.getI() == Box.manyAsksG1.length - 1) {
            next.setEnabled(false);
            previous.requestFocusInWindow();
        }
        if (next.isEnabled())
            next.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + RIGHT_ENABLED + "</font>" + "</html>");
        else
            next.setToolTipText(null);
        previous.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + LEFT_ENABLED + "</font>" + "</html>");
    }

    private static void initJRB(JRadioButton jrb, String s, int y){
        jrb.setText(s);
        jrb.setFont(textButton);
        jrb.setBounds(500, y, 150, 40);
    }

    private static void fillRememberColor(JRadioButton jrb, int k, int m){
        if (jrb == one) {
            Box.rememberColor[k][m]   = one.getBackground();
            Box.rememberColor[k][++m] = BASE_COLOR;
            Box.rememberColor[k][++m] = BASE_COLOR;
            Box.rememberColor[k][++m] = BASE_COLOR;
        } else if (jrb == two){
            Box.rememberColor[k][m]   = BASE_COLOR;
            Box.rememberColor[k][++m] = two.getBackground();
            Box.rememberColor[k][++m] = BASE_COLOR;
            Box.rememberColor[k][++m] = BASE_COLOR;
        } else if (jrb == three){
            Box.rememberColor[k][m]   = BASE_COLOR;
            Box.rememberColor[k][++m] = BASE_COLOR;
            Box.rememberColor[k][++m] = three.getBackground();
            Box.rememberColor[k][++m] = BASE_COLOR;
        } else if (jrb == four){
            Box.rememberColor[k][m]   = BASE_COLOR;
            Box.rememberColor[k][++m] = BASE_COLOR;
            Box.rememberColor[k][++m] = BASE_COLOR;
            Box.rememberColor[k][++m] = four.getBackground();
        }
    }

    private static void useRememberColor(int k, int m){
        one.setBackground(Box.rememberColor[k][m]);
        two.setBackground(Box.rememberColor[k][++m]);
        three.setBackground(Box.rememberColor[k][++m]);
        four.setBackground(Box.rememberColor[k][++m]);
    }

    private static void buttonSetEnabled(boolean flag){
        one.setEnabled(flag);
        two.setEnabled(flag);
        three.setEnabled(flag);
        four.setEnabled(flag);
    }

    private static void buttonSetText(int k, int m){
        one.setText(Box.bufResult[k][m]);
        two.setText(Box.bufResult[k][++m]);
        three.setText(Box.bufResult[k][++m]);
        four.setText(Box.bufResult[k][++m]);
    }

    private static void setBaseColor(){
        if (one.getBackground() != BASE_COLOR)
            one.setBackground(BASE_COLOR);
        if (two.getBackground() != BASE_COLOR)
            two.setBackground(BASE_COLOR);
        if (three.getBackground() != BASE_COLOR)
            three.setBackground(BASE_COLOR);
        if (four.getBackground() != BASE_COLOR)
            four.setBackground(BASE_COLOR);
    }

    private static void setSelectJRB() {
        int buf = 0;
        while (Box.rememberColor[Box.getI()][buf] == BASE_COLOR)
            buf++;
        switch (buf) {
            case 0:
                one.setSelected(true);
                break;
            case 1:
                two.setSelected(true);
                break;
            case 2:
                three.setSelected(true);
                break;
            case 3:
                four.setSelected(true);
                break;
            default:
                break;
        }
    }

    static Color getBaseColor() {
        return BASE_COLOR;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                goBack();
                break;
            case KeyEvent.VK_RIGHT:
                goOn();
                break;
            default:
        }
    }

    /*
    ОБРАБОТКА НАЖАТИЯ МЫШЬЮ НА КНОПКУ КЛАССА JRadioButton
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Box.isWasPressed[Box.getI()] = true;
        if (e.getActionCommand().equals(Box.answerResult[Box.getI()])) {
            if (e.getSource() == one)
                one.setBackground(Color.GREEN);
            else if (e.getSource() == two)
                two.setBackground(Color.GREEN);
            else if (e.getSource() == three)
                three.setBackground(Color.GREEN);
            else if (e.getSource() == four)
                four.setBackground(Color.GREEN);
            Box.setYes(Box.getYes() + 1);
            Box.setYesObj(Box.getYes());
        }
        else {
            if (e.getSource() == one)
                one.setBackground(Color.RED);
            else if (e.getSource() == two)
                two.setBackground(Color.RED);
            else if (e.getSource() == three)
                three.setBackground(Color.RED);
            else if (e.getSource() == four)
                four.setBackground(Color.RED);
            Box.setNot(Box.getNot() + 1);
            Box.setNotObj(Box.getNot());
        }
        Box.counter.setText(
                "<html>" + "<font color = \"00ff00\">" + Box.getYesObj().toString() + "</font>" +
                        " : " +
                        "<font color = \"ff0000\">" + Box.getNotObj().toString() + "</font>" + "</html>");
        buttonSetEnabled(false);
        fillRememberColor((JRadioButton) e.getSource(), Box.getI(), 0);
        if (Box.getYes() + Box.getNot() == Box.getLength()) {
            Final.interfaceF();
            Final.getWin_final().setVisible(true);
        }
    }

    void interfaceA() {
        Font text = new Font("Arial", Font.ITALIC, 17);
        Start.getP().setBackground(Color.LIGHT_GRAY);
        bg.clearSelection();
        ask.setFont(text);
        ask.setText(Box.manyAsksResult[Box.getI()]);
        ask.setBounds(50, 20, 600, 50);
        ask.setOpaque(true);
        ask.setBackground(Color.YELLOW);
        ask.setHorizontalAlignment(SwingConstants.CENTER);
        ask.setVerticalAlignment(SwingConstants.CENTER);
        pictureA.setIcon(Box.picturesResult[Box.getI()]);
        pictureA.setVerticalAlignment(SwingConstants.TOP);
        pictureA.setLocation(20, 100);
        pictureA.setSize(MAX_HOR_VALUE, MAX_VERT_VALUE);
        pictureA.setOpaque(true);
        pictureA.setBackground(Color.LIGHT_GRAY);
        Box.counter.setBounds(300, 550, 100, 70);
        Box.counter.setOpaque(true);//Делаем компонент JLabel непрозрачным
        Box.counter.setBackground(Color.YELLOW);
        Box.counter.setHorizontalAlignment(SwingConstants.CENTER);//Размещение текста по центру
        Box.counter.setVerticalAlignment(SwingConstants.CENTER);
        Box.counter.setFont(text);
        next.setFont(textButton);
        next.setBounds(500, 550, 100, 40);
        next.setEnabled(true);
        next.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + RIGHT_ENABLED + "</font>" + "</html>");
        previous.setFont(textButton);
        previous.setBounds(100, 550, 100, 40);
        previous.setEnabled(false);
        initJRB(one,   Box.bufResult[0][0], 150);
        initJRB(two,   Box.bufResult[0][1], 200);
        initJRB(three, Box.bufResult[0][2], 250);
        initJRB(four,  Box.bufResult[0][3], 300);
        bg.add(one);
        bg.add(two);
        bg.add(three);
        bg.add(four);
        Start.getP().add(ask);
        Start.getP().add(pictureA);
        Start.getP().add(one);
        Start.getP().add(two);
        Start.getP().add(three);
        Start.getP().add(four);
        Start.getP().add(previous);
        Start.getP().add(Box.counter);
        Start.getP().add(next);
        if (Box.isWasPressed[0]) {
            setSelectJRB();
            buttonSetEnabled(false);
        } else {
            buttonSetEnabled(true);
            bg.clearSelection();
        }
        useRememberColor(0, 0);
        if (!flag) {
            previous.addActionListener(e -> {
                goBack();
            });
            next.addActionListener(e -> {
                goOn();
            });
            one.addActionListener(this);
            two.addActionListener(this);
            three.addActionListener(this);
            four.addActionListener(this);
            one.addKeyListener(this);
            next.addKeyListener(this);
            previous.addKeyListener(this);
            flag = true;
        }
        next.requestFocusInWindow();
    }
}
