package com.rv.servicejavapractice.service.impl;

import com.rv.servicejavapractice.service.PracticeService;
import com.rv.servicejavapractice.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PracticeServiceImpl implements PracticeService {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    class Items{
        private String firstName;
        private String lastName;
    }

    @Override
    public Map<String, Object> getData() {
        try {
            List<Integer> data = List.of(1, 2, 3, 4);
            List<Object> objectList = List.of(
                    new Items("ravi","Thummar"),
                    new Items("ravi","Thummar"));
            Map<String, Object> stringObjectMap = new HashMap<>();
            stringObjectMap.put("data", data);
            stringObjectMap.put("objectList",objectList);

            if (!Utils.isObjectNullOrEmpty(stringObjectMap)) {
                return stringObjectMap;
            }
            return null;
        } catch (Exception e) {
            log.error("error is getting get while get getData() Method ", e);
        }
        return null;
    }
}
