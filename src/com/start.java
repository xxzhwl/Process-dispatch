package com;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
public class start  extends JFrame implements ActionListener{
	JButton fcfs;
	JButton rr;
	JButton piro;
	JButton spf;
	JButton exit;
	JButton commit;
	JButton piro_rr;
	JButton spf_rr;
	JPanel input;
	JPanel leftUp;
	JPanel rightUp;
	JPanel leftDown;
	JPanel rightDown;
	
	JLabel gs;
	JLabel lu;
	JLabel ru;
	JLabel ld;
	JLabel rd;
	
	
	JTextField pcb_num;
	JTextArea proQ;
	JTextArea readyQ;
	JTextArea waitQ;
	JTextArea runQ;
	LinkedList<Pcb> ready;//就绪队列
	LinkedList<Pcb> wait;//阻塞队列
	Create c;
	Select s;
	public start(){
		gs=new JLabel("进程个数：");
		gs.setFont(new Font ("微软雅黑",Font.PLAIN , 17));
		gs.setBounds(5, 10, 100, 40);
		
		pcb_num=new JTextField(5);
		pcb_num.setFont(new Font ("微软雅黑",Font.PLAIN , 17));
		pcb_num.setBounds(5, 70, 100, 40);
		
		commit=new JButton ("确定");
		commit.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		commit.setBounds(5, 150, 100, 40);
		
		fcfs=new JButton("先来先服务");
		fcfs.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		fcfs.setBounds(5, 230, 100, 40);
		
		rr=new JButton("时间片轮转");
		rr.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		rr.setBounds(5, 310, 100, 40);
		
		piro=new JButton("优先级调度");
		piro.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		piro.setBounds(5, 390, 100, 40);
		
	    spf=new JButton("短进程优先");
	    spf.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
	    spf.setBounds(5, 470, 100, 40);
	    
		piro_rr=new JButton("Piro+RR");
		piro_rr.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		piro_rr.setBounds(5, 550, 100, 40);
		
	    spf_rr=new JButton("SPF+RR");
	    spf_rr.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
	    spf_rr.setBounds(5, 630, 100, 40);
	    
		exit=new JButton("退出");
		exit.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		exit.setBounds(5, 710, 100, 40);

		
		lu=new JLabel("进程队列：");
		lu.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		lu.setBounds(0, 0, 100, 30);
		
		ld=new JLabel("就绪队列：");
		ld.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		ld.setBounds(0, 360, 100, 30);
		
		ru=new JLabel("运行队列：");
		ru.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		ru.setBounds(920, 0, 100, 30);
		
		rd=new JLabel("阻塞队列：");
		rd.setFont(new Font ("微软雅黑",Font.PLAIN , 12));
		rd.setBounds(920, 360, 100, 30);
		
		leftUp=new JPanel();
		leftDown=new JPanel();
		rightUp=new JPanel();
		rightDown=new JPanel();
		
		input=new JPanel();
		proQ=new JTextArea();
		waitQ=new JTextArea();
		readyQ=new JTextArea();
		runQ=new JTextArea();
		
		JScrollPane jspPro=new JScrollPane(proQ);
		JScrollPane jspWait=new JScrollPane(waitQ);
		JScrollPane jspReady=new JScrollPane(readyQ);
		JScrollPane jspRun=new JScrollPane(runQ);
		
		leftUp.add(jspPro);
		leftDown.add(jspReady);
		rightUp.add(jspRun);
		rightDown.add(jspWait);
		
		
		input.add(gs);
		input.add(pcb_num);
		input.add(commit);
		input.add(fcfs);
		input.add(rr);
		input.add(piro);
		input.add(spf);
		input.add(piro_rr);
		input.add(spf_rr);
		input.add(exit);
	
		proQ.setEnabled(false);
		proQ.setBackground(Color.black);
		proQ.setFont(new Font ("微软雅黑",Font.PLAIN , 13));
		
		waitQ.setEnabled(false);
		waitQ.setBackground(Color.black);
		waitQ.setFont(new Font ("微软雅黑",Font.PLAIN , 13));
		
		readyQ.setEnabled(false);
		readyQ.setBackground(Color.black);
		readyQ.setFont(new Font ("微软雅黑",Font.PLAIN , 13));
		
		runQ.setEnabled(false);
		runQ.setBackground(Color.black);
		runQ.setFont(new Font ("微软雅黑",Font.PLAIN , 13));
		
		
		leftUp.setLayout(null);
		leftUp.setBounds(0, 30, 800, 330);
		
		leftDown.setLayout(null);
		leftDown.setBounds(0, 390, 800, 330);
		
		rightUp.setLayout(null);
		rightUp.setBounds(920, 30, 800, 330);
		
		rightDown.setLayout(null);
		rightDown.setBounds(920, 390, 800, 330);
		
		jspPro.setBounds(0, 0, 800, 330);
		jspWait.setBounds(0, 0, 800, 330);
		jspReady.setBounds(0, 0, 800, 330);
		jspRun.setBounds(0, 0, 800, 330);
		
		input.setBounds(805, 0, 105, 800);
		input.setLayout(null);
		
		commit.addActionListener(this);
		fcfs.addActionListener(this);
		rr.addActionListener(this);
		piro.addActionListener(this);
		spf.addActionListener(this);
		piro_rr.addActionListener(this);
		spf_rr.addActionListener(this);
		exit.addActionListener(this);
		
		this.add(leftUp);
		this.add(leftDown);
		this.add(rightUp);
		this.add(rightDown);
		this.add(input);
		this.add(lu);
		this.add(ld);
		this.add(ru);
		this.add(rd);
		setBounds(180, 90, 1700, 800);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==commit){
			if(pcb_num.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"请输入进程个数");
			}
			else {
			proQ.setText("");
			waitQ.setText("");
			readyQ.setText("");
			runQ.setText("");			
			int x=Integer.parseInt(pcb_num.getText());
			c=new Create(x,proQ,readyQ);
			ready=c.ready;
			wait=new LinkedList<Pcb>();
			s=new Select(ready,wait,this);
			}
		}else if(e.getSource()==fcfs){
			if(ready.isEmpty()){
				proQ.append("\n进程全部结束，请重新创建进程");
			}else{
				s.FCFS();
			}
		}else if(e.getSource()==rr){
			if(ready.isEmpty()){
				proQ.append("\n进程全部结束，请重新创建进程");
			}else{
				s.RR();
			}
		}else if(e.getSource()==piro){
			
			if(ready.isEmpty()){
				proQ.append("\n进程全部结束，请重新创建进程");
			}else{
				s.Piro();
			}
		}else if(e.getSource()==spf){
			if(ready.isEmpty()){
				proQ.append("\n进程全部结束，请重新创建进程");
			}else{
				s.Spf();
			}
		}else if(e.getSource()==piro_rr){
			if(ready.isEmpty()){
				proQ.append("\n进程全部结束，请重新创建进程");
			}else{
				s.Piro_RR();
			}
		}else if(e.getSource()==spf_rr){
			if(ready.isEmpty()){
				proQ.append("\n进程全部结束，请重新创建进程");
			}else{
				s.Spf_RR();
			}
			
		}else if(e.getSource()==exit){
			System.exit(0);
		}
	}
	
	public static void main(String[] args){
		new start();
	}
}
