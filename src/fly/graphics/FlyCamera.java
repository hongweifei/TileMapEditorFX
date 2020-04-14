package fly.graphics;

public class FlyCamera
{
	public double look_at_x;///<
	public double look_at_y;///<

	public FlyCamera(){this(0,0);}

	public FlyCamera(double look_at_x,double look_at_y)
	{this.look_at_x = look_at_x;this.look_at_y = look_at_y;}
}
