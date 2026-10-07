package net.fot.fotslugcats.commands;

import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber
public class ModCommands {

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("getBiomeTemperature")
            .executes( arguments -> {
                Level level = arguments.getSource().getUnsidedLevel();
                double x = arguments.getSource().getPosition().x();
                double y = arguments.getSource().getPosition().y();
                double z = arguments.getSource().getPosition().z();

                arguments.getSource().sendSuccess(() -> Component.literal("" + level.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature()), true);
                return (int)level.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100;
            })
        );
        event.getDispatcher().register(Commands.literal("canRainDamage")
                .executes(arguments -> {
                    Level level = arguments.getSource().getUnsidedLevel();
                    double x = arguments.getSource().getPosition().x();
                    double y = arguments.getSource().getPosition().y();
                    double z = arguments.getSource().getPosition().z();
                    float biomeTemperature = level.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature();
                    arguments.getSource().sendSuccess(() -> Component.literal("" + (0.4 < biomeTemperature && biomeTemperature < 1.6)), true);
                    return 0;
                })
        );
    }
}
