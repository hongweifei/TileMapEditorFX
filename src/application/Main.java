package application;

import fly.window.FlyMenuBar;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application
{
	static FlyMenuBar menu_bar = new FlyMenuBar();

	@Override public void start(Stage primaryStage)
	{
		try
		{
			BorderPane root = new BorderPane();

			menu_bar.AddMenus("�ļ�","��ͼ","��ͼ����");

			menu_bar.AddMenuItems(0, "�½�","��","����","���Ϊ","�ر�");
			menu_bar.AddMenuItems(1, "����ͼƬ(����·��)","����ͼƬ(���·��)","�Ƴ�ͼƬ");
			menu_bar.AddMenuItems(2,"���ƿ�ߵ���");

			menu_bar.MenuInsertSeparator(0, 2);
			menu_bar.MenuInsertSeparator(0, 5);
			menu_bar.MenuInsertSeparator(1, 2);

			root.setTop(menu_bar.GetMenuBar());

			Scene scene = new Scene(root,800,600);

			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e){e.printStackTrace();}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}



