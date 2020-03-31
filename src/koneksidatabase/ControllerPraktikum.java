/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksidatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ASUS
 */
public class ControllerPraktikum {
    
    ModelPraktikum modelPraktikum;
    ViewPraktikum viewPraktikum;
    
    public ControllerPraktikum(ModelPraktikum modelPraktikum, ViewPraktikum viewPraktikum){
        this.modelPraktikum = modelPraktikum;
        this.viewPraktikum = viewPraktikum;
        
        if (modelPraktikum.getBanyakData() != 0){
            String dataMahasiswa[][] = modelPraktikum.readMahasiswa();
            viewPraktikum.tabel.setModel((new JTable(dataMahasiswa, viewPraktikum.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        viewPraktikum.btnTambahPanel.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(viewPraktikum.getNim().equals("")
                    || viewPraktikum.getNama().equals("")
                    || viewPraktikum.getAlamat().equals("")){
               JOptionPane.showMessageDialog(null, "Field Tidak Boleh Kosong");
        } else {
            String nim = viewPraktikum.getNim();
            String nama = viewPraktikum.getNama();
            String alamat = viewPraktikum.getAlamat();
            
            modelPraktikum.insertMahasiswa(nim, nama, alamat);
            viewPraktikum.tfNim.setText("");
            viewPraktikum.tfNamaMhs.setText("");
            viewPraktikum.tfAlamatMhs.setText("");
            
            String dataMahasiswa[][] = modelPraktikum.readMahasiswa();
            viewPraktikum.tabel.setModel(new JTable(dataMahasiswa, viewPraktikum.namaKolom).getModel());
            }
        }
    });
    
    viewPraktikum.tabel.addMouseListener(new MouseAdapter() {
       @Override
        public void mouseClicked(MouseEvent e) {
            int baris = viewPraktikum.tabel.getSelectedRow();
            int kolom = viewPraktikum.tabel.getSelectedColumn();
            
            String dataterpilih = viewPraktikum.tabel.getValueAt(baris, 0).toString();
            
            System.out.println(dataterpilih);
            
            int input = JOptionPane.showConfirmDialog(null, "Apa anda ingin menghapus NIM "+dataterpilih+ "?", "Pilih Opsi...",JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(input == 0){
                modelPraktikum.deleteMahasiswa(dataterpilih);
                
                String dataMahasiswa[][] = modelPraktikum.readMahasiswa();
                viewPraktikum.tabel.setModel(new JTable(dataMahasiswa, viewPraktikum.namaKolom).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
        }
    });
}
}

