package model.trading;

import model.players.Player;
import model.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//This class follows the Singleton pattern, since there should be only one Market
public class Market {

    private static final int startingAssetsNum = 10;
    private static Market instance;
    public List<Asset> assets;

    private Market() {
        assets = new ArrayList<>();
        for (int i = 0; i < startingAssetsNum; i++) {
            this.addNewAsset();
        }
    }

    public static Market getInstance() {
        if (instance == null) {
            instance = new Market();
        }
        return instance;
    }

    private void addNewAsset() {
        Asset a = null;
        boolean aux = true;
        while (aux) {
            aux = false;
            a = new Asset();
            for (Asset x : assets) {
                if (a.name.equalsIgnoreCase(x.name)) {
                    aux = true;
                }
            }
        }
        assets.add(a);
    }

    public void refresh() {
        Iterator<Asset> iter = assets.iterator();
        while (iter.hasNext()) {
            Asset a = iter.next();
            a.refreshPrice();
        }
    }

    public boolean flushAssets() {
        Iterator<Asset> iter = assets.iterator();
        boolean isFirst = true;
        while (iter.hasNext()) {
            Asset a = iter.next();
            if (a.isBankrupt()) {
                if (isFirst) {
                    System.out.println();
                    Utils.equalsWall();
                    isFirst = false;
                    System.out.println(a.name + " declared bankruptcy!");
                } else {
                    Utils.minusWall();
                    System.out.println(a.name + " declared bankruptcy!");
                }
                iter.remove();
            }
        }
        if (!isFirst) {
            Utils.equalsWall();
            System.out.println();
        }
        return !isFirst;
    }


    public void opportunity() {
        assets.add(new Asset());
    }

    public void print() {
        System.out.println("The market sits currently at: ");
        for (int i = 0; i < assets.size(); i++) {
            System.out.println(i + ": " + assets.get(i));
        }
    }

    public boolean buy(Player player, int assetIdx, int quantity) {
        if (assetIdx >= 0 && assetIdx < assets.size()) {
            return assets.get(assetIdx).buy(player, quantity);
        }
        return false;
    }

    public boolean sell(Player player, int assetIdx, int quantity) {
        if (assetIdx >= 0 && assetIdx < assets.size() && quantity <= assets.get(assetIdx).sharesOwned) {
            return assets.get(assetIdx).sell(player, quantity);
        }
        return false;
    }

    public int getNumOfAssets() {
        return assets.size();
    }

    public int marketIndex(Asset key) {
        for (int i = 0; i < assets.size(); i++) {
            if (key.equals(assets.get(i))) return i;
        }
        return -1;
    }

}
