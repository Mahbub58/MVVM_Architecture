package com.example.mvvmarchitecture_demo_project.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmarchitecture_demo_project.models.nicePlace;

import java.util.ArrayList;
import java.util.List;

/**
 * singleton pattern
 */
public class NicePlaceRepository {
    private static NicePlaceRepository instance;
    private ArrayList<nicePlace>dataSet=new ArrayList<>();

    public static NicePlaceRepository getInstance(){
        if(instance==null){
            instance=new NicePlaceRepository();
        }
        return instance;
    }

    //pertend to get data from a webservices or online source
    public MutableLiveData<List<nicePlace>> getNicePlaces(){
        setNicePlaces();

        MutableLiveData<List<nicePlace>>data=new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }
    private void setNicePlaces(){
        dataSet.add(new nicePlace("Bangladesh","https://th.bing.com/th/id/OIP.V0ZTog9uqSiLHsFvXpYRsgHaE7?pid=ImgDet&rs=1"));
        dataSet.add(new nicePlace("US","https://th.bing.com/th/id/R.5bc6a94ca0114ea56198bccc0a2b0d98?rik=eDteuVFFJ12iYg&pid=ImgRaw&r=0"));
        dataSet.add(new nicePlace("UAE","https://th.bing.com/th/id/OIP.V0ZTog9uqSiLHsFvXpYRsgHaE7?pid=ImgDet&rs=1"));
        dataSet.add(new nicePlace("UK","https://th.bing.com/th/id/OIP._SbuwodiLhpBqamg5D2EEAHaEK?pid=ImgDet&w=626&h=352&rs=1"));
        dataSet.add(new nicePlace("IND","https://th.bing.com/th/id/OIP.UCEQ68CIApHibRqBvxmTvwD6D6?pid=ImgDet&rs=1"));
        dataSet.add(new nicePlace("Japan","https://th.bing.com/th/id/OIP.szVykBXJfXLit2MGCJ-CagHaE7?pid=ImgDet&w=626&h=417&rs=1"));
        dataSet.add(new nicePlace("USA","https://cdn11.bigcommerce.com/s-x68mczjd0x/images/stencil/1280x1280/products/977/4790/Euphorbia_tirucalli_Sticks_on_Fire_landscape__91462.1562437919.jpg?c=2&imbypass=on"));
        dataSet.add(new nicePlace("Bangladesh","https://th.bing.com/th/id/OIP.hUEh3pqwSSHHK7EjofJ-VwHaE6?pid=ImgDet&rs=1"));
        dataSet.add(new nicePlace("IND","https://th.bing.com/th/id/OIP._SbuwodiLhpBqamg5D2EEAHaEK?pid=ImgDet&w=626&h=352&rs=1"));

    }

}
