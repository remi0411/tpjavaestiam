package com.company;

public class Pokemon {
    private int _id;
    private String _name;
    private int _spellLevel;
    private int _lifeLevel;
    private int _originalLifeLevel;

    public Pokemon(int id, String name, int lifeLevel, int spellLevel){
        this._id = id;
        this._name = name;
        this._lifeLevel = lifeLevel;
        this._spellLevel = spellLevel;
        this._originalLifeLevel = lifeLevel;
    }

    public String fightShout(){
        return String.format("Je suis le pokémon %s je suis le meilleur je vais gagner \n", this._name);
    }

    public String winShout(){
        return String.format("Je suis le pokémon %s j'ai gagné, Wahh \n", this._name);
    }

    public String looseShout(){
        return String.format("Je suis le pokémon %s, j'ai perdu.... \n", this._name);
    }

    public int get_spellLevel() {
        return _spellLevel;
    }

    public void set_spellLevel(int _spellLevel) {
        this._spellLevel = _spellLevel;
    }

    public int get_lifeLevel() {
        return _lifeLevel;
    }

    public String get_name() {
        return _name;
    }

    public void set_lifeLevel(int __lifeLevel) {
        this._lifeLevel = __lifeLevel;
    }

    public void regenLife(){
        this._lifeLevel = _originalLifeLevel;
    }
}
