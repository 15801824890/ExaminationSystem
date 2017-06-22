package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.*;

import dbutil.initDatas;
public class TeacherFrm extends JFrame{
    private JTree treeMenu;
    //private JTabbedPane tabPane=new JTabbedPane();
    private ClosableTabbedPane tabPane=new ClosableTabbedPane();
    private void initTree(){
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("����ϵͳ��̨");
		DefaultMutableTreeNode m1=new DefaultMutableTreeNode("������");
		DefaultMutableTreeNode m11=new DefaultMutableTreeNode("¼��ѡ����");
		DefaultMutableTreeNode m12=new DefaultMutableTreeNode("ά����Ŀ");
		//DefaultMutableTreeNode m12=new DefaultMutableTreeNode("���������");
		DefaultMutableTreeNode m13=new DefaultMutableTreeNode("¼���ж���");
		DefaultMutableTreeNode m14=new DefaultMutableTreeNode("¼������");
		DefaultMutableTreeNode m15=new DefaultMutableTreeNode("¼�������");
		
		//m11.add(new DefaultMutableTreeNode("¼��ѡ����"));
		//m11.add(new DefaultMutableTreeNode("ά��ѡ����"));
		//m13.add(new DefaultMutableTreeNode("¼���ж���"));
		//m13.add(new DefaultMutableTreeNode("ά���ж���"));
		//m12.add(new DefaultMutableTreeNode("¼���ѡ��"));
		//m12.add(new DefaultMutableTreeNode("ά����ѡ��"));
		//m14.add(new DefaultMutableTreeNode("¼������"));
		//m14.add(new DefaultMutableTreeNode("ά�������"));
		//m15.add(new DefaultMutableTreeNode("¼�������"));
		//m15.add(new DefaultMutableTreeNode("ά�������"));
		
		m1.add(m11);m1.add(m13);m1.add(m14);m1.add(m15);
		m1.add(m12);
		
		DefaultMutableTreeNode m2=new DefaultMutableTreeNode("�Ծ����");
		m2.add(new DefaultMutableTreeNode("��������"));
		m2.add(new DefaultMutableTreeNode("ά������"));
		DefaultMutableTreeNode m3=new DefaultMutableTreeNode("���ֹ���");
		m3.add(new DefaultMutableTreeNode("�Ծ�����"));
		
		DefaultMutableTreeNode m4=new DefaultMutableTreeNode("ͳ�Ʋ�ѯ");
		DefaultMutableTreeNode m5=new DefaultMutableTreeNode("��Ϣά��");
		
		root.add(m1);root.add(m2);root.add(m3);root.add(m4);root.add(m5);
		
		treeMenu=new JTree(root);
		treeMenu.addTreeSelectionListener(new TreeSelectionListener(){
         	public void valueChanged(TreeSelectionEvent e) {
         		String selectNode=e.getPath().getLastPathComponent().toString();
				if("¼��ѡ����".equals(selectNode)){
					tabPane.removeAll();
					InputSelectQuestionFrm pane1=new InputSelectQuestionFrm();
					tabPane.addTab("����ѡ����", pane1,null);
				}
				if("¼�������".equals(selectNode)){
					tabPane.removeAll();
					InputBlankQuestionFrm pane=new InputBlankQuestionFrm();
					tabPane.addTab("���������", pane,null);
				}
				if("¼���ж���".equals(selectNode)){
					tabPane.removeAll();
					InputJudgeQuestionFrm pane=new InputJudgeQuestionFrm();
					tabPane.addTab("�����ж���", pane,null);
				}
				if("¼������".equals(selectNode)){
					tabPane.removeAll();
					InputAnswerQuestionFrm pane=new InputAnswerQuestionFrm();
					tabPane.addTab("���Ӽ����", pane,null);
				}
			
				if("ά����Ŀ".equals(selectNode)){
					tabPane.removeAll();
					UpdateQuestionFrm pane=new UpdateQuestionFrm();
					tabPane.addTab("ά����Ŀ", pane,null);
				}
				if("��������".equals(selectNode)){
					tabPane.removeAll();
					tabPane.addTab("��������", new PaperPanel());
				}
				if("ά������".equals(selectNode)){
					new ViewPaperFrm();
				}
				
				
						
			}			
		});
	}
    public TeacherFrm(){
    	initTree();
    	JPanel jp=(JPanel)this.getContentPane();
    	JScrollPane jsp_tree=new JScrollPane(treeMenu);
    	JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jsp_tree,tabPane);
    	jp.add(splitPane);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setTitle("���Թ���ϵͳ(��ʦ��)");
    	this.setSize(1000,1000);
    	//this.setSize(initDatas.screenwidth-400,initDatas.screenheight-300);
    	this.setResizable(false);
    	this.setLocation(500, 0);
    	this.setVisible(true);
    	//���÷ָ��������ʾ����Ĵ�С,setvisible֮��
    	splitPane.setDividerLocation(0.2);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TeacherFrm();
	}

}
