package shape;

import java.util.List;

import canvas.RenderShape;

import java.util.ArrayList;

public class GroupShapes extends AShape {
	
	public GroupShapes(List<IShape> group) {
		super(new Point2DCartesian(0,0), 0, 0);
		_max = new Point2DCartesian(group.get(0).getPosition().getX(), group.get(0).getPosition().getY());
		_min = new Point2DCartesian(group.get(0).getPosition().getX(), group.get(0).getPosition().getY());
		_group = group;
		updatePosition();
	}
	
	public void add(IShape s) {
		_group.add(s);
		updatePosition();
	}
	
	public void remove(IShape s) {
		_group.remove(s);
		updatePosition();
	}
	
	public List<IShape> getGroupShapes(){
		return _group;
	}
	
	public void draw(RenderShape render) {
		render.draw(this);
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
	
	private void updatePosition() {
		for(int i=0; i<_group.size(); ++i) {
			if(_group.get(i).getPosition().getX() < _min.getX()) {
				_min.setX(_group.get(i).getPosition().getX());
			}
			if(_group.get(i).getPosition().getX() > _max.getX()) {
				_max.setX(_group.get(i).getPosition().getX());
			}
			if(_group.get(i).getPosition().getY() < _min.getY()) {
				_min.setY(_group.get(i).getPosition().getY());
			}
			if(_group.get(i).getPosition().getY() > _max.getY()) {
				_max.setY(_group.get(i).getPosition().getY());
			}
		}
		IPoint2D position = new Point2DCartesian((_max.getX()+_min.getX())/2, (_max.getY()+_min.getY())/2);
		setPosition(position);
	}
	
	public String toString() {
		return "to be implemented";
	}
	
	// object members
	private List<IShape> _group;
	private IPoint2D _max;
	private IPoint2D _min;
	
	// TO DO
}
