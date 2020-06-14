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
            	p1.state="就绪状态";
        		sta.waitQ.append("\n"+p1.name+"等待结束，离开等待队列，即将进入就绪队列"+"\n");
            	wait.remove(p1);
            	sta.readyQ.append("\n"+p1.name+"等待结束，离开等待队列，进入就绪队列"+"\n");
            	sta.readyQ.append("进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间\n");
            	sta.readyQ.append(p1.toString());
            	ready.add(p1);
            }
        }
	}
}
