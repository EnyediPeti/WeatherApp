package hu.peter.enyedi.weatherapp;

import hu.axolotl.tasklib.InlineTaskListener;
import hu.axolotl.tasklib.android.TaskEngineHolder;
import hu.axolotl.tasklib.base.BaseTask;
import hu.peter.enyedi.weatherapp.ui.Presenter;

public class TaskPresenter<S> extends Presenter<S> {

    private TaskEngineHolder holder = new TaskEngineHolder(this);

    @Override
    public void attachScreen(S screen) {
        super.attachScreen(screen);
        holder.start();
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        holder.stop();
    }

    protected final <T, U> long executeTask(BaseTask<T, U> task) {
        return holder.executeTask(task);
    }

    protected final <T, U> long executeTask(BaseTask<T, U> task, InlineTaskListener<T, U> taskListener) {
        return holder.executeTask(task, taskListener);
    }
}
