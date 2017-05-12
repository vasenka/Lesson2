package task2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Task2 {
    public static void main(String[] args) throws IOException {

        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
class MyFrame extends JFrame {
    PanelCalculate panel = new PanelCalculate();
    PanelCheck panel2 = new PanelCheck();
    ViewPanel panel4 = new ViewPanel();
    HelpPanel panel5 = new HelpPanel();
    StartPanel panel3 = new StartPanel();
    MyFrame() throws IOException {

        setSize(1000, 500);
        setTitle("Учет канцтоваров сотрудников");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu newRecordMenu = new JMenu("New record");

        JMenu checkMenu = new JMenu("Check");
        JMenu viewMenu = new JMenu("View");
        JMenuItem helpMenu = new JMenuItem("Help");

        menuBar.add(newRecordMenu);

        menuBar.add(checkMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        JMenuItem newRec = new JMenuItem("New Record");
        newRecordMenu.add(newRec);

        JMenuItem checkByName = new JMenuItem("By Name/#Table");
       checkMenu.add(checkByName);

        JMenuItem view = new JMenuItem("View all");
        viewMenu.add(view);

        add(panel3);

        newRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e5) {
                System.out.println("entered");

                panel.setVisible(true);
                panel2.setVisible(false);
                panel3.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel.setVisible(true);
                add(panel);

            }
        });

        checkByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("entered2");

                panel.setVisible(false);
                panel3.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel2.setVisible(true);
                add(panel2);
            }
        });
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel3.setVisible(false);
                panel2.setVisible(false);
                panel5.setVisible(false);
                panel4.setVisible(true);
                add(panel4);
            }
        });

        helpMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel3.setVisible(false);
                panel2.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(true);
                add(panel5);
            }
        });

    }
}
class PanelCheck extends JPanel {
    static JTextField nameOf;
    JLabel nameLabelOf;
    static JTextField table;
    JLabel tableLabel;
    JTextArea taOf;
    JButton but;

