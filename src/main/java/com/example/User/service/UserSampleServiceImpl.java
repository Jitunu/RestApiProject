package com.example.User.service;

import com.example.User.dao.SampleData;
import com.example.User.dao.UserSampleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;

@Service
public class UserSampleServiceImpl implements UserSampleService {

    @Autowired
    private UserSampleDao userSampleDao;


    @Override
    public String addSampleData(SampleData sampleData) {
        boolean result = userSampleDao.addUserData(sampleData);
        String str = null;
        if(result) {
            str = "Added Successful. Total number of User Data : "+ userSampleDao.getSampleDataList().size();
        }
        return str;
    }


    private String processEnumError(String errorMesssage) {
        String message = "%s can have %s ";
        if ("Channel".contains(errorMesssage)) {
            return String.format(message, "Channel");
        } else if ("Brand".contains(errorMesssage)) {
            return String.format(message, "Brand");
        }
        return "Invalid SMS Request";
    }
    public static void main(String[] args) {
        new UserSampleServiceImpl().processEnumError(null);
    }
}
