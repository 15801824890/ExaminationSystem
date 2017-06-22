package UI;

import java.awt.Component;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import org.omg.CORBA.PRIVATE_MEMBER;

import dbutil.CountDown;
import dbutil.DateTimer;


public class StudentFrm extends JFrame {
	private JLabel jlpic=new JLabel();
	private LoginFrm loginFrm=new LoginFrm();
    MenuBar menuBar=new MenuBar();
    Menu exam=new Menu("Exam");
    Menu view=new Menu("View");
    private JLabel jlbJLabel1=new JLabel("         ����ѧ��:"+loginFrm.uid);
    private JLabel jlbJlJLabel2=new JLabel("        ����ʱ�䣺40����  ");
    
    private JButton btnComplete=new JButton("�ύ�Ծ�");
    MenuItem startexamItem=new MenuItem("Sart exam");
    MenuItem exit=new MenuItem("Exit");
    public static JLabel time = new JLabel();
    public static JLabel remain=new JLabel();
    private JTabbedPane tabbedPane=new JTabbedPane();
    
    public StudentFrm(){
    	JPanel jp=(JPanel)this.getContentPane();
        JPanel topPane=new JPanel();
        topPane.add(time);topPane.add(jlbJLabel1);topPane.add(jlbJlJLabel2);topPane.add(remain);
		topPane.add(btnComplete);
    	JSplitPane splitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT,topPane,tabbedPane);//ˮƽ�ָ�
    	jp.add(splitPane);
    	
    	
    	menuBar.add(exam);menuBar.add(view);
    	exam.add(startexamItem);exam.add(exit);
    	
    	
    	//��label����backgroundImage
    	/*ImageIcon backImage=new ImageIcon("D:\\myeclipse\\workspaces\\ExaminationSystem\\src\\2.png");
    	backImage.setImage(backImage.getImage().getScaledInstance(backImage.getIconWidth(), backImage.getIconHeight(), Image.SCALE_DEFAULT));
    	System.out.println(backImage.getIconHeight() + "" + backImage.getIconWidth());
    	jlpic.setBounds(-80, -160, 600,600);  
        jlpic.setHorizontalAlignment(0);  
        jlpic.setIcon(backImage);
       
        this.add(jlpic);*/
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("���߿���ϵͳ��ѧ���ˣ�");
    	this.setMenuBar(menuBar);
    	this.setVisible(true);
    	this.setSize(1000,1000);
    	this.setResizable(false);
    	this.setLocation(700, 200);
    	
    	//java.util.Timer t=new java.util.Timer();
		DateTimer refreshDate=new DateTimer();
		refreshDate.start();
		
    	//���÷ָ��������ʾ����Ĵ�С,setvisible֮��
    	splitPane.setDividerLocation(0.4);
    	
    	btnComplete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showConfirmDialog(null, "ȷ���ύ����Ҫ���", "�ύ", JOptionPane.YES_NO_OPTION);
				System.exit(0);
			}
		});
    	
    	startexamItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        	ExamFrm1 examFrm1=new ExamFrm1();
					ExamFrm2 examFrm2=new ExamFrm2();
					ExamFrm3 examFrm3=new ExamFrm3();
					ExamFrm4 examFrm4=new ExamFrm4();
					ExamFrm5 examFrm5=new ExamFrm5();
					tabbedPane.addTab("��ѡ��",examFrm1);
					tabbedPane.addTab("��ѡ��",examFrm2);
					tabbedPane.addTab("�����",examFrm3);
					tabbedPane.addTab("�ж���",examFrm4);
					tabbedPane.addTab("�����",examFrm5);
					tabbedPane.setSelectedIndex(0);
					CountDown countDown=new CountDown();
				    countDown.start();
					
			}
		});
    	exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
    }
    
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      StudentFrm studentFrm=new StudentFrm();
   
	}

}
