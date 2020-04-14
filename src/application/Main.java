package application;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import fly.graphics.FlyCamera;
import fly.graphics.FlyRenderer;
import fly.graphics.FlyTileMap;
import fly.window.FlyFileChooser;
import fly.window.FlyListView;
import fly.window.FlyMenuBar;
import fly.window.FlyTextFieldManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application
{
	static FlyTileMap map = null;
	static String tile_map_path = null;

	static FlyCamera map_camera = new FlyCamera();
	static double mouse_last_x = 0;
	static double mouse_last_y = 0;

	static int map_render_width = 16;
	static int map_render_height = 16;

	static Canvas canvas;
	static FlyRenderer renderer;

	static FlyMenuBar menu_bar = new FlyMenuBar();

	static FlyTextFieldManager text_field = new FlyTextFieldManager();

	@Override public void start(Stage primaryStage)
	{
		try
		{
			BorderPane root = new BorderPane();

			menu_bar.AddMenus("文件","地图","地图绘制");

			menu_bar.AddMenuItems(0, "新建","打开","保存","另存为","关闭");
			menu_bar.AddMenuItems(1, "导入图片(绝对路径)","导入图片(相对路径)","移除图片");
			menu_bar.AddMenuItems(2, "绘制宽高调整");

			menu_bar.MenuInsertSeparator(0, 2);
			menu_bar.MenuInsertSeparator(0, 5);
			menu_bar.MenuInsertSeparator(1, 2);

			text_field.AddTextFieldsHavePromptText("地图宽度","地图高度","瓦片宽度","瓦片高度");

			canvas = new Canvas(800,600);
			renderer = new FlyRenderer(canvas);

			/*新建地图*/
			menu_bar.MenuItemAddEvent(menu_bar.GetMenuItemIndex("新建"),
			new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent arg0)
				{
					FlyFileChooser chooser = new FlyFileChooser();
					chooser.SetFileFilter("地图文件", "*.map");

					File file = null;
					if((file = chooser.ShowSaveDialog()) != null)
					{
						tile_map_path = file.getPath();
						System.out.println("地图路径：" + tile_map_path);

						VBox box = new VBox();
						box.getChildren().addAll(text_field.GetAll());
						box.setSpacing(10);//设置控件间隔

						DialogPane pane = new DialogPane();
						pane.setContent(box);

						ButtonType create_button = new ButtonType("创建",ButtonData.OK_DONE);
						pane.getButtonTypes().add(create_button);

						Dialog<ButtonType> dialog = new Dialog<ButtonType>();
						dialog.setDialogPane(pane);

						dialog.setTitle("创建地图");

						Optional<ButtonType> result = dialog.showAndWait();
						if(result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE)
						{
							if(!text_field.GetText(0).isEmpty() && !text_field.GetText(1).isEmpty()
								&& !text_field.GetText(2).isEmpty() && !text_field.GetText(3).isEmpty())
							{
								int width = Integer.parseInt(text_field.GetText(0));
								int height = Integer.parseInt(text_field.GetText(1));
								int tile_width = Integer.parseInt(text_field.GetText(2));
								int tile_height = Integer.parseInt(text_field.GetText(3));

								map = new FlyTileMap(width,height,tile_width,tile_height,null,null);

								try {FlyTileMap.WriteMap(tile_map_path, map);}
								catch (IOException e) {e.printStackTrace();}
							}
							else
							{
								Alert error = new Alert(Alert.AlertType.ERROR);
								error.setHeaderText("错误");
								error.setContentText("有空的参数");
								error.show();

								error = null;
							}
						}

						box = null;
						pane = null;
						create_button = null;
						dialog = null;

						result = null;
					}

					chooser = null;
				}
			});

			/*打开地图*/
			menu_bar.MenuItemAddEvent(menu_bar.GetMenuItemIndex("打开"),
			new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent arg0)
				{
					FlyFileChooser chooser = new FlyFileChooser();
					chooser.SetFileFilter("地图文件", "*.map");

					File file = null;
					if((file = chooser.ShowOpenDialog()) != null)
					{
						tile_map_path = file.getPath();
						System.out.println("地图路径：" + tile_map_path);

						try {map = FlyTileMap.ReadMap(tile_map_path);}
						catch (IOException e){e.printStackTrace();}

						try
						{
							map.Render(renderer,
									map_camera.look_at_x,map_camera.look_at_y,
										map_render_width, map_render_height);
						}
						catch (IOException e) {e.printStackTrace();}

						chooser = null;
					}
				}
			});

			/*保存地图*/
			menu_bar.MenuItemAddEvent(menu_bar.GetMenuItemIndex("保存"),
			new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent arg0)
				{
					if(map != null && tile_map_path != null)
					{
						try {FlyTileMap.WriteMap(tile_map_path, map);}
						catch (IOException e1){e1.printStackTrace();}
					}
					else
					{
						Alert information = new Alert(Alert.AlertType.INFORMATION);
						information.setHeaderText("提示：");
						information.setContentText("未有打开地图");
						information.show();

						information = null;
					}
				}
			});

			/*关闭程序*/
			menu_bar.MenuItemAddEvent(menu_bar.GetMenuItemIndex("关闭"),
			new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent arg0)
				{
					System.exit(0);
				}
			});


			/*导入图片(绝对路径)*/
			menu_bar.MenuItemAddEvent(menu_bar.GetMenuItemIndex("导入图片(绝对路径)"),
			new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent arg0)
				{
					if(map == null)
					{
						Alert information = new Alert(Alert.AlertType.INFORMATION);
						information.setHeaderText("提示");
						information.setContentText("未有打开地图");
						information.show();

						information = null;

						return;
					}

					FlyFileChooser chooser = new FlyFileChooser();
					chooser.SetFileFilter("图片文件", "*.png","*.bmp","*.jpg","*.jpeg");

					File file = null;
					if((file = chooser.ShowOpenDialog()) != null && map != null)
						map.AddImage(file.getPath());

					chooser = null;
				}
			});


			/*导入图片(相对路径)*/
			menu_bar.MenuItemAddEvent(menu_bar.GetMenuItemIndex("导入图片(相对路径)"),
			new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent arg0)
				{
					if(map == null)
					{
						Alert information = new Alert(Alert.AlertType.INFORMATION);
						information.setHeaderText("提示");
						information.setContentText("未有打开地图");
						information.show();

						information = null;

						return;
					}

					TextInputDialog input = new TextInputDialog();
					input.setTitle("导入图片(相对路径)");
					input.setContentText("请输入图片的相对路径");

					Optional<String> result = input.showAndWait();
					if(!result.toString().isEmpty() && map != null)
						map.AddImage(result.toString());

					result = null;
					input = null;
				}
			});


			/*移除图片*/
			menu_bar.MenuItemAddEvent(menu_bar.GetMenuItemIndex("移除图片"),
			new EventHandler<ActionEvent>()
			{
				@Override public void handle(ActionEvent arg0)
				{
					if(map != null)
					{
						FlyListView<String> list = new FlyListView<String>();

						for(int i = 0;i < map.tile_count;i++)
							list.AddItem(map.tile_image_path[i]);

						VBox box = new VBox();
						box.getChildren().add(list.GetListView());
						box.setSpacing(10);//设置控件间隔

						DialogPane pane = new DialogPane();
						pane.setContent(box);

						ButtonType create_button = new ButtonType("移除",ButtonData.OK_DONE);
						pane.getButtonTypes().add(create_button);

						Dialog<ButtonType> dialog = new Dialog<ButtonType>();
						dialog.setDialogPane(pane);

						dialog.setTitle("移除图片");

						Optional<ButtonType> result = dialog.showAndWait();
						if(result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE)
						{
							if(!list.SelectionIsEmpty() && map != null)
							{
								map.RemoveImage(list.GetSelectedIndex());
							}
						}

						list = null;

						box = null;
						pane = null;
						create_button = null;
						dialog = null;

						result = null;
					}
					else
					{
						Alert information = new Alert(Alert.AlertType.INFORMATION);
						information.setHeaderText("提示");
						information.setContentText("未有打开地图");
						information.show();

						information = null;
					}
				}
			});


			/*绘制宽高调整*/
			menu_bar.MenuItemAddEvent(menu_bar.GetMenuItemIndex("绘制宽高调整"),
			new EventHandler<ActionEvent>(){
				@Override public void handle(ActionEvent event)
				{
					FlyTextFieldManager field = new FlyTextFieldManager();
					field.AddTextFields(String.valueOf(map_render_width),
							String.valueOf(map_render_height));

					field.SetPromptText("绘制宽度","绘制高度");

					HBox box = new HBox();
					box.getChildren().addAll(field.GetAll());
					box.setSpacing(10);//设置控件间隔

					DialogPane pane = new DialogPane();
					pane.setContent(box);

					ButtonType create_button = new ButtonType("确定",ButtonData.OK_DONE);
					pane.getButtonTypes().add(create_button);

					Dialog<ButtonType> dialog = new Dialog<ButtonType>();
					dialog.setDialogPane(pane);

					dialog.setTitle("调整绘制宽高");

					Optional<ButtonType> result = dialog.showAndWait();
					if(result.isPresent() && result.get().getButtonData() == ButtonData.OK_DONE)
					{
						if(!field.GetText(0).isEmpty() && !field.GetText(1).isEmpty())
						{
							map_render_width = Integer.parseInt(field.GetText(0));
							map_render_height = Integer.parseInt(field.GetText(1));
						}
						else
						{
							Alert information = new Alert(Alert.AlertType.ERROR);
							information.setHeaderText("错误");
							information.setContentText("有参数为空");
							information.show();

							information = null;
						}
					}
				}
			});



			/*鼠标移动*/
			canvas.setOnMouseMoved(new EventHandler<MouseEvent>(){
				@Override public void handle(MouseEvent event)
				{
					mouse_last_x = event.getX();
					mouse_last_y = event.getY();
				}
			});

			/*鼠标拖拽*/
			canvas.setOnMouseDragged(new EventHandler<MouseEvent>(){
				@Override public void handle(MouseEvent event)
				{
					if(event.getButton() == MouseButton.MIDDLE && map != null)
					{
						double dx = event.getX() - mouse_last_x;
						double dy = event.getY() - mouse_last_y;

						map_camera.look_at_x += dx;
						map_camera.look_at_y += dy;

						mouse_last_x = event.getX();
						mouse_last_y = event.getY();


						try
						{
							map.Render(renderer,map_camera.look_at_x,map_camera.look_at_y,
								map_render_width, map_render_height);

						}
						catch (IOException e){e.printStackTrace();}

					}

				}
			});

			root.setTop(menu_bar.GetMenuBar());
			root.setCenter(canvas);

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












