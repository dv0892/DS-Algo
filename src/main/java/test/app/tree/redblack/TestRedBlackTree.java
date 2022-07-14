package test.app.tree.redblack;

import test.app.tree.Tree;
import test.app.tree.bst.Node;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestRedBlackTree extends Application{

	public TestRedBlackTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree<Integer> redBlackTree = new RedBlackTree<>();
        /*redBlackTree.insert(10).insert(20).insert(5).insert(40).insert(50).insert(25).insert(60).insert(80).insert(85)
                .insert(90).insert(30).insert(15).insert(75).insert(100).insert(55).insert(45).insert(0).insert(26);*/
        redBlackTree.insert(10).insert(20).insert(30).insert(25).insert(35);
        
        redBlackTree.traverse();
        redBlackTree.delete(60);
        redBlackTree.traverse();

        System.out.println("Max is: " + redBlackTree.getMax());
        System.out.println("Min is: " + redBlackTree.getMin());
		
        //launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		
        
        
        //list View for educational qualification
        
        TreeItem<Node> base1 = new TreeItem<>();
        //Creating a TreeView item
        TreeView view = new TreeView(base1);
        view.setPrefHeight(300);
        VBox pane = new VBox(10);
        pane.setPadding(new Insets(5, 5, 5, 50));
        pane.getChildren().addAll(view);
        //Setting the stage
        Group node = new Group(pane);
        Scene scene = new Scene(node, 595, 320, Color.BEIGE);
        stage.setTitle("List View Example");
        stage.setScene(scene);
        stage.show();
		
	}

}
