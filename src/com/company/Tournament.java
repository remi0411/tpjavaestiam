package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Tournament {

    private ArrayList<Pokemon> _nextRoundPlayers;
    private ArrayList<Pokemon> _roundPlayers;
    private int __nbPlaces;
    private boolean _isFinished;

    public Tournament(int nbPlaces) {
        _roundPlayers = new ArrayList<Pokemon>();
        _nextRoundPlayers = new ArrayList<>();
        this.__nbPlaces = nbPlaces;
        this._isFinished = false;
    }

    public ArrayList<Pokemon> get_roundPlayers() {
        return _roundPlayers;
    }

    public void set_roundPlayers(ArrayList<Pokemon> roundPlayers) {
        this._roundPlayers = roundPlayers;
        Collections.shuffle(this._roundPlayers);
    }

    public void addNextRoundPlayer(Pokemon pokemon){
        this._nextRoundPlayers.add(pokemon);
    }


    public ArrayList<Pokemon> get_nextRoundPlayers() {
        return _nextRoundPlayers;
    }

    public void startTournament(){
        System.out.println("Debut du tournoi");

        while(!this._isFinished) {
            startRound();
            this.set_roundPlayers(this.get_nextRoundPlayers());
            this._nextRoundPlayers = new ArrayList<>();
        }

        System.out.println(this.get_roundPlayers().get(0).get_name() + " a gagné le tournoi");
        System.out.println("Fin du tournoi");
    }

    public void startRound(){
        int initialRoundPlayersCount = this.get_roundPlayers().size();
        while((initialRoundPlayersCount)/2 > this._nextRoundPlayers.size()){
            Pokemon firstPokemon = this.get_roundPlayers().get(0);
            Pokemon secondPokemon = this.get_roundPlayers().get((this.get_roundPlayers().size() - 1));
            Pokemon winner = PokemonUtils.Fight(firstPokemon, secondPokemon);

            this.addNextRoundPlayer(winner);
            this._roundPlayers.remove(firstPokemon);
            this._roundPlayers.remove(secondPokemon);
        }

        if(initialRoundPlayersCount == 2 && this.get_nextRoundPlayers().size() == 1) this._isFinished = true;
    }
}
