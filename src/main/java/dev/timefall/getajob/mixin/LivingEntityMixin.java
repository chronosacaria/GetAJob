package dev.timefall.getajob.mixin;

import dev.timefall.getajob.powers.GetAJobPowerTypes;
import dev.timefall.getajob.tags.GetAJobEntityTypeTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements Angerable {

    @Shadow public abstract Random getRandom();

    @Shadow private @Nullable LivingEntity attacker;
    @Shadow private int lastAttackedTime;
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);
    private int angerTime;
    public int age;
    @Nullable
    private UUID angryAt;
    @Nullable
    private LivingEntity target;
    @Nullable
    protected PlayerEntity playerEntity;
    protected int playerHitTimer;

    LivingEntity livingEntity = (LivingEntity) (Object) this;

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setAngerTime(int angerTime) {
        if (((LivingEntity)(Object)this instanceof PlayerEntity player)
                && livingEntity.getType().isIn(GetAJobEntityTypeTags.VILLAGE_DEFENDERS)
                && GetAJobPowerTypes.VILLAGER_HATED.isActive(player)) {
            this.angerTime = angerTime;
        }
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        if (((LivingEntity)(Object)this instanceof PlayerEntity player)
                && player.getType().isIn(GetAJobEntityTypeTags.VILLAGE_DEFENDERS)
                && GetAJobPowerTypes.VILLAGER_HATED.isActive(player)) {
            this.angryAt = angryAt;
        }
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.getRandom()));
    }

    @Nullable
    @Override
    public LivingEntity getAttacker() {
        return this.attacker;
    }

    @Override
    public void setAttacker(@Nullable LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player
                && player.getType().isIn(GetAJobEntityTypeTags.VILLAGE_DEFENDERS)
                && GetAJobPowerTypes.VILLAGER_HATED.isActive(player)) {
            this.attacker = player;
            this.lastAttackedTime = this.age;
        }
    }

    @Override
    public void setAttacking(@Nullable PlayerEntity attacking) {
        this.playerEntity = attacking;
        this.playerHitTimer = this.age;
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        if (((LivingEntity)(Object)this).getType().isIn(GetAJobEntityTypeTags.VILLAGE_DEFENDERS)
                && GetAJobPowerTypes.VILLAGER_HATED.isActive(target)) {
            this.target = target;
        }
    }

    @Override
    public boolean canTarget(LivingEntity target) {
        if (target instanceof PlayerEntity player
                && !GetAJobPowerTypes.VILLAGER_HATED.isActive(player)
                && livingEntity.getWorld().getDifficulty() == Difficulty.PEACEFUL) {
            return false;
        }
        return target.canTakeDamage();
    }

    @Nullable
    @Override
    public LivingEntity getTarget() {
        return this.target;
    }
}

