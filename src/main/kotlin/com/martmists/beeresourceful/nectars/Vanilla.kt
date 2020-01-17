package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.ChanceDropFlavor
import net.minecraft.item.Items

object Vanilla {
    val DIAMOND_FLAVOR = BeeResourceful.registerFlavor("diamond", ChanceDropFlavor(Items.DIAMOND, chanceSheared = 0.1))
    val EMERALD_FLAVOR = BeeResourceful.registerFlavor("emerald", ChanceDropFlavor(Items.EMERALD, chanceSheared = 0.1))

    fun init() {}
}