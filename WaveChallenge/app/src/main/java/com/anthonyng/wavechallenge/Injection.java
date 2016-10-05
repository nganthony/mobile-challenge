package com.anthonyng.wavechallenge;

import com.anthonyng.wavechallenge.data.DataSource;
import com.anthonyng.wavechallenge.data.RemoteDataSource;
import com.anthonyng.wavechallenge.util.schedulers.BaseSchedulerProvider;
import com.anthonyng.wavechallenge.util.schedulers.SchedulerProvider;

/**
 * Created by Anthony on 2016-10-04.
 */
public class Injection {

    public static DataSource provideDataSource() {
        return RemoteDataSource.getInstance();
    }

    public static BaseSchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
