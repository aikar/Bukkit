package org.bukkit.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called when a player leaves a server
 */
public class PlayerQuitEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private final QuitReason reason; // Paper
    private String quitMessage;

    public PlayerQuitEvent(@NotNull final Player who, @Nullable final String quitMessage) {
        // Paper start
        this(who, quitMessage, null);
    }
    public PlayerQuitEvent(@NotNull final Player who, @Nullable final String quitMessage, @Nullable QuitReason quitReason) {
        super(who);
        this.reason = quitReason == null ? QuitReason.DISCONNECTED : quitReason;
        // Paper end
        this.quitMessage = quitMessage;
    }

    /**
     * Gets the quit message to send to all online players
     *
     * @return string quit message
     */
    @Nullable
    public String getQuitMessage() {
        return quitMessage;
    }

    /**
     * Sets the quit message to send to all online players
     *
     * @param quitMessage quit message
     */
    public void setQuitMessage(@Nullable String quitMessage) {
        this.quitMessage = quitMessage;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    // Paper start
    @NotNull
    public QuitReason getReason() {
        return this.reason;
    }

    public enum QuitReason {
        /**
         * The player left on their own behalf.
         * <p>
         * This does not mean they pressed the disconnect button in their client, but rather that the client severed the
         * connection themselves. This may occur if no keep-alive packet is received on their side, among other things.
         */
        DISCONNECTED,

        /**
         * The player was kicked from the server.
         */
        KICKED,

        /**
         * The player has timed out.
         */
        TIMED_OUT,

        /**
         * The player's connection has entered an erroneous state.
         * <p>
         * Reasons for this may include invalid packets, invalid data, and uncaught exceptions in the packet handler,
         * among others.
         */
        ERRONEOUS_STATE,
    }
    // Paper end
}
