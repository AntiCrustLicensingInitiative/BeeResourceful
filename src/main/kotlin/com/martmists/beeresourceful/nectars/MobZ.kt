package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.ChanceDropFlavor
import net.mobz.glomod
import techreborn.init.TRContent

object MobZ {
    val ENCHANTED_GOLD_FLAVOR = BeeResourceful.registerFlavor("enchanted_gold", ChanceDropFlavor(glomod.BOSSBARREN, chanceSheared = 0.1))
    val WEIRD_FLAVOR = BeeResourceful.registerFlavor("weird", ChanceDropFlavor(glomod.WEIRDINGOT, chanceSheared = 0.3))
    val METAL_FLAVOR = BeeResourceful.registerFlavor("metal", ChanceDropFlavor(glomod.HARDENEDMETAL, chanceSheared = 0.2))

    fun init() {}
}