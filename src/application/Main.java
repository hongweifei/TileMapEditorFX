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

			menu_bar.AddMenus("文件","地图","地图绘制");

			menu_bar.AddMenuItems(0, "新建","打开","保存","另存为","关闭");
			menu_bar.AddMenuItems(1, "导入图片(绝对路径)","导入图片(相对路径)","移除图片");
			menu_bar.AddMenuItems(2,"绘制宽高调整");

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



