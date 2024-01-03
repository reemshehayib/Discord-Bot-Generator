import botstuff.MessageResponse;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String arg[]) throws LoginException {
        String token = "OTA0ODQ4MTg0MjQ3OTg0MTI4.YYBfig.epKK_UlpaNUZuTOReI4GNdDK7Pk";
        JDA bot = JDABuilder.createDefault(token).setActivity(Activity.competing("Welcome to the class"))
                .setStatus(OnlineStatus.ONLINE).addEventListeners(new MessageResponse()).build();

    }

}
