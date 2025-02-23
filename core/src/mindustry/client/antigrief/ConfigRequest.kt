package mindustry.client.antigrief

import mindustry.*
import mindustry.gen.*

class ConfigRequest @JvmOverloads constructor(val x: Int, val y: Int, var value: Any?, var isRotate: Boolean = false) : Runnable {
    @JvmOverloads constructor(build: Building, value: Any?, isRotate: Boolean = false): this(build.tileX(), build.tileY(), value, isRotate)

    override fun run() {
        val tile = Vars.world?.tile(x, y) ?: return
        if (isRotate) Call.rotateBlock(Vars.player, tile.build, value as Boolean)
        else Call.tileConfig(Vars.player, tile.build, value)
    }
}
