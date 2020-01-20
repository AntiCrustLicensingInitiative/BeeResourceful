package com.martmists.beeresourceful.nectars.compat

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.SimpleFlavor
import net.minecraft.item.ItemStack
import techreborn.init.TRContent

object TechReborn {
    val RUBBER_FLAVOR = BeeResourceful.registerFlavor("rubber", SimpleFlavor.bySheared(ItemStack(TRContent.Parts.RUBBER.asItem(), 5)))
    val ALUMINIUM_FLAVOR = BeeResourceful.registerFlavor("aluminium", SimpleFlavor.bySheared(TRContent.Ingots.ALUMINUM.asItem()))
    val BRASS_FLAVOR = BeeResourceful.registerFlavor("brass", SimpleFlavor.bySheared(TRContent.Ingots.BRASS.asItem()))
    val BRONZE_FLAVOR = BeeResourceful.registerFlavor("bronze", SimpleFlavor.bySheared(TRContent.Ingots.BRONZE.asItem()))
    val CHROME_FLAVOR = BeeResourceful.registerFlavor("chrome", SimpleFlavor.bySheared(TRContent.Ingots.CHROME.asItem()))
    val COPPER_FLAVOR = BeeResourceful.registerFlavor("copper", SimpleFlavor.bySheared(TRContent.Ingots.COPPER.asItem()))
    val TIN_FLAVOR = BeeResourceful.registerFlavor("tin", SimpleFlavor.bySheared(TRContent.Ingots.TIN.asItem()))
    val ELECTRUM_FLAVOR = BeeResourceful.registerFlavor("electrum", SimpleFlavor.bySheared(TRContent.Ingots.ELECTRUM.asItem()))
    val INVAR_FLAVOR = BeeResourceful.registerFlavor("invar", SimpleFlavor.bySheared(TRContent.Ingots.INVAR.asItem()))
    val IRIDIUM_FLAVOR = BeeResourceful.registerFlavor("iridium", SimpleFlavor.bySheared(TRContent.Ingots.IRIDIUM.asItem()))
    val LEAD_FLAVOR = BeeResourceful.registerFlavor("lead", SimpleFlavor.bySheared(TRContent.Ingots.LEAD.asItem()))
    val NICKEL_FLAVOR = BeeResourceful.registerFlavor("nickel", SimpleFlavor.bySheared(TRContent.Ingots.NICKEL.asItem()))
    val PLATINUM_FLAVOR = BeeResourceful.registerFlavor("platinum", SimpleFlavor.bySheared(TRContent.Ingots.PLATINUM.asItem()))
    val SILVER_FLAVOR = BeeResourceful.registerFlavor("silver", SimpleFlavor.bySheared(TRContent.Ingots.SILVER.asItem()))
    val STEEL_FLAVOR = BeeResourceful.registerFlavor("steel", SimpleFlavor.bySheared(TRContent.Ingots.STEEL.asItem()))
    val TITANIUM_FLAVOR = BeeResourceful.registerFlavor("titanium", SimpleFlavor.bySheared(TRContent.Ingots.TITANIUM.asItem()))
    val TUNGSTEN_FLAVOR = BeeResourceful.registerFlavor("tungsten", SimpleFlavor.bySheared(TRContent.Ingots.TUNGSTEN.asItem()))
    val ZINC_FLAVOR = BeeResourceful.registerFlavor("zinc", SimpleFlavor.bySheared(TRContent.Ingots.ZINC.asItem()))

    fun init() {}
}