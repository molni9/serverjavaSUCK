package main.http;
import javax.sound.midi.Patch;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Handler extends Thread {


    private Socket socket;

    private  String derectory;

    Handler(Socket socket, String derectory) {


        this.socket = socket;
        this.derectory = derectory;

    }

    @Override
    public void run() {
        try(var input = this.socket.getInputStream(); var output = this.socket.getOutputStream()) {
            var url = this.getRequestUrl(input);
            var filePatch = Patch.of( this.derectory +url);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private String getRequestUrl(InputStream input){
        var reader = new Scanner(input).useDelimiter("\r\n");
        var Line = reader.next();
        return Line.split("")[1];
    }
}
