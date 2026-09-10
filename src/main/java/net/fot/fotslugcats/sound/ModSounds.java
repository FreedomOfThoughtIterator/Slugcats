package net.fot.fotslugcats.sound;

import net.fot.fotslugcats.FoTSlugcats;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, FoTSlugcats.MOD_ID);

    public static final Supplier<SoundEvent> KarmaIncGUIOpen = registerSoundEvent("karma_inc_gui_open");
    public static final Supplier<SoundEvent> KarmaInc = registerSoundEvent("karma_inc");
    public static final Supplier<SoundEvent> KarmaDecGUIOpen = registerSoundEvent("karma_dec_gui_open");
    public static final Supplier<SoundEvent> KarmaDec = registerSoundEvent("karma_dec");
    public static final Supplier<SoundEvent> KarmaChg = registerSoundEvent("karma_chg");


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(FoTSlugcats.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
