/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package speed_traffick_pack;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Car implements Runnable{
    int ID;
    int direction;
    Place place;
    int timer;
    int speed = 1000; //int places per second
	Thread t;
	
    
    public Car(){
    	Runnable s =  (Runnable) this;
    	this.t = new Thread(s);
    }
    
    public Thread getThread() {
    	return this.t;
    }

    public void setSpeed(int speed) {
    	this.speed =  speed;
    }
    public int getSpeed(){
    	return this.speed;
    }
    
    public float getTimer() {
    	return this.timer/((float) 1000);
    }
    
    
    
    
    public void run() {
    	try {
	    	while(!Thread.currentThread().isInterrupted()) {
	    		if(this.place.GetnextPlace_direction(this.direction)!=null) {
		    		if(this.place.FreeToMove(this.direction)) {
		    			Place lugar = this.place;
    					this.place = this.place.GetnextPlace_direction(this.direction);
    					this.place.setBlocked(true);
    					lugar.blocked = false;
		    	        //Aumenta contador del place si es medidor
		    	        if(this.place.isMeasuring()){
		    	        	this.place.setContCarros(this. place.getContCarros()+1);
		    	        }
	    	        	int time = 1/this.speed;
	    				Thread.sleep(time);
	    				this.timer+=time;
		        	}
	    		}else {
	    			Place lugar = this.place;
	    			this.place = this.place.GetnextPlace_direction(this.direction);
	    			lugar.setBlocked(false);
	    			return;
	    			
	    		}
	    		Thread.sleep(1);
	    		this.timer+=1;
	    	}
		}catch(Exception e) {
			return;
    	}
    }
    
    public Car(int id, int direction, Place place) {
        this.ID = id;
        this.direction = direction;
        this.place = place;
        this.place.setBlocked(true);
        Runnable s =  (Runnable) this;
        this.t = new Thread(s);
    }
    
    public Car(int id, int direction, Place place, int speed) {
        this.ID = id;
        this.direction = direction;
        this.place = place;
        this.place.setBlocked(true);
        this.speed = speed;
        Runnable s =  (Runnable) this;
    	this.t = new Thread(s);
    }

    public Car(int id) {
        this.ID = id;
        Runnable s =  (Runnable) this;
    	this.t = new Thread(s);
    }
    
    public void MoveCar() {
    	if(this.place.FreeToMove(this.direction)) {
    		this.place.setBlocked(false);
    		this.place = this.place.GetnextPlace_direction(this.direction);
    		this.place.setBlocked(true);
	        //Aumenta contador del place si es medidor
	        if(this.place.isMeasuring()){
	        	this.place.setContCarros(this. place.getContCarros()+1);
	        }
    	}
    }  
}
