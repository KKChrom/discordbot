package discordbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class testbot {

	public static void main(String[] args) {
		// Insert your bot's token here
		String token = "NTcyMTExNDI1ODQ2MjQ3NDU1.XMXiqg.yihHDPYgPwkEZ7-CiBvpe4mIir8";

		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

		// Add a listener which answers with "Pong!" if someone writes "!ping"
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("!ping")) {
				event.getChannel().sendMessage("Pong!");

			}

		});
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("!random")) {
				int random = (int) (Math.random() * 1000 + 1);
				event.getChannel().sendMessage(random + "");

			}
		});
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("!clear")) {
				event.getChannel().bulkDelete("!random");

			}
		});
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("!sandwich")) {
				event.getChannel().sendMessage("Show your sandwich.(bread*item*bread)");
				String s = null;
				s.equals(event.getMessageContent().toLowerCase());
				String y = s.substring(s.indexOf("bread"), s.length() - 4);
				event.getChannel().sendMessage(y);
			}

		});

		// Print the invite url of your bot
		System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
	}
}
