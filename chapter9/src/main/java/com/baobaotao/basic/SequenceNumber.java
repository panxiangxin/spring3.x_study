package com.baobaotao.basic;

public class SequenceNumber {
	
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
		return 0;
	}
	};

	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	
	public static void main(String[] args) {
		
		SequenceNumber sequenceNumber = new SequenceNumber();
		
		TestClient t1 = new TestClient(sequenceNumber);
		TestClient t2 = new TestClient(sequenceNumber);
		TestClient t3 = new TestClient(sequenceNumber);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static class TestClient extends Thread{
		
		private SequenceNumber sNumber;
		
		public TestClient(SequenceNumber sNumber) {
			this.sNumber = sNumber;
}
		@Override
		public void run() {
			
			for (int i = 0; i < 3; i++) {
				System.out.println("thread["+Thread.currentThread().getName()+"] sn["+ sNumber.getNextNum()+"]");
			}
		}
	}
}
