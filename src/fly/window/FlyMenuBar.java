package fly.window;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class FlyMenuBar
{
	private MenuBar menu_bar;
	private ArrayList<Menu> menu;
	private ArrayList<MenuItem> menu_item;
	private ArrayList<SeparatorMenuItem> menu_item_separator;

	public FlyMenuBar()
	{
		menu_bar = new MenuBar();
		menu = new ArrayList<Menu>();
		menu_item = new ArrayList<MenuItem>();
		menu_item_separator = new ArrayList<SeparatorMenuItem>();
	}

	/**
	 *  添加一个菜单
	 *
	 *  @param menu_text 要添加的菜单的文本
	 *
	 *  @return 返回菜单索引
	 * */
	public int AddMenu()
	{
		menu.add(new Menu());
		menu_bar.getMenus().add(menu.get(menu.size() - 1));
		return menu.size() - 1;
	}

	/**
	 *  添加一个菜单
	 *
	 *  @param menu_text 要添加的菜单的文本
	 *
	 *  @return 返回菜单索引
	 * */
	public int AddMenu(String menu_text)
	{
		menu.add(new Menu(menu_text));
		menu_bar.getMenus().add(menu.get(menu.size() - 1));
		return menu.size() - 1;
	}


	/**
	 * 添加多个菜单
	 *
	 * @param n 要添加的菜单数量
	 *
	 * @return 返回多个菜单的索引
	 * */
	public int[] AddMenus(int n)
	{
		int[] menu_index = new int[n];//各个菜单的索引

		for(int i = 0;i < n;i++)
			menu_index[i] = this.AddMenu();//添加一个菜单

		return menu_index;//返回各个菜单索引
	}

	/**
	 * 添加多个菜单
	 *
	 * @param menu_text 要添加的菜单的文本
	 *
	 * @return 返回多个菜单的索引
	 * */
	public int[] AddMenus(String... menu_text)
	{
		int[] menu_index = new int[menu_text.length];//各个菜单的索引

		for(int i = 0;i < menu_text.length;i++)
			menu_index[i] = this.AddMenu(menu_text[i]);//添加一个菜单

		return menu_index;//返回各个菜单索引
	}


	/**
	 * 添加一个菜单项
	 *
	 * @param menu_index 要添加菜单项的菜单的索引
	 *
	 * @return 返回菜单项索引
	 * */
	public int AddMenuItem(int menu_index)
	{
		menu_item.add(new MenuItem());//添加菜单项
		menu.get(menu_index).getItems().add(menu_item.get(menu_item.size() - 1));//往菜单添加菜单项
		return menu_item.size() - 1;//返回菜单项索引,索引等于菜单项数量 -1
	}

	/**
	 * 添加一个菜单项
	 *
	 * @param menu_index 要添加菜单项的菜单的索引
	 * @param menu_item_text 要添加的菜单项的文本
	 *
	 * @return 返回菜单项索引
	 * */
	public int AddMenuItem(int menu_index,String menu_item_text)
	{
		menu_item.add(new MenuItem(menu_item_text));//添加菜单项
		menu.get(menu_index).getItems().add(menu_item.get(menu_item.size() - 1));//往菜单添加菜单项
		return menu_item.size() - 1;//返回菜单项索引,索引等于菜单项数量 -1
	}

	/**
	 * 添加多个菜单项
	 *
	 * @param menu_index 要添加菜单项的菜单的索引
	 * @param n 要添加的菜单项的数量
	 *
	 * @return 返回多个菜单项的索引
	 * */
	public int[] AddMenuItems(int menu_index,int n)
	{
		int[] index = new int[n];//各个菜单的索引

		for(int i = 0;i < n;i++)
			index[i] = this.AddMenuItem(menu_index);//添加一个菜单项

		return index;//返回各个菜单项索引
	}

	/**
	 * 添加多个菜单项
	 *
	 * @param menu_index 要添加菜单项的菜单的索引
	 * @param menu_item_text 要添加的菜单项的数量文本
	 *
	 * @return 返回多个菜单项的索引
	 * */
	public int[] AddMenuItems(int menu_index,String... menu_item_text)
	{
		int[] index = new int[menu_item_text.length];//各个菜单的索引

		for(int i = 0;i < menu_item_text.length;i++)
			index[i] = this.AddMenuItem(menu_index,menu_item_text[i]);//添加一个菜单项

		return index;//返回各个菜单项索引
	}


	/**
	 * 移除菜单
	 *
	 * @param menu_index 要移除的菜单的索引
	 * */
	public void RemoveMenu(int menu_index)
	{
		menu_bar.getMenus().remove(menu_index);
		menu.remove(menu_index);
	}

	/**
	 * 菜单插入分割线
	 *
	 * @param menu_index 要插入分割线的菜单的索引
	 * @param separator_index 分割线索引
	 * */
	public void MenuInsertSeparator(int menu_index,int separator_index)
	{
		menu_item_separator.add(new SeparatorMenuItem());//创建一个新的分割符

		/*将分割符插入菜单之中*/
		menu.get(menu_index).getItems().add(separator_index,
		menu_item_separator.get(menu_item_separator.size() - 1));
	}



	/**
	 * 菜单项添加事件
	 *
	 * @param menu_item_index 要添加的监听器的菜单项的索引
	 * @param event 要添加的事件
	 * */
	public void MenuItemAddEvent(int menu_item_index,EventHandler<ActionEvent> event)
	{
		menu_item.get(menu_item_index).setOnAction(event);
	}


	/**
	 * 获取菜单栏
	 *
	 * @return 返回菜单栏
	 * */
	public MenuBar GetMenuBar(){return menu_bar;}

	/**
	 * 获取菜单
	 *
	 * @param menu_index 要获取的菜单的索引
	 *
	 * @return 返回菜单
	 * */
	public Menu GetMenu(int menu_index){return menu.get(menu_index);}

	/**
	 * 获取菜单
	 *
	 * @param menu_text 要获取的菜单的索引文本
	 *
	 * @return 返回菜单
	 * */
	public Menu GetMenu(String menu_text)//返回第一个找到的
	{
		int index = 0;//菜单索引
		for(int i = 0;i < menu.size();i++)//遍历菜单文本
		{
			if(menu.get(i).getText() == menu_text)//若菜单文本是要找的文本，结束循环
			{
				index = i;//索引记录
				break;//结束循环
			}
		}
		return menu.get(index);//返回菜单
	}


	/**
	 * 获取菜单项
	 *
	 * @param menu_item_index 要获取的菜单项的索引
	 *
	 * @return 返回菜单项
	 * */
	public MenuItem GetMenuItem(int menu_item_index){return menu_item.get(menu_item_index);}

	/**
	 * 获取菜单项
	 *
	 * @param menu_item_index 要获取的菜单项的文本
	 *
	 * @return 返回菜单项
	 * */
	public MenuItem GetMenuItem(String menu_item_text)//返回第一个找到的
	{
		int index = 0;//菜单项索引
		for(int i = 0;i < menu_item.size();i++)//遍历菜单项文本
		{
			if(menu_item.get(i).getText() == menu_item_text)//若菜单项文本是要找的文本，结束循环
			{
				index = i;//索引记录
				break;//结束循环
			}
		}
		return menu_item.get(index);//返回索引
	}


	/**
	 * 通过菜单文本找到菜单索引
	 *
	 * @param 要寻找的菜单的文本
	 *
	 * @return 返回菜单索引
	 * */
	public int GetMenuIndex(String menu_text)
	{
		int index = 0;//菜单索引
		for(int i = 0;i < menu.size();i++)//遍历菜单文本
		{
			if(menu.get(i).getText() == menu_text)//若菜单文本是要找的文本，结束循环
			{
				index = i;//索引记录
				break;//结束循环
			}
		}
		return index;//返回菜单
	}


	/**
	 * 通过菜单项文本找到菜单索引
	 *
	 * @param 要寻找的菜单项的文本
	 *
	 * @return 返回菜单项索引
	 * */
	public int GetMenuItemIndex(String menu_item_text)
	{
		int index = 0;//菜单项索引
		for(int i = 0;i < menu_item.size();i++)//遍历菜单项文本
		{
			if(menu_item.get(i).getText() == menu_item_text)//若菜单项文本是要找的文本，结束循环
			{
				index = i;//索引记录
				break;//结束循环
			}
		}
		return index;//返回索引
	}
}











