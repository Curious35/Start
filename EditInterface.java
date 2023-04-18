package com.kvv.start;

/**
 * Вспомогательное окно с правилами или окно "О программе"
 * @author Kukushkin V.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

class EditInterface implements ActionListener {
    private static final int WINDOW_WIDTH = 700, WINDOW_HEIGHT = 500;
    private static JFrame frame = new JFrame("Справка");
    private static JPanel panel = new JPanel();
    private static JLabel headLineLabel = new JLabel();
    private static JPanel textLabel = new JPanel();
    private static JEditorPane ep = new JEditorPane();
    private static JScrollPane sp = new JScrollPane(ep);
    private static JButton closeFrame = new JButton("Закрыть");
    private static JTextPane textArea = new JTextPane();
    private static Font head = new Font("Arial", Font.ITALIC, 22);
    private static Font line = new Font("Arial", Font.PLAIN, 14);
    private static Font textButton = new Font("Arial", Font.ITALIC, 14);
    private static Color color = new Color(80, 255, 140);

    static JFrame getFrame() {
        return frame;
    }

    static JPanel getTextLabel() {return textLabel;}

    EditInterface() {
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
        panel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        closeFrame.addActionListener(this);
    }

    /*
    О ПРОГРАММЕ
     */
    static void interfaceAbout(String formHeadline, String formText) {
        headLineLabel.setLayout(null);
        headLineLabel.setBackground(color);
        headLineLabel.setOpaque(true);
        headLineLabel.setBounds(0, 0, WINDOW_WIDTH, 80);
        headLineLabel.setFont(head);
        headLineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headLineLabel.setText(formHeadline);

        textLabel.setBackground(color);
        textLabel.setOpaque(true);
        textLabel.setBounds(0, 81, WINDOW_WIDTH, WINDOW_HEIGHT - headLineLabel.getHeight());
        textLabel.setLayout(null);
        textArea.setBounds(18, 50, 650, 250);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setAutoscrolls(true);
        textArea.setFont(line);
        textArea.setText(formText);
        closeFrame.setBounds(300, 320, 100, 40);
        closeFrame.setFont(textButton);
        closeFrame.setEnabled(true);
        closeFrame.setVisible(true);
        textLabel.add(textArea);
        textLabel.add(closeFrame);

        panel.add(headLineLabel);
        panel.add(textLabel);
        panel.revalidate();
        panel.repaint();
    }

    /*
    ПРАВИЛА
     */
    static void interfaceRules(String formHeadline, String formText) {
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        headLineLabel.setLayout(null);
        headLineLabel.setBackground(color);
        headLineLabel.setOpaque(true);
        headLineLabel.setBounds(0, 0, WINDOW_WIDTH, 80);
        headLineLabel.setFont(head);
        headLineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headLineLabel.setText(formHeadline);

        textLabel.setBackground(color);
        textLabel.setOpaque(true);
        textLabel.setBounds(0, 81, WINDOW_WIDTH, WINDOW_HEIGHT - headLineLabel.getHeight());
        textLabel.setLayout(null);
        textLabel.add(sp);
        sp.setBounds(18, 30, 650, 270);
        ep.setEditable(false);
        ep.setContentType("text/html");
        ep.setText(formText);
        ep.setCaretPosition(0);
        ep.revalidate();
        sp.repaint();
        closeFrame.setBounds(300, 320, 100, 40);
        closeFrame.setFont(textButton);
        closeFrame.setEnabled(true);
        closeFrame.setVisible(true);
        textLabel.add(closeFrame);
        panel.add(headLineLabel);
        panel.add(textLabel);
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(closeFrame))
            EditInterface.getFrame().setVisible(false);
    }
}
