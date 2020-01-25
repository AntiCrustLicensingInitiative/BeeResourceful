/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  com.martmists.beeresourceful.nectars.Potions$init
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionUtil
 *  net.minecraft.util.registry.DefaultedRegistry
 *  net.minecraft.util.registry.Registry
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.nectars;

import com.martmists.beeresourceful.BeeResourceful;
import com.martmists.beeresourceful.entities.SimpleFlavor;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.util.registry.Registry;
import java.util.HashMap;
import java.util.Map;


public final class Potions {
	private static final Map<String, HoneyFlavor> PotionFlavors = new HashMap<>();
	public static final Potions INSTANCE;
	public final Map<String, HoneyFlavor> getPotionFlavors() {
		return PotionFlavors;
	}
	public final void registerPotion(Potion it) {
		String string = it.finishTranslationKey("");
		String[] arr = string.split("/");
		String name = arr[arr.length - 1];
		if (!PotionFlavors.containsKey(name)) {
			ItemStack itemStack = PotionUtil.setPotion(new ItemStack(Items.POTION, 1), it);
			SimpleFlavor flavor = SimpleFlavor.Companion.byBottled(itemStack);
			PotionFlavors.put(name, flavor);
			BeeResourceful.INSTANCE.registerFlavor("potion_" + name, flavor);
		}
	}

	public final void init() {
		for (Potion potion : Registry.POTION)
			INSTANCE.registerPotion(potion);
		RegistryEntryAddedCallback.event(Registry.POTION).register((a, b, c) -> this.registerPotion(c));
	}

	static {
		INSTANCE = new Potions();
		PotionFlavors.put("mundane", null);
		PotionFlavors.put("awkward", null);
		PotionFlavors.put("thick", null);
		PotionFlavors.put("water", null);
		PotionFlavors.put("empty", null);
	}
}

