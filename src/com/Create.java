package com;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JTextArea;

public class Create extends Thread{
	LinkedList<Pcb> ready=new LinkedList<Pcb>();
	Pcb p;
	public Create(int num,JTextArea result,JTextArea readyQ){
		int s=num;
		result.append("\n���ڴ�������,���Ժ�\n");
		for(int i=0;i<s;i++){
			result.append("���ڴ�����"+(i+1)+"������\n");
			p=new Pcb();
			p.name="����"+(i+1);
			p.runTime=(int) (Math.random()*5)+6;
			p.prior=(int)(Math.random()*9)+1;
			p.runedTime=0;
			p.state="����״̬";
			p.waitPoint=(int) (Math.random()*2)+2;
			p.waitTime=(int)(Math.random()*2)+1;
			p.waitedTime=0;
			ready.add(p);
		}
		result.append("\n�������,��������Ϣ���£�");
		result.append("\n������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
        readyQ.append("\n������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��");
		Iterator<Pcb> it= ready.iterator();
        while(it.hasNext()){
            p = it.next();
            result.append("\n"+p.toString());
            p.state="����״̬";
            readyQ.append("\n"+p.toString());
       }
	}
}
