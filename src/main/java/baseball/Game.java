package baseball;

import java.util.ArrayList;

public class Game {
	private final int NUMBER_COUNT = 3;
	private boolean continueYn = true;
	private ArrayList<Integer> numbers = new ArrayList<Integer>(); 
	
	public void setContinueYn(boolean yn) {
		this.continueYn = yn;
	}
	
	public boolean getContinueYn() {
    	return this.continueYn;
    }
	
	public void startGame() {
		createNumbers();
		
		setContinueYn(false);
	}
	
	//중복되지 않는 3자리 숫자 생성
	public void createNumbers() {
		int number = 0;
		
		do {
			number = nextstep.utils.Randoms.pickNumberInRange(1,9);
			checkDup(numbers, number);
		}while(numbers.size() < NUMBER_COUNT);
	}
	
	//랜덤숫자가 이미 존재하는 숫자인지 판단
	public void checkDup(ArrayList<Integer> numbers, int number) {
		if(numbers.contains(number))
			return;
		
		numbers.add(number);
	}
}
