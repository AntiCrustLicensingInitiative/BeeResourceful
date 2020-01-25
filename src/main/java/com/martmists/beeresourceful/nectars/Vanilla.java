/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.nectars;

import com.martmists.beeresourceful.BeeResourceful;
import com.martmists.beeresourceful.entities.SimpleFlavor;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;


public final class Vanilla {
	private static final HoneyFlavor DIAMOND_FLAVOR;
	private static final HoneyFlavor EMERALD_FLAVOR;
	private static final HoneyFlavor IRON_FLAVOR;
	private static final HoneyFlavor GOLD_FLAVOR;
	private static final HoneyFlavor LAPIS_FLAVOR;
	private static final HoneyFlavor REDSTONE_FLAVOR;
	private static final HoneyFlavor GLOWSTONE_FLAVOR;
	private static final HoneyFlavor COAL_FLAVOR;
	private static final HoneyFlavor QUARTZ_FLAVOR;
	private static final HoneyFlavor XP_FLAVOR;
	private static final HoneyFlavor OBSIDIAN_FLAVOR;
	private static final HoneyFlavor BLAZE_FLAVOR;
	public static final Vanilla INSTANCE;

	public final HoneyFlavor getDIAMOND_FLAVOR() {
		return DIAMOND_FLAVOR;
	}

	public final HoneyFlavor getEMERALD_FLAVOR() {
		return EMERALD_FLAVOR;
	}

	public final HoneyFlavor getIRON_FLAVOR() {
		return IRON_FLAVOR;
	}

	public final HoneyFlavor getGOLD_FLAVOR() {
		return GOLD_FLAVOR;
	}

	public final HoneyFlavor getLAPIS_FLAVOR() {
		return LAPIS_FLAVOR;
	}

	public final HoneyFlavor getREDSTONE_FLAVOR() {
		return REDSTONE_FLAVOR;
	}

	public final HoneyFlavor getGLOWSTONE_FLAVOR() {
		return GLOWSTONE_FLAVOR;
	}

	public final HoneyFlavor getCOAL_FLAVOR() {
		return COAL_FLAVOR;
	}

	public final HoneyFlavor getQUARTZ_FLAVOR() {
		return QUARTZ_FLAVOR;
	}

	public final HoneyFlavor getXP_FLAVOR() {
		return XP_FLAVOR;
	}

	public final HoneyFlavor getOBSIDIAN_FLAVOR() {
		return OBSIDIAN_FLAVOR;
	}

	public final HoneyFlavor getBLAZE_FLAVOR() {
		return BLAZE_FLAVOR;
	}

	public final void init() {
	}

	static {
		INSTANCE = new Vanilla();
		Item item = Items.DIAMOND;
		DIAMOND_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("diamond", SimpleFlavor.Companion.bySheared(item));
		Item item2 = Items.EMERALD;
		EMERALD_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("emerald", SimpleFlavor.Companion.bySheared(item2));
		Item item3 = Items.IRON_INGOT;
		IRON_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("iron", SimpleFlavor.Companion.bySheared(item3));
		Item item4 = Items.GOLD_INGOT;
		GOLD_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("gold", SimpleFlavor.Companion.bySheared(item4));
		Item item5 = Items.LAPIS_LAZULI;
		LAPIS_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("lapis", SimpleFlavor.Companion.bySheared(item5));
		Item item6 = Items.REDSTONE;
		REDSTONE_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("redstone", SimpleFlavor.Companion.bySheared(item6));
		Item item7 = Items.GLOWSTONE_DUST;
		GLOWSTONE_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("glowstone", SimpleFlavor.Companion.bySheared(item7));
		Item item8 = Items.COAL;
		COAL_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("coal", SimpleFlavor.Companion.bySheared(item8));
		Item item9 = Items.QUARTZ;
		QUARTZ_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("quartz", SimpleFlavor.Companion.bySheared(item9));
		XP_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("experience", SimpleFlavor.Companion.byBottled(new ItemStack(Items.EXPERIENCE_BOTTLE)));
		Item item10 = Items.OBSIDIAN;
		OBSIDIAN_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("obsidian", SimpleFlavor.Companion.bySheared(item10));
		Item item11 = Items.BLAZE_ROD;
		BLAZE_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("blaze", SimpleFlavor.Companion.bySheared(item11));
	}
}

