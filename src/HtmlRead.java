import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class HtmlRead implements ActionListener {

    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help, back;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextField t1;

    private JScrollPane scroll;
    private JTextField t2;
    private int WIDTH = 800;
    private int HEIGHT = 700;

    public JTextArea Results;

    public String keyword = "book";

    public String link = "https://www.milton.edu/";
    public ArrayList results = new ArrayList();


    public static void main(String[] args) {
        HtmlRead swingControlDemo = new HtmlRead();
        swingControlDemo.showEventDemo();
    }

    public HtmlRead() {
        prepareGUI();

    }
        /*try {
           // System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("href=")) {
                    if (line.contains(keyword)) {
                      //  System.out.println(line.contains("facebook"));
                        int sports = line.indexOf("sports");
                        int beginIndex = line.indexOf("href=");//begin equals href
                        String chop = line.substring(beginIndex + 6);
                        //System.out.println(chop);
                        int endIndex = (chop.indexOf("\""));
                        int finish = chop.indexOf("\'");
                        if (endIndex < 0) {
                            if(line.contains(keyword)) {
                                System.out.println(chop.substring(0, finish));
                                Results.append(chop.substring(0, finish));
                                Results.append("\n");
                            }
                        } else if (finish < 0) {
                            if(line.contains(keyword)) {
                                System.out.println(chop.substring(0, endIndex));
                                Results.append(chop.substring(0, endIndex));
                                Results.append("\n");
                            }
                        } else if (finish < endIndex) {
                            if(line.contains(keyword)) {
                                System.out.println(chop.substring(0, finish));
                                Results.append(chop.substring(0, finish));
                                Results.append("\n");
                            }
                        } else {
                            if(line.contains(keyword)) {
                            System.out.println(chop.substring(0, endIndex));
                                Results.append(chop.substring(0, endIndex));
                            Results.append("\n");
                        }
                        }


                        //String rid = line.substring(0,endIndex);
                        //System.out.println(rid);
                    }

                }
                //if(keyword.contains("href=")){

                }

            reader.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }*/


    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());

        Results = new JTextArea();
        Results.setSize(WIDTH, HEIGHT);
        scroll = new JScrollPane(Results, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scroll = new JScrollPane(Results) ;
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      //  scroll.add(Results);
//        mainFrame.add(scroll);



        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        back = new JMenu("Back");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        mb.add(back);
        //end menu at top

        t1 = new JTextField("URL:");
        t2 = new JTextField("Keyword:");
        t1.setBounds(8, 1, WIDTH - 10, HEIGHT - 2);
        t2.setBounds(8, 1, WIDTH - 10, HEIGHT - 2);

        mainFrame.add(mb);  //add menu bar
        mainFrame.add(t1);//add typing area
        mainFrame.add(t2);//add typing area
        mainFrame.setJMenuBar(mb); //set menu bar




        // statusLabel = new JLabel("hi", JLabel.CENTER);
        // statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout()); //set the layout of the pannel

        mainFrame.add(controlPanel, BorderLayout.NORTH);
        //mainFrame.add(statusLabel);
        mainFrame.add(scroll, BorderLayout.CENTER);
//        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton enterButton = new JButton("Search");

        enterButton.setActionCommand("Search");

        enterButton.addActionListener(new ButtonClickListener());


        controlPanel.add(t1);
        controlPanel.add(t2);
        controlPanel.add(enterButton);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            t1.cut();
        if (e.getSource() == paste)
            t1.paste();
        if (e.getSource() == copy)
            t1.copy();
        if (e.getSource() == selectAll)
            t1.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println(t1.getText());
            link = t1.getText();
            keyword = t2.getText();
            if (command.equals("Search")) {
                try {
                    // System.out.println();
                    System.out.print("hello \n");
                    URL url = new URL(link);
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(url.openStream())
                    );
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains("href=")) {
                            if (line.contains(keyword)) {
                                //  System.out.println(line.contains("facebook"));
                                int sports = line.indexOf("sports");
                                int beginIndex = line.indexOf("href=");//begin equals href
                                String chop = line.substring(beginIndex + 6);
                                //System.out.println(chop);
                                int endIndex = (chop.indexOf("\""));
                                int finish = chop.indexOf("\'");
                                if (endIndex < 0) {
                                    if (line.contains(keyword)) {
                                        System.out.println(chop.substring(0, finish));
                                        Results.append(chop.substring(0, finish));
                                        Results.append("\n");
                                    }
                                } else if (finish < 0) {
                                    if (line.contains(keyword)) {
                                        System.out.println(chop.substring(0, endIndex));
                                        Results.append(chop.substring(0, endIndex));
                                        Results.append("\n");
                                    }
                                } else if (finish < endIndex) {
                                    if (line.contains(keyword)) {
                                        System.out.println(chop.substring(0, finish));
                                        Results.append(chop.substring(0, finish));
                                        Results.append("\n");
                                    }
                                } else {
                                    if (line.contains(keyword)) {
                                        System.out.println(chop.substring(0, endIndex));
                                        Results.append(chop.substring(0, endIndex));
                                        Results.append("\n");
                                    }
                                }



                                //String rid = line.substring(0,endIndex);
                                //System.out.println(rid);
                            }


                        }
                        //if(keyword.contains("href=")){

                    }

                    reader.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
             //   statusLabel.setText("Results");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else if (command.equals("Dance")) {
                statusLabel.setText("Jessie Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
          //  scroll.add(Results);
           // mainFrame.add(scroll, BorderLayout.CENTER);
        }
    }
}

