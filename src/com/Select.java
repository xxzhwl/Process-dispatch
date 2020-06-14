package com;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Select {
	LinkedList<Pcb> ready;
	LinkedList<Pcb> wait;
	Pcb p;
	Running r;
	Iterator<Pcb> it;
	start sta;
	public Select(LinkedList<Pcb> pcbs,LinkedList<Pcb> pcbs2,start st){
		ready=pcbs;
		wait=pcbs2;
		sta=st;
	}
	public void FCFS(){	
		it= ready.iterator();
		Pcb p;
        while(it.hasNext()){
            p = ready.getFirst();
            ready.removeFirst();
    		r=new Running(p,ready,wait,sta);
    		r.Fcfs();
        }
	}//�����ȷ���ѡ����һ������p,֮��ɾ�����еĵ�һ�����p
	
	public void RR(){
		it= ready.iterator();
		Pcb p;
        while(it.hasNext()){
            p = ready.getFirst();
            ready.removeFirst();
    		r=new Running(p,ready,wait,sta);
    		r.RR();
        }
	}//ʱ��Ƭ��ת
	
	public void Piro(){
		Comparator<Pcb> c = new Comparator<Pcb>() {
            @Override
            public int compare(Pcb p1, Pcb p2) {
                
                if(p1.prior>=p2.prior)
                    return -1;  //������ʾp1��p2Ҫ��
                else
                    return 1;
            }
        };
        it= ready.iterator();
		Pcb p;
        while(it.hasNext()){
        	Collections.sort(ready,c);
            p = ready.getFirst();
            ready.removeFirst();
    		r=new Running(p,ready,wait,sta);
    		r.Fcfs();
        }
	}//���ȼ�����
	
	public void Piro_RR(){
		Comparator<Pcb> c = new Comparator<Pcb>() {
            @Override
            public int compare(Pcb p1, Pcb p2) {
                
                if(p1.prior>=p2.prior)
                    return -1;  //������ʾp1��p2Ҫ��
                else
                    return 1;
            }
        };       
        it= ready.iterator();
		Pcb p;
        while(it.hasNext()){
        	Collections.sort(ready,c);
            p = ready.getFirst();
            ready.removeFirst();
    		r=new Running(p,ready,wait,sta);
    		r.RR();
        }
	}//���ȼ�����+ʱ��Ƭ��ת
	
	
	public void Spf(){
		Comparator<Pcb> c = new Comparator<Pcb>() {
            @Override
            public int compare(Pcb p1, Pcb p2) {
                
                if(p1.runTime<=p2.runTime)
                    return -1;  
                else
                    return 1;
            }
        };     
        it= ready.iterator();
		Pcb p;
        while(it.hasNext()){
        	Collections.sort(ready,c);
            p = ready.getFirst();
            ready.removeFirst();
    		r=new Running(p,ready,wait,sta);
    		r.Fcfs();
        }
	}//�̽�������
	
	public void Spf_RR(){
		Comparator<Pcb> c = new Comparator<Pcb>() {
            @Override
            public int compare(Pcb p1, Pcb p2) {
                
                if(p1.runTime<=p2.runTime)
                    return -1;  
                else
                    return 1;
            }
        };    
        it= ready.iterator();
		Pcb p;
        while(it.hasNext()){
        	Collections.sort(ready,c);
            p = ready.getFirst();
            ready.removeFirst();
    		r=new Running(p,ready,wait,sta);
    		r.Fcfs();
        }
	}//�̽�������+ʱ��Ƭ��ת
}
