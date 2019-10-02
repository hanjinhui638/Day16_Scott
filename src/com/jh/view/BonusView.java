package com.jh.view;

import java.util.ArrayList;

import com.jh.bonus.BonusDTO;

public class BonusView {

	public void view(String str) {
		System.out.println(str);
	}
	
	public void view(BonusDTO bonusDTO) {
		System.out.println("---------------------------");
		System.out.println("Ename :");
		System.out.println("Job : ");
		System.out.println("Sal : ");
		System.out.println("comm : ");
		
	}
	
	public void view(ArrayList<BonusDTO> ar) {
		for(BonusDTO bonusDTO:ar) {
			
			this.view(bonusDTO);
		}
	}
}
