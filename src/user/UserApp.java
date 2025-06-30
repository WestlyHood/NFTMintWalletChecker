package user;

import core.MintPhase;
import core.Wallet;
import core.WalletCheckerSystem;
import core.WalletStorage;

import java.util.List;
import javax.swing.*;

public class UserApp {
    public static void main(String[] args){
        WalletCheckerSystem system = new WalletCheckerSystem();

        List<Wallet> existingWallets = WalletStorage.load();
        system.loadWallets(existingWallets);

        String address = JOptionPane.showInputDialog(null, "Enter your wallet address: ","Wallet Checker", JOptionPane.PLAIN_MESSAGE);

        if (address != null && !address.trim().isEmpty()){
            MintPhase phase = system.getWalletPhase(address.trim());

            if (phase != null){
                JOptionPane.showMessageDialog(null, "Your wallet is in the " + phase + " mint phase.", "Result", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "This wallet is not registered for this mint", "Result", JOptionPane.WARNING_MESSAGE);
            }

        }else {
            JOptionPane.showMessageDialog(null, "No wallet address entered.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
