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
		readyQ.append("\n"+p.name+"ͨ���㷨���ȼ�����������״̬");
		runQ.append("\n"+p.name+"�����ж����У���������״̬"+"\n");
		p.state="����״̬";
		runQ.append("������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
		if(p.runedTime<p.waitPoint){
			for(int i=p.runedTime;i<p.waitPoint;i++){
				p.runedTime+=1;
				w.wt();
				runQ.append("\n"+p);
			}
			runQ.append("\n"+p.name+"����ȴ���,����������������"+"\n");
			waitQ.append("\n"+p.name+"����ȴ���,������������----------------"+"\n");
			waitQ.append("������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
			p.state="����״̬";
			wait.add(p);
		}else{
			for(int i=p.runedTime;i<p.runTime;i++){
				p.runedTime+=1;
				w.wt();
				runQ.append("\n"+p);
			}
			runQ.append("\n"+p.name+"���н���");
			p.state="����״̬";
			proQ.append("\n"+p.name+"���н���"+"\n");
			proQ.append("������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
			proQ.append("\n"+p);
			}
		}
		
	public void RR(){
		readyQ.append("\n"+p.name+"ͨ���㷨���ȼ�����������״̬"+"\n");
		runQ.append("\n"+p.name+"�����ж����У���������״̬"+"\n");
		p.state="����״̬";
		runQ.append("������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
		if(p.runedTime<p.waitPoint){
			int x=p.runedTime;
			for(int i=x;i<p.waitPoint;i++){
				p.runedTime+=1;
				w.wt();
				runQ.append("\n"+p);	
			}
			runQ.append("\n"+p.name+"����ȴ���,����������������"+"\n");
			waitQ.append("\n"+p.name+"����ȴ���,������������");
			waitQ.append("\n"+"������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
			p.state="����״̬";
			wait.add(p);
		}else{
			if((p.runTime-p.runedTime)<=time){
				for(int i=p.runedTime;i<p.runTime;i++){
					p.runedTime+=1;
					w.wt();
					runQ.append("\n"+p);
				}
				runQ.append("\n"+p.name+"���н���");
				p.state="����״̬";
				proQ.append("\n"+p.name+"���н���"+"\n");
				proQ.append("������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
				proQ.append("\n"+p);
			}else{
				int x=p.runedTime;
				for(int i=x;i<x+time;i++){
					p.runedTime+=1;
					runQ.append("\n"+p);		
				}
				p.state="����״̬";
				runQ.append("\nһ��ʱ��Ƭ������"+p.name+"�����������"+"\n");
				readyQ.append("\nһ��ʱ��Ƭ������"+p.name+"�����������"+"\n");
				readyQ.append("������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
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