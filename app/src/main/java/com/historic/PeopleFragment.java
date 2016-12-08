package com.historic;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class PeopleFragment extends Fragment{

    private RecyclerView recyclerView;
    private ContentAdapter mAdapter;
    private Context context;

    private AdView mAdView;
    public PeopleFragment() {
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View v =  inflater.inflate(R.layout.fragment_people, container, false);

        mAdView = (AdView) v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView = (RecyclerView) v.findViewById(R.id.content_recycler_view);
        mAdapter = new ContentAdapter(getContentModel(getActivity()),getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),1,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        return  v;
    }

    public List getContentModel(final Context context) {
        List<Content> personalityList = null;
        try {
            Reader reader = new InputStreamReader(context.getAssets().open
                    ("people.json"), "UTF-8");
            Gson gson = new Gson();
            Type type = new TypeToken<List<Content>>(){}.getType();
            personalityList = gson.fromJson(reader, type);
        } catch (Exception e) {
            return null;
        } finally {
            return personalityList;
        }
    }
}
