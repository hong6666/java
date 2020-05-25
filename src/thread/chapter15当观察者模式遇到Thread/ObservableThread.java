package thread.chapter15当观察者模式遇到Thread;

import javafx.beans.value.ObservableValue;

/**
 * ObservableThread
 *
 * @author 李弘昊
 * @since 2020/5/25
 */
public class ObservableThread<T> extends Thread implements Observable{

    private final TaskLifecycle<T> lifecycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObservableThread(Task<T> task)
    {
        this(new TaskLifecycle.EmptyLifecycle<>(),task)
    }

    public ObservableValue

    @Override
    public Cycle getCycle() {
        return null;
    }

}
