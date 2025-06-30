package admin;

import core.MintPhase;
import core.Wallet;
import core.WalletCheckerSystem;
import core.WalletStorage;

import java.util.List;
import java.util.Scanner;

public class AdminApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        WalletCheckerSystem system = new WalletCheckerSystem();

        List<Wallet> existingWallets = WalletStorage.load();
        system.loadWallets(existingWallets);

        System.out.println("Admin Panel: Register Wallets");

        boolean running = true;
        while(running){
            System.out.println("Enter wallet address (or 'exit' to finish): ");
            String address = scanner.nextLine().trim();

            if (address.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println("Select Mint Phase: 1. GUARANTEED 2. FCFS 3. PUBLIC");
            int phaseChoice = scanner.nextInt();
            scanner.nextLine();

            MintPhase phase = switch (phaseChoice){
                case 1 -> MintPhase.GUARANTEED;
                case 2 -> MintPhase.FCFS;
                case 3 -> MintPhase.PUBLIC;
                default -> null;
            };

            if (phase != null){
                system.registerWallet(address, phase);
                System.out.println("Wallet Registered: " + address + " -> " + phase);
            }else {
                System.out.println("Invalid Phase Selection");
            }
        }

        WalletStorage.save(system.getAllWallets());
        System.out.println("All wallets saved to file.");
    }
}
