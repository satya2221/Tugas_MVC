/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_mvc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/**
 *
 * @author Satya
 */
public class Controller_mine {
    Model_mine modelnya;
    View_mine viewnya;
    String dataterpilih = null;
    int baris,kolom;
 
    public Controller_mine(View_mine view, Model_mine model) {
        this.modelnya = model;
        this.viewnya = view;

        if (modelnya.banyaknyaData() != 0) {
            String dataMahasiswa[][] = modelnya.tampilkanData();
            viewnya.tabel.setModel(new JTable(dataMahasiswa, viewnya.Kolom).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        viewnya.btn_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (viewnya.getTfnim().equals("")
                        || viewnya.getTfnama().equals("")
                        || viewnya.getTaalamatnya().equals("")) {
                    JOptionPane.showMessageDialog(null, "field kosong");
                } else {

                    String nim = viewnya.getTfnim();
                    String nama = viewnya.getTfnama();
                    String alamat = viewnya.getTaalamatnya();
                    modelnya.masukkanData(nama, nim, alamat);
                    viewnya.tfnim.setText("");
                    viewnya.tfnama.setText("");
                    viewnya.taalamatnya.setText("");

                    updateTable();              
                }
            }

        });
        viewnya.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                baris = viewnya.tabel.getSelectedRow();
                kolom = viewnya.tabel.getSelectedColumn();

                dataterpilih = viewnya.tabel.getValueAt(baris, 0).toString();
//                System.out.println(dataterpilih);
                if (dataterpilih != null) {
                    viewnya.btn_hapus.setEnabled(true);
//                    viewnya.btn_Edit.setEnabled(true);
                }
            }

        });

        viewnya.btn_hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (dataterpilih != null) {
                        modelnya.hapusData(dataterpilih);
                        updateTable();
                        viewnya.tfnim.setText("");
                        viewnya.tfnama.setText("");
                        viewnya.taalamatnya.setText("");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Gagal Hapus!");
                }
            }
        });
        viewnya.tabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                baris = viewnya.tabel.getSelectedRow();
                viewnya.tfnim.setText(viewnya.tabel.getValueAt(baris, 0).toString());
                viewnya.tfnama.setText(viewnya.tabel.getValueAt(baris, 1).toString());
                viewnya.taalamatnya.setText(viewnya.tabel.getValueAt(baris, 2).toString());
                dataterpilih = viewnya.tabel.getValueAt(baris, 0).toString();
//                System.out.println(dataterpilih);
                if (dataterpilih != null) {
                    viewnya.tfnim.setEnabled(false);
//                    viewnya.btn_Edit.setEnabled(true);
                }
            }
            
        }
        );
        viewnya.btn_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nim = viewnya.getTfnim();
                String nama = viewnya.getTfnama();
                String alamat = viewnya.getTaalamatnya();
                
                modelnya.updateData(nama, nim, alamat);
                viewnya.tfnim.setText("");
                viewnya.tfnama.setText("");
                viewnya.taalamatnya.setText("");
                
                updateTable();
            }
        }
        );
        viewnya.btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewnya.tfnim.setText("");
                viewnya.tfnama.setText("");
                viewnya.taalamatnya.setText("");
                dataterpilih=null;
            }
        });  
//          
   }
    private void updateTable() {
        String dataMahasiswa[][] = modelnya.tampilkanData();
        viewnya.tabel.setModel(new JTable(dataMahasiswa, viewnya.Kolom).getModel());
    }
}
