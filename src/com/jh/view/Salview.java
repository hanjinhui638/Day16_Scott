package com.jh.view;

import java.util.List;

import com.jh.salgrade.SalgradeDTO;

public class Salview {
	
	public void view(List<SalgradeDTO> ar) {
		for(SalgradeDTO salgradeDTO : ar) {
			this.view(salgradeDTO);
		}
		
		
	}
	
	
	

	public void view(SalgradeDTO salgradeDTO) {
		System.out.println("-------------------------------------");
		System.out.println("Grade : " + salgradeDTO.getGrade());
		System.out.println("Losal : " + salgradeDTO.getLosal());
		System.out.println("Hisal : " + salgradeDTO.getHisal());

	}

	public void view(String str) {
		System.out.println(str);
	}

}
