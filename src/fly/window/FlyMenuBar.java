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
	MenuBar menu_bar;
	ArrayList<Menu> menu;
	ArrayList<MenuItem> menu_item;
	ArrayList<SeparatorMenuItem> menu_item_separator;

	public FlyMenuBar()
	{
		menu_bar = new MenuBar();
		menu = new ArrayList<Menu>();
		menu_item = new ArrayList<MenuItem>();
		menu_item_separator = new ArrayList<SeparatorMenuItem>();
	}

	/**
	 *  ���һ���˵�
	 *
	 *  @param menu_text Ҫ��ӵĲ˵����ı�
	 *
	 *  @return ���ز˵�����
	 * */
	public int AddMenu()
	{
		menu.add(new Menu());
		menu_bar.getMenus().add(menu.get(menu.size() - 1));
		return menu.size() - 1;
	}

	/**
	 *  ���һ���˵�
	 *
	 *  @param menu_text Ҫ��ӵĲ˵����ı�
	 *
	 *  @return ���ز˵�����
	 * */
	public int AddMenu(String menu_text)
	{
		menu.add(new Menu(menu_text));
		menu_bar.getMenus().add(menu.get(menu.size() - 1));
		return menu.size() - 1;
	}


	/**
	 * ��Ӷ���˵�
	 *
	 * @param n Ҫ��ӵĲ˵�����
	 *
	 * @return ���ض���˵�������
	 * */
	public int[] AddMenus(int n)
	{
		int[] menu_index = new int[n];//�����˵�������

		for(int i = 0;i < n;i++)
			menu_index[i] = this.AddMenu();//���һ���˵�

		return menu_index;//���ظ����˵�����
	}

	/**
	 * ��Ӷ���˵�
	 *
	 * @param menu_text Ҫ��ӵĲ˵����ı�
	 *
	 * @return ���ض���˵�������
	 * */
	public int[] AddMenus(String... menu_text)
	{
		int[] menu_index = new int[menu_text.length];//�����˵�������

		for(int i = 0;i < menu_text.length;i++)
			menu_index[i] = this.AddMenu(menu_text[i]);//���һ���˵�

		return menu_index;//���ظ����˵�����
	}


	/**
	 * ���һ���˵���
	 *
	 * @param menu_index Ҫ��Ӳ˵���Ĳ˵�������
	 *
	 * @return ���ز˵�������
	 * */
	public int AddMenuItem(int menu_index)
	{
		menu_item.add(new MenuItem());//��Ӳ˵���
		menu.get(menu_index).getItems().add(menu_item.get(menu_item.size() - 1));//���˵���Ӳ˵���
		return menu_item.size() - 1;//���ز˵�������,�������ڲ˵������� -1
	}

	/**
	 * ���һ���˵���
	 *
	 * @param menu_index Ҫ��Ӳ˵���Ĳ˵�������
	 * @param menu_item_text Ҫ��ӵĲ˵�����ı�
	 *
	 * @return ���ز˵�������
	 * */
	public int AddMenuItem(int menu_index,String menu_item_text)
	{
		menu_item.add(new MenuItem(menu_item_text));//��Ӳ˵���
		menu.get(menu_index).getItems().add(menu_item.get(menu_item.size() - 1));//���˵���Ӳ˵���
		return menu_item.size() - 1;//���ز˵�������,�������ڲ˵������� -1
	}

	/**
	 * ��Ӷ���˵���
	 *
	 * @param menu_index Ҫ��Ӳ˵���Ĳ˵�������
	 * @param n Ҫ��ӵĲ˵��������
	 *
	 * @return ���ض���˵��������
	 * */
	public int[] AddMenuItems(int menu_index,int n)
	{
		int[] index = new int[n];//�����˵�������

		for(int i = 0;i < n;i++)
			index[i] = this.AddMenuItem(menu_index);//���һ���˵���

		return index;//���ظ����˵�������
	}

	/**
	 * ��Ӷ���˵���
	 *
	 * @param menu_index Ҫ��Ӳ˵���Ĳ˵�������
	 * @param menu_item_text Ҫ��ӵĲ˵���������ı�
	 *
	 * @return ���ض���˵��������
	 * */
	public int[] AddMenuItems(int menu_index,String... menu_item_text)
	{
		int[] index = new int[menu_item_text.length];//�����˵�������

		for(int i = 0;i < menu_item_text.length;i++)
			index[i] = this.AddMenuItem(menu_index,menu_item_text[i]);//���һ���˵���

		return index;//���ظ����˵�������
	}


	/**
	 * �Ƴ��˵�
	 *
	 * @param menu_index Ҫ�Ƴ��Ĳ˵�������
	 * */
	public void RemoveMenu(int menu_index)
	{
		menu_bar.getMenus().remove(menu_index);
		menu.remove(menu_index);
	}

	/**
	 * �˵�����ָ���
	 *
	 * @param menu_index Ҫ����ָ��ߵĲ˵�������
	 * @param separator_index �ָ�������
	 * */
	public void MenuInsertSeparator(int menu_index,int separator_index)
	{
		menu_item_separator.add(new SeparatorMenuItem());//����һ���µķָ��

		/*���ָ������˵�֮��*/
		menu.get(menu_index).getItems().add(separator_index,
		menu_item_separator.get(menu_item_separator.size() - 1));
	}



	/**
	 * �˵�������¼�
	 *
	 * @param menu_item_index Ҫ��ӵļ������Ĳ˵��������
	 * @param event Ҫ��ӵ��¼�
	 * */
	public void MenuItemAddEvent(int menu_item_index,EventHandler<ActionEvent> event)
	{
		menu_item.get(menu_item_index).setOnAction(event);
	}


	/**
	 * ��ȡ�˵���
	 *
	 * @return ���ز˵���
	 * */
	public MenuBar GetMenuBar(){return menu_bar;}

	/**
	 * ��ȡ�˵�
	 *
	 * @param menu_index Ҫ��ȡ�Ĳ˵�������
	 *
	 * @return ���ز˵�
	 * */
	public Menu GetMenu(int menu_index){return menu.get(menu_index);}

	/**
	 * ��ȡ�˵�
	 *
	 * @param menu_text Ҫ��ȡ�Ĳ˵��������ı�
	 *
	 * @return ���ز˵�
	 * */
	public Menu GetMenu(String menu_text)//���ص�һ���ҵ���
	{
		int index = 0;//�˵�����
		for(int i = 0;i < menu.size();i++)//�����˵��ı�
		{
			if(menu.get(i).getText() == menu_text)//���˵��ı���Ҫ�ҵ��ı�������ѭ��
			{
				index = i;//������¼
				break;//����ѭ��
			}
		}
		return menu.get(index);//���ز˵�
	}


	/**
	 * ��ȡ�˵���
	 *
	 * @param menu_item_index Ҫ��ȡ�Ĳ˵��������
	 *
	 * @return ���ز˵���
	 * */
	public MenuItem GetMenuItem(int menu_item_index){return menu_item.get(menu_item_index);}

	/**
	 * ��ȡ�˵���
	 *
	 * @param menu_item_index Ҫ��ȡ�Ĳ˵�����ı�
	 *
	 * @return ���ز˵���
	 * */
	public MenuItem GetMenuItem(String menu_item_text)//���ص�һ���ҵ���
	{
		int index = 0;//�˵�������
		for(int i = 0;i < menu_item.size();i++)//�����˵����ı�
		{
			if(menu_item.get(i).getText() == menu_item_text)//���˵����ı���Ҫ�ҵ��ı�������ѭ��
			{
				index = i;//������¼
				break;//����ѭ��
			}
		}
		return menu_item.get(index);//��������
	}


	/**
	 * ͨ���˵��ı��ҵ��˵�����
	 *
	 * @param ҪѰ�ҵĲ˵����ı�
	 *
	 * @return ���ز˵�����
	 * */
	public int GetMenuIndex(String menu_text)
	{
		int index = 0;//�˵�����
		for(int i = 0;i < menu.size();i++)//�����˵��ı�
		{
			if(menu.get(i).getText() == menu_text)//���˵��ı���Ҫ�ҵ��ı�������ѭ��
			{
				index = i;//������¼
				break;//����ѭ��
			}
		}
		return index;//���ز˵�
	}


	/**
	 * ͨ���˵����ı��ҵ��˵�����
	 *
	 * @param ҪѰ�ҵĲ˵�����ı�
	 *
	 * @return ���ز˵�������
	 * */
	public int GetMenuItemIndex(String menu_item_text)
	{
		int index = 0;//�˵�������
		for(int i = 0;i < menu_item.size();i++)//�����˵����ı�
		{
			if(menu_item.get(i).getText() == menu_item_text)//���˵����ı���Ҫ�ҵ��ı�������ѭ��
			{
				index = i;//������¼
				break;//����ѭ��
			}
		}
		return index;//��������
	}
}











