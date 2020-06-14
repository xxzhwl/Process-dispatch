package com;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JTextArea;

public class Create extends Thread{
	LinkedList<Pcb> ready=new LinkedList<Pcb>();
	Pcb p;
	public Create(int num,JTextArea result,JTextArea readyQ){
		int s=num;
		result.append("\n正在创建进程,请稍后\n");
		for(int i=0;i<s;i++){
			result.append("正在创建第"+(i+1)+"个进程\n");
			p=new Pcb();
			p.name="进程"+(i+1);
			p.runTime=(int) (Math.random()*5)+6;
			p.prior=(int)(Math.random()*9)+1;
			p.runedTime=0;
			p.state="创建状态";
			p.waitPoint=(int) (Math.random()*2)+2;
			p.waitTime=(int)(Math.random()*2)+1;
			p.waitedTime=0;
			ready.add(p);
		}
		result.append("\n创建完成,各进程信息如下：");
		result.append("\n进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
        readyQ.append("\n进程名"+"\t"+"要求运行时间"+"\t"+"优先级"+"\t"+"状态"+"\t"+"已运行时间"+"\t"+"等待点"+"\t"+"等待时间"+"\t"+"已等待时间");
		Iterator<Pcb> it= ready.iterator();
        while(it.hasNext()){
            p = it.next();
            result.append("\n"+p.toString());
            p.state="就绪状态";
            readyQ.append("\n"+p.toString());
       }
	}
}
