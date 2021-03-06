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

import Dao.QuestionDao;

public class InputBlankQuestionFrm extends JPanel{
	private JButton btnAdd=new JButton("增加");
    private JButton btnCancel=new JButton("重置");
    private JLabel lblTitle=new JLabel("题目");
    private JTextArea txtTitle=new JTextArea(10,50);
	private JLabel lblAnswer=new JLabel("答案");
    private JTextArea txtAnswer=new JTextArea(10,50);
    public InputBlankQuestionFrm(){
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
			   String type="填空题";
			   String Blank_qtitle=txtTitle.getText();
			   String Blank_qanswer=txtAnswer.getText();
			   //int qtype=1;//1:单选题2：多选 3：判断4：填空5：简答
			   QuestionDao questionDao=new QuestionDao();
			   int r=questionDao.addBlankQuestion(type, Blank_qtitle, 
					   Blank_qanswer);
			   if(r>0)
				   JOptionPane.showMessageDialog(this, "填空题录入成功!");
			   else {
				   JOptionPane.showMessageDialog(this, "fail");
				   }
			   
		}
}
