package dev.timefall.getajob.powers;

import dev.timefall.getajob.GetAJob;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

import java.util.function.Predicate;

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

public class RemoveMobHostilityPower extends Power {

    private final Predicate<LivingEntity> entityCondition;

    /**
     * <p>DESC: This power allows you to remove the hostility of certain mobs. It's limited to certain mobs which have the
     * TargetGoal goal type. This means entities with brains (Piglins, Hoglins, and Villagers) won't be affected by this
     * power.</p>
     * <p>POWER_DESC: Removes the hostility of undead mobs towards the player.</p>
     *
     */
    public RemoveMobHostilityPower(PowerType<?> type, LivingEntity entity, Predicate<LivingEntity> entityCondition) {
        super(type, entity);
        this.entityCondition = entityCondition;
    }

    public boolean apply(Entity entity) {
        return entity instanceof LivingEntity && (entityCondition == null || entityCondition.test((LivingEntity) entity));
    }

    @SuppressWarnings("rawtypes")
    public static PowerFactory createFactory() {
        return new PowerFactory<RemoveMobHostilityPower>(GetAJob.id("remove_mob_hostility"),
                new SerializableData().add("entity_condition", ApoliDataTypes.ENTITY_CONDITION, null),
                data -> (type, player) -> new RemoveMobHostilityPower(type, player, data.get("entity_condition"))).allowCondition();
    }
}
