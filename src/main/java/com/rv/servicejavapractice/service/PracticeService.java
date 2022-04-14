package com.rv.servicejavapractice.service;

import com.rv.servicejavapractice.model.CommonResponse;

import java.util.List;
import java.util.Map;

public interface PracticeService {
    Map<String, Object> getData();

    List<CommonResponse> getDataList();
}
