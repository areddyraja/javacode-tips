package enumrelated;

public class EnumExample {

	public enum Level {

		HIGH(3), MEDIUM(2), LOW(1);

		// you can also add methods to Enum Code.
		private final int levelCode;

		Level(int levelCode) {
			this.levelCode = levelCode;
		}

		public int getLevelCode() {
			return this.levelCode;
		}

	}

	/**
	 * cannot extend Enum Class. public class EnumExtension extends Level {
	 * 
	 * }
	 */

	Level level1 = Level.HIGH;

	public void checkLevel(Level level) {

		switch (level) {
		case HIGH:
			System.out.println("Hello world: Level is high");
			break;
		case MEDIUM:
			System.out.println("Hello world Level is Medium");
			break;
		case LOW:
			System.out.println("Hello world  Level is low");
			break;
		}
	}

	public static void main(String[] args) {
		new EnumExample().checkLevel(Level.LOW);
	}

}
