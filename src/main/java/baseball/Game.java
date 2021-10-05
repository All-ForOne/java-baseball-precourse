package baseball;

import java.util.HashSet;

public class Game {
	private final int NUMBER_COUNT = 3;
	private boolean continueYn = true;
	private String numbers = ""; 
	
	public void setContinueYn(boolean yn) {
		this.continueYn = yn;
	}
	
	public boolean getContinueYn() {
    	return this.continueYn;
    }
	
	public void startGame() {
		this.numbers = createNumbers();
		String s = "";
		
		do {
			s = userInput();
		}while(! checkAnswer(s));
		
		setContinueYn(isRestartGame());
	}
	
	public boolean isRestartGame() {
		String s = "";
		do {
			System.out.print("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
			s = nextstep.utils.Console.readLine();
		}while(checkRestartInput(s));
		
		if("1".equals(s)) return true;
		
		return false;
		
	}
	
	public boolean checkRestartInput(String s) {
		if("1".equals(s) || "2".equals(s)) return false;
		System.out.println("[ERROR] 잘못된 값을 입력했습니다.");
		return true;
	}
	
	public boolean checkAnswer(String s) {
		int[] answer = null;
		int strike = 0;
		int ball = 0;
		for(int i = 0; i < s.length(); i++) {
			answer = findNumber(s, i);
			strike += answer[0];
			ball += answer[1];
		}
		
		printResult(strike, ball);
		
		if(strike == 3) {
			if(strike == 3) System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
			return true;
		}
		 
		return false;
	}
	
	public int[] findNumber(String s, int startIndex) {
		int[] answer = new int[2];
		int index = numbers.indexOf(s.substring(startIndex, startIndex+1));
		
		if(index == startIndex)	answer[0]++;
		
		if(index != -1 && index != startIndex) answer[1]++;
		
		return answer;
	}
	
	public void printResult(int strike, int ball) {
		String printString ="";
		if(strike+ball == 0) {
			System.out.println("낫싱");
			return;
		}
		
		if( strike != 0) printString = strike + "스트라이크 ";
		
		if(ball != 0) printString += ball + "볼";
		
		System.out.println(printString);
	}
	
	public String userInput(){
		String s = "";
		
		do {
			System.out.print("숫자를 입력해주세요 : ");
			s = nextstep.utils.Console.readLine();
		}while(! checkUserInput(s));
		
		return s;
	}
	
	public boolean checkUserInput(String s) {
		String pattern = "[1-9]{3}";
		HashSet<String> numbers = new HashSet<String>();
		
		for(int i = 0; i < s.length(); i++) {
			numbers.add(s.substring(i, i+1));
		}
		
		if(numbers.size() != s.length()) {
			System.out.println("[ERROR] 중복되지 않는 3자리 숫자를 입력하세요.\n");
			return false;
		}
		
		if(! s.matches(pattern)) {
			System.out.println("[ERROR] 3자리 숫자를 입력하세요.\n");
			return false;
		}
		return true;
	}
	
	//중복되지 않는 3자리 숫자 생성
	public String createNumbers() {
		int number = 0;
		String numbers = "";
		do {
			number = nextstep.utils.Randoms.pickNumberInRange(1,9);
			numbers = checkDup(numbers, Integer.toString(number)) ? numbers : numbers + Integer.toString(number);
		}while(numbers.length() < NUMBER_COUNT);
		
		return numbers;
	}
	
	//입력숫자가 이미 존재하는 숫자인지 판단
	public boolean checkDup(String numbers, String number) {
		if(numbers.indexOf(number) == -1) {
			return false;		
		}
		return true;
	}
}
