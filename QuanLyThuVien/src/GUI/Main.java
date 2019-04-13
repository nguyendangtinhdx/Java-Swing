/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DLL.DocGiaDLL;
import DLL.MuonTraDLL;
import DLL.SachDLL;
import DLL.ThongKeNguoiMuonDLL;
import DLL.ThongKeNguoiMuonQuaHanDLL;
import DLL.ThongKeSachChuaDuocMuonDLL;
import DLL.ThongKeSachDaMuonDLL;

import Entity.DocGia;
import Entity.MuonTra;
import Entity.Sach;
import Entity.ThongKeNguoiMuon;
import Entity.ThongKeNguoiMuonQuaHan;
import Entity.ThongKeSachChuaDuocMuon;
import Entity.ThongKeSachDaMuon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    MuonTraDLL mtDLL = new MuonTraDLL();
    ArrayList<MuonTra> listMT = new ArrayList<>();
    DocGiaDLL dgDLL = new DocGiaDLL();
    ArrayList<DocGia> listDG = new ArrayList<>();
    SachDLL sDLL = new SachDLL();
    ArrayList<Sach> listS = new ArrayList<>();
    
    ThongKeNguoiMuonDLL tknmDLL = new ThongKeNguoiMuonDLL();
    ArrayList<ThongKeNguoiMuon> listTKNM = new ArrayList<>();
    
    ThongKeNguoiMuonQuaHanDLL tknmqhDLL = new ThongKeNguoiMuonQuaHanDLL();
    ArrayList<ThongKeNguoiMuonQuaHan> listTKNMQH = new ArrayList<>();
    
    ThongKeSachDaMuonDLL tksdmDLL = new ThongKeSachDaMuonDLL();
    ArrayList<ThongKeSachDaMuon> listTKSDM = new ArrayList<>();
    
    ThongKeSachChuaDuocMuonDLL tkscdmDLL = new ThongKeSachChuaDuocMuonDLL();
    ArrayList<ThongKeSachChuaDuocMuon> listTKSCDM = new ArrayList<>();

    DefaultTableModel model1, model2, model3,model4;
    public Main() {
        initComponents();
        model1 = (DefaultTableModel) tblMuonTra.getModel();
        model2 = (DefaultTableModel) tblDocGiaMuonQuaHan.getModel();
        model3 = (DefaultTableModel) tblSachDaMuon.getModel();
        model4 = (DefaultTableModel) tblSachChuaDuocMuon.getModel();
        String laf = "";
        laf = "com.sun.java.swing.plaf.windows.WindownsLookAndFeel";
        try {
            UIManager.setLookAndFeel(laf);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
        }
        BidingMuonTra();// load dữ liệu lại
        BidingDocGia();
        BidingSach();
        BidingThongKeNguoiMuon();
        BidingThongKeNguoiMuonQuaHan();
        BidingThongKeThongKeSachDaMuon();
        BidingThongKeSachChuaDuocMuon();

        BidingDG();
        BidingS();

    }
  // lấy tên độc giả ra CBX

    public void BidingDG() {
        listDG = dgDLL.getALL();
        for (DocGia d : listDG) {
            cbxDG.addItem(d.getTenDG());
        }
    }

    public void BidingS() {
        listS = sDLL.getALL();
        for (Sach s : listS) {
            cbxSach.addItem(s.getTenSach());
        }
    }



    // hiển thị thông tin bảng Mượn trả
    public void BidingMuonTra() {
        listMT = mtDLL.getALL();
        Vector clums = new Vector();
        clums.add("MaMuonTra");
        clums.add("SoLuongMuon");
        clums.add("SoLuongTra");
        clums.add("NgayMuon");
        clums.add("NgayTra");
        clums.add("SoLanGiaHan");
        clums.add("TenDG");
        clums.add("TenSach");


        Vector data = new Vector();
        for (MuonTra mt : listMT) {
            Vector row = new Vector();
            row.add(mt.getMaMuonTra());
            row.add(mt.getSoLuongMuon());
            row.add(mt.getSoLuongTra());
            row.add(mt.getNgayMuon());
            row.add(mt.getNgayTra());
            row.add(mt.getSoLanGiaHan());

            listDG = dgDLL.getByMa(mt.getMaDG());
            if (listDG.size() > 0) {
                row.add(listDG.get(0).getTenDG());
            } else {
                row.add("isEmpty");
            }
            listS = sDLL.getByMa(mt.getMaSach());
            if (listS.size() > 0) {
                row.add(listS.get(0).getTenSach());
            } else {
                row.add("isEmpty");
            }

            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblMuonTra.setModel(dtm);
    }

    // hiển thị thông tin bảng Độc giả
    public void BidingDocGia() {
        listDG = dgDLL.getALL();
        Vector clums = new Vector();
        clums.add("MaDG");
        clums.add("TenDG");
        clums.add("Khoa");
        clums.add("SDT");

        Vector data = new Vector();
        for (DocGia dg : listDG) {
            Vector row = new Vector();
            row.add(dg.getMaDG());
            row.add(dg.getTenDG());
            row.add(dg.getKhoa());
            row.add(dg.getSDT());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblDocGia.setModel(dtm);
    }
    // hiển thị thông tin bảng Sách

    public void BidingSach() {
        listS = sDLL.getALL();
        Vector clums = new Vector();
        clums.add("MaSach");
        clums.add("TenSach");
        clums.add("TheLoai");
        clums.add("TenTG");
        clums.add("NXB");
        clums.add("ViTri");
        clums.add("SoLuong");

        Vector data = new Vector();
        for (Sach s : listS) {
            Vector row = new Vector();
            row.add(s.getMaSach());
            row.add(s.getTenSach());
            row.add(s.getTheLoai());
            row.add(s.getTenTG());
            row.add(s.getNXB());
            row.add(s.getViTri());
            row.add(s.getSoLuong());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblSach.setModel(dtm);
    }
    
     // hiển thị thông tin bảng Thống kê người mượn

    public void BidingThongKeNguoiMuon() {
        listTKNM = tknmDLL.getALL();
        Vector clums = new Vector();
        clums.add("MaDG");
        clums.add("TenDG");
        clums.add("MaSach");
        clums.add("TenSach");
        clums.add("SoLuongMuon");
        clums.add("SoLuongTra");

        Vector data = new Vector();
        for (ThongKeNguoiMuon tknm : listTKNM) {
            Vector row = new Vector();
            row.add(tknm.getMaDG());
            row.add(tknm.getTenDG());
            row.add(tknm.getMaSach());
            row.add(tknm.getTenSach());
            row.add(tknm.getSoLuongMuon());
            row.add(tknm.getSoLuongTra());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblDocGiaMuon.setModel(dtm);
    }
     // hiển thị thông tin bảng Thống kê người mượn quá hạn

    public void BidingThongKeNguoiMuonQuaHan() {
        listTKNMQH = tknmqhDLL.getALL();
        Vector clums = new Vector();
        clums.add("MaDG");
        clums.add("TenDG");
        clums.add("MaSach");
        clums.add("TenSach");
        clums.add("NgayMuon");
        clums.add("NgayTra");
        clums.add("SoNgayQuaHan");
        clums.add("TienNopPhat");

        Vector data = new Vector();
        for (ThongKeNguoiMuonQuaHan tknmqh : listTKNMQH) {
            Vector row = new Vector();
            row.add(tknmqh.getMaDG());
            row.add(tknmqh.getTenDG());
            row.add(tknmqh.getMaSach());
            row.add(tknmqh.getTenSach());
            row.add(tknmqh.getNgayMuon());
            row.add(tknmqh.getNgayTra());
            row.add(tknmqh.getSoNgayQuaHan());
            row.add(tknmqh.getTienNopPhat());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblDocGiaMuonQuaHan.setModel(dtm);
    }
     // hiển thị thông tin bảng Thống Sách đã mượn

    public void BidingThongKeThongKeSachDaMuon() {
        listTKSDM = tksdmDLL.getALL();
        Vector clums = new Vector();
        clums.add("MaSach");
        clums.add("TenSach");
        clums.add("TheLoai");
        clums.add("TenTG");
        clums.add("NXB");
        clums.add("ViTri");
        clums.add("SoLuongDaMuon");
        clums.add("SoLuongConLai");

        Vector data = new Vector();
        for (ThongKeSachDaMuon tksdm : listTKSDM) {
            Vector row = new Vector();
            row.add(tksdm.getMaSach());
            row.add(tksdm.getTenSach());
            row.add(tksdm.getTheLoai());
            row.add(tksdm.getTenTG());
            row.add(tksdm.getNXB());
            row.add(tksdm.getViTri());
            row.add(tksdm.getSoLuongDaMuon());
            row.add(tksdm.getSoLuongConLai());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblSachDaMuon.setModel(dtm);
    }
     // hiển thị thông tin bảng Thống Sách chưa được mượn

    public void BidingThongKeSachChuaDuocMuon() {
        listTKSCDM = tkscdmDLL.getALL();
        Vector clums = new Vector();
        clums.add("MaSach");
        clums.add("TenSach");
        clums.add("TheLoai");
        clums.add("TenTG");
        clums.add("NXB");
        clums.add("ViTri");
        clums.add("SoLuong");

        Vector data = new Vector();
        for (ThongKeSachChuaDuocMuon tkscdm : listTKSCDM) {
            Vector row = new Vector();
            row.add(tkscdm.getMaSach());
            row.add(tkscdm.getTenSach());
            row.add(tkscdm.getTheLoai());
            row.add(tkscdm.getTenTG());
            row.add(tkscdm.getNXB());
            row.add(tkscdm.getViTri());
            row.add(tkscdm.getSoLuong());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data, clums);
        tblSachChuaDuocMuon.setModel(dtm);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDocGia = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaDG = new javax.swing.JTextField();
        txtTenDG = new javax.swing.JTextField();
        txtKhoa = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenTG = new javax.swing.JTextField();
        txtTheLoai = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNXB = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtViTri = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMuonTra = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSoLuongTra = new javax.swing.JTextField();
        txtSoLuongMuon = new javax.swing.JTextField();
        txtMaMuonTra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNgayMuon = new javax.swing.JTextField();
        txtNgayTra = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtSoLanGiaHan = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cbxDG = new javax.swing.JComboBox<>();
        cbxSach = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDocGiaMuon = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDocGiaMuonQuaHan = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSachDaMuon = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSachChuaDuocMuon = new javax.swing.JTable();
        lblUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ THƯ VIỆN");

        tblDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDocGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDocGia);

        jLabel2.setText("MaDG");

        jLabel3.setText("TenDG");

        jLabel4.setText("Khoa");

        jLabel5.setText("SDT");

        jButton1.setText("Thêm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cập nhật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaDG)
                    .addComponent(txtTenDG)
                    .addComponent(txtKhoa)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(208, 208, 208))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 77, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("          ĐỘC GIẢ          ", jPanel1);

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSach);

        jLabel6.setText("MaSach");

        jLabel7.setText("TenSach");

        jLabel8.setText("TheLoai");

        jLabel9.setText("TenTG");

        jButton4.setText("Thêm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cập nhật");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Xóa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel10.setText("NXB");

        jLabel11.setText("ViTri");

        jLabel19.setText("SoLuong");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSach)
                    .addComponent(txtTenSach)
                    .addComponent(txtTheLoai)
                    .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jLabel19)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 77, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("          SÁCH          ", jPanel2);

        tblMuonTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMuonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMuonTraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMuonTra);

        jLabel12.setText("MaMuonTra");

        jLabel13.setText("SoLuongMuon");

        jLabel14.setText("SoLuongTra");

        jLabel16.setText("NgayMuon");

        jLabel17.setText("NgayTra");

        jButton7.setText("Thêm mới");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Cập nhật");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Xóa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel18.setText("SoLanGiaHan");

        jLabel27.setText("( Số sách mượn tối đa 3 cuốn )");

        jLabel28.setText("( Số ngày mượn tối đa 90 ngày )");

        jLabel29.setText("(Mỗi cuốn sách chỉ gia hạn được 2 lần)");

        jLabel30.setText("TenDG");

        cbxDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDGActionPerformed(evt);
            }
        });

        jLabel31.setText("TenSach");

        jLabel15.setText("MM-dd-yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaMuonTra, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(txtSoLuongMuon))
                            .addComponent(txtSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(txtSoLanGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel15))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxDG, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSach, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtMaMuonTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtSoLuongMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(txtSoLanGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addGap(20, 20, 20)
                                .addComponent(jButton7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addGap(55, 55, 55))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(21, 21, 21)
                        .addComponent(jButton9)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("          MƯỢN TRẢ          ", jPanel3);

        tblDocGiaMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblDocGiaMuon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Độc giả mượn", jPanel5);

        tblDocGiaMuonQuaHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblDocGiaMuonQuaHan);

        jLabel22.setText("Tiền nộp phạt = Số ngày quá hạn * 2000 (VND)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(385, 385, 385))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Độc giả mượn quá hạn", jPanel6);

        tblSachDaMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblSachDaMuon);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sách đã mượn", jPanel7);

        tblSachChuaDuocMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblSachChuaDuocMuon);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Sách chưa được mượn", jPanel8);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("          THỐNG KÊ          ", jPanel4);

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Thêm Độc giả
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String MaDG = txtMaDG.getText();
        String TenDG = txtTenDG.getText();
        String Khoa = txtKhoa.getText();
        String SDT = txtSDT.getText();

        DocGia dg = new DocGia();
        dg.setMaDG(MaDG);
        dg.setTenDG(TenDG);
        dg.setKhoa(Khoa);
        dg.setSDT(SDT);
        if (dgDLL.AddData(dg)) {
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
            BidingDocGia();// load lại dữ liệu khi Add thành công
        } else {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Cập nhật Độc giả
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String MaDG = txtMaDG.getText();
        String TenDG = txtTenDG.getText();
        String Khoa = txtKhoa.getText();
        String SDT = txtSDT.getText();

        int row = tblDocGia.getSelectedRow();

        DocGia dg = new DocGia();
        dg.setMaDG(listDG.get(row).getMaDG());
        dg.setTenDG(TenDG);
        dg.setKhoa(Khoa);
        dg.setSDT(SDT);
        if (dgDLL.update(dg)) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            BidingDocGia();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    // Xóa Độc gỉa 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if (tblDocGia.getSelectedRow() != -1) {
            int row = tblDocGia.getSelectedRow();
            listDG = dgDLL.getALL();
            if (dgDLL.delete(listDG.get(row).getMaDG())) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                BidingDocGia();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    // MouseClick Mượn trả
    private void tblMuonTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMuonTraMouseClicked
        if (tblMuonTra.getSelectedRow() != -1) {
            int row = tblMuonTra.getSelectedRow();
            listDG = dgDLL.getALL();
            listS = sDLL.getALL();
            listMT = mtDLL.getALL();
            
            txtMaMuonTra.setText(listMT.get(row).getMaMuonTra());
            txtSoLuongMuon.setText(String.valueOf(listMT.get(row).getSoLuongMuon()));// chuyển kiểu qua Integer
            txtSoLuongTra.setText(String.valueOf(listMT.get(row).getSoLuongTra()));
            txtNgayMuon.setText(listMT.get(row).getNgayMuon());
            txtNgayTra.setText(listMT.get(row).getNgayTra());
            txtSoLanGiaHan.setText(String.valueOf(listMT.get(row).getSoLanGiaHan()));

            listDG = dgDLL.getByMa(listMT.get(row).getMaDG());
            if (listDG.size() > 0) {
                cbxDG.setSelectedItem(listDG.get(0).getTenDG());
            } else {
                cbxDG.setSelectedItem(0);
            }
            listS = sDLL.getByMa(listS.get(row).getMaSach());
            if (listS.size() > 0) {
                cbxSach.setSelectedItem(listS.get(0).getTenSach());
            } else {
                cbxSach.setSelectedItem(0);
            }
        }
    }//GEN-LAST:event_tblMuonTraMouseClicked
    // MouseClick Độc giả
    private void tblDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDocGiaMouseClicked
        if (tblDocGia.getSelectedRow() != -1) {
            int row = tblDocGia.getSelectedRow();

            txtMaDG.setText(listDG.get(row).getMaDG());
            txtTenDG.setText(listDG.get(row).getTenDG());
            txtKhoa.setText(listDG.get(row).getKhoa());
            txtSDT.setText(listDG.get(row).getSDT());
        }
    }//GEN-LAST:event_tblDocGiaMouseClicked
    // MouseClike Sách
    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        if (tblSach.getSelectedRow() != -1) {
            int row = tblSach.getSelectedRow();

            txtMaSach.setText(listS.get(row).getMaSach());
            txtTenSach.setText(listS.get(row).getTenSach());
            txtTheLoai.setText(listS.get(row).getTheLoai());
            txtTenTG.setText(listS.get(row).getTenTG());
            txtNXB.setText(String.valueOf(listS.get(row).getNXB()));
            txtViTri.setText(listS.get(row).getViTri());
            txtSoLuong.setText(String.valueOf(listS.get(row).getSoLuong()));
    }//GEN-LAST:event_tblSachMouseClicked
    }
    // Xóa Sách
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       if (tblSach.getSelectedRow() != -1) {
            int row = tblSach.getSelectedRow();
            listS = sDLL.getALL();
            if (sDLL.delete(listS.get(row).getMaSach())) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                BidingSach();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    // Thêm Sách
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String MaSach = txtMaSach.getText();
        String TenSach = txtTenSach.getText();
        String TheLoai = txtTheLoai.getText();
        String TenTG = txtTenTG.getText();
        int NXB = Integer.parseInt(txtNXB.getText());
        String ViTri = txtViTri.getText();
        int SoLuong = Integer.parseInt(txtSoLuong.getText());

        Sach s = new Sach();
        s.setMaSach(MaSach);
        s.setTenSach(TenSach);
        s.setTheLoai(TheLoai);
        s.setTenTG(TenTG);
        s.setNXB(NXB);
        s.setViTri(ViTri);
        s.setSoLuong(SoLuong);
        if (sDLL.AddData(s)) {
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");
            BidingSach();// load lại dữ liệu khi Add thành công
        } else {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại");
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    // Cập nhật Sách
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String MaSach = txtMaSach.getText();
        String TenSach = txtTenSach.getText();
        String TheLoai = txtTheLoai.getText();
        String TenTG = txtTenTG.getText();
        int NXB = Integer.parseInt(txtNXB.getText());
        String ViTri = txtViTri.getText();
        int SoLuong = Integer.parseInt(txtSoLuong.getText());
        
        int row = tblSach.getSelectedRow();

        Sach s = new Sach();
        s.setMaSach(listS.get(row).getMaSach());
        s.setTenSach(TenSach);
        s.setTheLoai(TheLoai);
        s.setTenTG(TenTG);
        s.setNXB(NXB);
        s.setViTri(ViTri);
        s.setSoLuong(SoLuong);
        if (sDLL.update(s)) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            BidingSach();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    // kiểm tra số lượng mượn phải <= 3
    public boolean SLM(int c) {
        if (c > 3) {
            return false;
        }
        return true;
    }

    // kiểm tra số lượng trả phải <= 3
    public boolean SLT(int c) {
        if (c > 3) {
            return false;
        }
        return true;
    }

    // kiểm tra số lần gia hạn phải <= 2
    public boolean GH(int c) {
        if (c > 2) {
            return false;
        }
        return true;
    }
    // Thêm Mượn trả
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        listDG = dgDLL.getALL();
        listS = sDLL.getALL();
        String MaMuonTra = txtMaMuonTra.getText();
        int SoLuongMuon = Integer.parseInt(txtSoLuongMuon.getText()); // chuyển kiểu qua Integer
        int SoLuongTra = Integer.parseInt(txtSoLuongTra.getText()); // chuyển kiểu qua Integer
        String NgayMuon = txtNgayMuon.getText();
        String NgayTra = txtNgayTra.getText();
        int SoLanGiaHan = Integer.parseInt(txtSoLanGiaHan.getText());

        int rowDG = cbxDG.getSelectedIndex();
        int rowS = cbxSach.getSelectedIndex();

        String maDG = listDG.get(rowDG).getMaDG();
        String maS = listS.get(rowS).getMaSach();
        if (SLM(SoLuongMuon)) {
            if (SLT(SoLuongTra)) {
                if (GH(SoLanGiaHan)) {
                    MuonTra mt = new MuonTra();
                    mt.setMaMuonTra(MaMuonTra);
                    mt.setSoLuongMuon(SoLuongMuon);
                    mt.setSoLuongTra(SoLuongTra);
                    mt.setNgayMuon(NgayMuon);
                    mt.setNgayTra(NgayTra);
                    mt.setSoLanGiaHan(SoLanGiaHan);
                    mt.setMaDG(maDG);
                    mt.setMaSach(maS);
                    if (mtDLL.AddData(mt)) {
                        JOptionPane.showMessageDialog(this, "Thêm mới thành công");
                        BidingMuonTra();// load lại dữ liệu khi Add thành công
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm mới thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Số lần gia hạn không quá 2 lần");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Số lượng sách trả phải <= sách mượn");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Số lượng mượn sách phải <= 3");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbxDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDGActionPerformed
    // Xóa mượn trả
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (tblMuonTra.getSelectedRow() != -1) {
            int row = tblMuonTra.getSelectedRow();
            listMT = mtDLL.getALL();
            if (mtDLL.delete(listMT.get(row).getMaMuonTra())) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                BidingMuonTra();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed
    // Cập nhật Mượn trả
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        listDG = dgDLL.getALL();
        listMT = mtDLL.getALL();
        listS = sDLL.getALL();
        String MaMuonTra = txtMaMuonTra.getText();
        int SoLuongMuon = Integer.parseInt(txtSoLuongMuon.getText()); // chuyển kiểu qua Integer
        int SoLuongTra = Integer.parseInt(txtSoLuongTra.getText()); // chuyển kiểu qua Integer
        String NgayMuon = txtNgayMuon.getText();
        String NgayTra = txtNgayTra.getText();
        int SoLanGiaHan = Integer.parseInt(txtSoLanGiaHan.getText());

        int rowDG = cbxDG.getSelectedIndex();
        int rowS = cbxSach.getSelectedIndex();
        
        int row = tblMuonTra.getSelectedRow();
        
        String maDG = listDG.get(rowDG).getMaDG();
        String maS = listS.get(rowS).getMaSach();
        
        if (SLM(SoLuongMuon)) {
            if (SLT(SoLuongTra)) {
                if (GH(SoLanGiaHan)) {
                    MuonTra mt = new MuonTra();
                    mt.setMaMuonTra(listMT.get(row).getMaMuonTra());
                    mt.setSoLuongMuon(SoLuongMuon);
                    mt.setSoLuongTra(SoLuongTra);
                    mt.setNgayMuon(NgayMuon);
                    mt.setNgayTra(NgayTra);
                    mt.setSoLanGiaHan(SoLanGiaHan);
                    mt.setMaDG(maDG);
                    mt.setMaSach(maS);
                    if (mtDLL.update(mt)) {
                        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                        BidingMuonTra();// load lại dữ liệu khi Add thành công
                    } else {
                        JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Số lần gia hạn không quá 2 lần");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Số lượng sách trả phải <= sách mượn");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Số lượng mượn sách phải <= 3");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxDG;
    private javax.swing.JComboBox<String> cbxSach;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    protected static javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblDocGia;
    private javax.swing.JTable tblDocGiaMuon;
    private javax.swing.JTable tblDocGiaMuonQuaHan;
    private javax.swing.JTable tblMuonTra;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblSachChuaDuocMuon;
    private javax.swing.JTable tblSachDaMuon;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextField txtMaDG;
    private javax.swing.JTextField txtMaMuonTra;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLanGiaHan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongMuon;
    private javax.swing.JTextField txtSoLuongTra;
    private javax.swing.JTextField txtTenDG;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenTG;
    private javax.swing.JTextField txtTheLoai;
    private javax.swing.JTextField txtViTri;
    // End of variables declaration//GEN-END:variables
}
