
public class ReadyQueueScheduler extends Thread {

	public ReadyQueueScheduler() {
		// TODO Auto-generated constructor stub
	}

	public ReadyQueueScheduler(Runnable task) {
		super(task);
		// TODO Auto-generated constructor stub
	}

	public ReadyQueueScheduler(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public ReadyQueueScheduler(ThreadGroup group, Runnable task) {
		super(group, task);
		// TODO Auto-generated constructor stub
	}

	public ReadyQueueScheduler(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	public ReadyQueueScheduler(Runnable task, String name) {
		super(task, name);
		// TODO Auto-generated constructor stub
	}

	public ReadyQueueScheduler(ThreadGroup group, Runnable task, String name) {
		super(group, task, name);
		// TODO Auto-generated constructor stub
	}

	public ReadyQueueScheduler(ThreadGroup group, Runnable task, String name, long stackSize) {
		super(group, task, name, stackSize);
		// TODO Auto-generated constructor stub
	}

	public ReadyQueueScheduler(ThreadGroup group, Runnable task, String name, long stackSize,
			boolean inheritInheritableThreadLocals) {
		super(group, task, name, stackSize, inheritInheritableThreadLocals);
		// TODO Auto-generated constructor stub
	}

}
