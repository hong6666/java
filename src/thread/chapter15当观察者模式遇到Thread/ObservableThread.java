package thread.chapter15当观察者模式遇到Thread;

import javafx.beans.value.ObservableValue;

/**
 * ObservableThread
 * 2020-5-27观察者模式和线程结合搞不懂
 * @author 李弘昊
 * @since 2020/5/25
 */
public class ObservableThread<T> extends Thread implements Observable{

    private final TaskLifecycle<T> lifecycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObservableThread(Task<T> task)
    {
        this(new TaskLifecycle.EmptyLifecycle<>(),task);
    }

    public ObservableThread(TaskLifecycle<T> lifecycle,Task<T> task)
    {
        super();
        if (task == null)
        {
            throw new IllegalArgumentException("The task is required.");
        }
        this.lifecycle = lifecycle;
        this.task = task;
    }

    @Override
    public final void run()
    {
        //TODO
    }

    private void update(Cycle cycle,T result,Exception e)
    {
        //TODO
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }

}
