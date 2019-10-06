import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class LaPazRutasBot extends TelegramLongPollingBot {
    SendMessage message;
    String respuesta;
    public void onUpdateReceived(Update update) {
//        System.out.println(update.getMessage().getText()); // texto de prueba
//       System.out.println(update.getMessage().getFrom().getId()); // id para mantener la conversacion


        final String messageTextReceived = update.getMessage().getText(); // mesaje del usuario
        final long chatId = update.getMessage().getChatId(); // id del usuario
        respuesta = "Hola "+update.getMessage().getFrom().getFirstName() +" en que puedo ayudarte \n" +
                "/1A Buscar la ruta de una linea especifica \n" +
                "/2A Buscar minibuses a mi destino \n";

        message = new SendMessage().setChatId(chatId).setText(respuesta);

        String command=update.getMessage().getText();

        if(command.equals("/1A")){
            respuesta = "Buscar la ruta de una linea especifica \n" +
                    "/1AA Mi teleferico \n" +
                    "/2AA PumaKatari \n" +
                    "/3AA Minibuses \n" +
                    "/4AA Buses \n";

        }

        if (command.equals("/2A")){

            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }

        if (command.equals("/myfullname")){
            System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
        }
        message.setText(respuesta);

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
