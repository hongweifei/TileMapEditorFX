package fly.graphics;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class FlyRenderer
{
	private GraphicsContext context;///< 上下文
	private double canvas_width = 0;
	private double canvas_height = 0;

	private Event<Object> render_event;

	public FlyRenderer(Canvas canvas)
	{
		this.context = canvas.getGraphicsContext2D();
		this.canvas_width = canvas.getWidth();
		this.canvas_height = canvas.getHeight();
	}


	/**
	 * 获取上下文
	 * */
	public GraphicsContext GetContext()
	{
		return this.context;
	}



	/**
	 * 设置上下文
	 * */
	public void SetContext(Canvas canvas)
	{
		this.context = canvas.getGraphicsContext2D();
	}


	/**
	 * 设置上下文
	 * */
	public void SetContext(GraphicsContext context)
	{
		this.context = context;
	}


	/**
	 * 释放上下文
	 * */
	public void ReleaseContext()
	{
		this.context = null;
	}


	/**
	 * 释放上下文，并设置上下文
	 * */
	public void ReleaseAndSetContext(Canvas canvas)
	{
		this.context = null;
		this.context = canvas.getGraphicsContext2D();
	}



	/**
	 * 释放上下文，并设置上下文
	 * */
	public void ReleaseAndSetContext(GraphicsContext context)
	{
		this.context = null;
		this.context = context;
	}



	/**
	 * 清空画布
	 * */
	public void Clear()
	{
		this.context.clearRect(0, 0, this.canvas_width, this.canvas_height);
	}


	/**
	 * 设置渲染事件
	 *
	 * @param render_event 要设置的渲染事件
	 * */
	public void SetRenderEvent(Event<Object> render_event){this.render_event = render_event;}

	/**
	 * 执行渲染事件，Event.invoke的object是graphics类型
	 *
	 * @param g
	 * */
	public void Render() {render_event.invoke(new Object());}


	/**
	 * 画线
	 * */
	public void DrawLine(){}

	/**
	 * 画空心矩形
	 *
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * @param width 绘制宽度
	 * @param height 绘制高度
	 * */
	public void DrawRect(double x,double y,double width,double height)
	{
		context.rect(x, y, width, height);
	}

	/**
	 * 画实心矩形
	 *
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * @param width 绘制宽度
	 * @param height 绘制高度
	 * */
	public void DrawFillRect(double x,double y,double width,double height)
	{
		context.fillRect(x, y, width, height);
	}

	/**
	 * 画实心文本
	 *
	 * @param text 要绘制的文本
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * */
	public void DrawText(String text,double x,double y)
	{
		context.fillText(text, x, y);
	}

	/**
	 * 画实心文本
	 *
	 * @param text 要绘制的文本
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * @param max_width 绘制的文本的最大宽度
	 * */
	public void DrawText(String text,double x,double y,double max_width)
	{
		context.fillText(text, x, y, max_width);
	}


	/**
	 * 画空心文本
	 *
	 * @param text 要绘制的文本
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * */
	public void DrawStrokeText(String text,double x,double y)
	{
		context.strokeText(text, x, y);
	}

	/**
	 * 画空心文本
	 *
	 * @param text 要绘制的文本
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * @param max_width 绘制的文本的最大宽度
	 * */
	public void DrawStrokeText(String text,double x,double y,double max_width)
	{
		context.strokeText(text, x, y, max_width);
	}


	/**
	 * 绘制图片，不可设置绘制宽高
	 *
	 * @param img 要绘制的图像,Use ImageView for displaying images loaded with this class.
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 *
	 * */
	public void DrawImage(Image img,double x,double y)
	{
		this.context.drawImage(img, x, y);
	}

	/**
	 * 绘制图片，可设置绘制宽高
	 *
	 * @param img 要绘制的图像,Use ImageView for displaying images loaded with this class.
	 * @param x 绘制横坐标
	 * @param y 绘制纵坐标
	 * @param width 绘制宽度
	 * @param height 绘制高度
	 *
	 * */
	public void DrawImage(Image img,double x,double y,double width,double height)
	{
		this.context.drawImage(img, x, y, width, height);
	}

	/**
	 * 绘制图片，可设置绘制宽高
	 *
	 * @param img 要绘制的图像,Use ImageView for displaying images loaded with this class.
	 * @param dx 目标矩形的x坐标。
	 * @param dy 目标矩形的y坐标。
	 * @param dw 目标矩形的宽度。
	 * @param dh 目标矩形的高度。
	 * @param sx 源矩形的x坐标。
	 * @param sy 源矩形的y坐标。
	 * @param sw 源矩形的宽度。
	 * @param sh 源矩形的高度。
	 *
	 * */
	public void DrawImage(Image img,double dx,double dy,double dw,double dh,
			double sx,double sy,double sw,double sh)
	{
		this.context.drawImage(img, sx, sy, sw, sh, dx, dy, dw, dh);
	}
}



















