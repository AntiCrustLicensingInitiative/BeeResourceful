/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  io.github.cottonmc.libcd.api.LibCDInitializer
 *  io.github.cottonmc.libcd.api.condition.ConditionManager
 *  io.github.cottonmc.libcd.api.tweaker.TweakerManager
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.libcd;

import com.martmists.beeresourceful.BeeResourceful;
import io.github.cottonmc.libcd.api.LibCDInitializer;
import io.github.cottonmc.libcd.api.condition.ConditionManager;
import io.github.cottonmc.libcd.api.tweaker.TweakerManager;


public final class ModLibCDEntrypoint implements LibCDInitializer {
	@Override
	public void initTweakers(TweakerManager p0) {
		BeeResourceful.INSTANCE.getLogger().info("[Bee Resourceful] Adding LibCD tweaker...");
		p0.addAssistant("beeresourceful.libcd.CustomNectar", CustomNectar.INSTANCE);
		p0.addAssistant("beeresourceful.libcd.RecipeCreator", RecipeCreator.INSTANCE);
		BeeResourceful.INSTANCE.getLogger().warn("NOTE: The LibCD tweaker adds the items to the registry! If you create custom Nectars in one world, these will stay around in others until you restart your game! (This feature also may not work reliably on servers)");
	}

	@Override
	public void initConditions(ConditionManager p0) {

	}
}

