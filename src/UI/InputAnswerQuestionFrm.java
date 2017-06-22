package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import Dao.QuestionDao;

public class InputAnswerQuestionFrm extends	JPanel{
	private JButton btnAdd=new JButton("����");
    private JButton btnCancel=new JButton("����");
    private JLabel lblTitle=new JLabel("��Ŀ");
    private JTextArea txtTitle=new JTextArea(10,50);
	private JLabel lblAnswer=new JLabel("��");
    private JTextArea txtAnswer=new JTextArea(10,50);
    public InputAnswerQuestionFrm(){
    	this.setLayout(new BorderLayout());
		JPanel topPane=new JPanel();
		topPane.add(lblTitle);topPane.add(txtTitle);
		
		JPanel centerPane=new JPanel();
		centerPane.setLayout(new GridLayout(1,2));
		centerPane.add(lblAnswer);centerPane.add(txtAnswer);
        JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,topPane,centerPane);
        this.add(splitPane,BorderLayout.NORTH);
		
		JPanel btnPane=new JPanel();
		btnPane.add(btnAdd);btnPane.add(btnCancel);
		this.add(btnPane,BorderLayout.SOUTH);
		
		this.setVisible(true);
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
		txtAnswer.setText("");
	}

		private void btnAdd_Clicked(){
			   String type="�����";
			   String Answer_qtitle=txtTitle.getText();
			   String Answer_qanswer=txtAnswer.getText();
			   //int qtype=1;//1:��ѡ��2����ѡ 3���ж�4�����5�����
			   QuestionDao questionDao=new QuestionDao();
			   int r=questionDao.addAnswerQuestion(type, Answer_qtitle, 
					   Answer_qanswer);
			   if(r>0)
				   JOptionPane.showMessageDialog(this, "�����¼��ɹ�!");
			   else {
				   JOptionPane.showMessageDialog(this, "fail");
				   }
			   
		}
}
