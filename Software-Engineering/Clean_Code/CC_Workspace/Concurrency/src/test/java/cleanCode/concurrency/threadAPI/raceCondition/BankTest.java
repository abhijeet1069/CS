package cleanCode.concurrency.threadAPI.raceCondition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

class BankTest {

	@Test
	void testTransfer() {
		Bank bank = new Bank("Karur Vyasa Bank");
		Account satyam = new Account("Satyam",10000);
		Account ayush = new Account("Ayush",10000);
		Account karan = new Account("Karan",1000);
		bank.addAccount(satyam);
		bank.addAccount(ayush);
		bank.addAccount(karan);
		
		assertTrue(bank.transfer(satyam, karan, 1000));
		assertEquals(9000,satyam.getBalance());
		assertEquals(2000,karan.getBalance());
		
		assertFalse(bank.transfer(karan, satyam, 9000));
		assertEquals(9000,satyam.getBalance());
		assertEquals(2000,karan.getBalance());
	}
	
	@Test
	void testConcurrentTransfers() throws InterruptedException {
		Bank bank = new Bank("Test Bank");
		Account a = new Account("A", 10000);
		Account b = new Account("B", 10000);
		bank.addAccount(a);
		bank.addAccount(b);

		int numThreads = 10;
		int transferAmount = 100;

		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		CountDownLatch latch = new CountDownLatch(numThreads * 2); // A→B and B→A transfers

		// A to B
		for (int i = 0; i < numThreads; i++) {
			executor.submit(() -> {
				bank.transfer(a, b, transferAmount);
				latch.countDown();
			});
		}

		// B to A
		for (int i = 0; i < numThreads; i++) {
			executor.submit(() -> {
				bank.transfer(b, a, transferAmount);
				latch.countDown();
			});
		}

		latch.await(); // wait for all transfers to finish
		executor.shutdown();

		// Total money should remain the same
		assertEquals(20000, a.getBalance() + b.getBalance());
	}


}
