package com.nithinkvijayan.www.customloadersampleproject;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements LoaderCallbacks<ArrayList<String>> {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.text_view);
        getLoaderManager().initLoader(2,null,this);
    }

    @Override
    public Loader<ArrayList<String>> onCreateLoader(int i, Bundle bundle) {
        RandomStringLoader randomStringLoader=new RandomStringLoader(this);
        return randomStringLoader;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<String>> loader, ArrayList<String> strings) {
        String para="";
        for(String string: strings)
            para=para+string;
        textView.setText(para);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<String>> loader) {

    }
}
