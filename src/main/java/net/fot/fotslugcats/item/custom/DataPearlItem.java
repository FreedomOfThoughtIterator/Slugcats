package net.fot.fotslugcats.item.custom;

import net.fot.fotslugcats.FoTSlugcats;
import net.fot.fotslugcats.block.ModBlocks;
import net.fot.fotslugcats.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class DataPearlItem extends Item {
    public static final Map<Integer, String> dataMap =
            Map.of(
                    1, "Pearl contains no data.",
                    2, "888888888888888888888888888... [10725 lines]",
                    3, "0, 1, 1, 2, 3, 5, 8, 13, 21, 34,... [Un = U(n - 1) + U(n - 2), U-1 = 0, U0 = 1]",
                    4, "Dear diary...",
                    5, "Genome data 'sulfur-processing_microbe.gene'",
                    6, "Two parts rot bar extract, one part bone ash.",
                    7, "Karmic Urge 2. 'CatboyPebbles.img' will not display.",
                    8, "Pearl is too damaged to read.",
                    9, "We, of the Five-hundred-and-ninety-second High Convocation of the True Anointed Citadel, do hereby demand, with full force of Law and Religious doctrine, an Immediate end to construction of the Apostate Superstructure Abomination. To place shadow upon the Divine Body of the True Anointed Citadel is outrageous blasphemy and cannot be tolerated, no matter the circumstances...",
                    10, "14, 13, 5, 14, 13, 5, 14, 13, 5,... [9823 lines]"
            );
    public static final List<String> dataNine =
            List.of(
                    "We, of the Five-hundred-and-ninety-second High Convocation of the True Anointed Citadel, ",
                    "do hereby demand, with full force of Law and Religious doctrine, ",
                    "an Immediate end to construction of the Apostate Superstructure Abomination.",
                    "To place shadow upon the Divine Body of the True Anointed Citadel is outrageous blasphemy ",
                    "and cannot be tolerated, no matter the circumstances..."
            );

    public DataPearlItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        int dataStore = this.getDamage(context.getItemInHand());
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if (clickedBlock == ModBlocks.DATAPEARL_READER.get()) {
            if (level instanceof ServerLevel serverLevel) {
                if (dataStore == 0) {
                    setData(context.getItemInHand());
                    serverLevel.getServer().getPlayerList().broadcastSystemMessage(Component.literal(dataMap.get(this.getDamage(context.getItemInHand()))), true);
                } else {
                    if (dataStore != 9) {
                        serverLevel.getServer().getPlayerList().broadcastSystemMessage(Component.literal(dataMap.get(this.getDamage(context.getItemInHand()))), true);
                    } else {
                        readMultilineData(dataNine, serverLevel);
                    }
                }
            }
        }

        return super.useOn(context);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return false;
    }

    private void setData(ItemStack itemStack) {
        int amount = Mth.nextInt(RandomSource.create(), 1, 10);
        this.setDamage(itemStack, amount);
    }

    private void readMultilineData(List list, ServerLevel serverLevel) {

        serverLevel.getServer().getPlayerList().broadcastSystemMessage(
                Component.literal(list.getFirst().toString()),
                true);
        for (int i = 1; i < list.size(); i++) {
            int Index = i;
            FoTSlugcats.queueServerWork(80 * i, () -> {
                serverLevel.getServer().getPlayerList().broadcastSystemMessage(
                        Component.literal(list.get(Index).toString()),
                        true);
            });
        }
    }
}
