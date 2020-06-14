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
	}//先来先服务，选出第一个传给p,之后删除队列的第一项，返回p
	
	public void RR(){
		it= ready.iterator();
		Pcb p;
        while(it.hasNext()){
            p = ready.getFirst();
            ready.removeFirst();
    		r=new Running(p,ready,wait,sta);
    		r.RR();
        }
	}//时间片轮转
	
	public void Piro(){
		Comparator<Pcb> c = new Comparator<Pcb>() {
            @Override
            public int compare(Pcb p1, Pcb p2) {
                
                if(p1.prior>=p2.prior)
                    return -1;  //正数表示p1比p2要大
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
	}//优先级调度
	
	public void Piro_RR(){
		Comparator<Pcb> c = new Comparator<Pcb>() {
            @Override
            public int compare(Pcb p1, Pcb p2) {
                
                if(p1.prior>=p2.prior)
                    return -1;  //正数表示p1比p2要大
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
	}//优先级调度+时间片轮转
	
	
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
	}//短进程优先
	
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
	}//短进程优先+时间片轮转
}
