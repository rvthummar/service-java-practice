package com.rv.servicejavapractice.enums;

public enum EnumStatus {

	PASSED(40L, "Has Passed"), AVERAGE(60L, "Has Average Marks"), GOOD(80L, "Has Good Marks");

	private String name;
	private Long id;

	EnumStatus(Long id, String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}
	
	
	public static EnumStatus getById(Long id) {
	    for(EnumStatus e : values()) {
	        if(e.id.equals(id)) return e;
	    }
	    return null;
	}

}
