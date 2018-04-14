package FastClicker;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameCode extends Application 
{
	private boolean scoring;
	private int scores;
	private Long timer;
	Labeled txt;
	
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Click");
        Button btn = new Button();
        btn.setText("Click");
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
               if(!scoring)
               {
            	   scores++;
               }
            }
        });
        
        timer = System.nanoTime() + 10000000000L;
        new AnimationTimer()
        {
			@Override
			public void handle(long now) 
			{
				if(now > timer)
				{
					timer = now + 10000000000L;
					scoring = !scoring;
				}
				if(!scoring)
				{
					btn.setText("Click Me!");
				}
				else
				{
					btn.setText("Score: " + Integer.toString(scores));
					
				}
				
			}
        	
        }.start();

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
