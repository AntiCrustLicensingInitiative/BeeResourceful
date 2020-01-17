package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.ChanceDropFlavor
import net.minecraft.item.ItemStack
import techreborn.init.TRContent

object TechReborn {
    val RUBBER_FLAVOR = BeeResourceful.registerFlavor("rubber", ChanceDropFlavor(ItemStack(TRContent.Parts.RUBBER.asItem(), 2)))
    val ALUMINIUM_FLAVOR = BeeResourceful.registerFlavor("aluminium", ChanceDropFlavor(TRContent.Nuggets.ALUMINUM.asItem()))
    val BRASS_FLAVOR = BeeResourceful.registerFlavor("brass", ChanceDropFlavor(TRContent.Nuggets.BRASS.asItem()))
    val BRONZE_FLAVOR = BeeResourceful.registerFlavor("bronze", ChanceDropFlavor(TRContent.Nuggets.BRONZE.asItem()))
    val CHROME_FLAVOR = BeeResourceful.registerFlavor("chrome", ChanceDropFlavor(TRContent.Nuggets.CHROME.asItem()))
    val COPPER_FLAVOR = BeeResourceful.registerFlavor("copper", ChanceDropFlavor(ItemStack(TRContent.Nuggets.COPPER.asItem(), 2)))
    val TIN_FLAVOR = BeeResourceful.registerFlavor("tin", ChanceDropFlavor(ItemStack(TRContent.Nuggets.TIN.asItem(), 2)))
    val ELECTRUM_FLAVOR = BeeResourceful.registerFlavor("electrum", ChanceDropFlavor(TRContent.Nuggets.ELECTRUM.asItem()))
    val INVAR_FLAVOR = BeeResourceful.registerFlavor("invar", ChanceDropFlavor(TRContent.Nuggets.INVAR.asItem()))
    val IRIDIUM_FLAVOR = BeeResourceful.registerFlavor("iridium", ChanceDropFlavor(TRContent.Nuggets.IRIDIUM.asItem()))
    val LEAD_FLAVOR = BeeResourceful.registerFlavor("lead", ChanceDropFlavor(ItemStack(TRContent.Nuggets.LEAD.asItem(), 2)))
    val NICKEL_FLAVOR = BeeResourceful.registerFlavor("nickel", ChanceDropFlavor(TRContent.Nuggets.NICKEL.asItem()))
    val PLATINUM_FLAVOR = BeeResourceful.registerFlavor("platinum", ChanceDropFlavor(TRContent.Nuggets.PLATINUM.asItem()))
    val SILVER_FLAVOR = BeeResourceful.registerFlavor("silver", ChanceDropFlavor(ItemStack(TRContent.Nuggets.SILVER.asItem(), 2)))
    val STEEL_FLAVOR = BeeResourceful.registerFlavor("steel", ChanceDropFlavor(TRContent.Nuggets.STEEL.asItem()))
    val TITANIUM_FLAVOR = BeeResourceful.registerFlavor("titanium", ChanceDropFlavor(TRContent.Nuggets.TITANIUM.asItem()))
    val TUNGSTEN_FLAVOR = BeeResourceful.registerFlavor("tungsten", ChanceDropFlavor(TRContent.Nuggets.TUNGSTEN.asItem()))
    val ZINC_FLAVOR = BeeResourceful.registerFlavor("zinc", ChanceDropFlavor(TRContent.Nuggets.ZINC.asItem()))

    fun init() {}
}