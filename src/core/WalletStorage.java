package core;

import core.Wallet;
import core.MintPhase;

import java.io.*;
import java.util.*;

public class WalletStorage {
    private static final String FILE_PATH = "data/wallets.csv";

    public static void save(List<Wallet> wallets) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Wallet wallet : wallets) {
                writer.println(wallet.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving wallets: " + e.getMessage());
        }
    }

    public static List<Wallet> load() {
        List<Wallet> wallets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String address = parts[0].trim();
                    MintPhase phase = MintPhase.valueOf(parts[1].trim());
                    wallets.add(new Wallet(address, phase));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading wallets: " + e.getMessage());
        }
        return wallets;
    }
}
