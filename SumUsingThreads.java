public class SumUsingThreads {

	private static MyThread[] threads;

	static class MyThread extends Thread{
		private long sum; //sum

		public long getSum(){ //getter for sum
			return sum;
		}

		@Override
		public void run(){ //loops from 1 to 1,000,000 and sums
			long s = 0;
			for(int i = 1; i <= 1000000; i++){
				s++;
			}
			sum = s;
		}
	}
	public static void main(String[] args){

		long start = System.nanoTime(); //start time

		threads = new MyThread[1000]; //creates array of threads
		for(int i = 0; i < threads.length; i++){
			threads[i] = new MyThread();
			threads[i].start();
		}

		for(MyThread t : threads){
			try {
				t.join(); //join threads to main
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}

		long sumT = 0;
		for(MyThread thread : threads){
			sumT += thread.getSum(); //sums the sums of all threads
		}

		long end = System.nanoTime(); //end time

		System.out.println("Sum: " + sumT);
        System.out.println("Time (ns): " + (end - start));
	}
}