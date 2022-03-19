package com.example.mvvmarchitecture_demo_project.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmarchitecture_demo_project.models.nicePlace;
import com.example.mvvmarchitecture_demo_project.repository.NicePlaceRepository;

import java.util.List;

public class MainAcivitViewModel extends ViewModel {

    private NicePlaceRepository nicePlaceRepository;
    private MutableLiveData<List<nicePlace>> NicePlace;
    private  MutableLiveData<Boolean> mIsUpdating=new MutableLiveData<>();

    public void init(){
        if(NicePlace !=null){
            return;
        }
        nicePlaceRepository= NicePlaceRepository.getInstance();
        NicePlace=nicePlaceRepository.getNicePlaces();
    }

    public void addNewValue(final nicePlace nicePlace){
        mIsUpdating.setValue(true);
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                List<nicePlace>currentPleaces=NicePlace.getValue();
                currentPleaces.add(nicePlace);
                NicePlace.postValue(currentPleaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

        }.execute();
    }

    public LiveData<List<nicePlace>> getNicePlaces(){
        return NicePlace;
    }

    public LiveData<Boolean>getIsUpdating(){
        return mIsUpdating;
    }
}
