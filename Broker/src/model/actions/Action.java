package model.actions;

import model.players.Player;

public abstract class Action{
	
    protected String name;
    protected String desc;
    protected int time, mental;


    public Action(String name, String desc, int time, int mental) {
        this.name = name;
        this.desc = desc;
        this.time = time;
        this.mental = mental;
    }
    
    public void perform(Player player) {
    	player.modifyHealth(mental);
    	player.addTime(time);
    	performSpecificAction(player);
    }
    
    protected abstract void performSpecificAction(Player player);

    @Override
    public String toString() {
        return name + ": " + desc;
    }
}