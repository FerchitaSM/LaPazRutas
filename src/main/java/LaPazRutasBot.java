import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.net.MalformedURLException;
import java.net.URL;

public class LaPazRutasBot extends TelegramLongPollingBot {
    SendMessage message;
    String respuesta;
    URL url;

    {
        try {
            url = new URL("https://urgente.bo/sites/default/files/Ruta%20San%20Pedro-%20Achumani%201.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

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
        if(command.equals("/2AA")){
            respuesta = "Buscar la ruta de una linea especifica \nPumakatari \n" +
                    "/1p Inca Llojeta \n" +
                    "/2p Villa Salome \n" +
                    "/3p Chasquipampa \n" +
                    "/4p Caja Ferroviaria \n"+
                    "/5p Integradora \n" +
                    "/6p Irpavi 2 \n" +
                    "/7p Achumani \n";

        }

        if(command.equals("/7p")){
            respuesta = url+"\n"+
                    " Esta es la ruta de Achumani-San Pedro (La imagen esta abajo)\n"+
                    " Ahora en que puedo ayudarte \n" +
                    "/1A Buscar la ruta de una linea especifica \n" +
                    "/2A Buscar minibuses a mi destino \n"+
                    "/Nada ";

        }

        if (command.equals("/2A")){

            respuesta = "Envia tu Ubacion actual : \n" +
                    "/1 Aceptar \n" +
                    "/2 Denegar \n";

        }
        if (command.equals("/1")){

            respuesta = "Lo sentimos aun no tenemos la opcion disponible";

        }

        if (command.equals("/myfullname")){
            System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
        }
        if(command.equals("/Nada")){
            respuesta = " Fue un gusto ayudarte.";

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
