package net.fot.fotslugcats;

import it.unimi.dsi.fastutil.ints.IntObjectImmutablePair;
import it.unimi.dsi.fastutil.ints.IntObjectPair;
import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.entity.ModEntities;
import net.fot.fotslugcats.entity.client.*;
import net.fot.fotslugcats.entity.custom.RandomSlugcatEntity;
import net.fot.fotslugcats.init.ModAttributes;
import net.fot.fotslugcats.item.ModCreativeModeTabs;
import net.fot.fotslugcats.item.ModItems;
import net.fot.fotslugcats.screen.ModMenuTypes;
import net.fot.fotslugcats.screen.custom.KarmaScreen;
import net.fot.fotslugcats.sound.ModSounds;
import net.fot.fotslugcats.world.Karma;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.server.TickTask;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(FoTSlugcats.MOD_ID)
public class FoTSlugcats {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "fotslugcats";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "fotslugcats" namespace


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public FoTSlugcats(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);
        ModAttributes.REGISTRY.register(modEventBus);
        ModMenuTypes.MENUS.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    private static final Queue<IntObjectPair<Runnable>> workToBeScheduled = new ConcurrentLinkedQueue<>();
    private static final PriorityQueue<TickTask> workQueue = new PriorityQueue<>(Comparator.comparingInt(TickTask::getTick));

    public static void queueServerWork(int delay, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
            workToBeScheduled.add(new IntObjectImmutablePair<>(delay, action));
    }

    @SubscribeEvent
    public void tick(ServerTickEvent.Post event) {
        int currentTick = event.getServer().getTickCount();
        IntObjectPair<Runnable> work;
        while ((work = workToBeScheduled.poll()) != null) {
            workQueue.add(new TickTask(currentTick + work.leftInt(), work.right()));
        }
        while (!workQueue.isEmpty() && currentTick >= workQueue.peek().getTick()) {
            workQueue.poll().run();
        }
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @EventBusSubscriber
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {


            EntityRenderers.register(ModEntities.SLUGCAT.get(), RandomSlugcatRenderer::new);
            EntityRenderers.register(ModEntities.SURVIVOR.get(), SurvivorSlugcatRenderer::new);
            EntityRenderers.register(ModEntities.MONK.get(), MonkSlugcatRenderer::new);
            EntityRenderers.register(ModEntities.HUNTER.get(), HunterSlugcatRenderer::new);

        }
    }
}
