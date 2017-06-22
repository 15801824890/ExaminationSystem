package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import Dao.ExamDao;

public class ExamFrm2 extends JPanel{
	private ExamDao examDao=new ExamDao();
	private JButton btnstart=new JButton("��ʼ����");
	private JButton btnForward=new JButton("��һ��");
    private JButton btnBack=new JButton("��һ��");
    private JLabel lblid=new JLabel("��ţ�");
    private JTextField txtid=new JTextField(5);
    public int id2;
    private JLabel lblTitle=new JLabel("��Ŀ��");
    private JTextArea txtTitle=new JTextArea(10,50);
	private JLabel lblA=new JLabel("ѡ��A");
	private JTextField txtA = new JTextField(30);
	private JLabel lblB=new JLabel("ѡ��B");
    private JTextField txtB = new JTextField(30);
	private JLabel lblC=new JLabel("ѡ��C");
	private JTextField txtC = new JTextField(30);
	private JLabel lblD=new JLabel("ѡ��D");
    private JTextField txtD = new JTextField(30);
	private JLabel lblAnswer=new JLabel("��");
	
    private JComboBox cmbAnswer=new JComboBox(new String[]{"AB","AC","AD","BC","BD","ABC","ABD","ACD","BCD","ABCD"});
    private String[] exam2=new String[5];  
	LoginFrm loginFrm;
    
    public ExamFrm2(){
    	this.setLayout(new BorderLayout());
		JPanel topPane=new JPanel();         
		topPane.add(lblid);//topPane.add(txtid);
		topPane.add(lblTitle);topPane.add(txtTitle);
			   
		JPanel centerPane=new JPanel();
		centerPane.setLayout(new GridLayout(6,2));
		centerPane.add(lblA);centerPane.add(txtA);
		centerPane.add(lblB);centerPane.add(txtB);
	    centerPane.add(lblC);centerPane.add(txtC);
		centerPane.add(lblD);centerPane.add(txtD);
		centerPane.add(lblAnswer);centerPane.add(cmbAnswer);
		JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,topPane,centerPane);
		splitPane.setDividerLocation(0.4);
		this.add(splitPane);
		
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
			id2=examDao.queryTypeNums("��ѡ��")+1;txtid.setText(id2+"");
			lblid.setText("���:"+id2);
			exam2=examDao.updateEaxm1ByID(id2);
			txtTitle.setText(exam2[0]);
		    txtA.setText(exam2[1]);
		    txtB.setText(exam2[2]);
		    txtC.setText(exam2[3]);
		    txtD.setText(exam2[4]);
	}

		protected void btnBack_Clicked() {
			btnForward.setEnabled(true);
			String stu_id=loginFrm.uid;
			String timu_answer=(cmbAnswer.getSelectedItem().toString());
			String timu_id=txtid.getText();
			examDao.updateAnswertoPaper(stu_id, timu_id, txtTitle.getText(), txtA.getText(), txtB.getText(), txtC.getText(), txtD.getText(), timu_answer);
			id2++;txtid.setText(id2+"");lblid.setText("��ţ�"+id2);
			//System.out.print(examDao.queryTypeNums("��ѡ��"));
			if (id2<=examDao.queryTypeNums("��ѡ��")+examDao.queryTypeNums("��ѡ��")) {
				exam2=examDao.updateEaxm1ByID(id2);
				txtTitle.setText(exam2[0]);
			    txtA.setText(exam2[1]);
			    txtB.setText(exam2[2]);
			    txtC.setText(exam2[3]);
			    txtD.setText(exam2[4]);
			}else {
				id2--;txtid.setText(id2+"");lblid.setText("��ţ�"+id2);
				JOptionPane.showMessageDialog(null, "��ѡ��������");
				btnBack.setEnabled(false);
			}
			
		}

		private void btnForward_Clicked(){
			btnBack.setEnabled(true);
			 id2--;txtid.setText(id2+"");lblid.setText("��ţ�"+id2);
			 if (id2>examDao.queryTypeNums("��ѡ��")) {
				 exam2=examDao.updateEaxm1ByID(id2);
					txtTitle.setText(exam2[0]);
				    txtA.setText(exam2[1]);
				    txtB.setText(exam2[2]);
				    txtC.setText(exam2[3]);
				    txtD.setText(exam2[4]);
				    if (id2==examDao.queryTypeNums("��ѡ��")+1) {
						btnForward.setEnabled(false);
					}
			}
			 
	 }
		   

}
