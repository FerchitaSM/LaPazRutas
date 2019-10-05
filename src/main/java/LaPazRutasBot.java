import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class LaPazRutasBot extends TelegramLongPollingBot {
    SendMessage message;

    public void onUpdateReceived(Update update) {
//        System.out.println(update.getMessage().getText()); // texto de prueba
//       System.out.println(update.getMessage().getFrom().getId()); // id para mantener la conversacion


        final String messageTextReceived = update.getMessage().getText(); // mesaje del usuario
        final long chatId = update.getMessage().getChatId(); // id del usuario
        message = new SendMessage().setChatId(chatId).setText(messageTextReceived); // se crea el sms con el mismo mensaje de usuario



        String command=update.getMessage().getText();

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


        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return "LaPazRutasBot";
    }

    public String getBotToken() {
        return "878308952:AAELkgmF0NkxPV7t7KvpQ3-JOWWVChLeMbg";
    }
}
