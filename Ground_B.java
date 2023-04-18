package com.kvv.start;

/**
 * Уровень посложнее
 * @author Kukushkin V.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ground_B implements KeyListener {
    private static final int MAX_HOR_VALUE = 645;
    private static final int MAX_VERT_VALUE = 380;
    private static final String IS_RIGHT_ANSWER = "Правильно!";
    private static final String IS_BAD_ANSWER   = "Неверно!";
    private static final String RIGHT_ENABLED   = "Можете нажать на кнопку RIGHT";
    private static final String LEFT_ENABLED    = "Можете нажать на кнопку LEFT";
    private static final String FIELD_EDIT      = "Ответив, нажмите ENTER";
    private static final String PUSTO           = "";
    static Ground_B msg = new Ground_B();
    static String[] answerUser = new String[Box.manyAsksResult.length];//Хранит ответ игрока

    private static Font textButton = new Font("Arial", Font.ITALIC, 14);
    private static Font text = new Font("Arial", Font.ITALIC, 17);
    private static ImageIcon redCross  = new ImageIcon(Start.class.getResource(Start.PATH_PHOTO + "Redcross_B.png"));
    private static ImageIcon greenMark = new ImageIcon(Start.class.getResource(Start.PATH_PHOTO + "GreenMark_B.png"));
    private static JLabel mark = new JLabel();
    private static JLabel ask  = new JLabel();
    private static JLabel pictureB = new JLabel(Box.picturesResult[Box.getI()]);
    private static JButton next = new JButton(Start.FORWARD);
    private static JButton previous = new JButton(Start.BACK);
    private static JTextField tf = new JTextField(50);
    private boolean flag = false;

    private static void goBack() {
        if (Box.getI() == Box.manyAsksResult.length - 1)//i - текущий на момент нажатия на кнопку
            next.setEnabled(true);
        if (Box.getI() > 0) {
            Box.setI(Box.getI() - 1);//Устанавливаем текущий номер вопроса после нажания на кнопку
            if (!Box.isWasPressed[Box.getI()]){
                tf.setEditable(true);
                mark.setVisible(false);
            }
            if (Box.isWasPressed[Box.getI()] && answerUser[Box.getI()].equalsIgnoreCase(Box.answerResult[Box.getI()])){
                mark.setIcon(greenMark);
                mark.setVisible(true);
                mark.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + IS_RIGHT_ANSWER + "</font>" + "</html>");
                tf.setEditable(false);
            }
            else if (Box.isWasPressed[Box.getI()] && !answerUser[Box.getI()].equalsIgnoreCase(Box.answerResult[Box.getI()])) {
                mark.setIcon(redCross);
                mark.setVisible(true);
                mark.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + IS_BAD_ANSWER + "</font>" + "</html>");
                tf.setEditable(false);
            }
            pictureB.setIcon(Box.picturesResult[Box.getI()]);//картинка
            ask.setText(Box.manyAsksResult[Box.getI()]);//вопрос
            tf.setText(answerUser[Box.getI()]);//ответ игрока в строке ввода
        }
        if (Box.getI() == 0)
            previous.setEnabled(false);
        if (previous.isEnabled())
            previous.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + LEFT_ENABLED + "</font>" + "</html>");
        else
            previous.setToolTipText(null);
        next.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + RIGHT_ENABLED + "</font>" + "</html>");
        if (tf.isEditable())
            tf.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + FIELD_EDIT + "</font>" + "</html>");
        else
            tf.setToolTipText(null);
    }

    private static void goOn() {
        if (Box.getI() == 0)
            previous.setEnabled(true);
        if (Box.getI() < Box.manyAsksResult.length - 1) {
            Box.setI(Box.getI() + 1);
            if (!Box.isWasPressed[Box.getI()]){
                tf.setEditable(true);
                tf.requestFocus();
                mark.setVisible(false);
            }
            if (Box.isWasPressed[Box.getI()] && answerUser[Box.getI()].equalsIgnoreCase(Box.answerResult[Box.getI()])){
                mark.setIcon(greenMark);
                mark.setVisible(true);
                mark.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + IS_RIGHT_ANSWER + "</font>" + "</html>");
                tf.setEditable(false);
            }
            else if (Box.isWasPressed[Box.getI()] && !answerUser[Box.getI()].equalsIgnoreCase(Box.answerResult[Box.getI()])) {
                mark.setIcon(redCross);
                mark.setVisible(true);
                mark.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + IS_BAD_ANSWER + "</font>" + "</html>");
                tf.setEditable(false);
            }
            pictureB.setIcon(Box.picturesResult[Box.getI()]);
            ask.setText(Box.manyAsksResult[Box.getI()]);
            tf.setText(answerUser[Box.getI()]);
        }
        if (Box.getI() == Box.manyAsksResult.length - 1)
            next.setEnabled(false);
        if (next.isEnabled())
            next.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + RIGHT_ENABLED + "</font>" + "</html>");
        else
            next.setToolTipText(null);
        previous.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + LEFT_ENABLED + "</font>" + "</html>");
        if (tf.isEditable())
            tf.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + FIELD_EDIT + "</font>" + "</html>");
        else
            tf.setToolTipText(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    /*
    НАЖАТИЕ НА КЛАВИШИ ENTER, LEFT, RIGHT
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                if (!Box.isWasPressed[Box.getI()] && (!tf.getText().equals(PUSTO))) {
                    if (tf.getText().equalsIgnoreCase(Box.answerResult[Box.getI()])) {
                        Box.isRightResult[Box.getI()] = true;
                        mark.setIcon(greenMark);
                        mark.setVisible(true);
                        mark.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + IS_RIGHT_ANSWER + "</font>" + "</html>");
                        Box.setYes(Box.getYes() + 1);
                        Box.setYesObj(Box.getYes());
                    } else {
                        Box.isRightResult[Box.getI()] = false;
                        mark.setIcon(redCross);
                        mark.setVisible(true);
                        mark.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + IS_BAD_ANSWER + "</font>" + "</html>");
                        Box.setNot(Box.getNot() + 1);
                        Box.setNotObj(Box.getNot());
                    }
                    Box.counter.setText(
                            "<html>" + "<font color = \"00ff00\">" + Box.getYesObj().toString() + "</font>" +
                                    " : " +
                                    "<font color = \"ff0000\">" + Box.getNotObj().toString() + "</font>" + "</html>");
                    answerUser[Box.getI()] = tf.getText();
                    tf.setEditable(false);
                    tf.setToolTipText(null);
                    Box.isWasPressed[Box.getI()] = true;
                    if (Box.getYes() + Box.getNot() == Box.getLength()) {
                        Final.interfaceF();
                        Final.getWin_final().setVisible(true);
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                goBack();
                break;
            case KeyEvent.VK_RIGHT:
                goOn();
                break;
            default:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    void interfaceB(){
        ask.setFont(text);
        ask.setText(Box.manyAsksResult[Box.getI()]);
        ask.setBounds(20, 20, 640, 50);
        ask.setOpaque(true);
        ask.setBackground(Start.color);
        ask.setHorizontalAlignment(SwingConstants.CENTER);
        ask.setVerticalAlignment(SwingConstants.CENTER);
        pictureB.setIcon(Box.picturesResult[Box.getI()]);
        pictureB.setBackground(Start.color);
        pictureB.setOpaque(true);
        pictureB.setVerticalAlignment(SwingConstants.CENTER);
        pictureB.setLocation(20, 90);
        pictureB.setSize(MAX_HOR_VALUE, MAX_VERT_VALUE);
        tf.setBounds(150, 500, 400, 30);
        tf.setFont(text);
        if (tf.isEditable())
            tf.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + FIELD_EDIT + "</font>" + "</html>");
        mark.setBounds(580, 490, 50, 50);
        mark.setBackground(Start.color);
        mark.setOpaque(true);
        Box.counter.setBounds(300, 550, 100, 70);
        Box.counter.setOpaque(true);
        Box.counter.setBackground(Color.YELLOW);
        Box.counter.setHorizontalAlignment(SwingConstants.CENTER);
        Box.counter.setVerticalAlignment(SwingConstants.CENTER);
        Box.counter.setFont(text);
        next.setFont(textButton);
        next.setBounds(500, 550, 100, 40);
        next.setEnabled(true);
        if (next.isEnabled())
            next.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + RIGHT_ENABLED + "</font>" + "</html>");
        previous.setFont(textButton);
        previous.setBounds(100, 550, 100, 40);
        previous.setEnabled(false);
        Start.getP().add(ask);
        Start.getP().add(pictureB);
        Start.getP().add(tf);
        Start.getP().add(mark);
        Start.getP().add(Box.counter);
        Start.getP().add(previous);
        Start.getP().add(next);
        if (Box.isWasPressed[Box.getI()]) {
            tf.setText(answerUser[Box.getI()]);
            tf.setEditable(false);
            if (Box.isRightResult[Box.getI()])
                mark.setIcon(greenMark);
            else
                mark.setIcon(redCross);
            mark.setVisible(true);
        } else {
            tf.setEditable(true);
            tf.setText(PUSTO);
            tf.requestFocus();
            mark.setVisible(false);
        }
        if (!flag) {
            previous.addActionListener(e -> {
                goBack();
            });
            next.addActionListener(e -> {
                goOn();
            });
            tf.addKeyListener(this);
            previous.addKeyListener(this);
            next.addKeyListener(this);
            flag = true;
        }
    }
}
