/**
 * 
 */
package com.rv.servicejavapractice.model;

import lombok.Data;

/**
 * @author Ravi Thummar
 *
 */
@Data
public class FruitShop {
	private String name;

	public FruitShop(String name) {
		this.name = name;
	}
}
