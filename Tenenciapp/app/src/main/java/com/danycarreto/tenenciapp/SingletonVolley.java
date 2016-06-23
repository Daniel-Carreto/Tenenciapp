package com.danycarreto.tenenciapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by DanyCarreto on 23/06/16.
 */
public class SingletonVolley {

    private static SingletonVolley mInstance;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private SingletonVolley(Context context){
        mCtx = context;
        requestQueue =  getRequestQueue();
    }


    public static synchronized  SingletonVolley getmInstance(Context context){
        if(mInstance == null){
            mInstance = new SingletonVolley(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }


}