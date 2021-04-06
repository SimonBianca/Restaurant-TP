package presentation;

import javax.swing.JFrame;

public class GraphicAdministratorController{
	
	private JFrame administratorFrame;
	private AdministratorMainPanel administratorMainPanel;
	private WaiterMainPanel waiterMainPanel;
	private AddMenuItemPanel addMenuItemPanel;
	private AddBaseProductPanel addBaseProductPanel;
	private DeleteMenuItemPanel deleteMenuItemPanel;
	private EditMenuItemPanel editMenuItemPanel;
	private DeleteBaseProductPanel deleteBaseProductPanel;
	private DeleteCompositeProductPanel deleteCompositeProductPanel;
	private AddCompositeProductPanel addCompositeProductPanel;
	private ChangePricePanel changePricePanel;
	private AddBPToCPPanel addBPToCPPanel;
	private DeleteBPFromCPPanel deleteBPFromCPPanel;
	
	public void showAdministratorFrame() {
		administratorFrame=new JFrame();
		administratorFrame.setTitle("Administrator");
		administratorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		administratorFrame.setBounds(100,200,700,700);
		administratorFrame.setSize(500, 500);
		administratorFrame.setLocationRelativeTo(null);
		administratorFrame.setResizable(false);
		administratorFrame.setVisible(true);
	}
	
	public void showAdministratorMainPanel() {
		administratorFrame.getContentPane().removeAll();
		administratorMainPanel=new AdministratorMainPanel();
		administratorFrame.add(administratorMainPanel);
		administratorFrame.pack();
	}
	
	public void showWaiterMainPanel() {
		administratorFrame.getContentPane().removeAll();
		waiterMainPanel=new WaiterMainPanel();
		administratorFrame.add(waiterMainPanel);
		administratorFrame.pack();
	}
	
	public void showAddMenuItemPanel() {
		administratorFrame.getContentPane().removeAll();
		addMenuItemPanel=new AddMenuItemPanel();
		administratorFrame.add(addMenuItemPanel);
		administratorFrame.pack();
	}
	
	public void showAddBaseProductPanel() {
		administratorFrame.getContentPane().removeAll();
		addBaseProductPanel=new AddBaseProductPanel();
		administratorFrame.add(addBaseProductPanel);
		administratorFrame.pack();
	}
	
	public void showDeleteMenuItemPanel() {
		administratorFrame.getContentPane().removeAll();
		deleteMenuItemPanel=new DeleteMenuItemPanel();
		administratorFrame.add(deleteMenuItemPanel);
		administratorFrame.pack();
	}
	public void showDeleteBaseProductPanel() {
		administratorFrame.getContentPane().removeAll();
		deleteBaseProductPanel=new DeleteBaseProductPanel();
		administratorFrame.add(deleteBaseProductPanel);
		administratorFrame.pack();
	}
	public void showDeleteCompositeProductPanel() {
		administratorFrame.getContentPane().removeAll();
		deleteCompositeProductPanel=new DeleteCompositeProductPanel();
		administratorFrame.add(deleteCompositeProductPanel);
		administratorFrame.pack();
	}
	
	public void showEditMenuItemPanel() {
		administratorFrame.getContentPane().removeAll();
		editMenuItemPanel=new EditMenuItemPanel();
		administratorFrame.add(editMenuItemPanel);
		administratorFrame.pack();
	}
	
	public void showAddCompositeProductPanel() {
		administratorFrame.getContentPane().removeAll();
		addCompositeProductPanel=new AddCompositeProductPanel();
		administratorFrame.add(addCompositeProductPanel);
		administratorFrame.pack();
	}
	
	public void showChangePricePanel() {
		administratorFrame.getContentPane().removeAll();
		changePricePanel=new ChangePricePanel();
		administratorFrame.add(changePricePanel);
		administratorFrame.pack();
	}
	public void showAddBPToCPPanel() {
		administratorFrame.getContentPane().removeAll();
		addBPToCPPanel=new AddBPToCPPanel();
		administratorFrame.add(addBPToCPPanel);
		administratorFrame.pack();
	}
	
