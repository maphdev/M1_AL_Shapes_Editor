package bar;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BarMenuFx extends BarMenuAbstract implements BarMenu{
	
	private List<BarMenuButtonFx> _buttons;
	
	private Group _root;
	private Rectangle _zone;
	
	public BarMenuFx(Group root) {
		super();
		_root = root;
		_width = _root.getScene().getWidth()-2*(_marge+_stroke/2);
		_height = 60-2*(_marge+_stroke/2);
		_zone = new Rectangle();
		_zone.setX(_posX);
		_zone.setY(_posY);
		_zone.setWidth(_width);
		_zone.setHeight(_height);
		_zone.setFill(Color.WHITE);
		_zone.setStroke(Color.BLACK);
		_zone.setStrokeWidth(_stroke);
        _root.getChildren().add(_zone);
        
        _buttons = new ArrayList<BarMenuButtonFx> ();
        addButton(new BarMenuButtonFx(0,0,0));
        addButton(new BarMenuButtonFx(0,0,0));
        addButton(new BarMenuButtonFx(0,0,0));
        addButton(new BarMenuButtonFx(0,0,0));
        addButton(new BarMenuButtonFx(0,0,0));
	}
	
	private void addButton(BarMenuButtonFx b) {
		b.setLength(_height-2*_buttonMarge);
		b.setPosY(0+_posY+_buttonMarge);
		b.setPosX(_buttons.size()*(_height+_buttonMarge)+_posX+_buttonMarge);
		_root.getChildren().add(b);
		_buttons.add(b);
	}
}
