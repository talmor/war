package com.tommytony.war.structure;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import com.tommytony.war.Team;
import com.tommytony.war.Warzone;
import com.tommytony.war.utility.Direction;
import com.tommytony.war.volume.BlockInfo;
import com.tommytony.war.volume.Volume;

/**
 *
 * @author tommytony
 *
 */
public class Monument {
	private Location location;
	private Volume volume;

	private Team ownerTeam = null;
	private final String name;
	private Warzone warzone;

	public Monument(String name, Warzone warzone, Location location) {
		this.name = name;
		this.location = location;
		this.warzone = warzone;
		this.volume = new Volume(name, warzone.getWorld());
		this.setLocation(location);
	}

	public void addMonumentBlocks() {
		// make air (old three-high above floor)
		Volume airGap = new Volume("airgap", this.warzone.getWorld());
		airGap.setCornerOne(new BlockInfo(
				this.volume.getCornerOne().getX(), 
				this.volume.getCornerOne().getY() + 1, 
				this.volume.getCornerOne().getZ(),
				0,
				(byte)0));
		airGap.setCornerTwo(new BlockInfo(
				this.volume.getCornerTwo().getX(), 
				this.volume.getCornerOne().getY() + 3, 
				this.volume.getCornerTwo().getZ(),
				0,
				(byte)0));
		airGap.setToMaterial(Material.AIR);

		this.ownerTeam = null;
		int x = this.location.getBlockX();
		int y = this.location.getBlockY();
		int z = this.location.getBlockZ();
		
		Material main = Material.getMaterial(this.warzone.getWarzoneMaterials().getMainId());
		byte mainData = this.warzone.getWarzoneMaterials().getMainData();
		Material light = Material.getMaterial(this.warzone.getWarzoneMaterials().getLightId());
		byte lightData = this.warzone.getWarzoneMaterials().getLightData();

		// center
		Block current = this.warzone.getWorld().getBlockAt(x, y - 1, z);
		current.setType(main);
		current.setData(mainData);

		// inner ring
		current = this.warzone.getWorld().getBlockAt(x + 1, y - 1, z + 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x + 1, y - 1, z);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x + 1, y - 1, z - 1);
		current.setType(main);
		current.setData(mainData);

		current = this.warzone.getWorld().getBlockAt(x, y - 1, z + 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x, y - 1, z - 1);
		current.setType(main);
		current.setData(mainData);

		current = this.warzone.getWorld().getBlockAt(x - 1, y - 1, z + 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x - 1, y - 1, z);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x - 1, y - 1, z - 1);
		current.setType(main);
		current.setData(mainData);

		// outer ring
		current = this.warzone.getWorld().getBlockAt(x + 2, y - 1, z + 2);
		current.setType(light);
		current.setData(lightData);
		current = this.warzone.getWorld().getBlockAt(x + 2, y - 1, z + 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x + 2, y - 1, z);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x + 2, y - 1, z - 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x + 2, y - 1, z - 2);
		current.setType(light);
		current.setData(lightData);

		current = this.warzone.getWorld().getBlockAt(x - 1, y - 1, z + 2);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x - 1, y - 1, z - 2);
		current.setType(main);
		current.setData(mainData);

		current = this.warzone.getWorld().getBlockAt(x, y - 1, z + 2);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x, y - 1, z - 2);
		current.setType(main);
		current.setData(mainData);
		
		current = this.warzone.getWorld().getBlockAt(x + 1, y - 1, z + 2);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x + 1, y - 1, z - 2);
		current.setType(main);
		current.setData(mainData);

		current = this.warzone.getWorld().getBlockAt(x - 2, y - 1, z + 2);
		current.setType(light);
		current.setData(lightData);
		current = this.warzone.getWorld().getBlockAt(x - 2, y - 1, z + 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x - 2, y - 1, z);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x - 2, y - 1, z - 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x - 2, y - 1, z - 2);
		current.setType(light);
		current.setData(lightData);

		// block holder
		current = this.warzone.getWorld().getBlockAt(x, y, z);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x, y, z - 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x, y, z + 1);
		current.setType(main);
		current.setData(mainData);

		current = this.warzone.getWorld().getBlockAt(x, y + 1, z - 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x, y + 1, z + 1);
		current.setType(main);
		current.setData(mainData);

		current = this.warzone.getWorld().getBlockAt(x, y + 2, z);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x, y + 2, z - 1);
		current.setType(main);
		current.setData(mainData);
		current = this.warzone.getWorld().getBlockAt(x, y + 2, z + 1);
		current.setType(main);
		current.setData(mainData);

	}

	public boolean isNear(Location playerLocation) {
		int x = this.location.getBlockX();
		int y = this.location.getBlockY();
		int z = this.location.getBlockZ();
		int playerX = playerLocation.getBlockX();
		int playerY = playerLocation.getBlockY();
		int playerZ = playerLocation.getBlockZ();
		int diffX = Math.abs(playerX - x);
		int diffY = Math.abs(playerY - y);
		int diffZ = Math.abs(playerZ - z);
		if (diffX < 6 && diffY < 6 && diffZ < 6) {
			return true;
		}
		return false;
	}

	public boolean isOwner(Team team) {
		if (team == this.ownerTeam) {
			return true;
		}
		return false;
	}

	public boolean hasOwner() {
		return this.ownerTeam != null;
	}

	public void capture(Team team) {
		this.ownerTeam = team;
	}

	public void uncapture() {
		this.ownerTeam = null;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setOwnerTeam(Team team) {
		this.ownerTeam = team;

	}

	public String getName() {
		return this.name;
	}

	public void setLocation(Location location) {
		Block locationBlock = this.warzone.getWorld().getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
		this.volume.setCornerOne(locationBlock.getRelative(BlockFace.DOWN).getRelative(Direction.EAST(), 2).getRelative(Direction.SOUTH(), 2));
		this.volume.setCornerTwo(locationBlock.getRelative(BlockFace.UP, 2).getRelative(Direction.WEST(), 2).getRelative(Direction.NORTH(), 2));
		this.volume.saveBlocks();
		this.location = location;
		
		this.addMonumentBlocks();
	}

	public Volume getVolume() {
		return this.volume;
	}

	public void setVolume(Volume newVolume) {
		this.volume = newVolume;

	}

	public Team getOwnerTeam() {

		return this.ownerTeam;
	}
}
