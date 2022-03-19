package com.example.mvvmarchitecture_demo_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mvvmarchitecture_demo_project.adaptor.recyclerviewAdaptor;
import com.example.mvvmarchitecture_demo_project.models.nicePlace;
import com.example.mvvmarchitecture_demo_project.viewmodels.MainAcivitViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    recyclerviewAdaptor recyclerviewAdaptor;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    FloatingActionButton mFb;
    private MainAcivitViewModel mainAcivitViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        progressBar=findViewById(R.id.progressBar);
        mFb=findViewById(R.id.floating);

        mainAcivitViewModel= new ViewModelProvider(this).get(MainAcivitViewModel.class);
        mainAcivitViewModel.init();
        mainAcivitViewModel.getNicePlaces().observe(this, new Observer<List<nicePlace>>() {
            @Override
            public void onChanged(List<nicePlace> nicePlaces) {
                recyclerviewAdaptor.notifyDataSetChanged();
            }
        });

        mainAcivitViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }else{
                    hideProgressBar();
                    recyclerView.smoothScrollToPosition(mainAcivitViewModel.getNicePlaces().getValue().size()-1);
                }
            }
        });

        mFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainAcivitViewModel.addNewValue(new nicePlace("Addidas","https://th.bing.com/th/id/OIP.5G0XdnUpKu5zCoFKL-M4mQHaEc?pid=ImgDet&rs=1"));
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerviewAdaptor=new recyclerviewAdaptor(this,mainAcivitViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerviewAdaptor);
    }

    void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }
    void hideProgressBar(){
        progressBar.setVisibility(View.INVISIBLE);
    }
}