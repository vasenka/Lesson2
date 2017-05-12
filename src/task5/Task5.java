package task5;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {

        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class MyFrame extends JFrame {
    StartPanel panel = new StartPanel();
    RecordPanel panel2 = new RecordPanel();
    ViewPanel panel3 = new ViewPanel();
    MarkPanel panel4 = new MarkPanel();
    CompareByStPanel panel5 = new CompareByStPanel();
    MyFrame(){
       // panel = new StartPanel();
        setSize(1000,500);
        setTitle("Disciplines");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu recordMenu = new JMenu("Records");
        menuBar.add(recordMenu);
        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);
        JMenu compareMenu = new JMenu("Compare");
        menuBar.add(compareMenu);
        JMenuItem discRec = new JMenuItem("Disciplines");
        recordMenu.add(discRec);
        JMenuItem markRec = new JMenuItem("Marks");
        recordMenu.add(markRec);
        JMenuItem byDiscView = new JMenuItem("Students by disciplines");
        viewMenu.add(byDiscView);
        JMenuItem byMarcCompare = new JMenuItem("by Student's marks");
        compareMenu.add(byMarcCompare);

        add(panel);
        discRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel3.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel2.setVisible(true);
                add(panel2);
            }
        });
       // add(panel);
        byDiscView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel2.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(false);
                panel3.setVisible(true);
                add(panel3);
            }
        });
        markRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel2.setVisible(false);
                panel3.setVisible(false);
                panel5.setVisible(false);
                panel4.setVisible(true);
                add(panel4);
            }
        });
        byMarcCompare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel2.setVisible(false);
                panel3.setVisible(false);
                panel4.setVisible(false);
                panel5.setVisible(true);
                add(panel5);
            }
        });
    }
}
enum Disciplines {
    MATH, PHISICS, MECHANICS, ENGLISH, CHEMESTRY, BIOLOGY;
    static void collectStudent(List<String> listOfStudents, String student){
        listOfStudents.add(student);
    }
}
class Student {
    String fio;

    List<String> discipline = new ArrayList<>();

    List<Integer> mark = new ArrayList<>();

   public Student(String fio, List<String> discipline, List<Integer> mark) {
        this.fio = fio;
        this.discipline = discipline;
        this.mark = mark;
    }

    @Override
    public String toString() {
        String res = "Student: " + fio + " ";
        for (int i=0;i<discipline.size();i++) {
            res = res + discipline.get(i)+"- " + mark.get(i) + "\n";
        }
        return res;
    }
}
class DiscMark {
    String disc;
    int markOfDisc;
    DiscMark(String disc, int markOfDisc){
        this.disc = disc;
        this.markOfDisc = markOfDisc;
    }

