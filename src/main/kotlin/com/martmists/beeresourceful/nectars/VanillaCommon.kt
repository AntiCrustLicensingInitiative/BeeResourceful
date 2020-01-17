package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.ChanceDropFlavor
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object VanillaCommon {
    val IRON_FLAVOR = BeeResourceful.registerFlavor("iron", ChanceDropFlavor(ItemStack(Items.IRON_NUGGET, 4)))
    val GOLD_FLAVOR = BeeResourceful.registerFlavor("gold", ChanceDropFlavor(ItemStack(Items.GOLD_NUGGET, 2)))
    val LAPIS_FLAVOR = BeeResourceful.registerFlavor("lapis", ChanceDropFlavor(ItemStack(Items.LAPIS_LAZULI, 2)))
    val REDSTONE_FLAVOR = BeeResourceful.registerFlavor("redstone", ChanceDropFlavor(ItemStack(Items.REDSTONE, 3)))
    val GLOWSTONE_FLAVOR = BeeResourceful.registerFlavor("glowstone", ChanceDropFlavor(ItemStack(Items.GLOWSTONE_DUST, 3)))
    val COAL_FLAVOR = BeeResourceful.registerFlavor("coal", ChanceDropFlavor(ItemStack(Items.COAL)))
    val QUARTZ_FLAVOR = BeeResourceful.registerFlavor("quartz", ChanceDropFlavor(Items.QUARTZ))
    val XP_FLAVOR = BeeResourceful.registerFlavor("experience", ChanceDropFlavor(ItemStack(Items.HONEYCOMB, 3), ItemStack(Items.EXPERIENCE_BOTTLE)))
    val OBSIDIAN_FLAVOR = BeeResourceful.registerFlavor("obsidian", ChanceDropFlavor(Items.OBSIDIAN, chanceSheared = 0.7))
    // Ender is handled by Bee Productive already
    val BLAZE_FLAVOR = BeeResourceful.registerFlavor("blaze", ChanceDropFlavor(Items.BLAZE_ROD, chanceSheared = 0.85))

    fun init(){}
}
