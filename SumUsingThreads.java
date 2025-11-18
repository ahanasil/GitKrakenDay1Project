public class SumUsingThreads {

	private static MyThread[] threads;

	static class MyThread extends Thread{
		@Override
		public void run(){

		}
	}
	public static void main(String[] args){
		threads = new MyThread[1000];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new MyThread();
		}
	}
}