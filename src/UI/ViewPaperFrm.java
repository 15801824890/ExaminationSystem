package UI;

import java.awt.BorderLayout;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.QuestionDao;
import dbutil.SQLHelper;

public class ViewPaperFrm extends JFrame{
	private JTable table = null;
	private QuestionDao questionDao = new QuestionDao();
	private SQLHelper sqlHelper=new SQLHelper();
	private JButton btn_delete = new JButton("ɾ��");
	private JButton btn_update = new JButton("�޸�");
	private JButton btn_refresh=new JButton("ˢ��");
	String[] cols = { "���","��Ŀ����", "��Ŀ����", "ѡ��a", "ѡ��b","ѡ��c","ѡ��d","��" };
	public String[] strings=new String[8];
    
	public ViewPaperFrm() {
		// TODO Auto-generated constructor stub
		initTable();
    	this.setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(table);
		this.add(jsp,BorderLayout.NORTH);
		JPanel jpbtn = new JPanel();
		jpbtn.add(btn_update);jpbtn.add(btn_delete);jpbtn.add(btn_refresh);
		this.add(jpbtn,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setTitle("�Ծ�����");
		this.setSize(800,700);
		this.setLocation(500, 0);
		
		btn_delete.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_delete_clicked();
			}
		});
		btn_update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_update_clicked();
			}
		});
		btn_refresh.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn_refresh_clicked();
			}
		});
		
		}

	protected void btn_refresh_clicked() {
		// TODO Auto-generated method stub
		updateTable();
	}

	protected void btn_update_clicked() {
		// TODO Auto-generated method stub
		int r=table.getSelectedRow();
		if (r>-1) {
			BtnUpdateFrm2 btnUpdateFrm2=new BtnUpdateFrm2((String)table.getValueAt(r, 1),(String)table.getValueAt(r, 2),(String)table.getValueAt(r, 3),(String)table.getValueAt(r, 4),(String)table.getValueAt(r, 5),(String)table.getValueAt(r, 6),(String)table.getValueAt(r, 7));   
		}else {
			JOptionPane.showMessageDialog(null, "��ѡ���޸���");
		}
	}

	protected void btn_delete_clicked() {
		// TODO Auto-generated method stub
		int r = table.getSelectedRow();
		if (r > -1) {
			String qtitle = (String) table.getValueAt(r, 2);
			if (qtitle != null) {
				questionDao.deletePaperQuestionByqtitle(qtitle);
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				updateTable();
				}
		}else {
			JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ������Ŀ");
		}
	}

	private void initTable() {
		// TODO Auto-generated method stub
		String[][] rows=questionDao.queryPaper();
		table = new JTable(rows,cols);
	}
	/* ˢ�±�� */
	private void updateTable(){
		String[][] rows = questionDao.queryPaper();
		table.setModel(new DefaultTableModel(rows, cols));
	}
   public static void main(String[] args) {
	   new ViewPaperFrm();
}
}
