package net.fot.fotslugcats.entity.client;

import net.minecraft.client.model.Model;

//You may think this is one of Mojang's classes and to that I say uhh not entirely,
//not entirely! See the word 'test' in that other comment? That's brand new.
public record AdultAndBabyModelPair<T extends Model>(T adultModel, T babyModel) {
    //test
    public T getModel(final boolean isBaby) {
        return isBaby ? this.babyModel : this.adultModel;
    }
}