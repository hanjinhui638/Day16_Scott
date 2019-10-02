package com.jh.view;

import java.util.List;

import com.jh.salgrade.SalgradeDTO;

public class Salview {
	
	public void view(List<SalDTO> ar) {
		for(SalDTO salDTO : ar) {
			this.view(salDTO);
		}
		
		
	}
	
	
	

	public void view(SalDTO salDTO) {
		System.out.println("-------------------------------------");
		System.out.println("Grade : " + salDTO.getGrade());
		System.out.println("Losal : " + salDTO.getLosal());
		System.out.println("Hisal : " + salDTO.getHisal());

	}

	public void view(String str) {
		System.out.println(str);
	}

}
