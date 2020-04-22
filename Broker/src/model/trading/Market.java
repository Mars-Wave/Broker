package model.trading;

import model.players.Player;

import java.util.ArrayList;
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
        Asset a=null;
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
        for (Asset asset : assets) {
            asset.refreshPrice();
        }
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
        if (assetIdx >= 0 && assetIdx < assets.size() && quantity >= assets.get(assetIdx).sharesOwned) {
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
        throw new ArrayIndexOutOfBoundsException("Asset is not in market.");
    }

}
