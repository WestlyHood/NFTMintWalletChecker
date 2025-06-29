package core;

public class Wallet {
    private String walletAddress;
    private MintPhase mintPhase;

    public Wallet(String walletAddress, MintPhase mintPhase) {
        this.walletAddress = walletAddress;
        this.mintPhase = mintPhase;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public MintPhase getMintPhase() {
        return mintPhase;
    }

    @Override
    public String toString() {
        return walletAddress + "," + mintPhase;
    }
}
