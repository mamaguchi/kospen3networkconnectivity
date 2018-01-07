package com.example.intel.kospenmove02;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;


public class SyncTask extends AsyncTask<JobParameters, Void, Result<JobParameters>> {

    private static final String JOB_SCHEDULE_TAG = "SyncJobService";

    public static final String SYNC_KOSPENPATH_KEY = "kospenusers_api_endpoint";

    private static final int NOTIFICATION_ID = "SyncTaskNotification".hashCode();

    private final WeakReference<JobService> jobServiceWeakRef;



    public SyncTask(JobService jobService) {
        this.jobServiceWeakRef = new WeakReference<JobService>(jobService);
    }


    @Override
    protected Result<JobParameters> doInBackground(JobParameters... jobParameters) {
        // TO DO : kospenusers and screenings update btw database<->server

        Log.i(JOB_SCHEDULE_TAG, "[doInBackground] Async task running scheduled job...");
        Result<JobParameters> result = new Result<JobParameters>();
        result.jobParams = jobParameters[0];
        Log.i(JOB_SCHEDULE_TAG, "[doInBackground] Async task completed scheduled job...");

        return result;
    }

    @Override
    protected void onPostExecute(Result<JobParameters> jobParametersResult) {

        Log.i(JOB_SCHEDULE_TAG, "[onPostExecute] Async task: calling onPostExecute()");
        Toast.makeText(jobServiceWeakRef.get(), "[onPostExecute] AsyncJob finished successfully.", Toast.LENGTH_SHORT).show();

        jobServiceWeakRef.get().jobFinished(jobParametersResult.jobParams, false);

//        if(jobServiceWeakRef!=null && jobServiceWeakRef.get()!=null) {
//            Toast.makeText(jobServiceWeakRef.get(), "AsyncJob finished successfully.", Toast.LENGTH_SHORT).show();
//            jobServiceWeakRef.get().jobFinished(jobParametersResult.jobParams, false);
//        }
    }
}



































