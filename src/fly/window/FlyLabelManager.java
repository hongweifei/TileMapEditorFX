package fly.window;

import java.util.ArrayList;

import javafx.scene.control.Label;

public class FlyLabelManager
{
	private ArrayList<Label> label;

	public FlyLabelManager()
	{
		label = new ArrayList<Label>();
	}


	/**
	 * 添加一个标签
	 *
	 * @return 返回标签索引
	 * */
	public int AddLabel(){label.add(new Label());return label.size() - 1;}

	/**
	 * 添加一个标签，需设置文本
	 *
	 * @return 返回标签索引
	 * */
	public int AddLabel(String text){label.add(new Label(text));return label.size() - 1;}


	/**
	 * 获取单个标签
	 *
	 * @param index 标签索引
	 *
	 * @return 返回标签
	 * */
	public Label GetLabel(int index){return label.get(index);}

	/**
	 * 获取所有标签
	 *
	 * @return 返回所有标签
	 * */
	public Label[] GetLabels()
	{
		Label[] labels = new Label[label.size()];
		for(int i = 0;i < label.size();i++)
			labels[i] = label.get(i);
		return labels;
	}


	/**
	 * 添加  n 个标签
	 *
	 * @return 返回  n 个标签索引
	 * */
	public int[] AddLabels(int n)
	{
		int[] index = new int[n];
		for(int i = 0;i < n;i++)
		{
			index[i] = label.size();
			label.add(new Label());
		}
		return index;
	}

	/**
	 * 添加  n 个带文本的标签
	 *
	 * @return 返回  n 个标签索引
	 * */
	public int[] AddLabels(String... text)
	{
		int[] index = new int[text.length];
		for(int i = 0;i < text.length;i++)
		{
			index[i] = label.size();
			label.add(new Label(text[i]));
		}
		return index;
	}

	/**
	 * 设置指定标签的文本
	 *
	 * @param text 要设置的文本
	 * @param index 标签索引
	 * */
	public void SetText(String text,int index){label.get(index).setText(text);}

	/**
	 * 获取指定标签的文本
	 *
	 * @param index 标签索引
	 *
	 * @return 返回标签文本
	 * */
	public String GetText(int index){return label.get(index).getText();}
}















