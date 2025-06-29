package core;

import core.Wallet;
import core.MintPhase;

import java.util.*;

public class WalletCheckerSystem {
    private Map<String, Wallet> walletMap;

    public WalletCheckerSystem() {
        this.walletMap = new HashMap<>();
    }

    public void registerWallet(String address, MintPhase phase) {
        Wallet wallet = new Wallet(address, phase);
        walletMap.put(address.toLowerCase(), wallet);
    }

    public MintPhase getWalletPhase(String address) {
        Wallet wallet = walletMap.get(address.toLowerCase());
        return wallet != null ? wallet.getMintPhase() : null;
    }

    public List<Wallet> getAllWallets() {
        return new ArrayList<>(walletMap.values());
    }

    public void loadWallets(List<Wallet> wallets) {
        for (Wallet wallet : wallets) {
            walletMap.put(wallet.getWalletAddress().toLowerCase(), wallet);
        }
    }
}
