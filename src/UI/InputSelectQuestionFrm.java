package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Dao.QuestionDao;

public class InputSelectQuestionFrm extends JPanel {
	private static final long serialVersionUID=1L;
	private JButton btnAdd=new JButton("����");
    private JButton btnCancel=new JButton("����");
    private JLabel lblTitle=new JLabel("��Ŀ");
    private JTextArea txtTitle=new JTextArea(10,50);
    private JComboBox cmbType=new JComboBox(new String[]{"��ѡ��","��ѡ��"});
	private JLabel lblA=new JLabel("ѡ��A");
	private JTextField txtA = new JTextField(30);
	private JLabel lblB=new JLabel("ѡ��B");
    private JTextField txtB = new JTextField(30);
	private JLabel lblC=new JLabel("ѡ��C");
	private JTextField txtC = new JTextField(30);
	private JLabel lblD=new JLabel("ѡ��D");
    private JTextField txtD = new JTextField(30);
	private JLabel lblAnswer=new JLabel("��");
    private JComboBox cmbAnswer=new JComboBox(new String[]{"A","B","C","D","AB",
    		"AC","AD","BC","BD","CD","ABC","ABD","ACD","BCD","ABCD"});
   
    public InputSelectQuestionFrm(){
    	this.setLayout(new BorderLayout());
		JPanel topPane=new JPanel();
		topPane.add(lblTitle);topPane.add(txtTitle);topPane.add(cmbType);
			   
		JPanel centerPane=new JPanel();
		centerPane.setLayout(new GridLayout(6,2));
		centerPane.add(lblA);centerPane.add(txtA);
		centerPane.add(lblB);centerPane.add(txtB);
	    centerPane.add(lblC);centerPane.add(txtC);
		centerPane.add(lblD);centerPane.add(txtD);
		centerPane.add(lblAnswer);centerPane.add(cmbAnswer);
		JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,topPane,centerPane);
		this.add(splitPane);
		
		JPanel btnPane=new JPanel();
		btnPane.add(btnAdd);btnPane.add(btnCancel);
		this.add(btnPane,BorderLayout.SOUTH);
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCancel_Clicked();
			}

		});
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
						btnAdd_Clicked();
					}
				});
		   }
    
		protected void btnCancel_Clicked() {
		// TODO Auto-generated method stub
		txtTitle.setText("");
		txtA.setText("");
		txtB.setText("");
		txtC.setText("");
		txtD.setText("");
	}

		private void btnAdd_Clicked(){
			   String type=cmbType.getSelectedItem().toString();
			   if (type.equals("��ѡ��")) {
			   String singleselect_qtitle=txtTitle.getText();
			   String singleselect_qa=txtA.getText();
			   String singleselect_qb=txtB.getText();
			   String singleselect_qc=txtC.getText();
			   String singleselect_qd=txtD.getText();
			   String singleselect_qanswer=cmbAnswer.getSelectedItem().toString();
			   //int qtype=1;//1:��ѡ��2����ѡ 3���ж�4�����5�����
			   QuestionDao questionDao1=new QuestionDao();
			   int r=questionDao1.addSelectQuestion(type, singleselect_qtitle, 
					   singleselect_qa, singleselect_qb, singleselect_qc, 
					   singleselect_qd, singleselect_qanswer);
			   if(r>0)
				   JOptionPane.showMessageDialog(this, "��ѡ��¼��ɹ�!");
			   else {
				   JOptionPane.showMessageDialog(this, "fail");
				   }
			   }
			   if (type.equals("��ѡ��")) {
				   String doubleselect_qtitle=txtTitle.getText();
				   String doubleselect_qa=txtA.getText();
				   String doubleselect_qb=txtB.getText();
				   String doubleselect_qc=txtC.getText();
				   String doubleselect_qd=txtD.getText();
				   String doubleselect_qanswer=cmbAnswer.getSelectedItem().toString();
				   //String qtype="��ѡ��";//1:��ѡ��2����ѡ 3���ж�4�����5�����
				   QuestionDao questionDao2=new QuestionDao();
				   int r=questionDao2.addSelectQuestion(type, doubleselect_qtitle, 
						   doubleselect_qa, doubleselect_qb, doubleselect_qc, 
						   doubleselect_qd,doubleselect_qanswer);
				   if(r>0)
					   JOptionPane.showMessageDialog(this, "��ѡ��¼��ɹ�!");
				   else {
					   JOptionPane.showMessageDialog(this, "fail");
					   }
			   }
		}
}
	 
	