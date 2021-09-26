package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.DataControl;

public class RoomItem implements ActionListener {
	private JFrame window;
	private JLabel labelRoomNumber= new JLabel("Número da Sala: ");
	private JTextField roomNumber;
	private JLabel labelPrice= new JLabel("Preço da Sala: ");
	private JTextField price;
	private JCheckBox is3D;
	private JCheckBox acessability;
	private JButton deleteRoom = new JButton("Excluir");
	private JButton saveRoom = new JButton("Salvar");
	private String[] editedRoom= new String[5];
	private String[] newRoom = new String[4];
	private static DataControl data;
	private int position;
	private int option;
	private String windowLabel;
	
	public void addEdit(int op, DataControl d, 
			RoomSubMenu room, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Cadastrar Filme";
			labelRoomNumber = new JLabel("Número: ");
		}
		if (op == 2) {
			windowLabel = "Filme: Informações";
			labelRoomNumber = new JLabel("Número: ");
		}
		window=new JFrame(windowLabel);
		
		switch(op) {
		
		case 1:
			roomNumber = new JTextField(200);
			price = new JTextField(200);
			is3D = new JCheckBox("A Sala é 3D?");
			acessability = new JCheckBox("A Sala possui acessibilidade?");
			saveRoom.setBounds(245, 190, 115, 30);
			this.window.add(saveRoom);
			
			break;
			
		case 2:
			roomNumber = new JTextField(String.valueOf(data.getRooms().get(p).getRoomNumber()), 200);
			price = new JTextField(String.valueOf(data.getRooms().get(p).getPrice()), 200);
			is3D = new JCheckBox("A Sala é 3D?", data.getSnacks().get(p).getIsSweet());
			acessability = new JCheckBox("A Sala possui acessibilidade?", data.getRooms().get(p).getIsAcessabilty());
			saveRoom.setBounds(120, 190, 115, 30);
			deleteRoom.setBounds(245, 190, 115, 30);
			
			this.window.add(saveRoom);
			this.window.add(deleteRoom);
			
			break;
		
		default:
			break;
		
		}
		
		labelRoomNumber.setBounds(30, 20, 150, 25);
		roomNumber.setBounds(180, 20, 180, 25);
		labelPrice.setBounds(30, 50, 150, 25);
		price.setBounds(180, 50, 180, 25);
		is3D.setBounds(30, 140, 150, 25);
		acessability.setBounds(30, 170, 250, 25);
		
		this.window.add(labelRoomNumber);
		this.window.add(roomNumber);
		this.window.add(labelPrice);
		this.window.add(price);
		this.window.add(is3D);
		this.window.add(acessability);

		this.window.setLayout(null);

		window.setSize(500, 350);
		window.setLocationRelativeTo(null);
		this.window.setVisible(true);

		deleteRoom.addActionListener(this);
		saveRoom.addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == saveRoom) {
			if(option==1) { //cadastro de um lanche
				newRoom[0] =  roomNumber.getText();
				newRoom[1] =  price.getText();
				newRoom[2] =  String.valueOf(is3D.isSelected());
				newRoom[3] =  String.valueOf(acessability.isSelected());
				data.addRoom(newRoom);
				
			} else {
				// edição de um lanche cadastrado
				editedRoom[0] = Integer.toString(position); 
				
				editedRoom[1] =  roomNumber.getText();
				editedRoom[2] =  price.getText();
				editedRoom[3] =  String.valueOf(is3D.isSelected());
				editedRoom[4] =  String.valueOf(acessability.isSelected());
				data.editRoom(editedRoom);
			}
		}
		if(source == deleteRoom) {
			data.deleteRoom(position);
		}
	}
}
