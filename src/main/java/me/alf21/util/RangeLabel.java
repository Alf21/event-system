package me.alf21.util;

import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.object.Destroyable;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.object.PlayerLabel;

/**
 * @author Alf21
 */
public class RangeLabel implements Destroyable {

	private String name;
	private PlayerLabel playerLabel;
	private Location location;
	private Color color;
	
	/**
	 * main constructor
	 * @param name the name of rangeLabel
	 * @param location the location of the target
	 */
	public RangeLabel(String name, Location location) {
		this.name = name;
		this.location = location;
	}
	
	/**
	 * create the rangeLabel
	 * @param player the player
	 * @param originLocation the originLocation, eg. the players location
	 * @param color the playerLabel text color
	 * @param drawDistance the drawDistance of the playerLabel
	 * @param testLOS the invisibility through walls or objects of the playerLabel text
	 */
	public void create(Player player, Location originLocation, Color color, float drawDistance, boolean testLOS) {
		this.color = color;
		playerLabel = PlayerLabel.create(player, String.valueOf((int) location.distance(originLocation)), color, location, drawDistance+10, testLOS);
	}
	
	/**
	 * update the RangeLabel
	 * @param color the color of the playerlabel
	 * @param originLocation the location of the origin
	 */
	public void update(Color color, Location originLocation) {
		if(color == null) color = this.color;
		playerLabel.update(color, String.valueOf((int) location.distance(originLocation)));
	}
	
	/*
	 * (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#destroy()
	 */
	@Override
	public void destroy() {
		playerLabel.destroy();
		playerLabel = null;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see net.gtaun.shoebill.object.Destroyable#isDestroyed()
	 */
	@Override
	public boolean isDestroyed() {
		return playerLabel == null;
	}
}
