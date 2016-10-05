package com.anthonyng.wavechallenge.util.schedulers;

import rx.Scheduler;

/**
 * Created by Anthony on 2016-10-04.
 */

public interface BaseSchedulerProvider {

    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
