/*-
 * LICENSE
 * DiscordSRV
 * -------------
 * Copyright (C) 2016 - 2021 Austin "Scarsz" Shapiro
 * -------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * END
 */

package github.scarsz.discordsrv.api.events;

import github.scarsz.discordsrv.api.Cancellable;
import lombok.Getter;
import lombok.Setter;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * <p>Called after {@link DiscordGuildMessageReceivedEvent} when the message was validated as coming from a linked channel</p>
 * <p>Guaranteed to be from a linked {@link GuildMessageChannel}</p>
 */
public class DiscordGuildMessagePreProcessEvent extends DiscordEvent<MessageReceivedEvent> implements Cancellable {

    @Getter @Setter private boolean cancelled;

    @Getter private final User author;
    @Getter private final GuildMessageChannel channel;
    @Getter private final Guild guild;
    @Getter private final Member member;
    @Getter private final Message message;

    public DiscordGuildMessagePreProcessEvent(MessageReceivedEvent jdaEvent) {
        super(jdaEvent.getJDA(), jdaEvent);
        this.author = jdaEvent.getAuthor();
        this.channel = (GuildMessageChannel) jdaEvent.getChannel();
        this.guild = jdaEvent.getGuild();
        this.member = jdaEvent.getMember();
        this.message = jdaEvent.getMessage();
    }

}
