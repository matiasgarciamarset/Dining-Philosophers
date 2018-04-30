package com.matias;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
	private Integer id;
	private Integer amount_philosophers;
	private Semaphore[] sem;

	Philosopher(int id, Semaphore[] sem, Integer amount_philosophers) {
		this.id = id+1;
		this.amount_philosophers = amount_philosophers;
		this.sem = sem;
	}

	public void run() {
        System.out.println("["+this.id.toString()+"] I'm thinking");
        try {
	        if (id % 2 == 0) {
	        		// If philosopher is even then take right and then left
				sem[id-1].acquire();
	        		sem[id%amount_philosophers].acquire();
	        } else { 
	        		//  Otherwise take left and then right
		    		sem[id%amount_philosophers].acquire();
		    		sem[id-1].acquire();
	        }
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("["+this.id.toString()+"] I'm eating");
        sem[id%amount_philosophers].release();
		sem[id-1].release();
		System.out.println("["+this.id.toString()+"] I'm done ------");
		return;
    }
	

}
