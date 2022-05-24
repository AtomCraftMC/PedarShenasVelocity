package ir.alijk.pedarshenasvelocity;

import com.google.inject.Inject;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.event.command.CommandExecuteEvent;
import com.velocitypowered.api.event.player.ServerPreConnectEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.Player;
import org.slf4j.Logger;

@Plugin(
        id = "pedarshenasvelocity",
        name = "PedarShenasVelocity",
        version = "1.0.0",
        authors = {"Alijk"}
)
public class PedarShenasVelocity {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }

    @Subscribe
    public void onCommand(CommandExecuteEvent e) {
        CommandSource source = e.getCommandSource();

        if (!(source instanceof Player)) return;

        Player p = (Player) source;
        if (p.getCurrentServer().get().getServerInfo().getName().startsWith("verify")) {
            e.setResult(CommandExecuteEvent.CommandResult.denied());
        }
    }
}