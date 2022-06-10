
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Menu extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.koneksi.BukaKoneksi();
    /**
     * Creates new form registrasi
     */
    public Menu() {
        initComponents();
        TampilData();
        TampilTipe();
        TampilKos();
        Tkos();
        Ttip();
        TDk();
        TDkm();
        TDt();
        TP();
    }
    
    private void TampilData(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM data_kamar,data_kos WHERE data_kamar.id_kos = data_kos.id ");
            DefaultTableModel kos = new DefaultTableModel();
            kos.addColumn("No");
            kos.addColumn("Nama Kos");
            kos.addColumn("Tipe Kamar");
            kos.addColumn("Jumlah Kamar");
            kos.addColumn("Biaya");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("nama_kos"),
                  rs.getString("id_tipe"),
                  rs.getString("jumlah_kamar"),
                  rs.getString("biaya")
                };
                kos.addRow(data);
                jTable1.setModel(kos);
            }
        }catch(Exception e){
            
        }
    }
    
    private void TampilTipe(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM tipe_kamar");
            
            DefaultTableModel tp = new DefaultTableModel();
            tp.addColumn("No");
            tp.addColumn("Nama");
            tp.addColumn("AC");
            tp.addColumn("Kamar Mandi");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("nama"),
                  rs.getString("ac"),
                  rs.getString("km_dalem")
                };
                tp.addRow(data);
                jTable2.setModel(tp);
            }
        }catch(Exception e){
            
        }
    }
    
    private void TampilKos(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM data_kos");
            
            DefaultTableModel tk = new DefaultTableModel();
            tk.addColumn("No");
            tk.addColumn("Nama");
            tk.addColumn("Telepon");
            tk.addColumn("Alamat");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("nama_kos"),
                  rs.getString("telepon"),
                  rs.getString("alamat"),
                };
                tk.addRow(data);
                JTk.setModel(tk);
            }
        }catch(Exception e){
            
        }
    }
    
    private void Tkos(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM data_kos");
            
            DefaultTableModel tk = new DefaultTableModel();
            tk.addColumn("No");
            tk.addColumn("Nama");
            tk.addColumn("Telepon");
            tk.addColumn("Alamat");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("nama_kos"),
                  rs.getString("telepon"),
                  rs.getString("alamat"),
                };
                tk.addRow(data);
                Tkos.setModel(tk);
            }
        }catch(Exception e){
            
        }
    }
    
    private void Ttip(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM tipe_kamar");
            
            DefaultTableModel ttp = new DefaultTableModel();
            ttp.addColumn("No");
            ttp.addColumn("Nama");
            ttp.addColumn("AC");
            ttp.addColumn("Kamar Mandi");
            ttp.addColumn("Listrik");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("nama"),
                  rs.getString("ac"),
                  rs.getString("km_dalem"),
                  rs.getString("listrik")
                };
                ttp.addRow(data);
                Ttip.setModel(ttp);
            }
        }catch(Exception e){
            
        }
    }
    
    private void TDk(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM data_kos");
            
            DefaultTableModel tk = new DefaultTableModel();
            tk.addColumn("No");
            tk.addColumn("Nama");
            tk.addColumn("Alamat");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("nama_kos"),
                  rs.getString("alamat"),
                };
                tk.addRow(data);
                TDkos.setModel(tk);
            }
        }catch(Exception e){
            
        }
    }
    
    private void TDkm(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM data_kamar");
            
            DefaultTableModel tp = new DefaultTableModel();
            tp.addColumn("No");
            tp.addColumn("Tipe");
            tp.addColumn("Jumlah Kamar");
            tp.addColumn("Biaya");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("id_tipe"),  
                  rs.getString("jumlah_kamar"),
                  rs.getString("biaya")
                };
                tp.addRow(data);
                TDkm.setModel(tp);
            }
        }catch(Exception e){
            
        }
    }
    
    private void TDt(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM tipe_kamar");
            
            DefaultTableModel tp = new DefaultTableModel();
            tp.addColumn("No");
            tp.addColumn("Nama");
            tp.addColumn("AC");
            tp.addColumn("Kamar Mandi");
            tp.addColumn("Listrik");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("nama"),
                  rs.getString("ac"),
                  rs.getString("km_dalem"),
                  rs.getString("listrik")
                };
                tp.addRow(data);
                TDt.setModel(tp);
            }
        }catch(Exception e){
            
        }
    }
    
    private void TP(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM penyewaan,data_kos WHERE penyewaan.id_kos = data_kos.id AND status='lunas'");
            
            DefaultTableModel tp = new DefaultTableModel();
            tp.addColumn("No");
            tp.addColumn("Kos");
            tp.addColumn("Nama");
            tp.addColumn("No Telp");
            tp.addColumn("Lama Penyewaan");
            tp.addColumn("Tanggal Akhir");
            tp.addColumn("Total Biaya");
            tp.addColumn("Status");
            
            while(rs.next()){
                Object[] data ={
                  rs.getString("id"),
                  rs.getString("nama_kos"),
                  rs.getString("nama"),
                  rs.getString("no_telp"),
                  rs.getString("lama_penyewaan")+" bulan",
                  rs.getString("tgl_akhir"),
                  rs.getString("total_biaya"),
                  rs.getString("status")
                };
                tp.addRow(data);
                jTable3.setModel(tp);
            }
        }catch(Exception e){
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JAtas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JMenulist = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        tab1 = new javax.swing.JPanel();
        jpanel1a = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jpanel2a = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        jpanel3a = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        jpanel4a = new javax.swing.JLabel();
        tab5 = new javax.swing.JPanel();
        jpanel5a = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JMain = new javax.swing.JPanel();
        jp1 = new javax.swing.JPanel();
        Tanggal_Bayar = new javax.swing.JLabel();
        JTbayar = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        TDd = new javax.swing.JButton();
        jp2 = new javax.swing.JPanel();
        Tambah_Data = new javax.swing.JLabel();
        TD_kamar = new javax.swing.JPanel();
        Ptambah_data = new javax.swing.JLabel();
        TD_kos = new javax.swing.JPanel();
        Pdatakos = new javax.swing.JLabel();
        jp3 = new javax.swing.JPanel();
        L_datap = new javax.swing.JLabel();
        Ldp_nama = new javax.swing.JLabel();
        JDP_nama = new javax.swing.JTextField();
        Ldp_notlp = new javax.swing.JLabel();
        JDP_telp = new javax.swing.JTextField();
        Lpenyewaan = new javax.swing.JLabel();
        LP_namakos = new javax.swing.JLabel();
        JDP_namakos = new javax.swing.JTextField();
        LDP_alamat = new javax.swing.JLabel();
        JDP_alamat = new javax.swing.JTextField();
        LDP_kamar = new javax.swing.JLabel();
        JDP_kamar = new javax.swing.JTextField();
        LP_type = new javax.swing.JLabel();
        JDP_tipe = new javax.swing.JTextField();
        Lfasilitas = new javax.swing.JLabel();
        Lac = new javax.swing.JLabel();
        Jac = new javax.swing.JTextField();
        Lkm = new javax.swing.JLabel();
        Jkm = new javax.swing.JTextField();
        Llistrik = new javax.swing.JLabel();
        Jlistrik = new javax.swing.JTextField();
        LP_lama = new javax.swing.JLabel();
        JDP_lama_awal = new javax.swing.JTextField();
        Lbiaya = new javax.swing.JLabel();
        Jbiaya = new javax.swing.JTextField();
        LP_total = new javax.swing.JLabel();
        JDP_total = new javax.swing.JTextField();
        BDataPenyewa = new javax.swing.JButton();
        Ttipe4 = new javax.swing.JScrollPane();
        TDt = new javax.swing.JTable();
        Ttipe5 = new javax.swing.JScrollPane();
        TDkos = new javax.swing.JTable();
        Ttipe6 = new javax.swing.JScrollPane();
        TDkm = new javax.swing.JTable();
        DP = new javax.swing.JTextField();
        Jhitung = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Tgl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PTK_g3 = new javax.swing.JLabel();
        PTK_g4 = new javax.swing.JLabel();
        PTK_g5 = new javax.swing.JLabel();
        PTK_g6 = new javax.swing.JLabel();
        PTK_g7 = new javax.swing.JLabel();
        PTK_g8 = new javax.swing.JLabel();
        jp4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        History = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        TDr = new javax.swing.JButton();
        jp5 = new javax.swing.JPanel();
        Ltambahkamar = new javax.swing.JLabel();
        Lnama = new javax.swing.JLabel();
        JTK_nama = new javax.swing.JTextField();
        LTK_ac = new javax.swing.JLabel();
        JTK_ac = new javax.swing.JTextField();
        LTK_listrik = new javax.swing.JLabel();
        JTK_listrik = new javax.swing.JTextField();
        LTK_km = new javax.swing.JLabel();
        JTK_km = new javax.swing.JTextField();
        BTipeK = new javax.swing.JButton();
        Ttipe = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        TDtk = new javax.swing.JButton();
        t_kos = new javax.swing.JPanel();
        Jtambahkos = new javax.swing.JLabel();
        LTTK_nama = new javax.swing.JLabel();
        JTTK_nama = new javax.swing.JTextField();
        LTTK_alamat = new javax.swing.JLabel();
        JTTK_alamat = new javax.swing.JTextField();
        LTTK_telp = new javax.swing.JLabel();
        JTTK_telp = new javax.swing.JTextField();
        Btambahkos = new javax.swing.JButton();
        Ttipe1 = new javax.swing.JScrollPane();
        JTk = new javax.swing.JTable();
        TDtm = new javax.swing.JButton();
        t_kamar = new javax.swing.JPanel();
        LTD_tambah = new javax.swing.JLabel();
        LTD_nama = new javax.swing.JLabel();
        LTD_alamat = new javax.swing.JLabel();
        JTD_alamat = new javax.swing.JTextField();
        PTD_g = new javax.swing.JLabel();
        LTD_tipe = new javax.swing.JLabel();
        JTD_tipe = new javax.swing.JTextField();
        LTD_ac1 = new javax.swing.JLabel();
        JTD_ac = new javax.swing.JTextField();
        LTD_km = new javax.swing.JLabel();
        JTD_km = new javax.swing.JTextField();
        PTK_g2 = new javax.swing.JLabel();
        LTD_jumlah = new javax.swing.JLabel();
        JTD_jumlah = new javax.swing.JTextField();
        LTD_biaya = new javax.swing.JLabel();
        JTD_biaya = new javax.swing.JTextField();
        Btambahdata = new javax.swing.JButton();
        JTD_nama = new javax.swing.JTextField();
        Ttipe2 = new javax.swing.JScrollPane();
        Tkos = new javax.swing.JTable();
        Ttipe3 = new javax.swing.JScrollPane();
        Ttip = new javax.swing.JTable();
        LTD_listrik = new javax.swing.JLabel();
        JTD_listrik = new javax.swing.JTextField();
        JidT = new javax.swing.JTextField();
        Jid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JAtas.setBackground(new java.awt.Color(110, 80, 222));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background-sekolah-animasi-34.png"))); // NOI18N

        javax.swing.GroupLayout JAtasLayout = new javax.swing.GroupLayout(JAtas);
        JAtas.setLayout(JAtasLayout);
        JAtasLayout.setHorizontalGroup(
            JAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JAtasLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JAtasLayout.setVerticalGroup(
            JAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(JAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 560, -1));

        JMenulist.setBackground(new java.awt.Color(51, 0, 102));
        JMenulist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("REKOS");
        JMenulist.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, 194, -1));
        JMenulist.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 77, 230, 10));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reservasi Kos");
        JMenulist.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 91, 38));

        tab1.setBackground(new java.awt.Color(85, 65, 118));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        jpanel1a.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpanel1a.setForeground(new java.awt.Color(255, 255, 255));
        jpanel1a.setText("Home");
        jpanel1a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpanel1aMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jpanel1a)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel1a, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        JMenulist.add(tab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 262, -1));

        tab2.setBackground(new java.awt.Color(85, 65, 118));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        jpanel2a.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpanel2a.setForeground(new java.awt.Color(255, 255, 255));
        jpanel2a.setText("Tambah Data");
        jpanel2a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpanel2aMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jpanel2a)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel2a, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        JMenulist.add(tab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 262, -1));

        tab3.setBackground(new java.awt.Color(85, 65, 118));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        jpanel3a.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpanel3a.setForeground(new java.awt.Color(255, 255, 255));
        jpanel3a.setText("Input Data Penyewa");
        jpanel3a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpanel3aMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jpanel3a)
                .addGap(66, 66, 66))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel3a, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        JMenulist.add(tab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 262, -1));

        tab4.setBackground(new java.awt.Color(85, 65, 118));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        jpanel4a.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpanel4a.setForeground(new java.awt.Color(255, 255, 255));
        jpanel4a.setText("History");
        jpanel4a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpanel4aMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jpanel4a)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel4a, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        JMenulist.add(tab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 262, -1));

        tab5.setBackground(new java.awt.Color(85, 65, 118));
        tab5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab5MouseClicked(evt);
            }
        });

        jpanel5a.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpanel5a.setForeground(new java.awt.Color(255, 255, 255));
        jpanel5a.setText("Tipe Kamar");
        jpanel5a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpanel5aMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tab5Layout = new javax.swing.GroupLayout(tab5);
        tab5.setLayout(tab5Layout);
        tab5Layout.setHorizontalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab5Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jpanel5a)
                .addGap(95, 95, 95))
        );
        tab5Layout.setVerticalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel5a, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        JMenulist.add(tab5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 262, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/A1-removebg-preview.png"))); // NOI18N
        JMenulist.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 260, 218));

        getContentPane().add(JMenulist, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 560));

        JMain.setLayout(new java.awt.CardLayout());

        jp1.setBackground(new java.awt.Color(204, 204, 255));
        jp1.setForeground(new java.awt.Color(102, 102, 0));

        Tanggal_Bayar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Tanggal_Bayar.setText("Data Kos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        JTbayar.setViewportView(jTable1);

        TDd.setText("Tampilkan Data");
        TDd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDdMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(Tanggal_Bayar))
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TDd)
                            .addComponent(JTbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(Tanggal_Bayar)
                .addGap(13, 13, 13)
                .addComponent(TDd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        JMain.add(jp1, "card2");

        jp2.setBackground(new java.awt.Color(204, 204, 255));
        jp2.setForeground(new java.awt.Color(102, 102, 0));

        Tambah_Data.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Tambah_Data.setText("Tambah Data");

        TD_kamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TD_kamarMouseClicked(evt);
            }
        });

        Ptambah_data.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Ptambah_data.setText("Data Kamar");

        javax.swing.GroupLayout TD_kamarLayout = new javax.swing.GroupLayout(TD_kamar);
        TD_kamar.setLayout(TD_kamarLayout);
        TD_kamarLayout.setHorizontalGroup(
            TD_kamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TD_kamarLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(Ptambah_data, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        TD_kamarLayout.setVerticalGroup(
            TD_kamarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TD_kamarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Ptambah_data)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        TD_kos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TD_kosMouseClicked(evt);
            }
        });

        Pdatakos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Pdatakos.setText("Data Kos");

        javax.swing.GroupLayout TD_kosLayout = new javax.swing.GroupLayout(TD_kos);
        TD_kos.setLayout(TD_kosLayout);
        TD_kosLayout.setHorizontalGroup(
            TD_kosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TD_kosLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(Pdatakos)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        TD_kosLayout.setVerticalGroup(
            TD_kosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TD_kosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pdatakos, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(TD_kos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(TD_kamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(Tambah_Data)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Tambah_Data)
                .addGap(92, 92, 92)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TD_kamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TD_kos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        JMain.add(jp2, "card2");

        jp3.setBackground(new java.awt.Color(204, 204, 255));
        jp3.setForeground(new java.awt.Color(102, 102, 0));
        jp3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L_datap.setText("Data Penyewa");
        jp3.add(L_datap, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        Ldp_nama.setText("Nama");
        jp3.add(Ldp_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 20));
        jp3.add(JDP_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 100, 20));

        Ldp_notlp.setText("No.Tlp");
        jp3.add(Ldp_notlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 40, -1));
        jp3.add(JDP_telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 100, -1));

        Lpenyewaan.setText("Penyewaan");
        jp3.add(Lpenyewaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        LP_namakos.setText("Nama Kos");
        jp3.add(LP_namakos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 60, 20));
        jp3.add(JDP_namakos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 100, 20));

        LDP_alamat.setText("Alamat");
        jp3.add(LDP_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 40, 20));
        jp3.add(JDP_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 100, -1));

        LDP_kamar.setText("No");
        jp3.add(LDP_kamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 20, 20));
        jp3.add(JDP_kamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 100, -1));

        LP_type.setText("Tipe Kamar");
        jp3.add(LP_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 80, 20));
        jp3.add(JDP_tipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 100, -1));

        Lfasilitas.setText("Fasilitas");
        jp3.add(Lfasilitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        Lac.setText("AC");
        jp3.add(Lac, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 20, 20));
        jp3.add(Jac, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 70, -1));

        Lkm.setText("Kamar Mandi");
        jp3.add(Lkm, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 80, 20));
        jp3.add(Jkm, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 70, -1));

        Llistrik.setText("Listrik");
        jp3.add(Llistrik, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 40, 20));
        jp3.add(Jlistrik, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 70, -1));

        LP_lama.setText("Lama Penyewaan");
        jp3.add(LP_lama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, 20));
        jp3.add(JDP_lama_awal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 40, -1));

        Lbiaya.setText("Biaya");
        jp3.add(Lbiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 30, 20));
        jp3.add(Jbiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 100, -1));

        LP_total.setText("Total Biaya");
        jp3.add(LP_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 70, 20));
        jp3.add(JDP_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 90, -1));

        BDataPenyewa.setText("Masukkan Data");
        BDataPenyewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDataPenyewaActionPerformed(evt);
            }
        });
        jp3.add(BDataPenyewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 120, -1));

        TDt.setModel(new javax.swing.table.DefaultTableModel(
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
        TDt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDtMouseClicked(evt);
            }
        });
        Ttipe4.setViewportView(TDt);

        jp3.add(Ttipe4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 260, 80));

        TDkos.setModel(new javax.swing.table.DefaultTableModel(
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
        TDkos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDkosMouseClicked(evt);
            }
        });
        Ttipe5.setViewportView(TDkos);

        jp3.add(Ttipe5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 260, 80));

        TDkm.setModel(new javax.swing.table.DefaultTableModel(
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
        TDkm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDkmMouseClicked(evt);
            }
        });
        Ttipe6.setViewportView(TDkm);

        jp3.add(Ttipe6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 260, 80));

        DP.setEditable(false);
        DP.setBackground(new java.awt.Color(204, 204, 255));
        DP.setForeground(new java.awt.Color(204, 204, 255));
        DP.setBorder(null);
        jp3.add(DP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 20, -1));

        Jhitung.setText("Hitung");
        Jhitung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JhitungMouseClicked(evt);
            }
        });
        jp3.add(Jhitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 150, -1));

        jLabel2.setText("Tanggal Akhir");
        jp3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 80, 20));
        jp3.add(Tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 100, -1));

        jLabel3.setText("Bulan");
        jp3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 50, 20));

        jLabel4.setText("Pilih Kos");
        jp3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabel8.setText("Pilih Harga Kamar");
        jp3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        jLabel10.setText("Pilih Tipe Kamar");
        jp3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));

        PTK_g3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PTK_g3.setForeground(new java.awt.Color(255, 255, 255));
        PTK_g3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jp3.add(PTK_g3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, -1));

        PTK_g4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PTK_g4.setForeground(new java.awt.Color(255, 255, 255));
        PTK_g4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jp3.add(PTK_g4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 160, -1));

        PTK_g5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PTK_g5.setForeground(new java.awt.Color(255, 255, 255));
        PTK_g5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jp3.add(PTK_g5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 160, -1));

        PTK_g6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PTK_g6.setForeground(new java.awt.Color(255, 255, 255));
        PTK_g6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jp3.add(PTK_g6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, -1));

        PTK_g7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PTK_g7.setForeground(new java.awt.Color(255, 255, 255));
        PTK_g7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jp3.add(PTK_g7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 22, 170, -1));

        PTK_g8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PTK_g8.setForeground(new java.awt.Color(255, 255, 255));
        PTK_g8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jp3.add(PTK_g8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 22, 150, -1));

        JMain.add(jp3, "card2");

        jp4.setBackground(new java.awt.Color(204, 204, 255));
        jp4.setForeground(new java.awt.Color(102, 102, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Riwayat Pemesanan");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        History.setViewportView(jTable3);

        TDr.setText("Tampilkan Data");
        TDr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDrMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jp4Layout = new javax.swing.GroupLayout(jp4);
        jp4.setLayout(jp4Layout);
        jp4Layout.setHorizontalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(251, 251, 251))
            .addGroup(jp4Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TDr)
                    .addComponent(History, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jp4Layout.setVerticalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel5)
                .addGap(21, 21, 21)
                .addComponent(TDr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(History, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        JMain.add(jp4, "card2");

        jp5.setBackground(new java.awt.Color(204, 204, 255));
        jp5.setForeground(new java.awt.Color(102, 102, 0));
        jp5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ltambahkamar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Ltambahkamar.setText("Tambah Tipe Kamar");
        jp5.add(Ltambahkamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        Lnama.setText("Nama");
        jp5.add(Lnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));
        jp5.add(JTK_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 120, -1));

        LTK_ac.setText("AC");
        jp5.add(LTK_ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));
        jp5.add(JTK_ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 120, -1));

        LTK_listrik.setText("Listrik");
        jp5.add(LTK_listrik, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));
        jp5.add(JTK_listrik, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 120, -1));

        LTK_km.setText("Kamar Mandi");
        jp5.add(LTK_km, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));
        jp5.add(JTK_km, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 120, -1));

        BTipeK.setText("Tambah Tipe");
        BTipeK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTipeKActionPerformed(evt);
            }
        });
        jp5.add(BTipeK, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        Ttipe.setViewportView(jTable2);

        jp5.add(Ttipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 550, 153));

        TDtk.setText("Tampilkan Data ");
        TDtk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDtkMouseClicked(evt);
            }
        });
        jp5.add(TDtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        JMain.add(jp5, "card2");

        t_kos.setBackground(new java.awt.Color(204, 204, 255));
        t_kos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jtambahkos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Jtambahkos.setText("Tambah Kos");
        t_kos.add(Jtambahkos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 150, 40));

        LTTK_nama.setText("Nama Kos");
        t_kos.add(LTTK_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 60, 20));

        JTTK_nama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        t_kos.add(JTTK_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 130, 20));

        LTTK_alamat.setText("Alamat");
        t_kos.add(LTTK_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 40, 20));

        JTTK_alamat.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        t_kos.add(JTTK_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 130, 20));

        LTTK_telp.setText("No.telp");
        t_kos.add(LTTK_telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 40, 20));

        JTTK_telp.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        t_kos.add(JTTK_telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 130, 20));

        Btambahkos.setText("Tambah Kos");
        Btambahkos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtambahkosActionPerformed(evt);
            }
        });
        t_kos.add(Btambahkos, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, 20));

        JTk.setModel(new javax.swing.table.DefaultTableModel(
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
        Ttipe1.setViewportView(JTk);

        t_kos.add(Ttipe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 580, 130));

        TDtm.setText("Tampilkan Data");
        TDtm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDtmMouseClicked(evt);
            }
        });
        t_kos.add(TDtm, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        JMain.add(t_kos, "card3");

        t_kamar.setBackground(new java.awt.Color(204, 204, 255));
        t_kamar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LTD_tambah.setText("Tambah Data Kamar");
        t_kamar.add(LTD_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 120, -1));

        LTD_nama.setText("Nama Kos");
        t_kamar.add(LTD_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 60, 20));

        LTD_alamat.setText("Alamat");
        t_kamar.add(LTD_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 40, 20));
        t_kamar.add(JTD_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 170, -1));

        PTD_g.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PTD_g.setForeground(new java.awt.Color(255, 255, 255));
        PTD_g.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        t_kamar.add(PTD_g, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 706, -1));

        LTD_tipe.setText("Tipe Kamar");
        t_kamar.add(LTD_tipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 70, 20));
        t_kamar.add(JTD_tipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, 20));

        LTD_ac1.setText("AC/Non-AC");
        t_kamar.add(LTD_ac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));
        t_kamar.add(JTD_ac, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 170, 20));

        LTD_km.setText("Kamar Mandi");
        t_kamar.add(LTD_km, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 80, 20));
        t_kamar.add(JTD_km, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 160, 20));

        PTK_g2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PTK_g2.setForeground(new java.awt.Color(255, 255, 255));
        PTK_g2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        t_kamar.add(PTK_g2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 718, -1));

        LTD_jumlah.setText("Jumlah Kamar");
        t_kamar.add(LTD_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 80, 20));

        JTD_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTD_jumlahActionPerformed(evt);
            }
        });
        t_kamar.add(JTD_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 160, 20));

        LTD_biaya.setText("Biaya");
        t_kamar.add(LTD_biaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 30, 20));
        t_kamar.add(JTD_biaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 170, 20));

        Btambahdata.setText("Tambah");
        Btambahdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtambahdataActionPerformed(evt);
            }
        });
        t_kamar.add(Btambahdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 80, -1));
        t_kamar.add(JTD_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 40, 160, -1));

        Tkos.setModel(new javax.swing.table.DefaultTableModel(
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
        Tkos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TkosMouseClicked(evt);
            }
        });
        Ttipe2.setViewportView(Tkos);

        t_kamar.add(Ttipe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 280, 94));

        Ttip.setModel(new javax.swing.table.DefaultTableModel(
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
        Ttip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TtipMouseClicked(evt);
            }
        });
        Ttipe3.setViewportView(Ttip);

        t_kamar.add(Ttipe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 290, 94));

        LTD_listrik.setText("Listrik");
        t_kamar.add(LTD_listrik, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 40, 20));
        t_kamar.add(JTD_listrik, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 170, 20));

        JidT.setEditable(false);
        JidT.setBackground(new java.awt.Color(204, 204, 255));
        JidT.setForeground(new java.awt.Color(204, 204, 255));
        JidT.setBorder(null);
        t_kamar.add(JidT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 22, -1));

        Jid.setEditable(false);
        Jid.setBackground(new java.awt.Color(204, 204, 255));
        Jid.setForeground(new java.awt.Color(204, 204, 255));
        Jid.setBorder(null);
        t_kamar.add(Jid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 22, -1));

        JMain.add(t_kamar, "card3");

        getContentPane().add(JMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 730, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpanel1aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel1aMouseClicked
        jp1.setVisible(true);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,100,118));
        tab2.setBackground(new Color(85,65,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_jpanel1aMouseClicked

    private void jpanel2aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel2aMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(true);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,100,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_jpanel2aMouseClicked

    private void jpanel3aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel3aMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(true);
        jp4.setVisible(false);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,65,118));
        tab3.setBackground(new Color(85,100,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_jpanel3aMouseClicked

    private void jpanel4aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel4aMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(true);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,65,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,100,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_jpanel4aMouseClicked

    private void jpanel5aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpanel5aMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(true);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,65,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,100,118));
    }//GEN-LAST:event_jpanel5aMouseClicked

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        jp1.setVisible(true);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,100,118));
        tab2.setBackground(new Color(85,65,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        jp1.setVisible(false);
        jp2.setVisible(true);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,100,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(true);
        jp4.setVisible(false);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,65,118));
        tab3.setBackground(new Color(85,100,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(true);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,65,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,100,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_tab4MouseClicked

    private void tab5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab5MouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(true);
        t_kos.setVisible(false);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,65,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,100,118));
    }//GEN-LAST:event_tab5MouseClicked

    private void TD_kosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TD_kosMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        t_kos.setVisible(true);
        t_kamar.setVisible(false);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,100,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_TD_kosMouseClicked

    private void TD_kamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TD_kamarMouseClicked
        jp1.setVisible(false);
        jp2.setVisible(false);
        jp3.setVisible(false);
        jp4.setVisible(false);
        jp5.setVisible(false);
        t_kos.setVisible(false);
        t_kamar.setVisible(true);
        tab1.setBackground(new Color(85,65,118));
        tab2.setBackground(new Color(85,100,118));
        tab3.setBackground(new Color(85,65,118));
        tab4.setBackground(new Color(85,65,118));
        tab5.setBackground(new Color(85,65,118));
    }//GEN-LAST:event_TD_kamarMouseClicked

    private void JTD_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTD_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTD_jumlahActionPerformed

    private void BtambahdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtambahdataActionPerformed
        try{
            st = cn.createStatement();
            String dataKamar = "INSERT INTO data_kamar(id_kos,id_tipe,jumlah_kamar,biaya) VALUES ('"+Jid.getText()+"','"+JidT.getText()+"','"
                        +JTD_jumlah.getText()+"','"+JTD_biaya.getText()+"')";
                    st.execute(dataKamar);
                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data Tidak dapat ditambahkan");
        }
    }//GEN-LAST:event_BtambahdataActionPerformed

    private void BtambahkosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtambahkosActionPerformed
        try{
            st = cn.createStatement();
            String dataKos = "INSERT INTO data_kos(nama_kos,telepon,alamat) VALUES ('"+JTTK_nama.getText()+"','"+JTTK_telp.getText()+"','"
                        +JTTK_alamat.getText()+"')";
                    st.execute(dataKos);
                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data Tidak dapat ditambahkan");
        }
    }//GEN-LAST:event_BtambahkosActionPerformed

    private void BDataPenyewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDataPenyewaActionPerformed
        try{
            st = cn.createStatement();
            String Penye = "INSERT INTO penyewaan(id_kamar,id_kos,nama,no_telp,lama_penyewaan,total_biaya,tgl_akhir,status) VALUES ('"+JDP_kamar.getText()+"','"+DP.getText()+"','"
                        +JDP_nama.getText()+"','"+JDP_telp.getText()+"','"+JDP_lama_awal.getText()+"','"+JDP_total.getText()+"','"+Tgl.getText()+"','"+"lunas"+"')";
                    st.execute(Penye);
                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data Tidak dapat ditambahkan");
        }
    }//GEN-LAST:event_BDataPenyewaActionPerformed

    private void BTipeKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTipeKActionPerformed
        try{
            st = cn.createStatement();
            String tipe = "INSERT INTO tipe_kamar(nama,ac,km_dalem,listrik) VALUES ('"+JTK_nama.getText()+"','"+JTK_ac.getText()+"','"
                        +JTK_km.getText()+"','"+JTK_listrik.getText()+"')";
                    st.execute(tipe);
                    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data Tidak dapat ditambahkan");
        }
    }//GEN-LAST:event_BTipeKActionPerformed

    private void TkosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TkosMouseClicked
        int baris = Tkos.rowAtPoint(evt.getPoint());
        String id = Tkos.getValueAt(baris, 0).toString();
        Jid.setText(id);
        String nama = Tkos.getValueAt(baris, 1).toString();
        JTD_nama.setText(nama);
        String alamat = Tkos.getValueAt(baris, 3).toString();
        JTD_alamat.setText(alamat);
    }//GEN-LAST:event_TkosMouseClicked

    private void TtipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TtipMouseClicked
        int baris = Ttip.rowAtPoint(evt.getPoint());
        String id = Ttip.getValueAt(baris, 0).toString();
        JidT.setText(id);
        String tipe = Ttip.getValueAt(baris, 1).toString();
        JTD_tipe.setText(tipe);
        String ac = Ttip.getValueAt(baris, 2).toString();
        JTD_ac.setText(ac);
        String km = Ttip.getValueAt(baris, 3).toString();
        JTD_km.setText(km);
        String ls = Ttip.getValueAt(baris, 4).toString();
        JTD_listrik.setText(ls);
    }//GEN-LAST:event_TtipMouseClicked

    private void TDtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDtMouseClicked
        int baris = TDt.rowAtPoint(evt.getPoint());
        String ac = TDt.getValueAt(baris, 2).toString();
        Jac.setText(ac);
        String km = TDt.getValueAt(baris, 3).toString();
        Jkm.setText(km);
        String ls = TDt.getValueAt(baris, 4).toString();
        Jlistrik.setText(ls);
    }//GEN-LAST:event_TDtMouseClicked

    private void TDkosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDkosMouseClicked
        int baris = Tkos.rowAtPoint(evt.getPoint());
        String id = Tkos.getValueAt(baris, 0).toString();
        DP.setText(id);
        String nama = Tkos.getValueAt(baris, 1).toString();
        JDP_namakos.setText(nama);
        String alm = Tkos.getValueAt(baris, 2).toString();
        JDP_alamat.setText(alm);
    }//GEN-LAST:event_TDkosMouseClicked

    private void TDkmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDkmMouseClicked
        int baris = TDkm.rowAtPoint(evt.getPoint());
        String km = TDkm.getValueAt(baris, 0).toString();
        JDP_kamar.setText(km);
        String tk = TDkm.getValueAt(baris, 1).toString();
        JDP_tipe.setText(tk);
        String jb = TDkm.getValueAt(baris, 3).toString();
        Jbiaya.setText(jb);
    }//GEN-LAST:event_TDkmMouseClicked

    private void JhitungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JhitungMouseClicked
        int data1 = Integer.parseInt(JDP_lama_awal.getText());
        int data2 = Integer.parseInt(Jbiaya.getText());
        int hitung = data1*data2;
        JDP_total.setText(Integer.toString(hitung));
    }//GEN-LAST:event_JhitungMouseClicked

    private void TDdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDdMouseClicked
        try{    
        st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM data_kamar");
        }catch(Exception e){
            
        }
        TampilData();
    }//GEN-LAST:event_TDdMouseClicked

    private void TDtmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDtmMouseClicked
         try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM data_kos");
        }catch(Exception e){
            
        }
         TampilKos();
    }//GEN-LAST:event_TDtmMouseClicked

    private void TDrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDrMouseClicked
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM penyewaan");
        }catch(Exception e){
            
        }
        TP();
    }//GEN-LAST:event_TDrMouseClicked

    private void TDtkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDtkMouseClicked
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM tipe_kamar");
        }catch(Exception e){
            
        }
        TampilTipe();
    }//GEN-LAST:event_TDtkMouseClicked
    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BDataPenyewa;
    private javax.swing.JButton BTipeK;
    private javax.swing.JButton Btambahdata;
    private javax.swing.JButton Btambahkos;
    private javax.swing.JTextField DP;
    private javax.swing.JScrollPane History;
    private javax.swing.JPanel JAtas;
    private javax.swing.JTextField JDP_alamat;
    private javax.swing.JTextField JDP_kamar;
    private javax.swing.JTextField JDP_lama_awal;
    private javax.swing.JTextField JDP_nama;
    private javax.swing.JTextField JDP_namakos;
    private javax.swing.JTextField JDP_telp;
    private javax.swing.JTextField JDP_tipe;
    private javax.swing.JTextField JDP_total;
    private javax.swing.JPanel JMain;
    private javax.swing.JPanel JMenulist;
    private javax.swing.JTextField JTD_ac;
    private javax.swing.JTextField JTD_alamat;
    private javax.swing.JTextField JTD_biaya;
    private javax.swing.JTextField JTD_jumlah;
    private javax.swing.JTextField JTD_km;
    private javax.swing.JTextField JTD_listrik;
    private javax.swing.JTextField JTD_nama;
    private javax.swing.JTextField JTD_tipe;
    private javax.swing.JTextField JTK_ac;
    private javax.swing.JTextField JTK_km;
    private javax.swing.JTextField JTK_listrik;
    private javax.swing.JTextField JTK_nama;
    private javax.swing.JTextField JTTK_alamat;
    private javax.swing.JTextField JTTK_nama;
    private javax.swing.JTextField JTTK_telp;
    private javax.swing.JScrollPane JTbayar;
    private javax.swing.JTable JTk;
    private javax.swing.JTextField Jac;
    private javax.swing.JTextField Jbiaya;
    private javax.swing.JButton Jhitung;
    private javax.swing.JTextField Jid;
    private javax.swing.JTextField JidT;
    private javax.swing.JTextField Jkm;
    private javax.swing.JTextField Jlistrik;
    private javax.swing.JLabel Jtambahkos;
    private javax.swing.JLabel LDP_alamat;
    private javax.swing.JLabel LDP_kamar;
    private javax.swing.JLabel LP_lama;
    private javax.swing.JLabel LP_namakos;
    private javax.swing.JLabel LP_total;
    private javax.swing.JLabel LP_type;
    private javax.swing.JLabel LTD_ac1;
    private javax.swing.JLabel LTD_alamat;
    private javax.swing.JLabel LTD_biaya;
    private javax.swing.JLabel LTD_jumlah;
    private javax.swing.JLabel LTD_km;
    private javax.swing.JLabel LTD_listrik;
    private javax.swing.JLabel LTD_nama;
    private javax.swing.JLabel LTD_tambah;
    private javax.swing.JLabel LTD_tipe;
    private javax.swing.JLabel LTK_ac;
    private javax.swing.JLabel LTK_km;
    private javax.swing.JLabel LTK_listrik;
    private javax.swing.JLabel LTTK_alamat;
    private javax.swing.JLabel LTTK_nama;
    private javax.swing.JLabel LTTK_telp;
    private javax.swing.JLabel L_datap;
    private javax.swing.JLabel Lac;
    private javax.swing.JLabel Lbiaya;
    private javax.swing.JLabel Ldp_nama;
    private javax.swing.JLabel Ldp_notlp;
    private javax.swing.JLabel Lfasilitas;
    private javax.swing.JLabel Lkm;
    private javax.swing.JLabel Llistrik;
    private javax.swing.JLabel Lnama;
    private javax.swing.JLabel Lpenyewaan;
    private javax.swing.JLabel Ltambahkamar;
    private javax.swing.JLabel PTD_g;
    private javax.swing.JLabel PTK_g2;
    private javax.swing.JLabel PTK_g3;
    private javax.swing.JLabel PTK_g4;
    private javax.swing.JLabel PTK_g5;
    private javax.swing.JLabel PTK_g6;
    private javax.swing.JLabel PTK_g7;
    private javax.swing.JLabel PTK_g8;
    private javax.swing.JLabel Pdatakos;
    private javax.swing.JLabel Ptambah_data;
    private javax.swing.JPanel TD_kamar;
    private javax.swing.JPanel TD_kos;
    private javax.swing.JButton TDd;
    private javax.swing.JTable TDkm;
    private javax.swing.JTable TDkos;
    private javax.swing.JButton TDr;
    private javax.swing.JTable TDt;
    private javax.swing.JButton TDtk;
    private javax.swing.JButton TDtm;
    private javax.swing.JLabel Tambah_Data;
    private javax.swing.JLabel Tanggal_Bayar;
    private javax.swing.JTextField Tgl;
    private javax.swing.JTable Tkos;
    private javax.swing.JTable Ttip;
    private javax.swing.JScrollPane Ttipe;
    private javax.swing.JScrollPane Ttipe1;
    private javax.swing.JScrollPane Ttipe2;
    private javax.swing.JScrollPane Ttipe3;
    private javax.swing.JScrollPane Ttipe4;
    private javax.swing.JScrollPane Ttipe5;
    private javax.swing.JScrollPane Ttipe6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp4;
    private javax.swing.JPanel jp5;
    private javax.swing.JLabel jpanel1a;
    private javax.swing.JLabel jpanel2a;
    private javax.swing.JLabel jpanel3a;
    private javax.swing.JLabel jpanel4a;
    private javax.swing.JLabel jpanel5a;
    private javax.swing.JPanel t_kamar;
    private javax.swing.JPanel t_kos;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab5;
    // End of variables declaration//GEN-END:variables
}
