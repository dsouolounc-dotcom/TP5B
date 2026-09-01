package nc.ldu.helpdeskapi.model;

public class Ticket {
	private Long id;
	private String titre;
	private String description;
	private String priorite;
	private boolean resolu;
	public Ticket() {
	}
	public Ticket(Long id, String titre, String description,
	String priorite, boolean resolu) {
	this.id = id;
	this.titre = titre;
	this.description = description;
	this.priorite = priorite;
	this.resolu = resolu;
	}
	public void resoudre() {
	this.resolu = true;
	}
	public void changerPriorite(String nouvellePriorite) {
	this.priorite = nouvellePriorite;
	}
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getTitre() { return titre; }
	public void setTitre(String titre) { this.titre = titre; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description =
	description; }
	public String getPriorite() { return priorite; }
	public void setPriorite(String priorite) { this.priorite = priorite; }
	public boolean isResolu() { return resolu; }
	public void setResolu(boolean resolu) { this.resolu = resolu; }
}