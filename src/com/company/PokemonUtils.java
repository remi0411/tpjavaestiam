package com.company;

public class PokemonUtils {

    public static Pokemon Fight(Pokemon first, Pokemon second){
        System.out.print(first.fightShout());
        System.out.print(second.fightShout());
        while(second.get_lifeLevel() > 0 && first.get_lifeLevel() > 0){
            second.set_lifeLevel(second.get_lifeLevel() - first.get_spellLevel());
            first.set_lifeLevel(first.get_lifeLevel() - second.get_spellLevel());
        }

        Pokemon winner;
        if(first.get_lifeLevel()>0){
            winner = first;
            System.out.print(second.looseShout());
        }
        else{
            winner = second;
            System.out.print(first.looseShout());
        }

        winner.regenLife();
        System.out.print(winner.winShout());
        return winner;
    }
}
