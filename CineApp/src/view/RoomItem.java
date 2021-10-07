package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.DataControl;

/**
 * Menu/Janela com informações detalhadas sobre a sala selecionada
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class RoomItem implements ActionListener {
	private JFrame window;
	private JLabel labelRoomNumber= new JLabel("Número da Sala: ");
	private JTextField roomNumber;
	private JLabel labelPrice= new JLabel("Preço da Sala: ");
	private JTextField price;
	private JLabel labelSeatAmount= new JLabel("Quantidade de assentos disponíveis: ");
	private JTextField seatAmount;
	private JCheckBox is3D;
	private JCheckBox acessability;
	private JButton deleteRoom = new JButton("Excluir");
	private JButton saveRoom = new JButton("Salvar");
	private String[] editedRoom= new String[6];
	private String[] newRoom = new String[5];
	private static DataControl data;
	private int position;
	private int option;
	private String windowLabel;
	
	/**
	 * Execução da operação selecionada no RoomSubMenu
	 * || (1) Cadastro de nova Sala
	 * || (2) edição/exclusão de sala selecioanada
	 * @param op
	 * @param d Recebe todas as informações de dados já cadastrados no sistema.
	 * @param room
	 * @param p Posição do item selecionado
	 */
	public void addEdit(int op, DataControl d, 
			RoomSubMenu room, int p) {
		
		option=op;
		data=d;
		position=p;
		
		if (op == 1) {
			windowLabel = "Cadastrar Sala";
			labelRoomNumber = new JLabel("Número: ");
		}
		if (op == 2) {
			windowLabel = "Sala: Informações";
			labelRoomNumber = new JLabel("Número: ");
		}
		window=new JFrame(windowLabel);
		
		switch(op) {
		
		case 1:
			roomNumber = new JTextField(200);
			price = new JTextField(200);
			seatAmount = new JTextField(200);
			is3D = new JCheckBox("A Sala é 3D?");
			acessability = new JCheckBox("A Sala possui acessibilidade?");
			saveRoom.setBounds(200, 200, 115, 30);
			this.window.add(saveRoom);
			
			break;
			
		case 2:
			roomNumber = new JTextField(String.valueOf(data.getRooms().get(p).getRoomNumber()), 200);
			price = new JTextField(String.valueOf(data.getRooms().get(p).getPrice()), 200);
			seatAmount = new JTextField(String.valueOf(data.getRooms().get(p).getSeatAmount()));
			is3D = new JCheckBox("A Sala é 3D?", data.getRooms().get(p).getIs3D());
			acessability = new JCheckBox("A Sala possui acessibilidade?", data.getRooms().get(p).getIsAcessabilty());
			saveRoom.setBounds(120, 200, 115, 30);
			deleteRoom.setBounds(245, 200, 115, 30);
			
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
		labelSeatAmount.setBounds(30, 80, 150, 25);
		seatAmount.setBounds(180, 80, 180, 25);
		is3D.setBounds(30, 140, 150, 25);
		acessability.setBounds(30, 170, 250, 25);
		
		this.window.add(labelRoomNumber);
		this.window.add(roomNumber);
		this.window.add(labelPrice);
		this.window.add(labelSeatAmount);
		this.window.add(seatAmount);
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
	
	
	/**
	 * Escuta pelos eventos de clique e concluí a operação. Atualizando os dados do sistema para refletirem em toda aplicação.
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == saveRoom) {
			try {
				boolean added;
				if(option==1) { //cadastro
					
					newRoom[0] =  seatAmount.getText();
					newRoom[1] =  roomNumber.getText();
					newRoom[2] =  price.getText();
					newRoom[3] =  String.valueOf(is3D.isSelected());
					newRoom[4] =  String.valueOf(acessability.isSelected());
					
					added = data.addRoom(newRoom);
					
				} else {
					// edição
					editedRoom[0] = Integer.toString(position); 
					
					editedRoom[1] = seatAmount.getText();
					editedRoom[2] =  roomNumber.getText();
					editedRoom[3] =  price.getText();
					editedRoom[4] =  String.valueOf(is3D.isSelected());
					editedRoom[5] =  String.valueOf(acessability.isSelected());
					added = data.editRoom(editedRoom);
				}
				if (added) {
					JOptionPane.showMessageDialog(null, "Sala Salva!", null, 1);
					window.dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Erro ao adicionar os dados!\n"
							+ "1| Tenha certeza de que todos os campos estejam preenchidos\n"
							+ "2| Insira somente números nos campos de 'Número da sala', 'Preço da sala' e 'Assentos disponíveis'", null, 
							0);
				}
			} catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Erro ao adicionar os dados!\n"
						+ "1| Tenha certeza de que todos os campos estejam preenchidos\n"
						+ "2| Insira somente números nos campos de 'Número da sala', 'Preço da sala' e 'Assentos disponíveis'", null, 
						0);
			}
		}
		if(source == deleteRoom) {
			
			boolean delete;
			delete = data.deleteRoom(position);
			if (delete) {
				JOptionPane.showMessageDialog(null, "Sala Excluída!", null, 1);
				window.dispose();
			}else {
				JOptionPane.showMessageDialog(null,"Erro ao excluir a sala!\n"
						+ "Tenha certeza de que essa sala não esteja cadastrada em nenhuma sessão", null, 
						0);
			}
			window.dispose();
			
		}
	}
}
