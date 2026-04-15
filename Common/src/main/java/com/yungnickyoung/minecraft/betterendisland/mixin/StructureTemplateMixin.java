package com.yungnickyoung.minecraft.betterendisland.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StructureTemplate.class)
public abstract class StructureTemplateMixin {

    @Inject(method = "placeInWorld", at = @At("HEAD"), cancellable = true)
    private void betterendisland$blockForeignStructures(
            ServerLevelAccessor level,
            BlockPos pos,
            BlockPos pivot,
            StructurePlaceSettings settings,
            RandomSource rand,
            int flags,
            CallbackInfoReturnable<Boolean> cir) {
        if (!com.yungnickyoung.minecraft.betterendisland.BetterEndIslandCommon.betterendisland$placingOwn.get()) {
            double distSq = (double)pos.getX() * pos.getX() + (double)pos.getZ() * pos.getZ();
            if (distSq <= 107584.0D) {
                cir.setReturnValue(false);
            }
        }
    }
}