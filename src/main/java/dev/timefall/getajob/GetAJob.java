package dev.timefall.getajob;

import dev.timefall.getajob.registries.ItemsRegistry;
import dev.timefall.getajob.registries.factories.GetAJobPowerFactories;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class GetAJob implements ModInitializer {

    public static final String MOD_ID = "getajob";

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        GetAJobPowerFactories.register();
        ItemsRegistry.init();
    }
}
