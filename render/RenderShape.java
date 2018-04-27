package render;

import shape.GroupShapes;

public interface RenderShape {
	
	public void draw(GroupShapes shape);
	public void draw(shape.Polygon shape);
	public void draw(shape.Rectangle shape);
	public void draw(shape.Circle shape);
	

}
