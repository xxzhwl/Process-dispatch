package com;

import java.util.Iterator;
import java.util.LinkedList;

public class Waitting extends Thread{
	LinkedList<Pcb> ready;
	LinkedList<Pcb> wait;
	Iterator<Pcb> it;
	start sta;
	public Waitting(LinkedList<Pcb> pcbs,LinkedList<Pcb> pcbs2,start st){
		ready=pcbs;
		wait=pcbs2;
		sta=st;
	}
	public void wt (){
		it= wait.iterator();
		Pcb p1;
        while(it.hasNext() ){
            p1 = it.next();
            p1.waitedTime+=1;
            sta.waitQ.append("\n"+p1);
            if(p1.waitedTime>=p1.waitTime){
            	p1.state="����״̬";
        		sta.waitQ.append("\n"+p1.name+"�ȴ��������뿪�ȴ����У����������������"+"\n");
            	wait.remove(p1);
            	sta.readyQ.append("\n"+p1.name+"�ȴ��������뿪�ȴ����У������������"+"\n");
            	sta.readyQ.append("������"+"\t"+"Ҫ������ʱ��"+"\t"+"���ȼ�"+"\t"+"״̬"+"\t"+"������ʱ��"+"\t"+"�ȴ���"+"\t"+"�ȴ�ʱ��"+"\t"+"�ѵȴ�ʱ��\n");
            	sta.readyQ.append(p1.toString());
            	ready.add(p1);
            }
        }
	}
}
