package dev.timefall.getajob.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin_DELETE_ME {

    @Inject(method = "jump", at = @At("HEAD"))
    public void printSSIDs(CallbackInfo ci) {
        Registries.ITEM.getIds().stream()
                .filter(identifier -> Objects.equals(identifier.getNamespace(), "simplyswords"))
                .forEach(System.out::println);
    }
}
