public class SumUsingThreads {

	private static MyThread[] threads;

	static class MyThread extends Thread{
		private long sum;

		public long getSum(){
			return sum;
		}

		@Override
		public void run(){
			long s = 0;
			for(int i = 1; i <= 1000000; i++){
				s++;
			}
			sum = s;
		}
	}
	public static void main(String[] args){

		long start = System.nanoTime();

		threads = new MyThread[1000];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new MyThread();
			threads[i].start();
		}

		for(MyThread t : threads){
			try {
				t.join();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}

		long sumT = 0;
		for(MyThread thread : threads){
			sumT += thread.getSum();
		}

		long end = System.nanoTime();

		System.out.println("Sum: " + sumT);
        System.out.println("Time (ns): " + (end - start));
	}
}