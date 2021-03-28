package com.example.User.dao;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSampleDaoImpl implements UserSampleDao {

    List<SampleData> sampleDataList = new ArrayList<SampleData>();

    @Override
    public boolean addUserData(SampleData sampleData) {

        return sampleDataList.add(sampleData);
    }

    public List<SampleData> getSampleDataList(){
        return sampleDataList;
    }

}
