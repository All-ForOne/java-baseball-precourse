package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GameTest{
	
	Game game = new Game();
	
	@Test
	public void 숫자_생성_검증() {
		assertEquals(game.createNumbers().length(), 3);
	}
	
	@Test
	public void 중복_확인() {
		assertTrue(game.checkDup("123", "1"));
	}
	
	@Test
	public void 사용자_입력_검증() {
		assertFalse(game.checkUserInput("112"));
		assertFalse(game.checkUserInput("abc"));
		assertTrue(game.checkUserInput("547"));
	}
}