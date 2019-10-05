import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class LaPazRutasBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
//        System.out.println(update.getMessage().getText()); // texto de prueba
//        System.out.println(update.getMessage().getFrom().getId()); // id para mantener la conversacion

        String command=update.getMessage().getText();

        SendMessage message = new SendMessage();

        if(command.equals("/myname")){

            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }

        if (command.equals("/mylastname")){

            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        if (command.equals("/myfullname")){
            System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
        }

        message.setChatId(update.getMessage().getChatId());

    }

    public String getBotUsername() {
        return "LaPazRutasBot";
    }

    public String getBotToken() {
        return "878308952:AAELkgmF0NkxPV7t7KvpQ3-JOWWVChLeMbg";
    }
}
