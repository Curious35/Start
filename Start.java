package com.kvv.start;

/**
 * Начальная страница
 * @author Kukushkin V.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Start implements ActionListener {

    private static final int WINDOW_WIDTH = 700, WINDOW_HEIGHT = 700;
    static final int ZERO = 0;
    private static final String PUSTO = "";
    private static final String SPACE = " ";
    private static final String NAME  = "Викторина";
    private static final String TEST  =
            "<html><font size=4 face=\"Arial\"><u>З</u>" + SPACE + "а" + SPACE + "д" + SPACE + "а" + SPACE + "н" + SPACE + "и" + SPACE + "е</font></html>";
    private static final String HELP  =
            "<html><font size=4 face=\"Arial\"><u>С</u>" + SPACE + "п" + SPACE + "р" + SPACE + "а" + SPACE + "в" + SPACE + "к" + SPACE + "а</font></html>";
    static final String NEW     = "<html><font size=4 face=\"Arial\">Новое задание</font></html>";
    static final String EXIT    = "<html><font size=4 face=\"Arial\">Выход</font></html>";
    static final String RULES   = "<html><font size=4 face=\"Arial\">Правила \"Викторины\"</font></html>";
    static final String ABOUT   = "<html><font size=4 face=\"Arial\">О программе</font></html>";

    private static final String NONE       = "<html><font size=4 face=\"Arial\" color=\"RED\">Не выбран</font></html>";
    private static final String GEOGRAPHY  = "<html><font size=4 face=\"Arial\">География</font></html>";
    private static final String HISTORY    = "<html><font size=4 face=\"Arial\">История</font></html>";

    private static final String CAPITALS = "<html><font size=4 face=\"Arial\">Столицы государств</font></html>";
    private static final String USA      = "<html><font size=4 face=\"Arial\">США</font></html>";
    private static final String R_XVII   = "<html><font size=4 face=\"Arial\">Россия, век XVII</font></html>";
    private static final String LIGHT_G  = "<html><font size=4 face=\"Arial\">Попроще</font></html>";
    private static final String HARD_G   = "<html><font size=4 face=\"Arial\">Посложнее</font></html>";

    private static final String ONE_CB   = "1. Выберите раздел: ";
    private static final String TWO_CB   = "2. Выберите тему: ";
    private static final String THREE_CB = "3. Выберите степень сложности: ";
    private static final String GOTOVO_ENABLED = "Выберите раздел";

    static final String PATH_PHOTO = "/";

    static final String BACK    = "Назад";
    static final String FORWARD = "Вперёд";

    private static JFrame win = new JFrame(NAME);

    private static KeyStroke newMenu   = KeyStroke.getKeyStroke("control N");
    private static KeyStroke exitMenu  = KeyStroke.getKeyStroke("control E");
    private static KeyStroke rulesMenu = KeyStroke.getKeyStroke("control R");
    private static KeyStroke aboutMenu = KeyStroke.getKeyStroke("control A");

    private static JMenuBar menuBar = new JMenuBar();
    private static JMenu file = new JMenu(TEST);
    private static JMenu help = new JMenu(HELP);
    private static JMenuItem newTest = new JMenuItem(NEW);
    private static JMenuItem exit    = new JMenuItem(EXIT);
    private static JMenuItem rights  = new JMenuItem(RULES);
    private static JMenuItem about   = new JMenuItem(ABOUT);

    private static String[] dataR      = {NONE, GEOGRAPHY, HISTORY};
    private static String[] geographyT = {CAPITALS};
    private static String[] historyT   = {USA, R_XVII};
    private static String[] groundT    = {LIGHT_G, HARD_G};

    private static JPanel p = new JPanel();
    private static JButton gotovo = new JButton("Готово");
    private static JLabel label = new JLabel("В И К Т О Р И Н А");
    private static JLabel r = new JLabel(ONE_CB);
    private static JLabel t = new JLabel(TWO_CB);
    private static JLabel g = new JLabel(THREE_CB);
    private static JComboBox<String> razdel = new JComboBox<>(dataR);
    private static JComboBox<String> tema   = new JComboBox<>();
    private static JComboBox<String> ground = new JComboBox<>(groundT);
    private static Font headlineText = new Font("Arial", Font.BOLD, 30);
    private static Font textButton   = new Font("Arial", Font.ITALIC, 14);
    private static Font otherText    = new Font("Arial", Font.ITALIC, 17);
    private static String textR = "", textT = "", textG = "";

    static Color color = new Color(0, 220, 0);

    private static int index = 1;

    /*
    Методы класса
     */
    static JPanel getP() {
        return p;
    }

    static void initMasResults() {
        Box.manyAsksResult = Box.c;
        Box.answerResult = Box.c;
        for (int m = 0; m < 10; m++)
            Ground_B.answerUser[m] = PUSTO;
        Box.bufResult = Box.d;
        Box.pathResult = Box.c;
        Box.picturesResult = Box.im;
        for (int j = 0; j < Box.manyAsksResult.length; j++) {
            Box.isWasPressed[j] = false;
            Box.isRightResult[j] = false;
            for (int k = 0; k < Box.bufResult[Box.getI()].length; k++)
                Box.rememberColor[j][k] = Ground_A.getBaseColor();
        }
    }

    /*
    ОБРАБОТКА НАЖАТИЯ НА КНОПКУ "ГОТОВО" И ВЫБОРА РАЗДЕЛА
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        gotovo.setToolTipText(null);
        if (e.getSource().equals(razdel))
            switch ((String) Objects.requireNonNull(razdel.getSelectedItem())) {
                case GEOGRAPHY:
                    tema.setModel(new DefaultComboBoxModel<>(geographyT));
                    tema.setEnabled(true);
                    gotovo.setEnabled(true);
                    break;
                case HISTORY:
                    tema.setModel(new DefaultComboBoxModel<>(historyT));
                    tema.setEnabled(true);
                    gotovo.setEnabled(true);
                    break;
                default:
                    gotovo.setEnabled(false);
                    if (!gotovo.isEnabled())
                        gotovo.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + GOTOVO_ENABLED + "</font>" + "</html>");
            }
        else {
            if ((Objects.requireNonNull(ground.getSelectedItem())).equals(groundT[0]))
                index = 1;
            else
                index = 2;
            p.removeAll();
            p.repaint();
            if (!(Objects.requireNonNull(razdel.getSelectedItem())).toString().equals(NONE)) {
                textR = (String) razdel.getSelectedItem();
                initMasResults();
                switch ((String) razdel.getSelectedItem()) {
                    case GEOGRAPHY:
                        switch ((String) Objects.requireNonNull(tema.getSelectedItem())) {
                            case CAPITALS:/*СТОЛИЦЫ ГОСУДАРСТВ*/
                                textT = (String) tema.getSelectedItem();
                                switch ((String) Objects.requireNonNull(ground.getSelectedItem())) {
                                    case LIGHT_G:/*ПОПРОЩЕ*/
                                        textG = (String) ground.getSelectedItem();
                                        Box.manyAsksResult = Box.manyAsksG1;
                                        Box.bufResult = Box.bufG1;
                                        Box.answerResult = Box.answerG1;
                                        Box.pathResult = Box.pathA;
                                        Box.picturesResult = Box.picturesG1A;
                                        Box.setI(ZERO);
                                        Ground_A.mp.interfaceA();
                                        break;
                                    case HARD_G:/*ПОСЛОЖНЕЕ*/
                                        textG = (String) ground.getSelectedItem();
                                        Box.manyAsksResult = Box.manyAsksGC_B;
                                        Box.answerResult = Box.answerGC_B;
                                        Box.pathResult = Box.pathGC_B;
                                        Box.picturesResult = Box.picturesGC_B;
                                        Box.setI(ZERO);
                                        Ground_B.msg.interfaceB();
                                        p.repaint();
                                        break;
                                    default:
                                }
                                break;
                            default:
                        }
                        break;
                    case HISTORY:
                        switch ((String) Objects.requireNonNull(tema.getSelectedItem())) {
                            case USA:/*США*/
                                textT = (String) tema.getSelectedItem();
                                switch ((String) Objects.requireNonNull(ground.getSelectedItem())) {
                                    case LIGHT_G:/*ПОПРОЩЕ*/
                                        textG = (String) ground.getSelectedItem();
                                        Box.manyAsksResult = Box.manyAsksHNA;
                                        Box.bufResult = Box.bufHNA;
                                        Box.answerResult = Box.answerHNA;
                                        Box.pathResult = Box.pathHNA;
                                        Box.picturesResult = Box.picturesHNA;
                                        Box.setI(ZERO);
                                        Ground_A.mp.interfaceA();
                                        break;
                                    case HARD_G:/*ПОСЛОЖНЕЕ*/
                                        textG = (String) ground.getSelectedItem();
                                        Box.manyAsksResult = Box.manyAsksUSA_B;
                                        Box.answerResult = Box.answerUSA_B;
                                        Box.pathResult = Box.pathUSA_B;
                                        Box.picturesResult = Box.picturesUSA_B;
                                        Box.setI(ZERO);
                                        Ground_B.answerUser = Box.c;
                                        Ground_B.msg.interfaceB();
                                        p.repaint();
                                        break;
                                    default:
                                }
                                break;
                            case R_XVII:/*Россия, век XVII*/
                                textT = (String) tema.getSelectedItem();
                                switch ((String) Objects.requireNonNull(ground.getSelectedItem())) {
                                    case LIGHT_G:/*ПОПРОЩЕ*/
                                        textG = (String) ground.getSelectedItem();
                                        Box.manyAsksResult = Box.manyAsksHRXVII_A;
                                        Box.bufResult = Box.bufHRXVII_A;
                                        Box.answerResult = Box.answerHRXVII_A;
                                        Box.pathResult = Box.pathHRXVII_A;
                                        Box.picturesResult = Box.picturesHRXVII_A;
                                        Box.setI(ZERO);
                                        Ground_A.mp.interfaceA();
                                        break;
                                    case HARD_G:/*ПОСЛОЖНЕЕ*/
                                        textG = (String) ground.getSelectedItem();
                                        Box.manyAsksResult = Box.manyAsksHRXVII_B;
                                        Box.answerResult = Box.answerHRXVII_B;
                                        Box.pathResult = Box.pathHRXVII_B;
                                        Box.picturesResult = Box.picturesHRXVII_B;
                                        Box.setI(ZERO);
                                        Ground_B.msg.interfaceB();
                                        p.repaint();
                                        break;
                                    default:
                                }
                                break;
                            default:
                        }
                        break;
                    default:
                }
                razdel.setModel(new DefaultComboBoxModel<>(dataR));
            }
        }
    }

    private Start(JFrame frame) {
        Box mb = new Box();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(p);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setVisible(true);
        p.setLayout(null);
        frame.setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(help);
        file.add(newTest);
        newTest.setAccelerator(newMenu);
        file.add(exit);
        exit.setAccelerator(exitMenu);
        help.add(rights);
        rights.setAccelerator(rulesMenu);
        help.add(about);
        about.setAccelerator(aboutMenu);
        newTest.addActionListener(mb);
        exit.addActionListener(mb);
        rights.addActionListener(mb);
        about.addActionListener(mb);
        razdel.setName("JCB1");
        tema.setName("JCB2");
        gotovo.addActionListener(this);
        razdel.addActionListener(this);
        new Final();
        Final.getWin_final().setVisible(false);
        new EditInterface();
        EditInterface.getFrame().setVisible(false);
        interfaceStart();
    }

    static void interfaceStart() {
        p.setBackground(color);
        label.setFont(headlineText);
        label.setOpaque(false);
        label.setBackground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(100, 40,500, 100);
        r.setFont(otherText);
        r.setBounds(150, 190, 300, 40);
        r.setBackground(Color.YELLOW);
        r.setOpaque(false);
        t.setFont(otherText);
        t.setBounds(150, 305, 300, 40);
        t.setBackground(Color.YELLOW);
        t.setOpaque(false);
        g.setFont(otherText);
        g.setBounds(150, 410, 300, 40);
        g.setBackground(Color.YELLOW);
        g.setOpaque(false);
        razdel.setBounds(150, 240, 400, 40);
        tema.setBounds(150, 355, 400, 40);
        tema.setEnabled(false);
        ground.setBounds(150, 460, 400, 40);
        gotovo.setFont(textButton);
        gotovo.setBounds(300, 555, 100, 40);
        gotovo.setEnabled(false);
        if (!gotovo.isEnabled())
            gotovo.setToolTipText("<html>" + "<font size=4 face=\"Arial\">" + GOTOVO_ENABLED + "</font>" + "</html>");
        p.add(label);
        p.add(r);
        p.add(razdel);
        p.add(t);
        p.add(tema);
        p.add(g);
        p.add(ground);
        p.add(gotovo);
        p.revalidate();
        p.repaint();
    }

    public static void main(String[] args){
        new Start(win);
    }
}
