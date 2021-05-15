package com.lesson4.spells;

import com.lesson4.Character;
import com.lesson4.Spell;
import com.lesson4.characters.Monster;
import com.lesson4.characters.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExileMonsters extends Spell {


    public ExileMonsters() {
        super( "Изгнание монстров", new Random().nextInt( 66 ) );
    }


    public void cast( Wizard wizard, List<Character>characterList ) {
        List<String> nameCharacter = new ArrayList<>();
        super.cast( wizard, characterList );
        characterList.stream()
                .filter( character -> character instanceof Monster )
                .map( character -> character.setHealth( character.getHealth() - this.getRange() ) )
                .forEach( character -> nameCharacter.add( character.getName() ) );
        if( nameCharacter.size() > 0 ) {
            System.out.printf("Изгнание монстров ударяет по %s. Каждый получает %s урона.\n", nameCharacter, this.getRange());
        }
    }
}
