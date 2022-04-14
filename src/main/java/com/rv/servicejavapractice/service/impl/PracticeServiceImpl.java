package com.rv.servicejavapractice.service.impl;

import com.rv.servicejavapractice.model.CommonResponse;
import com.rv.servicejavapractice.service.PracticeService;
import com.rv.servicejavapractice.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PracticeServiceImpl implements PracticeService {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Items {
        private String firstName;
        private String lastName;
    }

    @Override
    public Map<String, Object> getData() {
        try {
            Map<String, Object> stringObjectMap = new HashMap<>();

            List<String> stringList = List.of("");
            if (!Utils.isListNullOrEmpty(stringList))
                stringObjectMap.put("stringList", stringList);

            List<Integer> integerList = List.of(1, 2, 3, 4);
            if (!Utils.isListNullOrEmpty(integerList))
                stringObjectMap.put("integerList", integerList);

            List<Items> itemsList = List.of(
                    new Items("Ravi", "Patel"),
                    new Items("Jenish", "Thummar"));
            if (!Utils.isListNullOrEmpty(itemsList))
                stringObjectMap.put("itemsList", itemsList);

            if (!Utils.isObjectNullOrEmpty(stringObjectMap)) {
                return stringObjectMap;
            }
            return null;
        } catch (Exception e) {
            log.error("error is getting get while get getData() Method ", e);
        }
        return null;
    }

    @Override
    public List<CommonResponse> getDataList() {
        List<CommonResponse> commonResponseList = new ArrayList<>();
        commonResponseList.add(new CommonResponse("Parsial Disbursed", 8, new Date(), 700000.00));
        commonResponseList.add(new CommonResponse("Parsial Disbursed", 8, new Date(), 400000.0));
        commonResponseList.add(new CommonResponse("Parsial Disbursed", 8, new Date(), 200000.0));
        commonResponseList.add(new CommonResponse("Sanction", 2, new Date(), 700000.00));
        commonResponseList.add(new CommonResponse("Completed", 1, new Date(), 700000.00));

        if (!Utils.isListNullOrEmpty(commonResponseList)) {
            CommonResponse response = commonResponseList.stream().findFirst().orElse(null);
            if (!Utils.isObjectNullOrEmpty(response)
                    && response.getStatus().equalsIgnoreCase("Parsial Disbursed")) {
                CommonResponse getSanctionData = commonResponseList.stream()
                        .filter(x-> x.getStatus().equalsIgnoreCase("Sanction"))
                        .findFirst().orElse(null);
                if(Double.compare(response.getAmount(), getSanctionData.getAmount()) == 0){
                    commonResponseList.get(0).setStatus("Disbursed");
                }
            }
        }


        return commonResponseList;
    }
}
