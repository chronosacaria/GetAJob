package dev.timefall.getajob.powers;

import dev.timefall.getajob.GetAJob;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.apace100.apoli.power.factory.PowerFactory;
import net.minecraft.util.Identifier;

public class GetAJobPowerTypes {
    public static final PowerType<?> VILLAGER_HATED = new PowerTypeReference<>(new Identifier(GetAJob.MOD_ID, "villager_hated"));

    public static void register() {
    }

    public static void register(PowerFactory<?> factory) {
        //Registry.register(ApoliRegistries.POWER_FACTORY, factory.getSerializerID(), factory);
    }
}
