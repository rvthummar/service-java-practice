package com.rv.servicejavapractice.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rv.servicejavapractice.enums.Fruit;
import com.rv.servicejavapractice.model.CommonResponse;
import com.rv.servicejavapractice.model.FruitShop;
import com.rv.servicejavapractice.service.PracticeService;
import com.rv.servicejavapractice.utils.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PracticeServiceImpl implements PracticeService {

	private static final String PARSIAL_DISBURSED = "Parsial Disbursed";
	private static final String SANCTION = "Sanction";
	private static final String DISBURSED = "Disbursed";

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

			List<Items> itemsList = List.of(new Items("Ravi", "Patel"), new Items("Jenish", "Thummar"));
			if (!Utils.isListNullOrEmpty(itemsList))
				stringObjectMap.put("itemsList", itemsList);

			if (!Utils.isObjectNullOrEmpty(stringObjectMap)) {
				return stringObjectMap;
			}
			return Collections.emptyMap();
		} catch (Exception e) {
			log.error("error is getting get while get getData() Method ", e);
		}
		return Collections.emptyMap();
	}

	@Override
	public List<CommonResponse> getDataList() {
		List<CommonResponse> commonResponseList = CommonResponse.generateCommonResponceList();

		if (!Utils.isListNullOrEmpty(commonResponseList)) {
			CommonResponse response = commonResponseList.stream().findFirst().orElse(null);
			if (!Utils.isObjectNullOrEmpty(response) && !Utils.isObjectNullOrEmpty(response.getStatus())
					&& response.getStatus().equalsIgnoreCase(PARSIAL_DISBURSED)) {
				CommonResponse getSanctionData = commonResponseList.stream()
						.filter(x -> x.getStatus().equalsIgnoreCase(SANCTION)).findFirst().orElse(null);
				if (!Utils.isObjectNullOrEmpty(getSanctionData)
						&& !Utils.isObjectNullOrEmpty(getSanctionData.getAmount())
						&& Double.compare(response.getAmount(), getSanctionData.getAmount()) == 0) {
					commonResponseList.get(0).setStatus(DISBURSED);
				}
			}
		}
		return commonResponseList;
	}

	List<FruitShop> fruitShop() {
		return EnumSet.allOf(Fruit.class).stream().map(f -> new FruitShop(f.name())).toList();
	}

//	public static void main(String[] args) {
//		log.info("{}", search(new ArrayList<>(List.of("Ravi", "Jenish", "Abc", "abf"))));
//		log.info("{}", getString(new ArrayList<>(List.of(0, 22, 5))));
//	}

	public static List<String> search(List<String> list) {
		return list.stream().filter(x -> x.startsWith("a") && x.length() == 3).collect(Collectors.toList());
	}

	public static String getString(List<Integer> list) {
		return list.stream().map(x -> (x % 2 == 0 ? "e" : "o") + x).collect(Collectors.joining(","));
	}

}
