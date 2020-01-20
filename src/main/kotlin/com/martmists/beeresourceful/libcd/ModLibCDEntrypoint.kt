package com.martmists.beeresourceful.libcd

import com.martmists.beeresourceful.BeeResourceful
import io.github.cottonmc.libcd.api.LibCDInitializer
import io.github.cottonmc.libcd.api.condition.ConditionManager
import io.github.cottonmc.libcd.api.tweaker.TweakerManager

/*
* Custom LibCD Tweaker for adding custom nectar
* Note: Requires textures and langs to be added in a resourcepack
* */

class ModLibCDEntrypoint : LibCDInitializer {
    override fun initTweakers(p0: TweakerManager) {
        BeeResourceful.logger.info("[Bee Resourceful] Adding LibCD tweaker...")
        p0.addAssistant("beeresourceful.libcd.CustomNectar", CustomNectar)
        p0.addAssistant("beeresourceful.libcd.RecipeCreator", RecipeCreator)
        BeeResourceful.logger.warn(
                "NOTE: The LibCD tweaker adds the items to the registry! " +
                        "If you create custom Nectars in one world, these will stay around " +
                        "in others until you restart your game! " +
                        "(This feature also may not work reliably on servers)")
    }

    override fun initConditions(p0: ConditionManager) {}
}