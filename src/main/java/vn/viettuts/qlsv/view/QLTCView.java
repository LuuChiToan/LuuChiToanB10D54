/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vn.viettuts.qlsv.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vn.viettuts.qlsv.entity.QLTC;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vn.viettuts.qlsv.PieCharrt.ModelPolarAreaChart;
import vn.viettuts.qlsv.dao.QLTCDao;
import vn.viettuts.qlsv.controller.LoginController;
public final class QLTCView extends javax.swing.JFrame {
private QLTCDao qltcdao;
private QLTCView qltcView;
private final String [] columnNames = new String [] {
            "ID", "Date", "Description", "Amount", "Type"};
    // định nghĩa dữ liệu mặc định của bẳng gymer là rỗng
    private final Object data = new Object [][] {};
    private List<QLTC> qltcs;
    int handle = 1;
    public QLTCView() {
        initComponents();
        addBtn.setEnabled(true);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        FieldSearch.setEnabled(true);
        Trangchu.setVisible(true);
        Quanlithuchi.setVisible(false);
        Thongke.setVisible(false);
        

    }
    public void showExpenseIncomePieChart(List<QLTC> qltcTable) {
        
        long totalExpense = 0;
        long totalIncome = 0;
        for (QLTC record : qltcTable) {
            long amount = record.getAmount();
            String type = record.getType();

            if ("Expense".equals(type)) {
                totalExpense += amount;
            } else if ("Income".equals(type)) {
                totalIncome += amount;
            }
        }
        long total = totalExpense + totalIncome;
        double percentageExpense = (double) totalExpense * 100 / total;
        double percentageIncome =  (double) totalIncome * 100 / total;
        polarAreaChart.clear();
        polarAreaChart.addItem(new ModelPolarAreaChart(new Color(255,51,51), "Expense",   percentageExpense));
        polarAreaChart.addItem(new ModelPolarAreaChart(new Color(87, 218, 137), "Income", percentageIncome));
        polarAreaChart.start();
    }
    
    public void updateLabels(List<QLTC> list) {
        long totalExpense = 0;
        long totalIncome = 0;

        for (QLTC ex :list) {


            if ("Expense".equals(ex.getType())) {
                totalExpense += ex.getAmount();
            } else if ("Income".equals(ex.getType())) {
                totalIncome += ex.getAmount();
            }
        }
            
        long profit = totalIncome - totalExpense;
        long loss = totalExpense - totalIncome;
        
        if (loss > 0 && handle == 0) {
            JOptionPane.showMessageDialog(this, "Expense exceeds Income");
        }else{
            handle =0;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        
        totalExpenseLabel.setText("Total Expense: " + decimalFormat.format(totalExpense));
        totalIncomeLabel.setText("Total Income: " + decimalFormat.format(totalIncome));
        profitLabel.setText("Profit: " + (profit > 0 ? decimalFormat.format(profit) : 0));
        lossLabel.setText("Loss: " + (loss > 0 ? decimalFormat.format(loss) : 0));
        Quanlithuchi.add(totalExpenseLabel);
        Quanlithuchi.add(totalIncomeLabel);
        Quanlithuchi.add(profitLabel);
        Quanlithuchi.add(lossLabel);        
    }
public void updateLabelsThongke(List<QLTC> list) {
        long totalExpense = 0;
        long totalIncome = 0;
        for (QLTC ex :list) {
            if ("Expense".equals(ex.getType())) {
                totalExpense += ex.getAmount();
            } else if ("Income".equals(ex.getType())) {
                totalIncome += ex.getAmount();
            }
        }        
        long profit = totalIncome - totalExpense;
        long loss = totalExpense - totalIncome;
        totalExpenseLabelThongke.setText("Total Expense: " + totalExpense);
        totalIncomeLabelThongke.setText("Total Income: " + totalIncome);
        profitLabelThongke.setText("Profit: " + (profit > 0 ? profit : 0));
        lossLabelThongke.setText("Loss: " + (loss > 0 ? loss : 0));
        Thongke.add(totalExpenseLabelThongke);
        Thongke.add(totalIncomeLabelThongke);
        Thongke.add(profitLabelThongke);
        Thongke.add(lossLabelThongke);      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        buttontrangchu = new javax.swing.JPanel();
        trangchu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        buttonquanlithuchi = new javax.swing.JPanel();
        quanlithuchi = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonthongke = new javax.swing.JPanel();
        thongke = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Buttondangxuat = new javax.swing.JPanel();
        dangxuat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Tab = new javax.swing.JPanel();
        Trangchu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Quanlithuchi = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        FieldSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnCancelSearch = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        typeCombobox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        Description = new javax.swing.JLabel();
        descriptionField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateField = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        qltcTable = new javax.swing.JTable();
        totalExpenseLabel = new javax.swing.JLabel();
        totalIncomeLabel = new javax.swing.JLabel();
        profitLabel = new javax.swing.JLabel();
        lossLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        qltcTable2 = new javax.swing.JTable();
        idField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        sortbydate = new javax.swing.JButton();
        sortbyamount = new javax.swing.JButton();
        Thongke = new javax.swing.JPanel();
        polarAreaChart = new vn.viettuts.qlsv.PieCharrt.PolarAreaChart();
        jScrollPane2 = new javax.swing.JScrollPane();
        qltcTable1 = new javax.swing.JTable();
        totalExpenseLabelThongke = new javax.swing.JLabel();
        totalIncomeLabelThongke = new javax.swing.JLabel();
        profitLabelThongke = new javax.swing.JLabel();
        lossLabelThongke = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        qltcTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1843, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1843, 800));
        getContentPane().setLayout(null);

