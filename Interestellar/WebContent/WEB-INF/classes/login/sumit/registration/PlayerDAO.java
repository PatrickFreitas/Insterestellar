package login.sumit.registration;

public interface PlayerDAO {
	public int insertPlayer(Player p);
	public Player getPlayer(String username, String password);
	public Player getPlayer(String username);
}
