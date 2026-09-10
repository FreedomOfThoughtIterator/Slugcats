package net.fot.fotslugcats.init;

import net.fot.fotslugcats.FoTSlugcats;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber
public class ModAttributes {
    public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, FoTSlugcats.MOD_ID);
    public static final DeferredHolder<Attribute, Attribute> KARMA = REGISTRY.register("karma", () -> new RangedAttribute("attribute.fotslugcats.karma", 1d, 1d, 10d).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> MAX_KARMA = REGISTRY.register("max_karma", () -> new RangedAttribute("attribute.fotslugcats.max_karma", 5d, 1d, 10d).setSyncable(true));
    public static final DeferredHolder<Attribute, Attribute> PROTECT_KARMA = REGISTRY.register("protect_karma", () -> new RangedAttribute("attribute.fotslugcats.protect_karma", 0d, 0d, 1d).setSyncable(true));

    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(entity -> event.add(entity, KARMA));
        event.getTypes().forEach(entity -> event.add(entity, MAX_KARMA));
        event.getTypes().forEach(entity -> event.add(entity, PROTECT_KARMA));
    }
}
