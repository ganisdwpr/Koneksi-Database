/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksidatabase;

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewPraktikum extends JFrame {
    
    JLabel lNim = new JLabel("NIM   : ");
    JTextField tfNim = new JTextField();
    JLabel lNamaMhs = new JLabel("Nama Mahasiswa : ");
    JTextField tfNamaMhs = new JTextField();
    JLabel lAlamatMhs = new JLabel("Alamat Mahasiswa : ");
    JTextField tfAlamatMhs = new JTextField();
    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnEditPanel = new JButton("Edit");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM", "Nama", "Alamat"};
    
    public ViewPraktikum() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(550, 520);
        setLocation(720,320);
        
        add(lNim);
        lNim.setBounds(5, 5, 90, 20);
        add(tfNim);
        tfNim.setBounds(110, 5, 120, 20);
        add(lNamaMhs);
        lNamaMhs.setBounds(5, 30, 90, 20);
        add(tfNamaMhs);
        tfNamaMhs.setBounds(110, 30, 120, 20);
        add(lAlamatMhs);
        lAlamatMhs.setBounds(5, 55, 90, 20);
        add(tfAlamatMhs);
        tfAlamatMhs.setBounds(110, 55, 120, 20);
        add(btnTambahPanel);
        btnTambahPanel.setBounds(20, 105, 90, 20);
        add(btnBatalPanel);
        btnBatalPanel.setBounds(130, 105, 90, 20);    
        
        add(scrollPane);
        scrollPane.setBounds(20, 145, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public String getNim(){
        return tfNim.getText();
    }
    public String getNama(){
        return tfNamaMhs.getText();
    }
    public String getAlamat(){
        return tfAlamatMhs.getText();
    }
}
