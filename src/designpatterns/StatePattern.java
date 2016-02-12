package designpatterns;

public class StatePattern {
	public static void main(String[] args) {

		GameContext context = new GameContext();

		context.setState(new HealthyState());
		context.gameAction();
		System.out.println("*****");

		context.setState(new SurvivalState());
		context.gameAction();
		System.out.println("*****");

		context.setState(new DeadState());
		context.gameAction();
		System.out.println("*****");

	}
}

class Player {

	public void attack() {
		System.out.println("Attack");
	}

	public void fireBumb() {
		System.out.println("Fire Bomb");
	}

	public void fireGunblade() {
		System.out.println("Fire Gunblade");
	}

	public void fireLaserPistol() {
		System.out.println("Laser Pistols");
	}

	public void firePistol() {
		System.out.println("Fire Pistol");
	}

	public void survive() {
		System.out.println("Surviving!");
	}

	public void dead() {
		System.out.println("Dead! Game Over");
	}

}

interface PlayerState {
	void action(Player p);
}

class HealthyState implements PlayerState {
	@Override
	public void action(Player p) {
		p.attack();
		p.fireBumb();
		p.fireGunblade();
		p.fireLaserPistol();
	}
}

class SurvivalState implements PlayerState {
	@Override
	public void action(Player p) {
		p.survive();
		p.firePistol();
	}
}

class DeadState implements PlayerState {
	@Override
	public void action(Player p) {
		p.dead();
	}
}

class GameContext {
	private PlayerState state = null;
	private Player player = new Player();

	public void setState(PlayerState state) {
		this.state = state;
	}

	public void gameAction() {
		state.action(player);
	}
}

class GameContextOld {
	private Player player = new Player();

	public void gameAction(String state) {
		if (state == "healthy") {
			player.attack();
			player.fireBumb();
			player.fireGunblade();
			player.fireLaserPistol();
		} else if (state == "survival") {
			player.survive();
			player.firePistol();
		} else if (state == "dead") {
			player.dead();
		}
	}
}
