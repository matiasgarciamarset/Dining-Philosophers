package com.matias;

import java.util.concurrent.Semaphore;

public class Main {

	private final static Integer AMOUNT_PHILOSOPHERS = 11;
	private final static Semaphore[] sem = new Semaphore[AMOUNT_PHILOSOPHERS+1];

	public static void main(String[] args) {
		for (int i=  0; i < AMOUNT_PHILOSOPHERS+1; i++) {
			sem[i] = new Semaphore(1);
		}
		for (int i=  0; i < AMOUNT_PHILOSOPHERS; i++) {
			(new Philosopher(i, sem, AMOUNT_PHILOSOPHERS)).start();
		}
	}

}
