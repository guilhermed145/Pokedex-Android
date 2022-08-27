package com.portfolio.pokeapp.model.async;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRunner {

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());

    public void executeAsync () {
        executor.execute(() -> {
            /*
             * Your task will be executed here
             * you can execute anything here that
             * you cannot execute in UI thread
             * for example a network operation
             * This is a background thread and you cannot
             * access view elements here
             *
             * its like doInBackground()
             * */
            handler.post(() -> {
                /*
                 * You can perform any operation that
                 * requires UI Thread here.
                 *
                 * its like onPostExecute()
                 * */
            });
        });
    }
}