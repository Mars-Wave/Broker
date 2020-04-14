package model.actions;

import model.players.Bot;
import model.players.Broker;
import model.players.Player;

public class OrderTakeawayAction extends Action {
	
	public OrderTakeawayAction() {
		super("Order takeaway", "Spend 1 hour ordering and eating takeaway food.", 60, -5);
	}
	
	@Override
	protected void performSpecificAction(Player player, boolean isUser) {
		if(isUser) {
			System.out.println("The meal was just ok. What you'd expect from a takeaway meal.");		
		}
		else {
			System.out.println(player.getName() + " ate a takeaway meal.");
		}		
	}

}
