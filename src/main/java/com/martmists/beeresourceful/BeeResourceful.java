/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  com.martmists.beeresourceful.BeeResourceful$onInitialize
 *  com.swordglowsblue.artifice.api.Artifice
 *  com.swordglowsblue.artifice.api.util.Processor
 *  io.github.alloffabric.beeproductive.BeeProductive
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  io.github.alloffabric.beeproductive.api.Nectar
 *  io.github.alloffabric.beeproductive.api.hive.Beehive
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.entity.passive.BeeEntity
 *  net.minecraft.item.Item
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.registry.DefaultedRegistry
 *  net.minecraft.util.registry.Registry
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful;

import com.martmists.beeresourceful.ext.HoneyFlavorJava;
import com.martmists.beeresourceful.ext.NectarJava;
import com.martmists.beeresourceful.libcd.RecipeCreator;
import com.martmists.beeresourceful.nectars.Potions;
import com.martmists.beeresourceful.nectars.Vanilla;
import com.martmists.beeresourceful.nectars.compat.MobZ;
import com.martmists.beeresourceful.nectars.compat.Oysters;
import com.martmists.beeresourceful.nectars.compat.TechReborn;
import com.swordglowsblue.artifice.api.Artifice;
import io.github.alloffabric.beeproductive.BeeProductive;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import io.github.alloffabric.beeproductive.api.Nectar;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BeeResourceful implements ModInitializer {
	private static final Logger logger;
	public static final BeeResourceful INSTANCE;

	public final Logger getLogger() {
		return logger;
	}

	@Override
	public void onInitialize() {
		logger.info("[Bee Resourceful] loading items...");
		logger.info("[Bee Resourceful] Adding Vanilla drops...");
		Vanilla.INSTANCE.init();
		logger.info("[Bee Resourceful] Adding potions...");
		Potions.INSTANCE.init();
		FabricLoader fabricLoader = FabricLoader.getInstance();
		if (fabricLoader.getEnvironmentType() == EnvType.CLIENT) {
			logger.info("[Bee Resourceful] Adding Artifice resources...");
			Artifice.registerAssets(new Identifier("beeresourceful", "br_potion_data"), pack -> pack.addTranslations(new Identifier("beeresourceful", "en_us"), translations -> {
				Potions.INSTANCE.getPotionFlavors().forEach((k, v) -> {
					Identifier id = new Identifier("beeresourceful", "potion_" + k + "_nectar");

					String[] args = id.getPath().replace("potion_", "potion_of_").split("_");
					for (int i = 0; i < args.length; i++) {
						if (!"of".equals(args[i]))
							args[i] = Character.toUpperCase(args[i].charAt(0)) + args[i].substring(1);
					}
					translations.entry("item.beeresourceful." + id.getPath(), String.join(" ", args));

					pack.addItemModel(id, i -> {
						i.parent(new Identifier("minecraft", "item/generated"));
						i.texture("layer0", new Identifier("beeresourceful", "item/potion_nectar"));
					});
				});
			}));
		}
		if (FabricLoader.getInstance().isModLoaded("techreborn")) {
			logger.info("[Bee Resourceful] Adding TR drops...");
			TechReborn.INSTANCE.init();
		}
		if (FabricLoader.getInstance().isModLoaded("oysters")) {
			logger.info("[Bee Resourceful] Adding Oysters drops...");
			Oysters.INSTANCE.init();
		}
		if (FabricLoader.getInstance().isModLoaded("mobz")) {
			logger.info("[Bee Resourceful] Adding MobZ drops...");
			MobZ.INSTANCE.init();
		}
		logger.info("[Bee Resourceful] Done loading. Enjoy!");
	}

	public final Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier("beeresourceful", name + "_nectar"), item);
	}


	public final Nectar registerNectar(String name, Nectar nectar) {
		nectar = Registry.register(BeeProductive.NECTARS, new Identifier("beeresourceful", name), nectar);
		NectarJava.registerItem(nectar, name);
		return nectar;
	}


	public final HoneyFlavor registerFlavor(String name, HoneyFlavor flavor) {
		HoneyFlavor object = Registry.register(BeeProductive.HONEY_FLAVORS, new Identifier("beeresourceful", name), flavor);
		HoneyFlavorJava.registerNectar(flavor, name);
		INSTANCE.registerRecipe(name, flavor);
		return object;
	}

	public final void registerRecipe(String name, HoneyFlavor flavor) {
		if (name.startsWith("potion_")) {
			RecipeCreator.INSTANCE.getPotionFlavors().put(name, flavor);
		} else {
			RecipeCreator.INSTANCE.getFlavors().put(name, flavor);
		}
	}

	private BeeResourceful() {
	}

	static {
		INSTANCE = new BeeResourceful();
		logger = LogManager.getLogger("Bee Resourceful");
	}
}

