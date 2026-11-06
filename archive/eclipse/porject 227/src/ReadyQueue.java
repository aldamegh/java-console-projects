import java.io.*;
import java.util.*;

public class ReadyQueue {
	
	Queue<PCB> readyQueue ;
	
	QNode  Rear;
	QNode  Front;
	
	
	public  ReadyQueue() {
		Queue<PCB> readyQueue = new LinkedList<PCB>() ;
		
		this.Rear = null ;
	    this.Front = null ;
		
		
		
				
		
}
		void enqueue(int key) {
	    
	        QNode temp = new QNode(key);
	 
	       
	        if (this.Rear == null) {
	            this.Front = this.Rear = temp;
	            return;
	        }
	 
	        
	        this.Rear.next = temp;
	        this.Rear = temp;
	    }
	 
	  
	    void dequeue() {
	        
	        if (this.Front == null)
	            return;
	 
	        
	        QNode temp = this.Front;
	        this.Front = this.Front.next;
	 
	       
	        if (this.Front == null)
	            this.Rear = null;
	    }
		
	    
	    
	    
	    
	    
		class QNode {
		    int key;
		    QNode next;
		 
		    public QNode(int key)
		    {
		        this.key = key;
		        this.next = null;
		    }
		}	
}