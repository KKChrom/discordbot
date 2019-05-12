package discordbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class testbot {

	public static void main(String[] args) {
		// Insert your bot's token here
		String token = "NTcyMTExNDI1ODQ2MjQ3NDU1.XMXiqg.yihHDPYgPwkEZ7-CiBvpe4mIir8";
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
		
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("?ping")) {
				event.getChannel().sendMessage("Pong!");
			}
		});
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("?rng")) {
				int random = (int) (Math.random() * 1000 + 1);
				event.getChannel().sendMessage(random + "");
			}
		});
		// Print the invite url of your bot
		System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
	}
}
