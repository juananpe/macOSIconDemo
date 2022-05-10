package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);


    //this is new since JDK 9
    final Taskbar taskbar = Taskbar.getTaskbar();

    try {
      //set icon for mac os (and other systems which do support this method)
      taskbar.setIconImage( SwingFXUtils.fromFXImage(  new Image(HelloApplication.class.getResource("favicon.png").toExternalForm()) , null));
    } catch (final UnsupportedOperationException e) {
      System.out.println("The os does not support: 'taskbar.setIconImage'");
    } catch (final SecurityException e) {
      System.out.println("There was a security exception for: 'taskbar.setIconImage'");
    }

    stage.getIcons().add(new Image(HelloApplication.class.getResource("favicon.png").toExternalForm()));
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
