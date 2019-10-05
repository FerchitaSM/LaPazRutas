import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class LaPazRutasBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        final String TextReceived = update.getMessage().getText(); // texto del usuario
        final long chatId = update.getMessage().getChatId(); // id del usuario

        SendMessage message = new SendMessage().setChatId(chatId).setText(TextReceived); // Crear mensaje para enviar
        try {
            execute(message); //Envio del mensaje
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
