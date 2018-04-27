package shape;

import java.util.List;

import render.RenderShape;

import java.util.ArrayList;

public class GroupShapes extends AShape {
	
	public GroupShapes(List<IShape> group) {
		super(group.get(0).getPosition(), 0, 0);
		_group = group;
	}
	
	public List<IShape> getGroupShapes(){
		return _group;
	}
	
	public void draw(RenderShape render) {
		render.draw(this);
	}
	
	public void setPosition(IPoint2D p) {
		double t_x = p.getX()-getPosition().getX();
		double t_y = p.getY()-getPosition().getY();
		super.setPosition(p);
		for(IShape shape : _group)
			shape.translate(t_x, t_y );
	}
	
	public void setPosition(double posX, double posY) {
		setPosition(new Point2DCartesian(posX, posY));
	}
	
	public void rotate(double posX, double posY, double degree) {
		rotate(new Point2DCartesian(posX, posY), degree);
	}
	
	public void rotate(IPoint2D p, double degree) {
		super.rotate(p, degree);
		for(IShape shape : _group) {
			shape.rotate(p, degree);
		}
	}
	
	public void translate(double posX, double posY) {
		super.translate(posX, posY);
		for(IShape shape : _group) {
			shape.translate(posX, posY);
		}
	}
	
	public boolean belongsTo(double posX, double posY) {
		for(IShape shape : _group) {
			if(shape.belongsTo(posX, posY)) {
				return true;
			}
		}
		return false;
	}
	
	// methods
	@Override
	public GroupShapes clone() {
		GroupShapes gs = (GroupShapes) super.clone();
		List<IShape> newGroup = new ArrayList<IShape>();
		for(int i=0; i<_group.size(); ++i) {
			newGroup.add(_group.get(i).clone());
		}
		gs._group = newGroup;
		return gs;
	}
	
	@Override
	public boolean equals(IShape shape) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return _group.toString();
	}
	
	// object members
	private List<IShape> _group;
	
	// TO DO
}
