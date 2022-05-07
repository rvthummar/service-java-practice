package com.rv.servicejavapractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

	private static final String PARSIAL_DISBURSED = "Parsial Disbursed";
	private String status;
	private Integer statusId;
	private Date date;
	private Double amount;

	String getCommonResponse() {
		return this.toString();
	}

	public static List<CommonResponse> generateCommonResponceList() {
		return new ArrayList<>(List.of(new CommonResponse(PARSIAL_DISBURSED, 8, new Date(), 700000.00),
				new CommonResponse(PARSIAL_DISBURSED, 8, new Date(), 400000.0),
				new CommonResponse(PARSIAL_DISBURSED, 8, new Date(), 200000.0),
				new CommonResponse("Sanction", 2, new Date(), 700000.00),
				new CommonResponse("Completed", 1, new Date(), 700000.00)));
	}

}
