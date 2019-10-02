package com.jh.control;

import java.util.Scanner;

public class FrontController {

	private Scanner sc;
	private EmpController empController;
	private DeptController demController;
	private SalgradeController salController;
	private BonusController bonusController;
	
	public FrontController() {
		sc = new Scanner(System.in);
		empController = new EmpController();
		demController = new DeptController();
		salController = new SalgradeController();
		bonusController = new BonusController();
		
	}
	
	public void start() {
		boolean check = true;
		int select = 0;
		
		while(check) {
			System.out.println("1.사원관리");
			System.out.println("2.부서관리");
			System.out.println("3.급여관리");
			System.out.println("4.보너스관리");
			System.out.println("3.종      료 ");
			select = sc.nextInt();
			
			switch(select) {
			case 1:
				empController.start();
				break;
			case 2:
				demController.start();
				break;
			case 3:
				salController.start();
				break;
			case 4: 
				bonusController.start();
				break;
			
			default:
				
				check=!check;
				
			}
		}
		
		
	}
}
