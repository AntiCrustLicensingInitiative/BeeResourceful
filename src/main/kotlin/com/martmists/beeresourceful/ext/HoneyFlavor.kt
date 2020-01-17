package com.martmists.beeresourceful.ext

import com.martmists.beeresourceful.BeeResourceful
import io.github.alloffabric.beeproductive.api.HoneyFlavor

fun HoneyFlavor.registerNectar(name: String) = BeeResourceful.registerNectar(name) { bee, hive -> hive.addHoneyFlavor(this) }
