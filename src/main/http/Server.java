package main.http;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Handler;

public class Server {
    private int port;
    private String derectory;

    public Server (int port, String derectory){
this.port = port;
this.derectory = derectory;

    }
 void  start(){
  try (var server = new ServerSocket(this.port)){
      while (true){
          var socket = server.accept();
          var thread = new Handler(socket, this.derectory );
          thread.start()
      }
  } catch (IOException e){
      e.printStackTrace();
  }

 }


}