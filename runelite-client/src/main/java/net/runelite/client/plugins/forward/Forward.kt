package net.runelite.client.plugins.forward

import com.google.inject.Provides
import lombok.extern.slf4j.Slf4j
import javax.inject.Inject
import net.runelite.api.Client
import net.runelite.api.events.GameStateChanged
import net.runelite.api.events.GameTick
import net.runelite.api.events.GraphicChanged
import net.runelite.client.config.ConfigManager
import net.runelite.client.eventbus.Subscribe
import net.runelite.client.plugins.Plugin
import net.runelite.client.plugins.PluginDescriptor
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Slf4j
@PluginDescriptor(
    name = "Forward",
    description = "Test plugin",
    tags = ["test"]
)
class Forward : Plugin() {
    companion object {
        @JvmField
        var plugin: Forward? = null
    }

    val clss = Forward::class.java
    val jclass = Forward::javaClass
    private val log: Logger = LoggerFactory.getLogger(Forward::class.java)

    @Inject
    lateinit var client: Client

    override fun startUp() {
        log.info("Forward Gfx plugin startUp")
        plugin = this
    }

    @Subscribe
    fun onGraphicChanged(g: GraphicChanged) {
        if (g.actor.name?.contains("Gemstone Crab") == true || g.actor.name?.contains("Weebs2244") ?: false) {
            val a = g.actor
            val n = a.name
            val vxs = g.actor.model.verticesX
            val vys = g.actor.model.verticesY
            val vzs = g.actor.model.verticesZ
            log.info("Graphic changed $n (${a.animationFrame}): Lvl ${a.combatLevel} at ${a.worldLocation.x}, ${a.worldLocation.y}")
        }
    }

    @Subscribe
    fun onGameTick(event: GameTick) {
        val foo = 1
        val bar = foo * 2
    }

    @Subscribe
    fun onGameStateChanged(event: GameStateChanged) {
        val foo = 1
        val bar = foo * 2
    }
}