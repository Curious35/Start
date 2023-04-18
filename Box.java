package com.kvv.start;

/**
 *
 * @author Kukushkin V.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Box implements ActionListener {
    private static final int LENGTH = 10;
    private static final int DEEP = 4;
    private static int i = 0, yes = 0, not = 0;
    private static Integer yesObj = yes, notObj = not;

    static int getI() {
        return i;
    }

    static void setI(int i) {
        Box.i = i;
    }

    static int getYes() {
        return yes;
    }

    static void setYes(int yes) {
        Box.yes = yes;
    }

    static int getNot() {
        return not;
    }

    static void setNot(int not) {
        Box.not = not;
    }

    static Integer getYesObj() {
        return yesObj;
    }

    static void setYesObj(Integer yesObj) {
        Box.yesObj = yesObj;
    }

    static Integer getNotObj() {
        return notObj;
    }

    static void setNotObj(Integer notObj) {
        Box.notObj = notObj;
    }

    static int getLength() {return LENGTH;}

    /*
    Массивы с данными, соответствующие конкретному тесту
     */
    /*
    СТОЛИЦЫ ГОСУДАРСТВ: А
     */
    static String[] manyAsksG1 = {
            "Выберите столицу государства Непал",
            "Выберите столицу Новой Зеландии",
            "Столица Парагвая - это ...",
            "Стольный град Монголии",
            "Столица Мексики",
            "Столица Бразилии",
            "Столица Канады",
            "Столица Венесуэлы",
            "Столица Мали",
            "Столица Таджикистана"
    };
    static String[][] bufG1 ={
            {"Сува", "Нукуалофа", "Катманду", "Басра"},
            {"Окленд", "Веллингтон", "Касабланка", "Ашкелон"},
            {"Асунсьон", "Манагуа", "Порт-о-Пренс", "Карачи"},
            {"Нук", "Улан-Батор", "Пхеньян", "Хошимин"},
            {"Гранада", "Нджамена", "Панама", "Мехико"},
            {"Буэнос-Айрес", "Бразилиа", "Рио-де-Жанейро", "Тяньцзинь"},
            {"Ванкувер", "Оттава", "Тампа", "Орландо"},
            {"Барселона", "Луанда", "Лодзь", "Каракас"},
            {"Бамако", "Велкопоповице", "Цербст", "Кербела"},
            {"Атырау", "Бишкек", "Гётеборг", "Душанбе"}
    };

    static String[] answerG1 = {"Катманду", "Веллингтон", "Асунсьон", "Улан-Батор", "Мехико", "Бразилиа",
            "Оттава", bufG1[7][3], "Бамако", "Душанбе"};

    static String[] pathA = {Start.PATH_PHOTO + "Kathmandu_A.jpg",
            Start.PATH_PHOTO + "Wellington_A.jpg",
            Start.PATH_PHOTO + "Asuncion_A.jpg",
            Start.PATH_PHOTO + "Ulan-Bator_A.jpg",
            Start.PATH_PHOTO + "Mehico_A.jpg",
            Start.PATH_PHOTO + "Brasilia_A.jpg",
            Start.PATH_PHOTO + "Ottawa_A.jpg",
            Start.PATH_PHOTO + "Caracas_A.jpg",
            Start.PATH_PHOTO + "Bamako_A.jpg",
            Start.PATH_PHOTO + "Dushanbe_A.jpg"};

    static ImageIcon[] picturesG1A = {
            new ImageIcon(Start.class.getResource(pathA[0])),
            new ImageIcon(Start.class.getResource(pathA[1])),
            new ImageIcon(Start.class.getResource(pathA[2])),
            new ImageIcon(Start.class.getResource(pathA[3])),
            new ImageIcon(Start.class.getResource(pathA[4])),
            new ImageIcon(Start.class.getResource(pathA[5])),
            new ImageIcon(Start.class.getResource(pathA[6])),
            new ImageIcon(Start.class.getResource(pathA[7])),
            new ImageIcon(Start.class.getResource(pathA[8])),
            new ImageIcon(Start.class.getResource(pathA[9]))
    };

    /*
    Столицы государств_B
     */
    static String[] manyAsksGC_B = {
            "Какой город является столицей Палау?",
            "Столица Федеративных Штатов Микронезии.",
            "Столица Демократической Республики Конго.",
            "Введите столицу государства Лесото.",
            "Напишите столицу Южного Судана.",
            "... - это стольный град Сент-Китс и Невис.",
            "Главный город государства Сент-Винсент и Гренадины.",
            "Главный город в Соломоновых Островах.",
            "Столица королевства Бутан.",
            "Столица Республики Конго."
    };

    static String[] answerGC_B = {"Нгерулмуд", "Паликир", "Киншаса", "Масеру", "Джуба", "Бастер",
            "Кингстаун", "Хониара", "Тхимпху", "Браззавиль"};

    static String[] pathGC_B = {Start.PATH_PHOTO + "10_B.jpg",
            Start.PATH_PHOTO + "11_B.jpg",
            Start.PATH_PHOTO + "12_B.jpg",
            Start.PATH_PHOTO + "13_B.jpg",
            Start.PATH_PHOTO + "14_B.jpg",
            Start.PATH_PHOTO + "15_B.jpg",
            Start.PATH_PHOTO + "16_B.jpg",
            Start.PATH_PHOTO + "17_B.jpg",
            Start.PATH_PHOTO + "18_B.jpg",
            Start.PATH_PHOTO + "19_B.jpg"};

    static ImageIcon[] picturesGC_B = {
            new ImageIcon(Start.class.getResource(pathGC_B[0])),
            new ImageIcon(Start.class.getResource(pathGC_B[1])),
            new ImageIcon(Start.class.getResource(pathGC_B[2])),
            new ImageIcon(Start.class.getResource(pathGC_B[3])),
            new ImageIcon(Start.class.getResource(pathGC_B[4])),
            new ImageIcon(Start.class.getResource(pathGC_B[5])),
            new ImageIcon(Start.class.getResource(pathGC_B[6])),
            new ImageIcon(Start.class.getResource(pathGC_B[7])),
            new ImageIcon(Start.class.getResource(pathGC_B[8])),
            new ImageIcon(Start.class.getResource(pathGC_B[9]))
    };

    /*
    США_А
     */
    static String[] manyAsksHNA = {
            "В каком году началась война за независимость США?",
            "Первым президентом США избрали ...",
            "Сколько дней правил Джефферсон?",
            "Дата принятия Декларации независимости США",
            "Восстание Шейса началось в ... году",
            "Выберите годы Гражданской войны в США",
            "Время Англо-Американской войны.",
            "Самый первый штат США.",
            "Из скольких штатов состоит США?",
            "Период Великой депрессии"
    };
    static String[][] bufHNA ={
            {"1775", "1776", "1765", "1783"},
            {"Лафайета", "Монро", "Джефферсона", "Вашингтона"},
            {"2865", "2922", "31", "199"},
            {"4.07.1776", "14.07.1789", "9.11.1799", "22.08.1643"},
            {"1787", "1929", "1786", "1818"},
            {"1853-1856", "1861-1865", "1905-1907", "1789-1799"},
            {"1916-1919", "1912", "1926", "1812-1815"},
            {"Пенсильвания", "Вашингтон", "Делавэр", "Вермонт"},
            {"51", "50", "52", "49"},
            {"1929-1933", "1775-1783", "1929-1939", "1941"}
    };

    static String[] answerHNA = {bufHNA[0][0], bufHNA[1][3], bufHNA[2][1], bufHNA[3][0], bufHNA[4][2], bufHNA[5][1],
            bufHNA[6][3], bufHNA[7][2], bufHNA[8][1], bufHNA[9][2]};

    static String[] pathHNA = {Start.PATH_PHOTO + "1_A.jpg",
            Start.PATH_PHOTO + "2_A.jpg",
            Start.PATH_PHOTO + "3_A.jpg",
            Start.PATH_PHOTO + "4_A.jpg",
            Start.PATH_PHOTO + "5_A.jpg",
            Start.PATH_PHOTO + "6_A.jpg",
            Start.PATH_PHOTO + "7_A.jpg",
            Start.PATH_PHOTO + "8_A.jpg",
            Start.PATH_PHOTO + "9_A.png",
            Start.PATH_PHOTO + "10_A.jpg"};

    static ImageIcon[] picturesHNA = {
            new ImageIcon(Start.class.getResource(pathHNA[0])),
            new ImageIcon(Start.class.getResource(pathHNA[1])),
            new ImageIcon(Start.class.getResource(pathHNA[2])),
            new ImageIcon(Start.class.getResource(pathHNA[3])),
            new ImageIcon(Start.class.getResource(pathHNA[4])),
            new ImageIcon(Start.class.getResource(pathHNA[5])),
            new ImageIcon(Start.class.getResource(pathHNA[6])),
            new ImageIcon(Start.class.getResource(pathHNA[7])),
            new ImageIcon(Start.class.getResource(pathHNA[8])),
            new ImageIcon(Start.class.getResource(pathHNA[9]))
    };

    //USA_B
    static String[] manyAsksUSA_B = {
            "Какой штат США стал пятидесятым?",
            "Напишите название самого крупного по площади штата США",
            "Напишите фамилию 16-го президента США",
            "Укажите фамилию президента США, руководившего страной в 1901-1909 гг.",
            "В каком году Франклин Рузвельт стал президентом США?",
            "Как ещё называли Конфедеративные Штаты Америки (КША)?",
            "В каком году возникли Конфедеративные Штаты Америки?",
            "В каком году окончилась война за независимость США?",
            "Год капитуляции британских войск при Йорктауне",
            "Самый крупный город штата Пенсильвания"
    };

    static String[] answerUSA_B = {"Гавайи", "Аляска", "Линкольн", "Рузвельт", "1933", "Дикси",
            "1861", "1783", "1781", "Филадельфия"};

    static String[] pathUSA_B = {Start.PATH_PHOTO + "USA1_B.jpg",
            Start.PATH_PHOTO + "USA2_B.jpg",
            Start.PATH_PHOTO + "USA3_B.jpg",
            Start.PATH_PHOTO + "USA4_B.jpg",
            Start.PATH_PHOTO + "USA5_B.jpg",
            Start.PATH_PHOTO + "USA6_B.jpg",
            Start.PATH_PHOTO + "USA7_B.png",
            Start.PATH_PHOTO + "USA8_B.jpg",
            Start.PATH_PHOTO + "USA9_B.jpg",
            Start.PATH_PHOTO + "USA10_B.jpg"};

    static ImageIcon[] picturesUSA_B = {
            new ImageIcon(Start.class.getResource(pathUSA_B[0])),
            new ImageIcon(Start.class.getResource(pathUSA_B[1])),
            new ImageIcon(Start.class.getResource(pathUSA_B[2])),
            new ImageIcon(Start.class.getResource(pathUSA_B[3])),
            new ImageIcon(Start.class.getResource(pathUSA_B[4])),
            new ImageIcon(Start.class.getResource(pathUSA_B[5])),
            new ImageIcon(Start.class.getResource(pathUSA_B[6])),
            new ImageIcon(Start.class.getResource(pathUSA_B[7])),
            new ImageIcon(Start.class.getResource(pathUSA_B[8])),
            new ImageIcon(Start.class.getResource(pathUSA_B[9]))
    };

    //Россия, век XVII
    static String[] manyAsksHRXVII_A = {
            "Когда началось правление Василия Шуйского?",
            "Сколько лет продолжалось правление Михаила Романова?",
            "Кем был избран на царствование Михаил Романов?",
            "Какие годы относятся к периоду семибоярщины?",
            "В каком городе произошёл Медный бунт?",
            "Как прозвали царя Алексея Михайловича?",
            "Патриарх Московский и всея Руси в 1606-1612 годах",
            "В каком году был \"извержен\" с патриаршества Никон?",
            "Когда было принято Соборное уложение?",
            "Кто руководил Крымскими походами 1687, 1689 годов?"
    };
    static String[][] bufHRXVII_A ={
            {"29.05.1606", "29.05.1682", "27.03.1613", "23.04.1605"},
            {"4", "36", "34", "32"},
            {"Избранной радой", "Земским собором", "Синодом", "Опричниной"},
            {"1605-1610", "1610-1612", "1672-1682", "1632-1634"},
            {"Тула", "Рязань", "Москва", "Ярославль"},
            {"Грозный", "Полусахалинский", "Великий", "Тишайший"},
            {"Тихон", "Гермоген", "Филарет", "Игнатий"},
            {"1666", "1652", "1681", "1672"},
            {"12.01.1682", "9.06.1672", "1649", "27.04.1682"},
            {"Голицын", "Милославский", "Хованский", "Репнин"}
    };

    static String[] answerHRXVII_A = {bufHRXVII_A[0][0], bufHRXVII_A[1][3], bufHRXVII_A[2][1], bufHRXVII_A[3][1], bufHRXVII_A[4][2],
            bufHRXVII_A[5][3], bufHRXVII_A[6][1], bufHRXVII_A[7][0], bufHRXVII_A[8][2], bufHRXVII_A[9][0]};

    static String[] pathHRXVII_A = {Start.PATH_PHOTO + "XVII_1A.jpg",
            Start.PATH_PHOTO + "XVII_2A.jpg",
            Start.PATH_PHOTO + "XVII_3A.jpg",
            Start.PATH_PHOTO + "XVII_4A.jpg",
            Start.PATH_PHOTO + "XVII_5A.jpg",
            Start.PATH_PHOTO + "XVII_6A.jpg",
            Start.PATH_PHOTO + "XVII_7A.jpg",
            Start.PATH_PHOTO + "XVII_8A.jpg",
            Start.PATH_PHOTO + "XVII_9A.jpg",
            Start.PATH_PHOTO + "XVII_10A.jpg"};

    static ImageIcon[] picturesHRXVII_A = {
            new ImageIcon(Start.class.getResource(pathHRXVII_A[0])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[1])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[2])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[3])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[4])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[5])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[6])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[7])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[8])),
            new ImageIcon(Start.class.getResource(pathHRXVII_A[9]))
    };

    /*
    Россия, век XVII B
     */
    static String[] manyAsksHRXVII_B = {
            "В 1648 году в Москве вспыхнул ... бунт.",
            "С какого года Соборное уложение 1649 года утратило силу?",
            "Фамилия руководителя восстания 1606-1607 годов.",
            "В каком году к власти пришёл Лжедмитрий I?",
            "В каком году закончился период Смутного времени?",
            "Как в старину называлось взыскание с ответчика в пользу истца?",
            "Сколько лет Софья была правительницей-регентшей Российского царства?",
            "Год принятия \"Двенадцати статей\" царевны Софьи.",
            "Год заключения \"Вечного мира\" с Речью Посполитой.",
            "Год заключения Нерчинского договора с Империей Цин"
    };

    static String[] answerHRXVII_B = {"соляной", "1832", "Болотников", "1605", "1613", "Правёж",
            "7", "1685", "1686", "1689"};

    static String[] pathHRXVII_B = {Start.PATH_PHOTO + "XVII_1B.jpeg",
            Start.PATH_PHOTO + "XVII_2B.jpg",
            Start.PATH_PHOTO + "XVII_3B.jpg",
            Start.PATH_PHOTO + "XVII_4B.jpg",
            Start.PATH_PHOTO + "XVII_5B.jpg",
            Start.PATH_PHOTO + "XVII_6B.jpg",
            Start.PATH_PHOTO + "XVII_7B.jpg",
            Start.PATH_PHOTO + "XVII_8B.jpg",
            Start.PATH_PHOTO + "XVII_9B.jpg",
            Start.PATH_PHOTO + "XVII_10B.jpg"};

    static ImageIcon[] picturesHRXVII_B = {
            new ImageIcon(Start.class.getResource(pathHRXVII_B[0])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[1])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[2])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[3])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[4])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[5])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[6])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[7])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[8])),
            new ImageIcon(Start.class.getResource(pathHRXVII_B[9]))
    };

    /*
    Массивы с данными, заполняемые в зависимости от выбранного игроком теста
     */
    static volatile String[] manyAsksResult = new String[LENGTH];
    static volatile String[][] bufResult = new String[LENGTH][DEEP];
    static volatile String[] answerResult = new String[LENGTH];
    static volatile ImageIcon[] picturesResult = new ImageIcon[LENGTH];
    static volatile String[] pathResult = new String[LENGTH];
    static volatile boolean[] isRightResult = new boolean[LENGTH];

    static volatile boolean[] isWasPressed = new boolean[LENGTH];
    static volatile Color[][] rememberColor = new Color[LENGTH][DEEP];

    static String[] c = new String[LENGTH];
    static String[][] d = new String[LENGTH][DEEP];
    static ImageIcon[] im = new ImageIcon[LENGTH];

    /*
    ОБЩИЙ СЧЁТЧИК
     */
    static volatile JLabel counter = new JLabel(
            "<html>" + "<font color = \"00ff00\">" + yesObj.toString() + "</font>" +
                    " : " +
                    "<font color = \"ff0000\">" + notObj.toString() + "</font>" + "</html>");

    private static String headline = "";
    private static String textAbout = "\"Викторина\", версия 1.0. \nДата выпуска: декабрь 2018 года.\n" +
            "Разработчик: Кукушкин В. В.\nСоздатель благодарен кандидату технических наук, " +
            "профессору кафедры прикладной математики Вологодского государственного университета Свердлову Сергею Залмановичу " +
            "за полезные замечания, высказанные во время работы над \"Викториной\"";
    private String textRules =
            "<html>" +
                    "<style>" +
                    "<font size=4 face=\"Arial\">" +
                    "<ol>" +
                    "<li>" + "Запуская \"Викторину\", Вы попадаете на главную страницу приложения." + "</li>" +
                    "<li>" + "На ней участник викторины может выбрать интересующие его раздел, тему и уровень." + "</li>" +
                    "<li>" + "Раздел, тема и уровень однозначно определяют задание." + "</li>" +
                    "<li>" + "Нажатие на кнопку \"Готово\" открывает выбранное задание." + "</li>" +
                    "<li>" + "Тип задания зависит от выбранного уровня." + "</li>" +
                    "<ul>" +
                    "<li>" + "Если выбран уровень \"Попроще\", то участнику викторины откроется тест с четырьмя вариантами ответа, один" +
                    " и только один из которых правильный." + "</li>" +
                    "<li>" + "Если выбран уровень \"Посложнее\", то участнику викторины откроется задание с ограниченно-свободным ответом." +
                    " Ограниченно-свободным ответом считается единственное, занесённое в поле ввода слово или число. Если" +
                    " ответом по сути является число, которое можно записать одним словом, следует писать число, а не слово. " +
                    "В ответах, содержащих букву \"Ё\", её следует писать." + "</li>" +
                    "</ul>" +
                    "<li>" + "Всякое задание викторины состоит пока из десяти вопросов." + "</li>" +
                    "<li>" + "Переключаться между вопросами можно при помощи кнопок \"Вперёд\" и \"Назад\", а так же " +
                    "с помощью клавиатуры, нажимая соответственно RIGHT или LEFT." + "</li>" +
                    "<li>" + "Каждое задание снабжено счётчиком, учитывающим Ваши ответы. Количество правильных отмечается зелёным цветом, " +
                    "а неверных - красным." + "</li>" +
                    "<li>" + "Задание считается завершённым, если Вы ответили на все вопросы задания." + "</li>" +
                    "<li>" + "За каждое завершённое задание приложение ставит оценку по пятибалльной шкале." + "</li>" +
                    "<ul>" +
                    "<li>" + "Ставится единичка, если Вы правильно ответили лишь на один вопрос или не дали верных ответов вообще." + "</li>" +
                    "<li>" + "Приложение поставит оценку 2, если Вы правильно ответили на два, три или четыре вопроса." + "</li>" +
                    "<li>" + "\"Викторина\" оценит работу на тройку, если Вы дали верные ответы на пять или шесть вопросов." + "</li>" +
                    "<li>" + "Ответив правильно на семь или восемь вопросов, Вы получаете четвёрку." + "</li>" +
                    "<li>" + "В оставшихся случаях Вам ставится пятёрка." + "</li>" +
                    "</ul>" +
                    "<li>" + "\"Викторина\" снабжена меню. Для выбора пункта меню можно воспользоваться \"горячими\" клавишами." + "</li>" +
                    "<ul>" +
                    "<li>" + "Сочетание Ctrl + N переведёт Вас на главную страницу \"Викторины\"." + "</li>" +
                    "<li>" + "Сочетание Ctrl + E завершит работу \"Викторины\"." + "</li>" +
                    "<li>" + "Комбинация Ctrl + R откроет Правила." + "</li>" +
                    "<li>" + "Клавиши Ctrl + A покажут общую информацию о приложении." + "</li>" +
                    "</ul>" +
                    "</ol>" +
                    "</font>" +
                    "</style>" +
                    "</html>";

    /*
    ВЫБОР ПУНКТА МЕНЮ
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case Start.NEW:
                Start.getP().removeAll();
                Start.getP().repaint();
                i = Start.ZERO;
                yes = Start.ZERO;
                yesObj = yes;
                not = Start.ZERO;
                notObj = not;
                counter.setText(
                        "<html>" + "<font color = \"00ff00\">" + yesObj.toString() + "</font>" +
                                " : " +
                                "<font color = \"ff0000\">" + notObj.toString() + "</font>" + "</html>");
                Start.initMasResults();
                Start.interfaceStart();
                break;
            case Start.EXIT:
                System.exit(0);
                break;
            case Start.RULES:
                headline = "Правила \"Викторины\"";
                EditInterface.getTextLabel().removeAll();
                EditInterface.getTextLabel().repaint();
                EditInterface.interfaceRules(headline, textRules);
                EditInterface.getFrame().setVisible(true);
                break;
            case Start.ABOUT:
                headline = "О программе";
                EditInterface.getTextLabel().removeAll();
                EditInterface.getTextLabel().repaint();
                EditInterface.interfaceAbout(headline, textAbout);
                EditInterface.getFrame().setVisible(true);
                break;
            default:
        }
    }
}
