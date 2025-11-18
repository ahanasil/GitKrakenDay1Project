public class SumUsingThreads {

	private static MyThread[] threads;

	static class MyThread extends Thread{
		@Override
		public void run(){
			int sum = 0;
			for(int i = 1; i <= 1000000; i++){
				sum += i;
			}
		}
	}
	public static void main(String[] args){
		threads = new MyThread[1000];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new MyThread();
		}
	}
}