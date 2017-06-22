package UI;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import dbutil.SQLHelper;
import Dao.*;
public class PaperPanel extends JPanel {
	private JTable table = null;
	private QuestionDao questionDao = new QuestionDao();
	private SQLHelper sqlHelper=new SQLHelper();
	private JButton btn_add = new JButton("�������");
	private JButton btn_view = new JButton("�鿴����");
	String[] cols = {"��Ŀ����", "��Ŀ����", "ѡ��a", "ѡ��b","ѡ��c","ѡ��d","��" };
	
    public String[] strings=new String[7];
	
    public PaperPanel() {
    	initTable();
    	this.setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(table);
		this.add(jsp,BorderLayout.NORTH);
		JPanel jpbtn = new JPanel();
		jpbtn.add(btn_add);jpbtn.add(btn_view);
		this.add(jpbtn,BorderLayout.SOUTH);

		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_add_clicked();
			}		 
		});
		btn_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_view_clicked();
			}
		});
		}
    
		protected void btn_view_clicked() {
		// TODO Auto-generated method stub
		new ViewPaperFrm();
	}
		protected void btn_add_clicked() {
		// TODO Auto-generated method stub
			int r=table.getSelectedRow();
			if (r > -1) {
				String qtypeString=(String) table.getValueAt(r, 0);
				String qtitleString= (String) table.getValueAt(r, 1);
				String qaString= (String) table.getValueAt(r, 2);
				String qbString= (String) table.getValueAt(r, 3);
				String qcString= (String) table.getValueAt(r, 4);
				String qdString= (String) table.getValueAt(r, 5);
				String qanswerString= (String) table.getValueAt(r, 6);
				int s=questionDao.addQuestiontoPaper(qtypeString, qtitleString, 
						   qaString, qbString, qcString, 
						   qdString,qanswerString);
				   if(s>0)
					   JOptionPane.showMessageDialog(this, "����¼��ɹ�!");
				   else {
					   JOptionPane.showMessageDialog(this, "fail");
					   }
			}
	}
		
		private void initTable() {
		// TODO Auto-generated method stub
			String[][] rows=questionDao.queryAllquestions();
			table = new JTable(rows,cols);
	}
		/* ˢ�±�� */
		private void updateTable(){
			String[][] rows = questionDao.queryAllquestions();
			table.setModel(new DefaultTableModel(rows, cols));
		}
	
    }	
