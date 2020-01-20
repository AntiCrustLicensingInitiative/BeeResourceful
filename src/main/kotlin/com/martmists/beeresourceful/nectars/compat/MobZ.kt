package com.martmists.beeresourceful.nectars.compat

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.SimpleFlavor
import net.mobz.glomod

object MobZ {
    val ENCHANTED_GOLD_FLAVOR = BeeResourceful.registerFlavor("enchanted_gold", SimpleFlavor.bySheared(glomod.BOSSBARREN))
    val WEIRD_FLAVOR = BeeResourceful.registerFlavor("weird", SimpleFlavor.bySheared(glomod.WEIRDINGOT))
    val METAL_FLAVOR = BeeResourceful.registerFlavor("metal", SimpleFlavor.bySheared(glomod.HARDENEDMETAL))

    fun init() {}
}