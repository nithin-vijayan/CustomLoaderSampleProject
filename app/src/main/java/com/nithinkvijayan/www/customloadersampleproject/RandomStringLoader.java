package com.nithinkvijayan.www.customloadersampleproject;


import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nk on 28/8/16.
 */
public class RandomStringLoader extends AsyncTaskLoader<ArrayList<String>> {

    public RandomStringLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public void deliverResult(ArrayList<String> data) {
        if(isStarted())
        super.deliverResult(data);
    }

    @Override
    public ArrayList<String> loadInBackground() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String[] randomText={"Lorem ipsum dolor sit amet","Neque porro quisquam","dolorem ipsum quia dolor"};
        Random random=new Random();
        ArrayList<String> arrayList=new ArrayList<String>();

        for (int i=0;i<15;i++)
            arrayList.add(randomText[random.nextInt(randomText.length)]+"\n");
        return arrayList;

    }
}
