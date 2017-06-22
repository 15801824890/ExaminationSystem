package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Dao.ExamDao;
//��տ��Խ���
public class ExamFrm3 extends JPanel{
	private ExamDao examDao=new ExamDao();
	private JButton btnstart=new JButton("��ʼ����");
	private JButton btnForward=new JButton("��һ��");
    private JButton btnBack=new JButton("��һ��");
    private JLabel lblid=new JLabel("��ţ�");
    private JTextField txtid=new JTextField(5);
    public int id3;
    private JLabel lblTitle=new JLabel("��Ŀ��");
    private JTextArea txtTitle=new JTextArea(10,50);
	private JLabel lblAnswer=new JLabel("��");
	private JTextArea txtAnswer=new JTextArea(10,50);
	private String exam3=null;  
	LoginFrm loginFrm;
    
    public ExamFrm3(){
		this.setLayout(new BorderLayout());
		JPanel topPane=new JPanel();topPane.add(lblid);
		topPane.add(lblTitle);topPane.add(txtTitle);
			   
		JPanel centerPane=new JPanel();
		centerPane.setLayout(new GridLayout(1,2));
		centerPane.add(lblAnswer);centerPane.add(txtAnswer);
		JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,topPane,centerPane);
        this.add(splitPane,BorderLayout.NORTH);
		JPanel btnPane=new JPanel();
		btnPane.add(btnstart);
		btnPane.add(btnForward);btnPane.add(btnBack);
		this.add(btnPane,BorderLayout.SOUTH);
		
	    btnstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnstart_clicked();
			}
		});
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnBack_Clicked();
			}

		});
		
		btnForward.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
						btnForward_Clicked();
					}
				});
		   }
    
		protected void btnstart_clicked() {
		// TODO Auto-generated method stub
			id3=examDao.queryTypeNums("��ѡ��")+examDao.queryTypeNums("��ѡ��")+1;txtid.setText(id3+"");
			lblid.setText("���:"+id3);
			exam3=examDao.updateEaxm3ByID(id3);
			txtTitle.setText(exam3);
	}

		protected void btnBack_Clicked() {
			btnForward.setEnabled(true);
			String stu_id=loginFrm.uid;
			String timu_answer=txtAnswer.getText();
			String timu_id=txtid.getText();
			examDao.updateAnswertoPaper(stu_id, timu_id, txtTitle.getText(),null,null,null,null, timu_answer);
			id3++;txtid.setText(id3+"");lblid.setText("��ţ�"+id3);
			if (id3<=examDao.queryTypeNums("��ѡ��")+examDao.queryTypeNums("��ѡ��")+examDao.queryTypeNums("�����")) {
				exam3=examDao.updateEaxm3ByID(id3);
				txtTitle.setText(exam3);
				txtAnswer.setText("");
			}else {
				id3--;txtid.setText(id3+"");lblid.setText("��ţ�"+id3);
				JOptionPane.showMessageDialog(null, "�����������");
				btnBack.setEnabled(false);
			}
			
		}

		private void btnForward_Clicked(){
			btnBack.setEnabled(true);
			 id3--;txtid.setText(id3+"");lblid.setText("��ţ�"+id3);
			 if (id3>examDao.queryTypeNums("��ѡ��")+examDao.queryTypeNums("��ѡ��")) {
				 exam3=examDao.updateEaxm3ByID(id3);
					txtTitle.setText(exam3);
				    if (id3==examDao.queryTypeNums("��ѡ��")+examDao.queryTypeNums("��ѡ��")+1) {
						btnForward.setEnabled(false);
					}
			}
			 
	 }

}
