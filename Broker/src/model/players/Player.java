package model.players;

import javafx.util.Pair;
import model.life.MentalHealth;
import model.life.Time;
import model.locations.Location;
import model.locations.LocationChanger;
import model.trading.Asset;
import model.trading.Market;

import java.util.*;

public abstract class Player {
	
	protected Location currLoc;
	protected LocationChanger map;
	protected Market globalMarket;
	protected MentalHealth mentalH;
	protected int money;
	protected Time ownTime;		//To be used when we add more players (MODS)
	protected String name;
	protected String surname;
	protected List<Pair<Asset, Integer>> portfolio;

	public Player(String name, String surname, LocationChanger map, int locIdx, int money, Market globalMarket) {
		map.startIn(this, locIdx);
		this.name = name;
		this.surname = surname;
		this.map = map;
		this.money = money;
		this.globalMarket = globalMarket;
		this.mentalH = new MentalHealth(100);
		this.ownTime = new Time();
		this.portfolio = new ArrayList<>();
	}
	
	public abstract void update();
	public abstract void buy();
	public abstract void sell();
	
	protected void moveTo(int locIdx) {
		map.moveTo(this, locIdx);
	}
	
	public boolean canContinue() {
		return !this.mentalH.insane() && money >= 0;
	}
	
	public void setCurrLoc(Location newLoc) {
		this.currLoc = newLoc;
	}
	
	public Location getCurrLoc() {
		return this.currLoc;
	}
	
	public void modifyHealth(int amount) {
		this.mentalH.add(amount);
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public void modifyMoney(int amount) {
		this.money += amount;
	}
	
	public void addTime(int minutes) {
		this.ownTime.addTime(minutes);
	}
	
	public Market getGlobalMarket() {
		return this.globalMarket;
	}
	
	public String getName() {
		return this.name + " " + this.surname;
	}

	public List<Pair<Asset, Integer>> getPortfolio(){
		return portfolio;
	}

}
