package fly.window;

import java.util.ArrayList;

import javafx.scene.control.TextField;


public class FlyTextFieldManager
{
private ArrayList<TextField> text_field;

	public FlyTextFieldManager(){text_field = new ArrayList<TextField>();}


	/**
	 * 获取文本编辑框
	 *
	 * @param index 要获取的文本编辑框的索引
	 *
	 * @return 返回文本编辑框
	 * */
	public TextField Get(int index) {return this.text_field.get(index);}


	/**
	 * 获取所有文本编辑框
	 *
	 * @return 返回所有文本编辑框
	 * */
	public TextField[] GetAll()
	{
		TextField[] field = new TextField[this.text_field.size()];
		for(int i = 0;i < this.text_field.size();i++)
			field[i] = this.text_field.get(i);

		return field;
	}



	/**
	 * 添加一个文本编辑框
	 *
	 * @return 返回文本编辑框的索引
	 * */
	public int AddTextField(){text_field.add(new TextField());return text_field.size() - 1;}

	/**
	 * 添加一个带文本的文本编辑框
	 *
	 * @param text 文本编辑框的文本
	 *
	 * @return 返回文本编辑框的索引
	 * */
	public int AddTextField(String text){text_field.add(new TextField(text));return text_field.size() - 1;}

	/**
	 * 添加 n 个文本编辑框
	 *
	 * @param n 要添加的文本编辑框的数量
	 *
	 * @return 返回文本编辑框的索引
	 * */
	public int[] AddTextFields(int n)
	{
		int[] index = new int[n];
		for(int i = 0;i < n;i++)
		{
			index[i] = text_field.size();
			text_field.add(new TextField());
		}

		return index;
	}

	/**
	 * 添加 n 个文本编辑框
	 *
	 * @param text 要添加的文本编辑框的文本
	 *
	 * @return 返回文本编辑框的索引
	 * */
	public int[] AddTextFields(String... text)
	{
		int[] index = new int[text.length];
		for(int i = 0;i < text.length;i++)
		{
			index[i] = text_field.size();
			text_field.add(new TextField(text[i]));
		}

		return index;
	}


	/**
	 * 添加一个带提示文本的文本编辑框
	 *
	 * @param text 文本编辑框的提示文本
	 *
	 * @return 返回文本编辑框的索引
	 * */
	public int AddTextFieldHavePromptText(String text)
	{
		text_field.add(new TextField());
		text_field.get(text_field.size() - 1).setPromptText(text);
		return text_field.size() - 1;
	}


	/**
	 * 添加 n 个带提示文本的文本编辑框
	 *
	 * @param text 要添加的文本编辑框的提示文本
	 *
	 * @return 返回文本编辑框的索引
	 * */
	public int[] AddTextFieldsHavePromptText(String... text)
	{
		int[] index = new int[text.length];
		for(int i = 0;i < text.length;i++)
		{
			index[i] = text_field.size();
			text_field.add(new TextField());
			text_field.get(index[i]).setPromptText(text[i]);
		}

		return index;
	}


	/**
	 * 设置文本编辑框文本
	 *
	 * @param text 要设置的文本
	 * @param index 要设置文本的文本编辑框的索引
	 * */
	public void SetText(String text,int index){text_field.get(index).setText(text);}

	/**
	 * 获取文本编辑框文本
	 *
	 * @param index 要获取的文本的文本编辑框的索引
	 * */
	public String GetText(int index){return text_field.get(index).getText();}


	/**
	 * 设置文本编辑框的提示文本
	 *
	 * @param text 提示文本
	 * @param index 要设置提示文本的文本编辑框的索引
	 * */
	public void SetPromptText(String text,int index)
	{
		this.text_field.get(index).setPromptText(text);
	}

	/**
	 * 设置多个文本编辑框的提示文本，从第一个开始
	 *
	 * @param text 提示文本
	 * @param index 要设置提示文本的文本编辑框的索引
	 * */
	public void SetPromptText(String... text)
	{
		for(int i = 0; i < text.length;i++)
			this.text_field.get(i).setPromptText(text[i]);
	}
}













