package mediatek2022;

public interface Utilisateur {
	String name();
	boolean isBibliothecaire();
	/*
	 * data() permet de récupérer les informations qui seraient nécessaires à des
	 * contrôles sur l'abonné (age, abonnement désactivé,...)
	 */	
	Object[] data();
}
