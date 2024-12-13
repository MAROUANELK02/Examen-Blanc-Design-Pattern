package com.marouaneLasmak;

import com.marouaneLasmak.aop.SecuredByAspect;
import com.marouaneLasmak.aop.SecurityContext;
import com.marouaneLasmak.implementation.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("Enter your role: ");
        String role = sc.nextLine();
        SecurityContext.authenticate(username, password, new String[]{role});
        executeStatement();
    }

    @SecuredByAspect(roles = {"admin"})
    public static void executeStatement() {
        Agent a1 = new Agent("Agent1", new ScoringStrategy());
        Agent a2 = new Agent("Agent2", new HistoryStrategy());
        Agent a3 = new Agent("Agent3", new ScoringStrategy());
        System.out.println("Agents created !");
        System.out.println("*****************************");

        a1.addObserver(a2);
        a1.addObserver(a3);
        a2.addObserver(a1);
        a2.addObserver(a3);
        a3.addObserver(a1);
        a3.addObserver(a2);
        System.out.println("Agents getting notified !");
        System.out.println("*****************************");

        Container container = Container.getInstance();
        System.out.println("Container created !");
        System.out.println("*****************************");

        System.out.println("Adding agents to container !");
        System.out.println("*****************************");
        container.addAgent(a1);
        container.addAgent(a2);
        container.addAgent(a3);

        System.out.println("Showing container !");
        System.out.println("*****************************");
        container.showAgents();

        Transaction transaction1 = new Transaction.Builder()
                .setId("1")
                .setDate(LocalDateTime.now())
                .setAmount(100)
                .setType(TransactionType.Achat)
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .setId("2")
                .setDate(LocalDateTime.now())
                .setAmount(200)
                .setType(TransactionType.Vente)
                .build();

        Transaction transaction3 = new Transaction.Builder()
                .setId("3")
                .setDate(LocalDateTime.now())
                .setAmount(300)
                .setType(TransactionType.Achat)
                .build();

        Transaction transaction4 = new Transaction.Builder()
                .setId("4")
                .setDate(LocalDateTime.now())
                .setAmount(400)
                .setType(TransactionType.Vente)
                .build();

        Transaction transaction5 = new Transaction.Builder()
                .setId("5")
                .setDate(LocalDateTime.now())
                .setAmount(500)
                .setType(TransactionType.Achat)
                .build();

        Transaction transaction6 = new Transaction.Builder()
                .setId("6")
                .setDate(LocalDateTime.now())
                .setAmount(600)
                .setType(TransactionType.Vente)
                .build();

        System.out.println("Adding transactions to agents !");
        System.out.println("*****************************");
        a1.addTransaction(transaction1);
        a2.addTransaction(transaction2);
        a3.addTransaction(transaction3);
        a1.addTransaction(transaction4);
        a2.addTransaction(transaction5);
        a3.addTransaction(transaction6);

        System.out.println("*****************************");
        System.out.println("Showing Max amount transaction for each agent !");
        System.out.println("*****************************");
        System.out.println();

        System.out.println("for agent 1 " + a1.maxTransactionAmount());
        System.out.println();
        System.out.println("for agent 2 " + a2.maxTransactionAmount());
        System.out.println();
        System.out.println("for agent 1 " + a1.maxTransactionAmount());
        System.out.println();
        System.out.println("for agent 2 " + a2.maxTransactionAmount());
        System.out.println();
        a1.addTransaction(transaction5);
        System.out.println();
        System.out.println("for agent 1 " + a1.maxTransactionAmount());
        System.out.println();

        System.out.println("*****************************");
        System.out.println("Showing transactions for each agent !");
        System.out.println();
        a1.showTransactions();
        a2.showTransactions();
        a3.showTransactions();

    }
}