    PanelCheck() throws IOException {
        setLayout(null);
        nameOf = new JTextField(10);
        nameLabelOf = new JLabel("Фамилия");
        table = new JTextField(10);
        tableLabel = new JLabel(" или # стола");
        taOf = new JTextArea();
        but = new JButton("Check");
        nameOf.setBounds(10,10,100,30);
        nameLabelOf.setBounds(120,10,100,30);

        tableLabel.setBounds(250,10,100,30);
        table.setBounds(360,10,100,30);
        but.setBounds(10,50,100,30);
        taOf.setBounds(10,100,200,200);


        add(nameOf);
        add(nameLabelOf);
        add(table);
        add(tableLabel);
        add(but);

        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File file;
                if (PanelCheck.nameOf.getText().equals("")) {
                    file = new File("src/task2/Table#"+PanelCheck.table.getText() + ".txt");
                } else {
                    file = new File("src/task2/"+PanelCheck.nameOf.getText() + ".txt");
                }

                try {
                    if (!file.exists()) {
                        taOf.setText("Файл еще не заведен!");
                    }
                    BufferedReader bf = new BufferedReader(new FileReader(file));
                    String s;
                    String s2 = "";
                    while ((s = bf.readLine())!= null) {
                        s2 = s2+s+"\n";
                    }
                    taOf.setText(s2);
                }catch (IOException e7) {}
            }
        });
        add(taOf);
    }
}
class PanelCalculate extends JPanel {
    static JTextField name;
    JLabel nameLabel;
    static JTextField table;
    JLabel tableLabel;
    JTextField tf;
    JLabel lb;
    JTextField tf2;
    JLabel lb2;
    JTextField tf3;
    JLabel lb3;
    JButton button;
    static JTextArea ta;
    PanelCalculate() {
        setLayout(null);
        name = new JTextField(10);
        nameLabel = new JLabel("Фамилия");
        table = new JTextField(10);
        tableLabel = new JLabel(" или # стола");
        tf = new JTextField(10);
        lb = new JLabel("Линейка");
        tf2 = new JTextField(10);
        lb2 = new JLabel("Ручка");
        tf3 = new JTextField(10);
        lb3 = new JLabel("Карандащ");
        button = new JButton("Добавить");
        ta = new JTextArea();
        nameLabel.setBounds(10,10,100,30);
        name.setBounds(120,10,100,30);

        tableLabel.setBounds(250,10,100,30);
        table.setBounds(360,10,100,30);

        lb.setBounds(10,50,100,30);
        tf.setBounds(120,50,100,30);
        lb2.setBounds(10,100,100,30);
        tf2.setBounds(120,100,100,30);
        lb3.setBounds(10,150,100,30);
        tf3.setBounds(120,150,100,30);
        button.setBounds(10,200,100,30);
        ta.setBounds(10,250,200,200);
        add(nameLabel);
        add(name);
        add(tableLabel);
        add(table);
        add(tf);
        add(lb);
        add(tf2);
        add(lb2);
        add(tf3);
        add(lb3);
        add(button);
        add(ta);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(table.getText());
                ta.setText("Линейка - "+tf.getText()+" шт\n Ручка - "+tf2.getText()+" шт\n " +
                        "Карандаш - " + tf3.getText() + " шт\n " +
                        "Общая стоимость: "+Price.getPrice(Integer.parseInt(tf.getText()),Integer.parseInt(tf2.getText()),Integer.parseInt(tf3.getText())));
           try {
               Price.writeToFile();
           }catch (IOException e2) {}

            }
        });

    }

}
class StartPanel extends JPanel {
    JLabel label;
    String photo = "up1_EPAM1.jpg";
    StartPanel() {
        Image img = Toolkit.getDefaultToolkit().getImage(photo);
        label = new JLabel();
        label.setIcon(new ImageIcon(img));
        add(label);
    }
}
class ViewPanel extends JPanel{
    JTextArea ta;
    JLabel label;
    JButton but_show;
    ViewPanel() throws IOException {
        setLayout(null);
        label = new JLabel("Список всех учтенных:");
        ta = new JTextArea();
        but_show = new JButton("Show");

        label.setBounds(10,10,300,30);
        ta.setBounds(10,50,300,400);

        but_show.setBounds(320,10,100,30);
        System.out.println(ta.getText());
        add(label);

        add(but_show);
        add(ta);
        but_show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("src/task2/all.txt");
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    BufferedReader bf = new BufferedReader(new FileReader(file));
                    String s;
                    String s2 = "";
                    while ((s = bf.readLine()) != null) {
                        s2 = s2 + s + "\n";
                    }
                    ta.setText(s2);
                   // add(ta);
                }catch (IOException e2) {}
            }
        });
    }
}
class HelpPanel extends JPanel {
    JTextArea ta;
    HelpPanel(){
        ta = new JTextArea("Данное приложение позволяет производить запись \n" +
                "количества канц.товаров на рабочем столе в зависимости от\n"+
        "фамилии сотрудника или от номера рабочего стола,\n " +
                "стоимость рассчитывается\n"+
        "тут же и записывается в файл. \n"+"\n"+
        "Также можно по фамилии или номеру стола проверить список \n" +
                "учтенных канц.товаров и их общую стоимость.\n"+"\n"+
        "И можно вывести на экран список фамилий/столов, которые уже учтены.\n"+
        "!!! После выхода из программы данные сохраняются!!!");
        add(ta);
    }
}
class Price {
    static final double LINPRICE = 50;
    static final double PENPRICE = 10;
    static final double PENCILPRICE = 5;
    static double getPrice(int numLin, int numPen, int numPencil) {
        return numLin*LINPRICE+numPen*PENPRICE+numPencil*PENCILPRICE;
    }
    static void writeToFile() throws IOException {
        File file;
        if (PanelCalculate.name.getText().equals("")) {
            file = new File("src/task2/Table#"+PanelCalculate.table.getText() + ".txt");
            WriteAll.writeAll("Table#"+PanelCalculate.table.getText());
        } else {
            file = new File("src/task2/"+PanelCalculate.name.getText() + ".txt");
            WriteAll.writeAll(PanelCalculate.name.getText());
        }
        PrintWriter out = new PrintWriter(file);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            out.print(PanelCalculate.ta.getText());


        } catch (IOException e) {

        }finally {
            out.close();
        }
    }
}
class WriteAll {
    static void writeAll(String info)throws IOException {
        File fileAll = new File("src/task2/all.txt");

        FileWriter outAll = new FileWriter(fileAll, true);
        try{
            if (!fileAll.exists()) {
                fileAll.createNewFile();
            }
            outAll.write(info+"\n");
        }catch (IOException e) {}
        finally {
            outAll.close();
        }
    }
}