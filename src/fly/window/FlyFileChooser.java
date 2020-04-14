package fly.window;


import java.io.File;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.Window;

public class FlyFileChooser
{
	private FileChooser file_chooser;
	private FileChooser.ExtensionFilter file_filter;

	public FlyFileChooser()
	{
		file_chooser = new FileChooser();
	}

	/**
	 * 设置文本选择器标题
	 *
	 * @param title 要设置的标题
	 * */
	public void SetTitle(String title)
	{
		this.file_chooser.setTitle(title);
	}

	/**
	 * 弹出可多选文件的“打开文件”文件选择器对话框。
	 *
	 * @return 返回选择的文件
	 * */
	public List<File> ShowOpenMultipleDialog()
	{
		return this.file_chooser.showOpenMultipleDialog(null);
	}

	/**
	 * 弹出“打开文件”文件选择器对话框
	 *
	 * @return 返回选择的文件
	 * */
	public File ShowOpenDialog()
	{
		return this.file_chooser.showOpenDialog(null);
	}

	/**
	 * 弹出“保存文件”文件选择器对话框
	 *
	 * @return 返回选择的文件
	 * */
	public File ShowSaveDialog()
	{
		return this.file_chooser.showSaveDialog(null);
	}



	/**
	 * 弹出可多选文件的“打开文件”文件选择器对话框。
	 *
	 * @param window 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 *
	 * @return 返回选择的文件
	 * */
	public List<File> ShowDialog(Window window)
	{
		return this.file_chooser.showOpenMultipleDialog(window);
	}

	/**
	 * 弹出可多选文件的“打开文件”文件选择器对话框。
	 *
	 * @param window 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 * @param title
	 *
	 * @return 返回选择的文件
	 * */
	public List<File> ShowDialog(Window window,String title)
	{
		this.file_chooser.setTitle(title);
		return this.file_chooser.showOpenMultipleDialog(window);
	}

	/**
	 * 弹出“打开文件”文件选择器对话框
	 *
	 * @param window 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 *
	 * @return 返回选择的文件
	 * */
	public File ShowOpenDialog(Window window)
	{
		return this.file_chooser.showOpenDialog(window);
	}

	/**
	 * 弹出“保存文件”文件选择器对话框
	 *
	 * @param window 打开对话框所依赖的框架和放置对话框时应考虑其外观位置的组件。
	 *
	 * @return 返回选择的文件
	 * */
	public File ShowSaveDialog(Window window)
	{
		return this.file_chooser.showSaveDialog(window);
	}

	/**
	 * 设置过滤器,支持文件的格式 *.*
	 *
	 * @param file_filter 要设置的过滤器
	 * */
	public void SetFileFilter(FileChooser.ExtensionFilter file_filter)
	{
		this.file_filter = file_filter;
		file_chooser.getExtensionFilters().add(file_filter);
	}

	/**
	 * 设置过滤器,支持文件的格式 *.*
	 *
	 * @param description textual description for the filter, may be null
	 * @param extensions accepted file name extensions
	 * */
	public void SetFileFilter(String description, String... extensions)
	{
		file_filter = new FileChooser.ExtensionFilter(description,extensions);
		file_chooser.getExtensionFilters().add(file_filter);
	}
}








