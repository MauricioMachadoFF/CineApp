package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.*;

public class RoomSubMenu implements ActionListener, ListSelectionListener {
	private JFrame window;
	private JLabel title;
	private JButton createRoom;
	private JButton refreshRoom;
	private static DataControl data;
	private JList<String> listRooms;
	private String[] roomsNumbers = new String[100];
	
	public void showData(DataControl d){
		data = d;

			roomsNumbers = new RoomControl(data).getRoomsNumber();
			listRooms = new JList<String>(roomsNumbers);
			listRooms.setLayoutOrientation(JList.VERTICAL);
			
			
			window = new JFrame("Salas");
			title = new JLabel("Salas Cadastrados");
			createRoom = new JButton("Novo Sala");
			refreshRoom = new JButton("Atualizar");

			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setBounds(150, 10, 250, 30);
			listRooms.setBounds(100, 50, 150, 160);
			listRooms.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listRooms.setVisibleRowCount(30);

			createRoom.setBounds(10, 250, 150, 30);
			refreshRoom.setBounds(330, 250, 150, 30);

			window.setLayout(null);

			window.add(title);
			window.add(listRooms);
			window.add(createRoom);
			window.add(refreshRoom);

			window.setSize(500, 350);
			window.setLocationRelativeTo(null);
			window.setVisible(true);

			createRoom.addActionListener(this);
			refreshRoom.addActionListener(this);
			listRooms.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == createRoom) {
			new RoomItem().addEdit(1, data, this, 1);
		}
		//atualiza a lista de lanches
		if(src == refreshRoom) {
			listRooms.setListData(new RoomControl(data).getRoomsNumber());
			listRooms.updateUI();
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listRooms) {
			new RoomItem().addEdit(2, data, this, 
				listRooms.getSelectedIndex());
		}
		
	}
}
