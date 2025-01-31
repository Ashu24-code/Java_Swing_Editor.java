import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class JavaSwing extends JFrame {

    public static JFrame fr;
    public static FileOutputStream fos;
    public static PrintWriter pw;
    public static JavaSwing gd;
    public static JButton create, save, show;
    public static JTextField title, width, height, file;
    public static JTextArea code;
    public static JCheckBox frame, button, label, textField, textArea;
    public static JLabel tLabel, wLabel, hLabel, fLabel, info, coord;
    public static String s1, s2, s3, s4, s5, s6, s7, s8, s9, s, fileName;
    public int selection, cWidth, cHeight, fWidth, fHeight, mX, mY, nfWidth, nfHeight;
    public static int count, preSelect, check;

    public static void main(String[] args) {
        gd = new JavaSwing();
        gd.setVisible(true);
    }

    public JavaSwing() {
        fWidth = 800;
        fHeight = 570;
        nfWidth = 0;
        nfHeight = 0;
        cWidth = 0;
        cHeight = 0;
        mX = 0;
        mY = 0;
        count = 0;
        preSelect = -5;
        check = 0;

        fileName = "";
        setTitle("JAVA'S CONTROL SWING EDITOR");
        setSize(fWidth, fHeight);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        create = new JButton("Create");
        save = new JButton("Save");
        show = new JButton("Code");

        title = new JTextField();
        width = new JTextField();
        height = new JTextField();
        file = new JTextField();
        code = new JTextArea();

        tLabel = new JLabel("Title:");
        wLabel = new JLabel("Width:");
        hLabel = new JLabel("Height:");
        fLabel = new JLabel("File Name:");
        info = new JLabel("Ready...");
        coord = new JLabel("(0,0)");

        create.addActionListener(new ButtonListener());
        save.addActionListener(new ButtonListener());
        show.addActionListener(new ButtonListener());

        add(tLabel);
        add(wLabel);
        add(hLabel);
        add(create);
        add(title);
        add(width);
        add(height);
        add(file);
        add(fLabel);
        add(save);
        add(info);
        add(coord);
        add(show);

        tLabel.setBounds(10, 150, 80, 20);
        title.setBounds(10, 170, 80, 20);
        wLabel.setBounds(10, 200, 80, 20);
        width.setBounds(10, 220, 80, 20);
        hLabel.setBounds(10, 250, 80, 20);
        height.setBounds(10, 270, 80, 20);
        create.setBounds(10, 290, 100, 20);
        fLabel.setBounds(10, 320, 80, 20);
        file.setBounds(10, 340, 80, 20);
        save.setBounds(10, 360, 100, 20);
        coord.setBounds(10, 390, 80, 20);
        info.setBounds(10, 410, 80, 20);
        show.setBounds(10, 440, 100, 20);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.pink);
        g.fillRect(0, 0, 100, fHeight);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == create) {
                fileName = file.getText();
                cWidth = Integer.parseInt(width.getText());
                cHeight = Integer.parseInt(height.getText());
                selection = preSelect;
                info.setText("Created!");

            } else if (e.getSource() == save) {
                try {
                    String str = fileName + ".java";
                    fos = new FileOutputStream(str);
                    pw = new PrintWriter(fos);
                    s = "public class " + fileName + " {\n\n}";
                    pw.println(s);
                    pw.close();
                    info.setText("File Created!");
                } catch (Exception exc) {
                    info.setText("Error Saving File!");
                }
            } else if (e.getSource() == show) {
                if (check == 0) {
                    fr = new JFrame("Code Preview");
                    fr.setSize(350, 450);
                    fr.setLayout(new BorderLayout());
                    fr.setLocation(450, 0);
                    fr.add(new JScrollPane(code), BorderLayout.CENTER);
                    code.setText(s);
                    fr.setVisible(true);
                    check = 1;
                    show.setText("Hide");
                } else {
                    fr.dispose();
                    check = 0;
                    show.setText("Code");
                }
            }
        }
    }
}
