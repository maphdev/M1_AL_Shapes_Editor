package shape;

import java.util.ArrayList;
import java.util.List;

public class GroupShapes extends AShape {
	private List<IShape> _group;
	
	public GroupShapes() {
		super(new Point2DCartesian(1,1), 0, 0);
		_group = new ArrayList<IShape>();
	}
	
	public void add(IShape s) {
		_group.add(s);
	}
	
	public void remove(IShape s) {
		_group.remove(s);
	}
	
	public List<IShape> getGroupShapes(){
		return _group;
	}
	
	// methods
	@Override
	public GroupShapes clone() {
		return (GroupShapes) super.clone();
	}

	@Override
	public boolean equals(IShape shape) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return "to be implemented";
	}

	@Override
	public void updateRotationCenter() {
		// TO DO
	}
	
	// TO DO
}
