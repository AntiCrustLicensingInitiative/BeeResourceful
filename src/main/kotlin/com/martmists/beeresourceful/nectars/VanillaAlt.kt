package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.ChanceDropFlavor
import techreborn.init.TRContent

object VanillaAlt {
    val DIAMOND_FLAVOR = BeeResourceful.registerFlavor("diamond", ChanceDropFlavor(TRContent.Nuggets.DIAMOND.asItem()))
    val EMERALD_FLAVOR = BeeResourceful.registerFlavor("emerald", ChanceDropFlavor(TRContent.Nuggets.EMERALD.asItem()))

    fun init() {}
}