package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean isValidInput = false;
        int tournamentSize = 0;

        while(!isValidInput){
            System.out.println("Veuillez entrer le nombre de pokémons participant au tournoi: ");
            if(sc.hasNextInt()){
                tournamentSize = sc.nextInt();
                if(tournamentSize > 0 && ((tournamentSize & (tournamentSize - 1)) == 0)){
                    isValidInput = true;
                }
            }
            else{
                System.out.println("Erreur dans votre saisie");
                sc.next();
            }
        }

        ArrayList<Pokemon> players = new ArrayList<>();
        Tournament tournament = new Tournament(tournamentSize);

        for (int i=0; i<tournamentSize; i++){
            players.add(new Pokemon(i,"Pokemon n°"+i, ThreadLocalRandom.current().nextInt(1, 100 + 1), ThreadLocalRandom.current().nextInt(1, 100 + 1)));
        }

        tournament.set_roundPlayers(players);
        tournament.startTournament();

    }

}
