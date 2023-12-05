class Produit{
    private String libelle;
    private String designation;
    private int NumProd;
    private float PrixProd;
    public Produit(String libelle, String designation, int numProd, float prixProd) {
        this.libelle = libelle;
        this.designation = designation;
        NumProd = numProd;
        PrixProd = prixProd;
    }
    public String getLibelle() {
        return libelle;
    }
    public String getDesignation() {
        return designation;
    }
    public int getNumProd() {
        return NumProd;
    }
    public float getPrixProd() {
        return PrixProd;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setNumProd(int numProd) {
        NumProd = numProd;
    }
    public void setPrixProd(float prixProd) {
        PrixProd = prixProd;
    }
    @Override
    public String toString() {
        return "Produit [libelle=" + libelle + ", designation=" + designation + ", NumProd=" + NumProd + ", PrixProd="
                + PrixProd + "]";
    }
    
}