        Menu.setBackground(new java.awt.Color(51, 204, 255));
        Menu.setPreferredSize(new java.awt.Dimension(288, 720));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/_54eff0cc-1eb5-4a85-975c-3f36ad83b675 (1).jpg"))); // NOI18N

        trangchu.setText("     Trang chủ");
        trangchu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangchuMouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-money (2).png"))); // NOI18N

        javax.swing.GroupLayout buttontrangchuLayout = new javax.swing.GroupLayout(buttontrangchu);
        buttontrangchu.setLayout(buttontrangchuLayout);
        buttontrangchuLayout.setHorizontalGroup(
            buttontrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttontrangchuLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trangchu, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
        );
        buttontrangchuLayout.setVerticalGroup(
            buttontrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(trangchu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        quanlithuchi.setText("Quản lí thu chi");
        quanlithuchi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quanlithuchiMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accounting (1).png"))); // NOI18N

        javax.swing.GroupLayout buttonquanlithuchiLayout = new javax.swing.GroupLayout(buttonquanlithuchi);
        buttonquanlithuchi.setLayout(buttonquanlithuchiLayout);
        buttonquanlithuchiLayout.setHorizontalGroup(
            buttonquanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonquanlithuchiLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quanlithuchi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        buttonquanlithuchiLayout.setVerticalGroup(
            buttonquanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonquanlithuchiLayout.createSequentialGroup()
                .addGroup(buttonquanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quanlithuchi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        thongke.setBackground(new java.awt.Color(102, 204, 0));
        thongke.setText("  Thống kê");
        thongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongkeMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pie-chart (1).png"))); // NOI18N

        javax.swing.GroupLayout buttonthongkeLayout = new javax.swing.GroupLayout(buttonthongke);
        buttonthongke.setLayout(buttonthongkeLayout);
        buttonthongkeLayout.setHorizontalGroup(
            buttonthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonthongkeLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thongke, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
        );
        buttonthongkeLayout.setVerticalGroup(
            buttonthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(buttonthongkeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        Buttondangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtondangxuatMouseClicked(evt);
            }
        });

        dangxuat.setText("  Đăng xuất");
        dangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dangxuatMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit (1).png"))); // NOI18N

        javax.swing.GroupLayout ButtondangxuatLayout = new javax.swing.GroupLayout(Buttondangxuat);
        Buttondangxuat.setLayout(ButtondangxuatLayout);
        ButtondangxuatLayout.setHorizontalGroup(
            ButtondangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtondangxuatLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtondangxuatLayout.setVerticalGroup(
            ButtondangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonthongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonquanlithuchi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(buttontrangchu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Buttondangxuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(buttontrangchu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(buttonquanlithuchi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(buttonthongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addComponent(Buttondangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        getContentPane().add(Menu);
        Menu.setBounds(6, 10, 130, 720);

        Trangchu.setPreferredSize(new java.awt.Dimension(1843, 800));

        jLabel2.setBackground(new java.awt.Color(255, 51, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Screenshot 2024-04-15 191757 (1).png"))); // NOI18N

        jLabel12.setText("<html>... “Chúng ta chỉ sống một lần trên đời”. Đúng là như vậy nhưng điều đó không có nghĩa là chúng ta nên tiêu xài phung phí. Thay vào đó, chúng ta nên hiểu rằng,  cuộc sống chỉ có một nên chúng ta cần phải <br> sống một  cách có trách nhiệm và bền vững. Vậy nên để được như vậy thì chúng ta phải: <br>      1. Tiết kiệm cho tương lai: Cuộc sống luôn đầy rẫy những bất ngờ và thách thức. Tiết kiệm không chỉ giúp bạn chuẩn bị cho những khó khăn có thể xảy ra, mà còn giúp bạn có được sự tự do tài chính <br> để  theo đuổi  những ước mơ và mục tiêu của mình. </html>");

        jLabel11.setText("<html> 2. Biết được giá trị thực sự: Hãy dành thời gian để suy nghĩ về những gì thực sự quan trọng với <br> bạn, và đầu tư vào những điều đó. Đôi khi, những thứ tốt nhất trong cuộc sống không phải là <br> những thứ đắt tiền nhất. </html>");

        jLabel13.setText("<html> 3. Sống bền vững: Tiêu xài phung phí không chỉ ảnh hưởng đến túi tiền của bạn, mà còn ảnh <br> hưởng đến môi trường. Hãy cố gắng mua sắm một cách có ý thức, tái chế và tái sử dụng khi<br> có thể. </html>");

        jLabel14.setText("<html> 4. Học cách quản lý tài chính: Việc hiểu biết về cách quản lý tài chính cá nhân sẽ giúp bạn kiểm <br> soát tốt hơn việc tiêu xài và giúp bạn tiết kiệm được nhiều hơn. </html>");

        jLabel15.setText("<html>    Cuối cùng, hãy nhớ rằng, việc tiết kiệm không có nghĩa là bạn phải từ chối mọi niềm vui trong cuộc sống.  Thay vào đó, hãy tìm cách tận hưởng cuộc sống một cách có ý nghĩa hơn, và đồng thời, tiết kiệm cho  tương lai. Sống tiết kiệm không chỉ giúp bạn tạo ra một tương lai tài chính ổn định, mà còn giúp bạn trân  trọng hơn những gì bạn có. </html>");

        javax.swing.GroupLayout TrangchuLayout = new javax.swing.GroupLayout(Trangchu);
        Trangchu.setLayout(TrangchuLayout);
        TrangchuLayout.setHorizontalGroup(
            TrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangchuLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(TrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TrangchuLayout.createSequentialGroup()
                        .addGroup(TrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(654, Short.MAX_VALUE))
        );
        TrangchuLayout.setVerticalGroup(
            TrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangchuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(TrangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TrangchuLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Quanlithuchi.setBackground(new java.awt.Color(0, 153, 204));
        Quanlithuchi.setMinimumSize(new java.awt.Dimension(1293, 1000));
        Quanlithuchi.setPreferredSize(new java.awt.Dimension(1293, 720));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Description","Month","Week","Amount Range" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 204, 255));
        btnSearch.setText("Search");

        btnCancelSearch.setBackground(new java.awt.Color(255, 102, 0));
        btnCancelSearch.setText("Cancel");

        addBtn.setText("Add");

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");

        deleteBtn.setText("Delete");

        typeCombobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        typeCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Expense", "Income" }));
        typeCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboboxActionPerformed(evt);
            }
        });

        jLabel7.setText("Type");

        jLabel6.setText("Amount");

        Description.setText("Description");

        jLabel3.setText("Date");

        qltcTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null}
            },
            new String []  {
                "ID","Date", "Description", "Amount","Type"
            }
        ) );
        jScrollPane1.setViewportView(qltcTable);

        qltcTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null}
            },
            new String []  {
                "ID", "Date", "Description", "Amount","Type"
            }
        ) );
        jScrollPane4.setViewportView(qltcTable2);

        jLabel1.setText("ID");

        sortbydate.setText("Sort by Date");

        sortbyamount.setText("Sort by Amount");

        javax.swing.GroupLayout QuanlithuchiLayout = new javax.swing.GroupLayout(Quanlithuchi);
        Quanlithuchi.setLayout(QuanlithuchiLayout);
        QuanlithuchiLayout.setHorizontalGroup(
            QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanlithuchiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuanlithuchiLayout.createSequentialGroup()
                        .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(QuanlithuchiLayout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QuanlithuchiLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QuanlithuchiLayout.createSequentialGroup()
                                .addComponent(FieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearch)
                                    .addComponent(btnCancelSearch)))
                            .addGroup(QuanlithuchiLayout.createSequentialGroup()
                                .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(QuanlithuchiLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QuanlithuchiLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalExpenseLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(profitLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalIncomeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lossLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))
                            .addGroup(QuanlithuchiLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sortbyamount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sortbydate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        QuanlithuchiLayout.setVerticalGroup(
            QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanlithuchiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(QuanlithuchiLayout.createSequentialGroup()
                        .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Description)
                        .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(typeCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QuanlithuchiLayout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn)
                        .addGap(8, 8, 8)
                        .addComponent(deleteBtn)))
                .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(QuanlithuchiLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(QuanlithuchiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(QuanlithuchiLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(totalExpenseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalIncomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(profitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lossLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(sortbydate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortbyamount)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Thongke.setPreferredSize(new java.awt.Dimension(2948, 800));

        qltcTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null}
            },
            new String []  {
                "Date", "Description", "Amount","Type"
            }
        ) );
        jScrollPane2.setViewportView(qltcTable1);

        qltcTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null}
            },
            new String []  {
                "Date", "Description", "Amount","Type"
            }
        ) );
        jScrollPane3.setViewportView(qltcTable3);

        javax.swing.GroupLayout ThongkeLayout = new javax.swing.GroupLayout(Thongke);
        Thongke.setLayout(ThongkeLayout);
        ThongkeLayout.setHorizontalGroup(
            ThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongkeLayout.createSequentialGroup()
                .addGroup(ThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongkeLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(polarAreaChart, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addGroup(ThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalIncomeLabelThongke, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(profitLabelThongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lossLabelThongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalExpenseLabelThongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ThongkeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1871, Short.MAX_VALUE))
        );
        ThongkeLayout.setVerticalGroup(
            ThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongkeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(ThongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(polarAreaChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ThongkeLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(totalExpenseLabelThongke, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(totalIncomeLabelThongke, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(profitLabelThongke, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lossLabelThongke, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TabLayout = new javax.swing.GroupLayout(Tab);
        Tab.setLayout(TabLayout);
        TabLayout.setHorizontalGroup(
            TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Thongke, javax.swing.GroupLayout.DEFAULT_SIZE, 3094, Short.MAX_VALUE))
            .addGroup(TabLayout.createSequentialGroup()
                .addGroup(TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Trangchu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quanlithuchi, javax.swing.GroupLayout.PREFERRED_SIZE, 1351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1111, 1257, Short.MAX_VALUE))
        );
        TabLayout.setVerticalGroup(
            TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Trangchu, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addGroup(TabLayout.createSequentialGroup()
                .addGroup(TabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Quanlithuchi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Tab);
        Tab.setBounds(137, 0, 3100, 1366);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void trangchuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangchuMouseClicked
        Trangchu.setVisible(true);
        Quanlithuchi.setVisible(false);
        Thongke.setVisible(false);
        buttontrangchu.setBackground(new Color(255,255,255));
        buttonquanlithuchi.setBackground(new Color(100,100,100));
        buttonthongke.setBackground(new Color(100,100,100));
        
    }//GEN-LAST:event_trangchuMouseClicked

    private void quanlithuchiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quanlithuchiMouseClicked
        Trangchu.setVisible(false);
        Quanlithuchi.setVisible(true);
        Thongke.setVisible(false);
        buttontrangchu.setBackground(new Color(100,100,100));
        buttonquanlithuchi.setBackground(new Color(255, 255, 255));
        buttonthongke.setBackground(new Color(100,100,100));
    }//GEN-LAST:event_quanlithuchiMouseClicked

    private void thongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongkeMouseClicked
        Trangchu.setVisible(false);
        Quanlithuchi.setVisible(false);
        Thongke.setVisible(true);
        buttontrangchu.setBackground(new Color(100,100,100));
        buttonquanlithuchi.setBackground(new Color(100,100,100));
        buttonthongke.setBackground(new Color(255,255,255));
        polarAreaChart.start();
    }//GEN-LAST:event_thongkeMouseClicked

    private void typeComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComboboxActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ButtondangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtondangxuatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtondangxuatMouseClicked

    private void dangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dangxuatMouseClicked
        this.setVisible(false);
        LoginView view = new LoginView();
        LoginController controller = new LoginController(view);
        // hiển thị màn hình login
        controller.showLoginView();
    }//GEN-LAST:event_dangxuatMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBtnActionPerformed
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        
    }
  public void showListQLTC(List<QLTC> list) {
    int expenseRowCount = 0;

    // Đếm số lượng giao dịch Expense để xác định kích thước của mảng qltcs
    for (QLTC qltc : list) {
        if ("Expense".equals(qltc.getType())) {
            expenseRowCount++;
        }
    }

    Object[][] qltcs = new Object[expenseRowCount][5];
    int currentRow = 0; // Dùng để theo dõi chỉ số hàng hiện tại trong mảng qltcs

    for (QLTC qltc : list) {
        if ("Expense".equals(qltc.getType())) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd/MM/yyyy");
            Date date = qltc.getDate();
            if (date != null) {
                //qltcs[currentRow][1] = dateFormat.format(date);
                qltcs[currentRow][1] = dateFormat.format(date);
            } else {
                //qltcs[currentRow][1] = "";
                qltcs[currentRow][1] = "";
            }
            qltcs[currentRow][0] = qltc.getId();
            qltcs[currentRow][2] = qltc.getDescription();
            qltcs[currentRow][3] = qltc.getFormattedAmount();
            qltcs[currentRow][4] = qltc.getType();
            currentRow++;
        }
    }
    
        
        qltcTable.setModel(new DefaultTableModel(qltcs, columnNames));
       qltcTable.getColumnModel().getColumn(0).setPreferredWidth(50);
       qltcTable.getColumnModel().getColumn(0).setMinWidth(50);
       qltcTable.getColumnModel().getColumn(0).setMaxWidth(50);
       qltcTable.getColumnModel().getColumn(3).setPreferredWidth(100);
       qltcTable.getColumnModel().getColumn(3).setMinWidth(100);
       qltcTable.getColumnModel().getColumn(3).setMaxWidth(100);
       qltcTable.getColumnModel().getColumn(2).setPreferredWidth(100);
       qltcTable.getColumnModel().getColumn(2).setMinWidth(100);
       qltcTable.getColumnModel().getColumn(2).setMaxWidth(100);
       qltcTable.getColumnModel().getColumn(1).setPreferredWidth(150);
       qltcTable.getColumnModel().getColumn(1).setMaxWidth(150);
       qltcTable.getColumnModel().getColumn(1).setMinWidth(150);
       qltcTable.getColumnModel().getColumn(4).setPreferredWidth(90);
       qltcTable.getColumnModel().getColumn(4).setMaxWidth(90);
       qltcTable.getColumnModel().getColumn(4).setMinWidth(90);
       qltcTable1.setModel(new DefaultTableModel(qltcs, columnNames));
       qltcTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
       qltcTable1.getColumnModel().getColumn(0).setMinWidth(50);
       qltcTable1.getColumnModel().getColumn(0).setMaxWidth(50);
       qltcTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
       qltcTable1.getColumnModel().getColumn(3).setMinWidth(100);
       qltcTable1.getColumnModel().getColumn(3).setMaxWidth(100);
       qltcTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
       qltcTable1.getColumnModel().getColumn(2).setMinWidth(100);
       qltcTable1.getColumnModel().getColumn(2).setMaxWidth(100);
       qltcTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
       qltcTable1.getColumnModel().getColumn(1).setMaxWidth(150);
       qltcTable1.getColumnModel().getColumn(1).setMinWidth(150);
       qltcTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
       qltcTable1.getColumnModel().getColumn(4).setMaxWidth(90);
       qltcTable1.getColumnModel().getColumn(4).setMinWidth(90);
    }
public void showListQLTC1(List<QLTC> list) {
    int expenseRowCount = 0;

    // Đếm số lượng giao dịch Expense để xác định kích thước của mảng qltcs
    for (QLTC qltc : list) {
        if ("Income".equals(qltc.getType())) {
            expenseRowCount++;
        }
    }

    Object[][] qltcs = new Object[expenseRowCount][5];
    int currentRow = 0; // Dùng để theo dõi chỉ số hàng hiện tại trong mảng qltcs

    for (QLTC qltc : list) {
        if ("Income".equals(qltc.getType())) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd/MM/yyyy");
            Date date = qltc.getDate();
            if (date != null) {
                //qltcs[currentRow][1] = dateFormat.format(date);
                qltcs[currentRow][1] = dateFormat.format(date);
            } else {
                //qltcs[currentRow][1] = "";
                qltcs[currentRow][1] = "";
            }
            qltcs[currentRow][0] = qltc.getId();
            qltcs[currentRow][2] = qltc.getDescription();
            qltcs[currentRow][3] = qltc.getFormattedAmount();
            qltcs[currentRow][4] = qltc.getType();
            currentRow++;
        }
    }
       qltcTable2.setModel(new DefaultTableModel(qltcs, columnNames));
       qltcTable3.setModel(new DefaultTableModel(qltcs, columnNames));
       qltcTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
       qltcTable2.getColumnModel().getColumn(0).setMinWidth(50);
       qltcTable2.getColumnModel().getColumn(0).setMaxWidth(50);
       qltcTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
       qltcTable2.getColumnModel().getColumn(3).setMinWidth(100);
       qltcTable2.getColumnModel().getColumn(3).setMaxWidth(100);
       qltcTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
       qltcTable2.getColumnModel().getColumn(2).setMinWidth(100);
       qltcTable2.getColumnModel().getColumn(2).setMaxWidth(100);
       qltcTable2.getColumnModel().getColumn(1).setPreferredWidth(150);
       qltcTable2.getColumnModel().getColumn(1).setMaxWidth(150);
       qltcTable2.getColumnModel().getColumn(1).setMinWidth(150);
       qltcTable2.getColumnModel().getColumn(4).setPreferredWidth(90);
       qltcTable2.getColumnModel().getColumn(4).setMaxWidth(90);
       qltcTable2.getColumnModel().getColumn(4).setMinWidth(90);
        qltcTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
       qltcTable3.getColumnModel().getColumn(0).setMinWidth(50);
       qltcTable3.getColumnModel().getColumn(0).setMaxWidth(50);
       qltcTable3.getColumnModel().getColumn(3).setPreferredWidth(100);
       qltcTable3.getColumnModel().getColumn(3).setMinWidth(100);
       qltcTable3.getColumnModel().getColumn(3).setMaxWidth(100);
       qltcTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
       qltcTable3.getColumnModel().getColumn(2).setMinWidth(100);
       qltcTable3.getColumnModel().getColumn(2).setMaxWidth(100);
       qltcTable3.getColumnModel().getColumn(1).setPreferredWidth(150);
       qltcTable3.getColumnModel().getColumn(1).setMaxWidth(150);
       qltcTable3.getColumnModel().getColumn(1).setMinWidth(150);
       qltcTable3.getColumnModel().getColumn(4).setPreferredWidth(90);
       qltcTable3.getColumnModel().getColumn(4).setMaxWidth(90);
       qltcTable3.getColumnModel().getColumn(4).setMinWidth(90);
    }  
    public void fillQLTCFromSelectedRow() {
    // lấy chỉ số của hàng được chọn 
    int row = qltcTable.getSelectedRow();
    if (row >= 0) {
        idField.setText(qltcTable.getModel().getValueAt(row, 0).toString());
        String ngay = String.valueOf(qltcTable.getModel().getValueAt(row, 1)); 
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd/MM/yyyy"); // Thêm thứ vào đằng trước ngày
        Date date = dateFormat.parse(ngay); // Chuyển đổi chuỗi ngày sinh sang đối tượng Date
        dateField.setDate(date); // Hiển thị lại ngày sinh trong JDateChooser
    } catch (ParseException e) {
        // Xử lý nếu có lỗi ParseException
        e.printStackTrace();
    }

        descriptionField.setText(qltcTable.getModel().getValueAt(row, 2).toString());
        amountField.setText(qltcTable.getModel().getValueAt(row, 3).toString());
        if("Expense".equals(qltcTable.getModel().getValueAt(row, 4).toString()))
            
            typeCombobox.setSelectedIndex(0);
        else typeCombobox.setSelectedIndex(1);
        // enable Edit and Delete buttons
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        // disable Add button
        addBtn.setEnabled(false);
    }
}
    public void fillQLTCFromSelectedRow2() {
    // lấy chỉ số của hàng được chọn 
    int row = qltcTable2.getSelectedRow();
    if (row >= 0) {
        idField.setText(qltcTable2.getModel().getValueAt(row, 0).toString());
        String ngay = String.valueOf(qltcTable2.getModel().getValueAt(row,1)); 
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd/MM/yyyy"); // Thêm thứ vào đằng trước ngày
        Date date = dateFormat.parse(ngay); // Chuyển đổi chuỗi ngày sinh sang đối tượng Date
        dateField.setDate(date); // Hiển thị lại ngày sinh trong JDateChooser
    } catch (ParseException e) { 
        // Xử lý nếu có lỗi ParseException
        e.printStackTrace();
    }

        descriptionField.setText(qltcTable2.getModel().getValueAt(row, 2).toString());
        amountField.setText(qltcTable2.getModel().getValueAt(row, 3).toString());
        if("Expense".equals(qltcTable2.getModel().getValueAt(row, 4).toString()))
            
            typeCombobox.setSelectedIndex(0);
        else typeCombobox.setSelectedIndex(1);
        // enable Edit and Delete buttons
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        // disable Add button
        addBtn.setEnabled(false);
    }
}


public void clearQLTCInfo() {
    idField.setText("");
    dateField.setCalendar(null);
    descriptionField.setText("");
    amountField.setText("");
    // disable Edit and Delete buttons
    editBtn.setEnabled(false);
    deleteBtn.setEnabled(false);
    // enable Add button
    addBtn.setEnabled(true);
    typeCombobox.setSelectedIndex(0);
}
    public void showQLTC(QLTC qltc) {
    idField.setText("" + qltc.getId());
    descriptionField.setText("" + qltc.getDescription());
    amountField.setText(""+ qltc.getFormattedAmount());

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String ngayFormatted = dateFormat.format(qltc.getDate());
    dateField.setDate(qltc.getDate());

    // enable Edit and Delete buttons
    editBtn.setEnabled(true);
    deleteBtn.setEnabled(true);
    // disable Add button
    addBtn.setEnabled(false);
    addBtn.setEnabled(false);
}
    public QLTC getQLTCInfo() {
    if (!validateDate() || !validateDescription() || !validateAmount()) {
        return null;
    }
    try {
        QLTC qltc = new QLTC();
        if (idField.getText() != null && !"".equals(idField.getText())) {
            qltc.setId(Integer.parseInt(idField.getText()));
        }
        qltc.setDescription(descriptionField.getText().trim());
        qltc.setAmount(Long.parseLong(amountField.getText().replaceAll(",", "").trim()));
        
        qltc.setType(typeCombobox.getSelectedItem().toString());
        Date date = dateField.getDate();
        qltc.setDate(date);
        
        return qltc;
    } catch (Exception e) {
        showMessage(e.getMessage());
    }
    return null;
}
     private boolean validateDate() {
        Date date = dateField.getDate();
        if (date == null ) {
            dateField.requestFocus();
            showMessage("Ngày không được trống.");
            return false;
        }
        return true;
    }
     private boolean validateDescription() {
        String description = descriptionField.getText();
        if (description == null || "".equals(description.trim())) {
            descriptionField.requestFocus();
            showMessage("Mô tả không được trống.");
            return false;
        }
        return true;
    }
     private boolean validateType(){
         String type = (String)typeCombobox.getSelectedItem();
             return false;
     }   
     private boolean validateAmount() {
        try {
            long amount = Long.parseLong(amountField.getText().replaceAll(",", "").trim());
            if (amount<0) {
                amountField.requestFocus();
                showMessage("Khoản tiền không hợp lệ.");
                return false;         
        }
        } catch (Exception e) {
            amountField.requestFocus();
            showMessage("Khoản tiền không hợp lệ!");
            return false;
        }
        return true;
     
        
    }    
        public int getChoseSelectSearch() {
        Object selectedOption = jComboBox1.getSelectedIndex();
        
// Kiểm tra xem mục đang được chọn là gì
        if (selectedOption != null) {
            if (selectedOption.equals(0)) {
                return 1;
            } else if (selectedOption.equals(1)) {
                return 2;
            }else if (selectedOption.equals(2)) {
                return 3;
            }
            else if (selectedOption.equals(3)) {
                return 4;
            }
            else if (selectedOption.equals(4)) {
                return 5;
            }
        }
        return 0;
    }
      public String validateSearch(){
        String search = FieldSearch.getText();
        if (search == null || "".equals(search.trim())) {
            FieldSearch.requestFocus();
            showMessage("Nội dung tìm kiếm không hợp lệ!");
            return "";
        }
        btnCancelSearch.setEnabled(true);
        addBtn.setEnabled(false);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        clearBtn.setEnabled(false);
        FieldSearch.setEnabled(false);
        return search;
      }
      
      public void cancelSearch()
    {
        String id=idField.getText();
        btnCancelSearch.setEnabled(false);
        btnSearch.setEnabled(true);
        clearBtn.setEnabled(true);
        FieldSearch.setText("");
        if (id == null || "".equals(id.trim()))
        {
            
            addBtn.setEnabled(true);
            editBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        }
        else
        {
            addBtn.setEnabled(false);
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }
    public void valueChanged(ListSelectionEvent e) {
    }
    public void addAddQLTCListener(ActionListener listener) {
        addBtn.addActionListener(listener);
        
    }
     public void addEditQLTCListener(ActionListener listener) {
        editBtn.addActionListener(listener);
    }
    
    public void addDeleteQLTCListener(ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    public void addListQLTCSelectionListener(ListSelectionListener listener) {
        qltcTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void addListQLTCSelectionListener2(ListSelectionListener listener) {
        qltcTable2.getSelectionModel().addListSelectionListener(listener);
        
    }
    public void addListQLTCSelectionListener1(ListSelectionListener listener) {
        qltcTable1.getSelectionModel().addListSelectionListener(listener);
        
    }
    
    public void addListQLTCSelectionListener3(ListSelectionListener listener) {
        qltcTable3.getSelectionModel().addListSelectionListener(listener);
        
    }
    public void addSearchListener(ActionListener listener) {
        btnSearch.addActionListener(listener);
        
    }
    
    public void addCancelSearchQLTCListener(ActionListener listener){
        btnCancelSearch.addActionListener(listener);
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }
    public JButton getsortbydate() {
        return sortbydate;
    }
    public JButton getsortbyamount() {
        return sortbyamount;
    }
    public JTextField getFieldSearch() {
        return FieldSearch;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JComboBox<String> getTypeCombobox() {
        return typeCombobox;
    }

    public JTable getQltcTable() {
        return qltcTable;
    }
    public JTable getQltcTable1() {
        return qltcTable1;
    }
    public JTable getQltcTable2() {
        return qltcTable2;
    }
    public JTable getQltcTable3() {
        return qltcTable3;
    }
public void addSortbydateListener(ActionListener listener) {
        sortbydate.addActionListener(listener);
    }
public void addSortbyamountListener(ActionListener listener) {
        sortbyamount.addActionListener(listener);
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buttondangxuat;
    private javax.swing.JLabel Description;
    private javax.swing.JTextField FieldSearch;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Quanlithuchi;
    private javax.swing.JPanel Tab;
    private javax.swing.JPanel Thongke;
    private javax.swing.JPanel Trangchu;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField amountField;
    private javax.swing.JButton btnCancelSearch;
    private javax.swing.JButton btnSearch;
    private javax.swing.JPanel buttonquanlithuchi;
    private javax.swing.JPanel buttonthongke;
    private javax.swing.JPanel buttontrangchu;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel dangxuat;
    private com.toedter.calendar.JDateChooser dateField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField idField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lossLabel;
    private javax.swing.JLabel lossLabelThongke;
    private vn.viettuts.qlsv.PieCharrt.PolarAreaChart polarAreaChart;
    private javax.swing.JLabel profitLabel;
    private javax.swing.JLabel profitLabelThongke;
    private javax.swing.JTable qltcTable;
    private javax.swing.JTable qltcTable1;
    private javax.swing.JTable qltcTable2;
    private javax.swing.JTable qltcTable3;
    private javax.swing.JLabel quanlithuchi;
    private javax.swing.JButton sortbyamount;
    private javax.swing.JButton sortbydate;
    private javax.swing.JLabel thongke;
    private javax.swing.JLabel totalExpenseLabel;
    private javax.swing.JLabel totalExpenseLabelThongke;
    private javax.swing.JLabel totalIncomeLabel;
    private javax.swing.JLabel totalIncomeLabelThongke;
    private javax.swing.JLabel trangchu;
    private javax.swing.JComboBox<String> typeCombobox;
    // End of variables declaration//GEN-END:variables

}
