package com.anthonyng.wavechallenge.util.schedulers;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Anthony on 2016-10-05.
 */

public class ImmediateScheduler implements BaseSchedulerProvider {

    @Override
    public Scheduler computation() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler io() {
        return Schedulers.immediate();
    }

    @Override
    public Scheduler ui() {
        return Schedulers.immediate();
    }
}
