package com.kvv.start;

/**
 * Выставляется итоговая оценка за пройденное задание
 * @author Kukushkin V.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

class Final implements ActionListener {
    private static final int WINDOW_WIDTH = 600, WINDOW_HEIGHT = 565;
    private static final String ONE   = "1";
    private static final String TWO   = "2";
    private static final String THREE = "3";
    private static final String FOUR  = "4";
    private static final String FIVE  = "5";
    private static final String PUSTO = "";
    private static final String OUR_MARK = "Ваша оценка: ";
    private static JFrame win_final = new JFrame("Итоги");
    private static JPanel panel = new JPanel();
    private static JLabel headLine = new JLabel("Итоги");
    private static JLabel stat = new JLabel();
    private static JLabel t0 = new JLabel();
    private static JLabel mark = new JLabel();
    private static JLabel t1 = new JLabel(), t2 = new JLabel();
    private static JButton update = new JButton("Выбрать новое задание");
    private static Font gigant = new Font("Arial", Font.ITALIC, 70);
    private static Font textButton = new Font("Arial", Font.ITALIC, 14);
    private static Font head = new Font("Arial", Font.ITALIC, 22);
    private static Font speech = new Font("Arial", Font.ITALIC, 18);
    private static String text = "";
    private static Color color1 = new Color(255, 255, 100);
    private static String[] s = {
            "Очень печально...", "Не ожидал такого результата от Вас...",
            "Неудовлетворительный итог.", "Не отчаивайтесь, бывает и хуже, но реже.",
            "Удовлетворительно, но не хорошо.",
            "Хорошо, но не расслабляйтесь.", "Обратите внимание на допущенные ошибки.",
            "Молодчина! Так держать!"};

    static JFrame getWin_final() {
        return win_final;
    }

    Final() {
        win_final.setDefaultCloseOperation(HIDE_ON_CLOSE);
        win_final.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        win_final.setResizable(false);
        win_final.setLayout(null);
        win_final.add(panel);
        win_final.revalidate();
        win_final.repaint();
        win_final.setVisible(true);
        panel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panel.setBackground(color1);
        panel.setLayout(null);
        interfaceF();
        addListeners();
    }

    static void interfaceF() {
        headLine.setFont(head);
        headLine.setBounds(50, 20, 500, 50);
        headLine.setOpaque(true);
        headLine.setBackground(color1);
        headLine.setHorizontalAlignment(SwingConstants.CENTER);
        headLine.setVerticalAlignment(SwingConstants.CENTER);

        stat.setOpaque(true);
        stat.setBackground(color1);
        stat.setFont(speech);
        switch (Box.getYes()) {
            case 0: case 5: case 6: case 7: case 8: case 9: case 10:
                text = "ов";
                break;
            case 2: case 3: case 4:
                text = "а";
                break;
            default:
        }
        stat.setText("Вы правильно ответили на " + Box.getYes() + " вопрос" + text + " из " + Box.getLength() + ".");
        stat.setBounds(50, 100, 500, 50);
        stat.setHorizontalAlignment(SwingConstants.CENTER);
        stat.setVerticalAlignment(SwingConstants.CENTER);

        t0.setOpaque(true);
        t0.setBackground(color1);
        t0.setFont(speech);
        t0.setText(OUR_MARK);
        t0.setBounds(105, 160, 200, 48);
        t0.setHorizontalAlignment(SwingConstants.LEFT);
        t0.setVerticalAlignment(SwingConstants.CENTER);

        mark.setOpaque(true);
        mark.setBounds(275, 210, 50, 110);
        mark.setBackground(color1);
        mark.setHorizontalAlignment(SwingConstants.CENTER);
        mark.setVerticalAlignment(SwingConstants.CENTER);
        mark.setFont(gigant);
        if (Box.getYes() < 2) {
            mark.setText(ONE);
            mark.setForeground(Color.BLACK);
            t1.setText(s[0]);
            t2.setText(s[1]);
        } else if ((Box.getYes() >= 2) && (Box.getYes() < 5)) {
            mark.setText(TWO);
            mark.setForeground(Color.GRAY);
            t1.setText(s[2]);
            t2.setText(s[3]);
        } else if ((Box.getYes() >= 5) && (Box.getYes() < 7)) {
            mark.setText(THREE);
            mark.setForeground(Color.BLUE);
            t1.setText(s[4]);
            t2.setText("");
        } else if ((Box.getYes() >= 7) && (Box.getYes() < 9)) {
            mark.setText(FOUR);
            mark.setForeground(Color.GREEN);
            t1.setText(s[5]);
            t2.setText(s[6]);
        } else {
            mark.setText(FIVE);
            mark.setForeground(Color.RED);
            t1.setText(s[7]);
            t2.setText(PUSTO);
        }

        t1.setOpaque(true);
        t1.setBackground(color1);
        t1.setFont(speech);
        t1.setBounds(10, 330, 550, 40);
        t1.setHorizontalAlignment(SwingConstants.CENTER);
        t1.setVerticalAlignment(SwingConstants.CENTER);

        t2.setOpaque(true);
        t2.setBackground(color1);
        t2.setFont(speech);
        t2.setBounds(10, 372, 550, 40);
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        t2.setVerticalAlignment(SwingConstants.CENTER);

        update.setFont(textButton);
        update.setBounds(200, 440, 200, 40);
        update.setEnabled(true);
        panel.add(headLine);
        panel.add(stat);
        panel.add(t0);
        panel.add(mark);
        panel.add(t1);
        panel.add(t2);
        panel.add(update);
        panel.revalidate();
        panel.repaint();
    }

    private void addListeners() {
        update.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(update)) {
            Start.getP().removeAll();
            Start.getP().repaint();
            Box.setI(Start.ZERO);
            Box.setYes(Start.ZERO);
            Box.setYesObj(Box.getYes());
            Box.setNot(Start.ZERO);
            Box.setNotObj(Box.getNot());
            Box.counter.setText(
                    "<html>" + "<font color = \"00ff00\">" + Box.getYesObj().toString() + "</font>" +
                            " : " +
                            "<font color = \"ff0000\">" + Box.getNotObj().toString() + "</font>" + "</html>");
            Start.initMasResults();
            Start.interfaceStart();
            win_final.setVisible(false);
            Start.getP().setVisible(true);
        }
    }
}
