/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_mvc;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
/**
 *
 * @author Satya
 */
public class View_mine extends JFrame{
    JPanel divnya = new JPanel();
    
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    Font font_isi = new Font("SanSerif", Font.PLAIN, 14);

    JLabel lnamanya = new JLabel("Nama anda : ");
    JTextField tfnama = new JTextField();

    JLabel lnimnya = new JLabel("NIM anda : ");
    JTextField tfnim = new JTextField();

    JLabel lalamatnya = new JLabel("Alamat anda : ");
    JTextArea taalamatnya = new JTextArea();
    
    JButton btn_tambah = new JButton("tambah");
    JButton btn_edit = new JButton("edit");
    JButton btn_hapus = new JButton("hapus");
    JButton btn_cancel = new JButton("cancel");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object Kolom[] = {"NIM","Nama","Alamat"};
    
    public View_mine(){
        tableModel = new DefaultTableModel(Kolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Latihan MVC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800,600);

       JLabel label = new JLabel("--INPUT DATA MAHASISWA--");
       divnya.add(label);
       label.setBounds(250, 20, 300, 20);
       label.setFont(fontt);

        add(divnya);
        divnya.setBackground(Color.PINK);
        divnya.setBounds(10,10,755,525);
        divnya.setLayout(null);

        divnya.add(lnamanya);
        lnamanya.setFont(font_isi);
        lnamanya.setBounds(250,80,90,25);
        divnya.add(tfnama);
        tfnama.setFont(font_isi);
        tfnama.setBackground(Color.BLACK);
        tfnama.setForeground(Color.WHITE);
        tfnama.setBounds(340,80,180,25);

        divnya.add(lnimnya);
        lnimnya.setBounds(250,120,90,25);
        lnimnya.setFont(font_isi);
        divnya.add(tfnim);
        tfnim.setFont(font_isi);
        tfnim.setBackground(Color.BLACK);
        tfnim.setForeground(Color.WHITE);
        tfnim.setBounds(340,120,180,25);

        divnya.add(lalamatnya);
        lalamatnya.setFont(font_isi);
        lalamatnya.setBounds(250,160,95,25);
        divnya.add(taalamatnya);
        taalamatnya.setFont(font_isi);
        taalamatnya.setBounds(340,160,180,100);
        taalamatnya.setBackground(Color.BLACK);
        taalamatnya.setForeground(Color.WHITE);
        taalamatnya.setLineWrap(true);
        taalamatnya.setWrapStyleWord(true);
        
        divnya.add(btn_tambah);
        btn_tambah.setFont(font_isi);
        btn_tambah.setBounds(180,280,90,20);

        divnya.add(btn_edit);
        btn_edit.setFont(font_isi);
        btn_edit.setBounds(280,280,90,20);
//        btn_edit.setEnabled(false);

        divnya.add(btn_hapus);
        btn_hapus.setFont(font_isi);
        btn_hapus.setBounds(380,280,90,20);
//        btn_hapus.setEnabled(false);

        divnya.add(btn_cancel);
        btn_cancel.setFont(font_isi);
        btn_cancel.setBounds(480,280,90,20);
        
        tabel.setBackground(Color.PINK);
        tabel.setForeground(Color.BLACK);
        divnya.add(scrollPane);
        scrollPane.setBackground(Color.PINK);
        scrollPane.setBounds(120, 320, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
//     public static void main(String[] args) {
//        new View_mine();
//    }

    public String getTfnama() {
        return tfnama.getText();
    }

    public String getTfnim() {
        return tfnim.getText();
    }

    public String getTaalamatnya() {
        return taalamatnya.getText();
    }
}
