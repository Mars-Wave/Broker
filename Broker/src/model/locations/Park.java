package model.locations;

import model.actions.moveActions.*;
import model.actions.parkActions.FeedPidgeonsAction;
import model.actions.parkActions.ObserveKidsAction;
import model.actions.parkActions.RideSwingAction;

public class Park extends Location {
	
    public Park(){
    	super("Park");
    	addAction(new FeedPidgeonsAction());
    	addAction(new ObserveKidsAction());
    	addAction(new RideSwingAction());
        addAction(new goHomeAction());
        addAction(new goOfficeAction());
        addAction(new goBankAction());
        addAction(new goBarAction());
    }

}