	public void showDeleteBPFromCPPanel() {
		administratorFrame.getContentPane().removeAll();
		deleteBPFromCPPanel=new DeleteBPFromCPPanel();
		administratorFrame.add(deleteBPFromCPPanel);
		administratorFrame.pack();
	}
	
	
	public DeleteBPFromCPPanel getDeleteBPFromCPPanel() {
		return deleteBPFromCPPanel;
	}

	public void setDeleteBPFromCPPanel(DeleteBPFromCPPanel deleteBPFromCPPanel) {
		this.deleteBPFromCPPanel = deleteBPFromCPPanel;
	}

	public AddBPToCPPanel getAddBPToCPPanel() {
		return addBPToCPPanel;
	}

	public void setAddBPToCPPanel(AddBPToCPPanel addBPToCPPanel) {
		this.addBPToCPPanel = addBPToCPPanel;
	}

	public ChangePricePanel getChangePricePanel() {
		return changePricePanel;
	}

	public void setChangePricePanel(ChangePricePanel changePricePanel) {
		this.changePricePanel = changePricePanel;
	}

	public AddCompositeProductPanel getAddCompositeProductPanel() {
		return addCompositeProductPanel;
	}

	public void setAddCompositeProductPanel(AddCompositeProductPanel addCompositeProductPanel) {
		this.addCompositeProductPanel = addCompositeProductPanel;
	}

	public DeleteBaseProductPanel getDeleteBaseProductPanel() {
		return deleteBaseProductPanel;
	}

	public void setDeleteBaseProductPanel(DeleteBaseProductPanel deleteBaseProductPanel) {
		this.deleteBaseProductPanel = deleteBaseProductPanel;
	}

	public DeleteCompositeProductPanel getDeleteCompositeProductPanel() {
		return deleteCompositeProductPanel;
	}

	public void setDeleteCompositeProductPanel(DeleteCompositeProductPanel deleteCompositeProductPanel) {
		this.deleteCompositeProductPanel = deleteCompositeProductPanel;
	}

	public EditMenuItemPanel getEditMenuItemPanel() {
		return editMenuItemPanel;
	}

	public void setEditMenuItemPanel(EditMenuItemPanel editMenuItemPanel) {
		this.editMenuItemPanel = editMenuItemPanel;
	}

	public DeleteMenuItemPanel getDeleteMenuItemPanel() {
		return deleteMenuItemPanel;
	}

	public void setDeleteMenuItemPanel(DeleteMenuItemPanel deleteMenuItemPanel) {
		this.deleteMenuItemPanel = deleteMenuItemPanel;
	}

	public JFrame getMainFrame() {
		return administratorFrame;
	}

	public void setMainFrame(JFrame administratorFrame) {
		this.administratorFrame = administratorFrame;
	}

	public AdministratorMainPanel getAdministratorMainPanel() {
		return administratorMainPanel;
	}

	public void setAdministratorMainPanel(AdministratorMainPanel administratorMainPanel) {
		this.administratorMainPanel = administratorMainPanel;
	}

	public WaiterMainPanel getWaiterMainPanel() {
		return waiterMainPanel;
	}

	public void setWaiterMainPanel(WaiterMainPanel waiterMainPanel) {
		this.waiterMainPanel = waiterMainPanel;
	}

	public AddMenuItemPanel getAddMenuItemPanel() {
		return addMenuItemPanel;
	}

	public void setAddMenuItemPanel(AddMenuItemPanel addMenuItemPanel) {
		this.addMenuItemPanel = addMenuItemPanel;
	}

	public AddBaseProductPanel getAddBaseProductPanel() {
		return addBaseProductPanel;
	}

	public void setAddBaseProductPanel(AddBaseProductPanel addBaseProductPanel) {
		this.addBaseProductPanel = addBaseProductPanel;
	}

	public JFrame getAdministratorFrame() {
		return administratorFrame;
	}

	public void setAdministratorFrame(JFrame administratorFrame) {
		this.administratorFrame = administratorFrame;
	}
	
	

}
