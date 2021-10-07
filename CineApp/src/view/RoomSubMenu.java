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

/**
 * Submenu para operações relacionados com as salas de cinema.
 * @author Mauricio Machado
 * @version 1.0 (Out 2021)
 */
public class RoomSubMenu implements ActionListener, ListSelectionListener {
	private JFrame window;
	private JLabel title;
	private JButton createRoom;
	private JButton refreshRoom;
	private static DataControl data;
	private JList<String> listRooms;
	private String[] roomsNumbers = new String[100];
	
	/**
	 * Geração do submenu de salas.
	 * || (1) Permite adicionar novas salas
	 * || (2) Permite atualizar a tela, para mostrar novas salas cadastrados
	 * || (3) Permite editar salas já cadastradas
	 * || (4) Permite excluir salas já cadastradas
	 * @param d Passagem dos dados já cadastrados no início da aplicação.
	 */
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
			listRooms.setBounds(100, 50, 300, 160);
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
	
	/**
	 * Escuta eventos de clique em botões.
	 * || (1) Adicionar sala
	 * || (2) Atualizar lista
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == createRoom) {
			new RoomItem().addEdit(1, data, this, 1);
		}
		//atualiza
		if(src == refreshRoom) {
			listRooms.setListData(new RoomControl(data).getRoomsNumber());
			listRooms.updateUI();
		}
		
	}

	/**
	 * Escuta eventos de seleção na JList
	 * || (1) Editar/excluir sala selecionada
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();

		if(e.getValueIsAdjusting() && source == listRooms) {
			new RoomItem().addEdit(2, data, this, 
				listRooms.getSelectedIndex());
		}
		
	}
}
