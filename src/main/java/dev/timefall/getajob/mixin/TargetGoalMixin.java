package dev.timefall.getajob.mixin;

import dev.timefall.getajob.powers.RemoveMobHostilityPower;
import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Copyright (c) 2023 UltrusBot, provided under
 * The MIT License (MIT)
 * <br/><br/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <br/><br/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <br/><br/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

@Mixin(ActiveTargetGoal.class)
public abstract class TargetGoalMixin extends TrackTargetGoal {

    public TargetGoalMixin(MobEntity mob, boolean checkVisibility) {
        super(mob, checkVisibility);
    }

    @Inject(method = "start", at = @At("HEAD"), cancellable = true)
    public void getajob$removeMobHostility(CallbackInfo ci) {
        if (PowerHolderComponent.getPowers(target, RemoveMobHostilityPower.class)
                .stream()
                .anyMatch(
                        removeMobHostilityPower -> removeMobHostilityPower
                                .apply(this.mob))) {
            this.stop();
            ci.cancel();
        }
    }
}
