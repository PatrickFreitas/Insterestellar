package login.sumit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlayerDAOImplement implements PlayerDAO {
	
	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertPlayer(Player p) {
		int status = 0;
		
		try {
			con =  ConnectionProvider.getCon();
			ps = con.prepareStatement("insert into Player(`Usuario`, `Senha`, `Email`) values(?,?,?)");
			ps.setString(1, p.getUsername());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getEmail());
			status = ps.executeUpdate();
			con.close();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	@Override
	public Player getPlayer(String username, String password) {
		Player player = new Player();
		
		try {
			con =  ConnectionProvider.getCon();
			ps = con.prepareStatement("select * from Player where Usuario=? and Senha=?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet result = ps.executeQuery();
			while(result.next()) {
				player.setUsername(result.getString(1));
				player.setPassword(result.getString(2));
				player.setEmail(result.getString(3));
			}
			con.close();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return player;
	}
	
	@Override
	public Player getPlayer(String username) {
		Player player = new Player();
		
		try {
			con =  ConnectionProvider.getCon();
			ps = con.prepareStatement("select * from Player where Usuario=?");
			ps.setString(1, username);

			ResultSet result = ps.executeQuery();
			while(result.next()) {
				player.setUsername(result.getString(1));
				player.setPassword(result.getString(2));
				player.setEmail(result.getString(3));
			}
			con.close();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return player;
	}

}
