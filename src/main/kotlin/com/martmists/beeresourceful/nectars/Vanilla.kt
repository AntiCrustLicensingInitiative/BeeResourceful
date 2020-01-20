package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.SimpleFlavor
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object Vanilla {
    val DIAMOND_FLAVOR = BeeResourceful.registerFlavor("diamond", SimpleFlavor.bySheared(Items.DIAMOND))
    val EMERALD_FLAVOR = BeeResourceful.registerFlavor("emerald", SimpleFlavor.bySheared(Items.EMERALD))
    val IRON_FLAVOR = BeeResourceful.registerFlavor("iron", SimpleFlavor.bySheared(Items.IRON_INGOT))
    val GOLD_FLAVOR = BeeResourceful.registerFlavor("gold", SimpleFlavor.bySheared(Items.GOLD_INGOT))
    val LAPIS_FLAVOR = BeeResourceful.registerFlavor("lapis", SimpleFlavor.bySheared(Items.LAPIS_LAZULI))
    val REDSTONE_FLAVOR = BeeResourceful.registerFlavor("redstone", SimpleFlavor.bySheared(Items.REDSTONE))
    val GLOWSTONE_FLAVOR = BeeResourceful.registerFlavor("glowstone", SimpleFlavor.bySheared(Items.GLOWSTONE_DUST))
    val COAL_FLAVOR = BeeResourceful.registerFlavor("coal", SimpleFlavor.bySheared(Items.COAL))
    val QUARTZ_FLAVOR = BeeResourceful.registerFlavor("quartz", SimpleFlavor.bySheared(Items.QUARTZ))
    val XP_FLAVOR = BeeResourceful.registerFlavor("experience", SimpleFlavor.byBottled(ItemStack(Items.EXPERIENCE_BOTTLE)))
    val OBSIDIAN_FLAVOR = BeeResourceful.registerFlavor("obsidian", SimpleFlavor.bySheared(Items.OBSIDIAN))
    // Ender is handled by Bee Productive already
    val BLAZE_FLAVOR = BeeResourceful.registerFlavor("blaze", SimpleFlavor.bySheared(Items.BLAZE_ROD))

    fun init() {}
}
