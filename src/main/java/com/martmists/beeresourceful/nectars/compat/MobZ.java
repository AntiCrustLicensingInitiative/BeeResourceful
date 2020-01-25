/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.item.Item
 *  net.mobz.Items.Item.BossIngot
 *  net.mobz.Items.Item.HardenedMetal
 *  net.mobz.Items.Item.WeirdIngot
 *  net.mobz.glomod
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.nectars.compat;

import com.martmists.beeresourceful.BeeResourceful;
import com.martmists.beeresourceful.entities.SimpleFlavor;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import net.mobz.Items.Item.BossIngot;
import net.mobz.Items.Item.HardenedMetal;
import net.mobz.Items.Item.WeirdIngot;
import net.mobz.glomod;

public final class MobZ {
	private static final HoneyFlavor ENCHANTED_GOLD_FLAVOR;
	private static final HoneyFlavor WEIRD_FLAVOR;
	private static final HoneyFlavor METAL_FLAVOR;
	public static final MobZ INSTANCE;

	public final HoneyFlavor getENCHANTED_GOLD_FLAVOR() {
		return ENCHANTED_GOLD_FLAVOR;
	}

	public final HoneyFlavor getWEIRD_FLAVOR() {
		return WEIRD_FLAVOR;
	}

	public final HoneyFlavor getMETAL_FLAVOR() {
		return METAL_FLAVOR;
	}

	public final void init() {
	}

	private MobZ() {
	}

	static {
		INSTANCE = new MobZ();
		BossIngot bossIngot = glomod.BOSSBARREN;
		ENCHANTED_GOLD_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("enchanted_gold", SimpleFlavor.Companion.bySheared(bossIngot));
		WeirdIngot weirdIngot = glomod.WEIRDINGOT;
		WEIRD_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("weird", SimpleFlavor.Companion.bySheared(weirdIngot));
		HardenedMetal hardenedMetal = glomod.HARDENEDMETAL;
		METAL_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("metal", SimpleFlavor.Companion.bySheared(hardenedMetal));
	}
}

