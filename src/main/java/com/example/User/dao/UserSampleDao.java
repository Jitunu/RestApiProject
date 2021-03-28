package com.example.User.dao;

import java.util.List;

public interface UserSampleDao {
    boolean addUserData(SampleData sampleData);
    List<SampleData> getSampleDataList();
}
