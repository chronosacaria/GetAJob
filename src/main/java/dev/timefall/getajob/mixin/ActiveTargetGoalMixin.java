package dev.timefall.getajob.mixin;

import dev.timefall.getajob.powers.ModifyBehaviorPower;
import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ActiveTargetGoal.class)
public abstract class ActiveTargetGoalMixin extends TrackTargetGoal {
    @Shadow @Nullable protected LivingEntity targetEntity;

    @Shadow public abstract void start();

    //List<ModifyBehaviorPower> powersCheck = PowerHolderComponent.getPowers(target, ModifyBehaviorPower.class);

    public ActiveTargetGoalMixin(MobEntity mob, boolean checkVisibility) {
        super(mob, checkVisibility);
    }

    @Inject(method = "start", at = @At(value = "HEAD"), cancellable = true)
    public void getajob$modifyEntityBehavior(CallbackInfo ci) {
        //List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(targetEntity, ModifyBehaviorPower.class);
        if (PowerHolderComponent.getPowers(this.mob.getTarget(), ModifyBehaviorPower.class)
                .stream()
                .anyMatch(
                        removeMobHostilityPower -> removeMobHostilityPower
                                .checkEntity(this.mob.getType()))) {
            ModifyBehaviorPower.EntityBehavior behavior = PowerHolderComponent.getPowers(targetEntity, ModifyBehaviorPower.class).get(0).getDesiredBehavior();
            if (behavior == ModifyBehaviorPower.EntityBehavior.NEUTRAL) {
                stop();
                ci.cancel();
            }
        }
        //if (PowerHolderComponent.getPowers(targetEntity, ModifyBehaviorPower.class)
        //        .stream()
        //        .anyMatch(
        //                modifyBehaviorPower -> modifyBehaviorPower
        //                        .checkEntity(targetEntity.getType()))) {
        //    ModifyBehaviorPower.EntityBehavior entityBehavior = powersCheck.get(0).getDesiredBehavior();
        //    if (entityBehavior == ModifyBehaviorPower.EntityBehavior.NEUTRAL) {
        //        this.stop();
        //        ci.cancel();
        //    }
        //}
    }
}
