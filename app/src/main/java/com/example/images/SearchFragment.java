package com.example.images;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;

import java.util.Objects;


public class SearchFragment extends Fragment {
    RecyclerView searchRecycler;
    SearchBar search_bar;
    SearchView search_view;


 View view;

    public SearchFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_search, container, false);
        searchRecycler=view.findViewById(R.id.searchRecycler);
        search_bar=view.findViewById(R.id.search_bar);
        search_view=view.findViewById(R.id.search_view);
        search_view.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(event==null || event.getAction()!=KeyEvent.ACTION_DOWN){
                    return false;
                }
                search_bar.setText(search_view.getText());
                if(!Objects.requireNonNull(search_view.getText()).toString().isEmpty()){







                }
                return true;
            }
        });

        return view;
    }
}