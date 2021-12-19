/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tetris;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hp
 */
public class LeaderboardForm extends javax.swing.JFrame {

    private DefaultTableModel tm;
    
    private String leaderboardFile = "leaderboard"; 
    
    private TableRowSorter<TableModel> sorter;
    
    public LeaderboardForm() {
        initComponents();
        initTableData();
        initTableSorter(); 
    }

    private void initTableData()
    {
        Vector ci = new Vector();
        ci.add("Player");
        ci.add("Score"); 

        tm = (DefaultTableModel) leaderboard.getModel();
    
        try
        {
            FileInputStream fs = new FileInputStream(leaderboardFile);
            ObjectInputStream os = new ObjectInputStream(fs); 

            tm.setDataVector( (Vector<Vector>)os.readObject(), ci ); 

            os.close();
            fs.close();
        }
        catch(Exception e){} 
    }
    
    private void initTableSorter()
    {
        sorter = new TableRowSorter<>(tm);
        leaderboard.setRowSorter(sorter); 

        ArrayList<SortKey> keys = new ArrayList<>();
        keys.add( new SortKey(1, SortOrder.DESCENDING) ); 

        sorter.setSortKeys(keys);
    } 

    private void saveLeaderboard()
    {
        try
        {
            FileOutputStream fs = new FileOutputStream(leaderboardFile);
            ObjectOutputStream os = new ObjectOutputStream(fs); 

            os.writeObject( tm.getDataVector() ); 

            os.close();
            fs.close();
        }
        catch(Exception e){}
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaderboard = new javax.swing.JTable();
        btnMainMenu = new javax.swing.JButton();
        btnMainMenu1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        leaderboard.setBackground(new java.awt.Color(240, 240, 240));
        leaderboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leaderboard.setGridColor(new java.awt.Color(240, 240, 240));
        leaderboard.setSelectionForeground(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(leaderboard);

        btnMainMenu.setBackground(new java.awt.Color(0, 0, 0));
        btnMainMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        btnMainMenu.setBorder(null);
        btnMainMenu.setBorderPainted(false);
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        btnMainMenu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMainMenu1.setText("Leaderboard");
        btnMainMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenu1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LeaderboardBg (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMainMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMainMenu)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMainMenu)
                    .addComponent(btnMainMenu1))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMainMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMainMenu1ActionPerformed

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        this.setVisible(false);
        Tetris.showStartup();
    }//GEN-LAST:event_btnMainMenuActionPerformed

    public void addPlayer(String playerName, int score)
    {
        tm.addRow(new Object[] {playerName, score});
        saveLeaderboard(); 
        sorter.sort();
        this.setVisible(true);
    }
    
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
            java.util.logging.Logger.getLogger(LeaderboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaderboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaderboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaderboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaderboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnMainMenu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaderboard;
    // End of variables declaration//GEN-END:variables
}
