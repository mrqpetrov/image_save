package team.marvel;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class MainWindow extends JFrame {
public MainWindow (int width, int height){
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setSize(width,height);
getContentPane().setLayout(null);

JPanel panel1 = new JPanel(null);
JPanel panel2 = new JPanel(null);

JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
tabbedPane.setBounds(10,22,600,409);
getContentPane().add(tabbedPane);

setResizable(false);
tabbedPane.addTab("Панель загрузки", panel1);
JTextArea txtrEnterUrlHere = new JTextArea();
txtrEnterUrlHere.setText("Введите URL ...");
txtrEnterUrlHere.setBounds(10, 40, 580, 330);
panel1.add(txtrEnterUrlHere);

JButton btnGetImage = new JButton("Загрузить изображение");
btnGetImage.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    try {
        Main.setImage(new URL(txtrEnterUrlHere.getText()));
        System.out.println(Main.getImage());
    } catch (MalformedURLException e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Invalid URL or no internet connection!");

    }
      }
   });
        btnGetImage.setBounds(10, 11, 185, 23);
panel1.add(btnGetImage);

JButton btnGetFile = new JButton("Скачать файл");
btnGetFile.setBounds(433,11,157,23);
panel1.add(btnGetFile);
tabbedPane.addTab("Панель просмотра", panel2);

Choice choice = new Choice();
choice.setBounds(520,10,70,20);
panel2.add(choice);

choice.add("png");
choice.add("jpeg");

JLabel lblFormat = new JLabel("Формат");
lblFormat.setBounds(468,10,46,14);
panel2.add(lblFormat);

JButton btnView = new JButton("Посмотреть");
btnView.setBounds(10, 7,130,23);
panel2.add(btnView);

btnView = new JButton("Посмотреть");
btnView.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
    }
});

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(10, 41, 500, 309);
panel2.add(scrollPane);

panel1 = new JPanel();
((JScrollPane) scrollPane).setViewportView(panel1);
panel1.setLayout(new BorderLayout(0,0));

JLabel imageIcon = new JLabel("  ");
panel1.add(imageIcon, BorderLayout.CENTER);


    JMenuBar menuBar = new JMenuBar ();
    menuBar.setBounds(0,0,500,21);
    getContentPane().add (menuBar);

JMenu nnFile = new JMenu("Файл");
menuBar.add(nnFile);

JMenuItem itemSaveImage = new JMenuItem("Сохранить изображение");
nnFile.add(itemSaveImage);

JMenu nnOption = new JMenu("Опции");
menuBar.add(nnOption);
JMenuItem nnExit = new JMenuItem("Выйти");
nnOption.add(nnExit);
    setVisible(true);


}
}
