import java.util.TreeMap;

import javax.swing.GroupLayout.Alignment;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class DisplayFrame extends GridPane{
	public DisplayFrame(Database db)
	{
		constructFrame(db);
	}
	
	public void constructFrame(Database db){
		for(String s : db.hash.keySet())
		{
			constuctPlace(s, db.hash.get(s));
		}
	}
	int j = 0;
	private void constuctPlace(String s, TreeMap<String, String> treeMap) {
		Label t = new Label(s);
		t.setFont(Font.font(20));
		t.setAlignment(Pos.CENTER);
		this.add(t, 1, j);
		j++;
		int i = 0;
		for(String d : treeMap.keySet())
		{
			t = new Label(d);
			t.setMaxWidth(200);
			t.setWrapText(true);
			this.add(t, 0, i + j);
			t = new Label(treeMap.get(d));
			this.add(t, 2, i + j);
			i++;
		}
		j += i;
	}
}
