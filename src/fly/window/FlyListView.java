package fly.window;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class FlyListView<T>
{
	private ListView<T> list;
	//private ObservableList<T> list_data;

	public FlyListView()
	{
		list = new ListView<T>();

	}


	/**
	 * 获取ListView
	 *
	 * @return 返回ListView
	 * */
	public ListView<T> GetListView(){return this.list;}




	/**
	 * 此方法可用于测试是否有任何选定的索引项。
	 *
	 * @return 如果没有选定项，则返回true；如果有，则返回false。
	 * */
	public boolean SelectionIsEmpty()
	{
		return list.getSelectionModel().isEmpty();
	}




	/**
	 * 获取选中项索引
	 * */
	public int GetSelectedIndex()
	{
		return this.list.getSelectionModel().getSelectedIndex();
	}



	/**
	 * 获取选中项索引
	 * */
	public ObservableList<Integer> GetSelectedIndexs()
	{
		return this.list.getSelectionModel().getSelectedIndices();
	}


	/**
	 * 获取选中项索引
	 * */
	public T GetSelectedItem()
	{
		return this.list.getSelectionModel().getSelectedItem();
	}



	/**
	 * 获取选中项索引
	 * */
	public ObservableList<T> GetSelectedItems()
	{
		return this.list.getSelectionModel().getSelectedItems();
	}





	/**
	 * 添加列表项
	 *
	 * @param item 要添加的项
	 *
	 * @return 返回列表项索引
	 * */
	public int AddItem(T item)
	{
		list.getItems().add(item);
		return list.getItems().size() - 1;
	}


	/**
	 * 添加多个列表项
	 *
	 * @param item 要添加的项
	 *
	 * @return 返回列表项索引
	 * */
	public int[] AddItems(T... item)
	{
		int[] index = new int[item.length];
		for(int i = 0;i < item.length;i++)
			index[i] = this.AddItem(item[i]);
		return index;
	}


	/**
	 * 移除单个列表项
	 *
	 * @param index 要移除的列表项的索引
	 * */
	public void RemoveItem(int index)
	{
		list.getItems().remove(index);
	}

	/**
	 * 移除所有列表项
	 *
	 * @param index 要移除的列表项的索引
	 * */
	public void RemoveAllItem()
	{
		list.getItems().removeAll();
	}

}






























