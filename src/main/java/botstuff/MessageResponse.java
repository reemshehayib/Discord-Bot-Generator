package botstuff;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MessageResponse extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        Message message = event.getMessage();
        String content = message.getContentRaw();
        MessageChannel channel = event.getChannel();

        if (content.equals("~echo"))
        {
            channel.sendMessage("Don't worry about the grade").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
            return;
        }
        String size_5 = content.substring(0,5);
        if(size_5.equals("~hsay")){

            channel.sendMessage(content.substring(6)).queue();
            channel.deleteMessageById(event.getMessageId()).queue();
            return;
        }
        String size_4 = content.substring(0,4);
        if(size_4.equals("~say")){

            String name = event.getAuthor().getName();
            channel.sendMessage(name + " says: " + content.substring(5)).queue();
            channel.deleteMessageById(event.getMessageId()).queue();
            return;
        }

        if(content.equals("~PANIC")){
            String name = event.getAuthor().getName();
            channel.sendMessage(name + ", remember to chill and relax. Just do your best").queue();
            return;
        }

        if(content.equals("~help")){
            String path = "C:\\Users\\fouad\\Desktop\\Bot idea.txt";
            //we did this because there is two types of exceptions mixing up
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                String line = br.readLine();
                StringBuilder sb = new StringBuilder();
                sb.append("``` ");
                while(line!=null){
                    sb.append(line + "\n");
                    line = br.readLine();
                }
                sb.append("```");
                channel.sendMessage(sb).queue();
                br.close();
            }catch (IOException error){
            }
            return;
        }

        if(content.equals("~motivate")){
            int rnd = (int)(Math.random()*10);
            String path = "C:\\Users\\fouad\\Desktop\\motivate.txt";
            try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            for(; rnd>=0 ; rnd--){
                line = br.readLine();
            }
            channel.sendMessage(line).queue();
            br.close();
            }catch (IOException error){

            }
            return;
        }
        if(content.equals("~DSExam")){

            String path = "C:\\Users\\fouad\\Desktop\\DS_Exam_Instructions.txt";
            try{
                BufferedReader br = new BufferedReader(new FileReader(path));
                String line = br.readLine();
                StringBuilder sb = new StringBuilder();
                sb.append("``` ");
                while(line!=null){
                    sb.append(line + "\n");
                    line = br.readLine();
                }
                sb.append("```");
                channel.sendMessage(sb).queue();
                br.close();
            }catch (IOException error){

            }
            return;
        }
        if(content.equals("~shutdown")){
            channel.sendMessage("See you next week!").queue();

            event.getJDA().shutdown();
        }
        if(content.substring(0,1).equals("~")){
            channel.sendMessage("No command recognized, check '~help' for list of commands").queue();
        }
    }
}