    @Override
    public String toString() {
        return disc+" - "+markOfDisc;
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
class RecordPanel extends JPanel {
    JLabel nameLabel;
    JTextField name;
    JButton button_add;
    JTextArea textWindow;

    static List<List<String>> arrayDiscStud = new ArrayList<>();
    RecordPanel() {
        setLayout(null);
        nameLabel = new JLabel("Ф.И.О. студента");
        name = new JTextField();
        button_add = new JButton("Add");
        textWindow = new JTextArea();
        nameLabel.setBounds(10,10,150,30);
        name.setBounds(120,10,300,30);
        button_add.setBounds(10, 100,100,30);
        textWindow.setBounds(10,150,500,400);
        add(nameLabel);
        add(name);

        JCheckBox[] box = new JCheckBox[Disciplines.values().length];

        List<String> studentChoice = new ArrayList<>();

        for (int i=0;i<Disciplines.values().length;i++) {
            int j = i;
            arrayDiscStud.add(new ArrayList<>());
            box[i] = new JCheckBox(Disciplines.values()[i].toString());
            box[i].setBounds(10+i*150,50,150,30);
            add(box[i]);
            box[i].addItemListener(new ItemListener() {
                boolean signed;
                @Override
                public void itemStateChanged(ItemEvent e) {
                    signed = !signed;
                    if (signed==true) {
                        Disciplines.collectStudent(arrayDiscStud.get(j), name.getText());
                        studentChoice.add(Disciplines.values()[j].toString());
                    }
                }
            });
        }

        add(button_add);
        add(textWindow);
        List<String> allSt = new ArrayList<>();

        button_add.addActionListener(new ActionListener() {
            int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                allSt.add(name.getText()+ " "+studentChoice);
                textWindow.append(allSt.get(i)+"\n");
                System.out.println(allSt.get(i));
                i++;
                for (int j=0;j<Disciplines.values().length;j++) {
                    box[j].setSelected(false);
                }
                studentChoice.clear();

            }
        });
    }
}
class ViewPanel extends JPanel {
    JButton button_view;
    JTextArea viewWindow;
    List<String> chosen = new ArrayList<>();
    int marked;
    ViewPanel(){
        setLayout(null);
        JCheckBox[] box = new JCheckBox[Disciplines.values().length];

        for (int i=0;i<Disciplines.values().length;i++) {
            int j = i;
            box[i] = new JCheckBox(Disciplines.values()[i].toString());
            box[i].setBounds(10+i*150,10,150,30);
            add(box[i]);
            box[i].addItemListener(new ItemListener() {
                boolean signed;
                @Override
                public void itemStateChanged(ItemEvent e) {
                    signed = !signed;
                    if (signed==true) {
                        chosen = RecordPanel.arrayDiscStud.get(j);
                        marked = j;
                    }
                }
            });
        }
        button_view = new JButton("View");
        button_view.setBounds(10, 50, 100,30);
        viewWindow = new JTextArea();
        viewWindow.setBounds(10,100,500,300);
        add(button_view);
        add(viewWindow);
        button_view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewWindow.setText("");
                for (int i=0;i<chosen.size();i++) {
                    viewWindow.append(chosen.get(i)+"\n");
                }
                System.out.println(chosen);
                box[marked].setSelected(false);
            }
        });
    }
}
class MarkPanel extends JPanel {
    JLabel nameLabel;
    JTextField name;
    JButton button_view;
    static List<Student> listSt = new ArrayList<>();
    List<String> disciplines = new ArrayList<>();
    List<Integer> markAr = new ArrayList<>();
    MarkPanel(){
        setLayout(null);
        nameLabel = new JLabel("Ф.И.О. студента");
        name = new JTextField();
        button_view = new JButton("View");
        nameLabel.setBounds(10,10,150,30);
        name.setBounds(120,10,300,30);
        button_view.setBounds(450,10,100,30);
        add(nameLabel);
        add(name);
        add(button_view);
        JCheckBox[] box = new JCheckBox[Disciplines.values().length];
        List<JTextField> marks = new ArrayList<>();

                JLabel labelMark = new JLabel("<===== Marks");
                labelMark.setBounds(900, 100,150,30);
                add(labelMark);
                JButton button_commit = new JButton("Committee");
                button_commit.setBounds(10,150,100,30);
                add(button_commit);
             for (int i=0;i<Disciplines.values().length;i++) {

                box[i] = new JCheckBox(Disciplines.values()[i].toString());
                box[i].setBounds(10+i*150,50,150,30);
                add(box[i]);
                 marks.add(new JTextField());
                 marks.get(i).setBounds(10+i*150,100,80,30);
                 add(marks.get(i));

               }
               button_view.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       for (int i=0;i<Disciplines.values().length;i++) {
                           if (!RecordPanel.arrayDiscStud.get(i).contains(name.getText())) {
                               box[i].setEnabled(false);
                           } else {
                               disciplines.add(Disciplines.values()[i].toString());
                               System.out.println(disciplines);
                               marks.get(i).setEditable(true);
                           }
                       }
                   }
               });

               button_commit.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       //set
                       for (int i=0;i<marks.size();i++) {
                           if (RecordPanel.arrayDiscStud.get(i).contains(name.getText())) {
                               if (marks.get(i).getText().equals("")) {
                                   markAr.add(0);
                               } else {
                                   markAr.add(Integer.parseInt(marks.get(i).getText()));
                               }
                               System.out.println(markAr);
                           }
                           box[i].setEnabled(true);
                           marks.get(i).setText("");
                           marks.get(i).setEditable(false);
                       }
                       List<String> disciplinesR = new ArrayList<>(disciplines);
                       List<Integer> markArR = new ArrayList<>(markAr);
                       listSt.add(new Student(name.getText(), disciplinesR, markArR ));
                       System.out.println(listSt);
                       disciplines.clear();
                       markAr.clear();
                   }
               });

    }
}
class CompareByStPanel extends JPanel {
    JLabel nameLabel;
    JTextField name;
    JTextArea textWindow;
    JButton button_compare;
    List<DiscMark> discMark = new ArrayList<>();
    MarkComparator markComparator = new MarkComparator();
    DiscComparator discComparator = new DiscComparator();
    BiComparator biComparator = new BiComparator(markComparator,discComparator);
    CompareByStPanel() {
        setLayout(null);
        nameLabel = new JLabel("Ф.И.О. студента");
        name = new JTextField();
        button_compare = new JButton("Compare marks");
        textWindow = new JTextArea();
        nameLabel.setBounds(10,10,150,30);
        name.setBounds(120,10,300,30);
        button_compare.setBounds(450,10,100,30);
        textWindow.setBounds(10, 50, 500, 300);
        add(nameLabel);
        add(name);
        add(button_compare);
        add(textWindow);
        button_compare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textWindow.setText("");
                discMark.clear();
                System.out.println(MarkPanel.listSt);
                for (int i = 0; i < MarkPanel.listSt.size(); i++) {
                    if (MarkPanel.listSt.get(i).fio.equals(name.getText())) {
                        for (int j = 0; j < MarkPanel.listSt.get(i).discipline.size(); j++) {
                            discMark.add(new DiscMark(MarkPanel.listSt.get(i).discipline.get(j), MarkPanel.listSt.get(i).mark.get(j)));
                        }
                    }
                }

                System.out.println("=======================");

                System.out.println(discMark);

                discMark.sort(biComparator);

                System.out.println("=======================");

                textWindow.setText(printArray(discMark));
            }
        });
    }
    static String printArray(List<DiscMark> discMarkArray) {
        String res = "";
        for (DiscMark bs : discMarkArray) {
            res = res+bs.toString()+"\n";
        }
        return res;
    }
}

class DiscComparator implements Comparator<DiscMark> {

    @Override
    public int compare(DiscMark o1, DiscMark o2) {
        return o1.disc.compareTo(o2.disc);
    }
}
class MarkComparator implements Comparator<DiscMark> {

    @Override
    public int compare(DiscMark o1, DiscMark o2) {
        int res;
        if (o1.markOfDisc==o2.markOfDisc) {
            res = 0;
        } else if (o1.markOfDisc>o2.markOfDisc) {
            res = 1;
        } else res = -1;
        return res;
    }
}
class BiComparator implements Comparator<DiscMark> {
    Comparator<DiscMark> cmp1;
    Comparator<DiscMark> cmp2;
    BiComparator(Comparator<DiscMark> cpm1, Comparator<DiscMark> cpm2) {
        this.cmp1 = cpm1;
        this.cmp2 = cpm2;
    }
    @Override
    public int compare(DiscMark o1, DiscMark o2) {
        int res = cmp1.compare(o1,o2);
        if (res==0) {
            res = cmp2.compare(o1,o2);
        }
        return res;
    }
}