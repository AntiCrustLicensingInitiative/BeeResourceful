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
 *  org.jetbrains.annotations.NotNull
 *  techreborn.init.TRContent
 *  techreborn.init.TRContent$Ingots
 *  techreborn.init.TRContent$Parts
 */
package com.martmists.beeresourceful.nectars.compat;

import com.martmists.beeresourceful.BeeResourceful;
import com.martmists.beeresourceful.entities.SimpleFlavor;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import techreborn.init.TRContent;


public final class TechReborn {
	private static final HoneyFlavor RUBBER_FLAVOR;
	private static final HoneyFlavor ALUMINIUM_FLAVOR;
	private static final HoneyFlavor BRASS_FLAVOR;
	private static final HoneyFlavor BRONZE_FLAVOR;
	private static final HoneyFlavor CHROME_FLAVOR;
	private static final HoneyFlavor COPPER_FLAVOR;
	private static final HoneyFlavor TIN_FLAVOR;
	private static final HoneyFlavor ELECTRUM_FLAVOR;
	private static final HoneyFlavor INVAR_FLAVOR;
	private static final HoneyFlavor IRIDIUM_FLAVOR;
	private static final HoneyFlavor LEAD_FLAVOR;
	private static final HoneyFlavor NICKEL_FLAVOR;
	private static final HoneyFlavor PLATINUM_FLAVOR;
	private static final HoneyFlavor SILVER_FLAVOR;
	private static final HoneyFlavor STEEL_FLAVOR;
	private static final HoneyFlavor TITANIUM_FLAVOR;
	private static final HoneyFlavor TUNGSTEN_FLAVOR;
	private static final HoneyFlavor ZINC_FLAVOR;
	public static final TechReborn INSTANCE;

	public final HoneyFlavor getRUBBER_FLAVOR() {
		return RUBBER_FLAVOR;
	}

	public final HoneyFlavor getALUMINIUM_FLAVOR() {
		return ALUMINIUM_FLAVOR;
	}

	public final HoneyFlavor getBRASS_FLAVOR() {
		return BRASS_FLAVOR;
	}

	public final HoneyFlavor getBRONZE_FLAVOR() {
		return BRONZE_FLAVOR;
	}

	public final HoneyFlavor getCHROME_FLAVOR() {
		return CHROME_FLAVOR;
	}

	public final HoneyFlavor getCOPPER_FLAVOR() {
		return COPPER_FLAVOR;
	}

	public final HoneyFlavor getTIN_FLAVOR() {
		return TIN_FLAVOR;
	}

	public final HoneyFlavor getELECTRUM_FLAVOR() {
		return ELECTRUM_FLAVOR;
	}

	public final HoneyFlavor getINVAR_FLAVOR() {
		return INVAR_FLAVOR;
	}

	public final HoneyFlavor getIRIDIUM_FLAVOR() {
		return IRIDIUM_FLAVOR;
	}

	public final HoneyFlavor getLEAD_FLAVOR() {
		return LEAD_FLAVOR;
	}

	public final HoneyFlavor getNICKEL_FLAVOR() {
		return NICKEL_FLAVOR;
	}

	public final HoneyFlavor getPLATINUM_FLAVOR() {
		return PLATINUM_FLAVOR;
	}

	public final HoneyFlavor getSILVER_FLAVOR() {
		return SILVER_FLAVOR;
	}

	public final HoneyFlavor getSTEEL_FLAVOR() {
		return STEEL_FLAVOR;
	}

	public final HoneyFlavor getTITANIUM_FLAVOR() {
		return TITANIUM_FLAVOR;
	}

	public final HoneyFlavor getTUNGSTEN_FLAVOR() {
		return TUNGSTEN_FLAVOR;
	}

	public final HoneyFlavor getZINC_FLAVOR() {
		return ZINC_FLAVOR;
	}

	public final void init() {
	}

	private TechReborn() {
	}

	static {
		INSTANCE = new TechReborn();
		RUBBER_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("rubber", SimpleFlavor.Companion.bySheared(new ItemStack(TRContent.Parts.RUBBER.asItem(), 5)));
		Item item = TRContent.Ingots.ALUMINUM.asItem();

		ALUMINIUM_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("aluminium", SimpleFlavor.Companion.bySheared(item));
		Item item2 = TRContent.Ingots.BRASS.asItem();

		BRASS_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("brass", SimpleFlavor.Companion.bySheared(item2));
		Item item3 = TRContent.Ingots.BRONZE.asItem();

		BRONZE_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("bronze", SimpleFlavor.Companion.bySheared(item3));
		Item item4 = TRContent.Ingots.CHROME.asItem();

		CHROME_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("chrome", SimpleFlavor.Companion.bySheared(item4));
		Item item5 = TRContent.Ingots.COPPER.asItem();

		COPPER_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("copper", SimpleFlavor.Companion.bySheared(item5));
		Item item6 = TRContent.Ingots.TIN.asItem();

		TIN_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("tin", SimpleFlavor.Companion.bySheared(item6));
		Item item7 = TRContent.Ingots.ELECTRUM.asItem();

		ELECTRUM_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("electrum", SimpleFlavor.Companion.bySheared(item7));
		Item item8 = TRContent.Ingots.INVAR.asItem();

		INVAR_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("invar", SimpleFlavor.Companion.bySheared(item8));
		Item item9 = TRContent.Ingots.IRIDIUM.asItem();

		IRIDIUM_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("iridium", SimpleFlavor.Companion.bySheared(item9));
		Item item10 = TRContent.Ingots.LEAD.asItem();

		LEAD_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("lead", SimpleFlavor.Companion.bySheared(item10));
		Item item11 = TRContent.Ingots.NICKEL.asItem();

		NICKEL_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("nickel", SimpleFlavor.Companion.bySheared(item11));
		Item item12 = TRContent.Ingots.PLATINUM.asItem();

		PLATINUM_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("platinum", SimpleFlavor.Companion.bySheared(item12));
		Item item13 = TRContent.Ingots.SILVER.asItem();

		SILVER_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("silver", SimpleFlavor.Companion.bySheared(item13));
		Item item14 = TRContent.Ingots.STEEL.asItem();

		STEEL_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("steel", SimpleFlavor.Companion.bySheared(item14));
		Item item15 = TRContent.Ingots.TITANIUM.asItem();

		TITANIUM_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("titanium", SimpleFlavor.Companion.bySheared(item15));
		Item item16 = TRContent.Ingots.TUNGSTEN.asItem();

		TUNGSTEN_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("tungsten", SimpleFlavor.Companion.bySheared(item16));
		Item item17 = TRContent.Ingots.ZINC.asItem();

		ZINC_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("zinc", SimpleFlavor.Companion.bySheared(item17));
	}
}

