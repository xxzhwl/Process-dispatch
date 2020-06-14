package com;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JTextArea;

public class Running  extends Thread{
	Pcb p;
	LinkedList<Pcb> ready;
	LinkedList<Pcb> wait;
	static int time=5;
	Iterator<Pcb> it;
	Waitting w;
	JTextArea proQ;
	JTextArea readyQ;
	JTextArea waitQ;
	JTextArea runQ;
	public Running(Pcb pcb,LinkedList<Pcb> pcbs,LinkedList<Pcb> pcbs2,start st){
		p=pcb;	
		ready=pcbs;
		wait=pcbs2;
		proQ=st.proQ;
		readyQ=st.readyQ;
		waitQ=st.waitQ;
		runQ=st.runQ;
		w=new Waitting(pcbs,pcbs2,st);
	}
	public void Fcfs(){
		readyQ.append("\n"+p.name+"通过算法调度即将进入运行状态");
		runQ.append("\n"+p.name+"在运行队列中，处于运行状态"+"\n");
		p.state="运行状态";
		runQ.append("进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
		if(p.runedTime<p.waitPoint){
			for(int i=p.runedTime;i<p.waitPoint;i++){
				p.runedTime+=1;
				w.wt();
				runQ.append("\n"+p);
			}
			runQ.append("\n"+p.name+"到达等待点,即将进入阻塞队列"+"\n");
			waitQ.append("\n"+p.name+"到达等待点,进入阻塞队列----------------"+"\n");
			waitQ.append("进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
			p.state="阻塞状态";
			wait.add(p);
		}else{
			for(int i=p.runedTime;i<p.runTime;i++){
				p.runedTime+=1;
				w.wt();
				runQ.append("\n"+p);
			}
			runQ.append("\n"+p.name+"运行结束");
			p.state="结束状态";
			proQ.append("\n"+p.name+"运行结束"+"\n");
			proQ.append("进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
			proQ.append("\n"+p);
			}
		}
		
	public void RR(){
		readyQ.append("\n"+p.name+"通过算法调度即将进入运行状态"+"\n");
		runQ.append("\n"+p.name+"在运行队列中，处于运行状态"+"\n");
		p.state="运行状态";
		runQ.append("进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
		if(p.runedTime<p.waitPoint){
			int x=p.runedTime;
			for(int i=x;i<p.waitPoint;i++){
				p.runedTime+=1;
				w.wt();
				runQ.append("\n"+p);	
			}
			runQ.append("\n"+p.name+"到达等待点,即将进入阻塞队列"+"\n");
			waitQ.append("\n"+p.name+"到达等待点,进入阻塞队列");
			waitQ.append("\n"+"进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
			p.state="阻塞状态";
			wait.add(p);
		}else{
			if((p.runTime-p.runedTime)<=time){
				for(int i=p.runedTime;i<p.runTime;i++){
					p.runedTime+=1;
					w.wt();
					runQ.append("\n"+p);
				}
				runQ.append("\n"+p.name+"运行结束");
				p.state="结束状态";
				proQ.append("\n"+p.name+"运行结束"+"\n");
				proQ.append("进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
				proQ.append("\n"+p);
			}else{
				int x=p.runedTime;
				for(int i=x;i<x+time;i++){
					p.runedTime+=1;
					runQ.append("\n"+p);		
				}
				p.state="就绪状态";
				runQ.append("\n一个时间片结束，"+p.name+"进入就绪队列"+"\n");
				readyQ.append("\n一个时间片结束，"+p.name+"进入就绪队列"+"\n");
				readyQ.append("进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
				ready.add(p);
				it= ready.iterator();
				Pcb p1;
		        while(it.hasNext() ){
		            p1 = it.next(); 	
		            readyQ.append("\n"+p1.toString());
		            }
		        }
				}
			}		
		}