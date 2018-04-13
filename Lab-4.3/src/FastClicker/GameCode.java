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
	private long timer;
	Labeled text;
	
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
    	primaryStage.setTitle("FASTEST CLICKER");
    	Button butt = new Button();
    	butt.setText("HOW FAST CAN YE CLICK?");
    	butt.setText("Click");
    	butt.setOnAction(new EventHandler<ActionEvent>() 
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
					butt.setText("CLICK ME REAL FAST NOW!");
				}
				else
				{
					butt.setText("Score: " + Integer.toString(scores));
					
				}
				
			}
        	
        }.start();
    }
        
        StackPane root = new StackPane();
        root.getChildren().add(butt);
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
        
    }
}
