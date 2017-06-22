package UI;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.CellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.omg.CORBA.PUBLIC_MEMBER;

import dbutil.SQLHelper;
import Dao.QuestionDao;


public class UpdateQuestionFrm extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTable table = null;
	private QuestionDao questionDao = new QuestionDao();
	private SQLHelper sqlHelper=new SQLHelper();
	private JButton btn_delete = new JButton("ɾ��");
	private JButton btn_update = new JButton("�޸�");
	private JButton btn_refresh=new JButton("ˢ��");
	String[] cols = { "��Ŀ����", "��Ŀ����", "ѡ��a", "ѡ��b","ѡ��c","ѡ��d","��" };
    public String[] strings=new String[7];
	
    public UpdateQuestionFrm(){
    	initTable();
    	this.setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(table);
		this.add(jsp,BorderLayout.NORTH);
		JPanel jpbtn = new JPanel();
		jpbtn.add(btn_update);jpbtn.add(btn_delete);jpbtn.add(btn_refresh);
		this.add(jpbtn,BorderLayout.SOUTH);

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
				updateTable();
			}
		});
		}

		protected void btn_update_clicked() {
		// TODO Auto-generated method stub
		int r=table.getSelectedRow();
		if (r>-1) {
			BtnUpdateFrm btnUpdateFrm=new BtnUpdateFrm((String)table.getValueAt(r, 0),(String)table.getValueAt(r, 1),(String)table.getValueAt(r, 2),(String)table.getValueAt(r, 3),(String)table.getValueAt(r, 4),(String)table.getValueAt(r, 5),(String)table.getValueAt(r, 6));   
		}else {
			JOptionPane.showMessageDialog(null, "��ѡ���޸���");
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
		
		
		
	/*	protected void btn_update_clicked() {
		// TODO Auto-generated method stub
		/*	int col = table.getSelectedColumn();//��ȡѡ�е��к�
			int row = table.getSelectedRow();//��ȡѡ�е��к�
			//Ӧ���ȸ�Ϊ�ɱ༭״̬���ټ��
			table.editCellAt(row,col);
			//DefaultTableModel model = (DefaultTableModel) table.getModel();//��ȡdefaulttablemodel
			Object value = table.getValueAt(row, col);//�����кź��кţ���ȡĳ����Ԫ���ֵ
			
			//model.setValueAt(value, row, col);//�޸�ĳ��Ԫ���ֵ
			table.setValueAt(value, row, col);
			
			String[][] rows = questionDao.queryAllquestions();
			table.setModel(new DefaultTableModel(rows, cols));
			int r = table.getSelectedRow();//��ȡѡ�е��к� 
			if (r>=0) {
				for (int i = 0; i < 7; i++) {
					strings[i]=(String) table.getValueAt(r, i);
				}
				update(strings);
			}else {
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ���Ŀ");
				}
			
	}

/*private void update(String[] str) {
			// TODO Auto-generated method stub
			JPanel jPanel=new JPanel(new GridLayout(8,1));
			JPanel jpbtn=new JPanel(new FlowLayout());
			JButton btn_OK=new JButton("ȷ��");
			JButton btn_Cancel=new JButton("ȡ��");
			JLabel[] labels=new JLabel[str.length];
			final JTextField[] text=new JTextField[str.length];
			JPanel[] jps=new JPanel[str.length];
			for (int i = 0; i < str.length; i++) {
				jps[i]=new JPanel(new FlowLayout(FlowLayout.LEFT));
				labels[i]=new JLabel(cols[i]);
				text[i]=new JTextField(35);
				text[i].setText(str[i]);
				jps[i].add(labels[i]);jps[i].add(text[i]);
				jPanel.add(jps[i]);
			}
			jpbtn.add(btn_OK);jpbtn.add(btn_Cancel);
			jPanel.add(jpbtn);
			dialog.add(jPanel);
			dialog.setTitle("�޸���Ŀ");
			dialog.setSize(600,600);
			dialog.setLocation(500, 300);
			dialog.setVisible(true);
			
			btn_Cancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
				}
			});
			btn_OK.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int qtype=Integer.parseInt(text[0].getText());
					String qtitle=text[1].getText().toString();
					String qa=text[2].getText().toString();
					String qb=text[3].getText().toString();
					String qc=text[4].getText().toString();
					String qd=text[5].getText().toString();
					String qanswer=text[6].getText().toString();
					String sql="UPDATE t_timu SET qtype='"+qtype+"',qtitle='"+qtitle+"',qa='"+qa+"',qb='"+qb+"',qc='"+qc+"',qd='"+qd+"',qanswer='"+qanswer+"' WHERE qtitle='"+strings[1]+"'";
					System.out.println(sql);
					if (sqlHelper.executeUpdate(sql)>0) {
						JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
						dialog.dispose();
			
						//dialog.repaint();
						//dialog.validate();
						updateTable();

						
						};
						
						
				}
			});
			
			
}*/	
	
		
        protected void btn_delete_clicked() {
		// TODO Auto-generated method stub
			int r = table.getSelectedRow();
			if (r > -1) {
				String qtitle = (String) table.getValueAt(r, 1);
				if (qtitle != null) {
					questionDao.deleteQuestionByqtitle(qtitle);
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					updateTable();
					}
			}else {
				JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ������Ŀ");
			}
	}





}
		

