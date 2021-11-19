public class Carte
{
    // Définition des attributs de la classe Carte
    public int signe;
    public String name;
    public int value;

    // Définition du constructeur
    public Carte(int signe, String name, int value)
    {
        this.signe = signe;
        this.name = name;
        this.value = value;
    }

    // Définition de la méthode printOut()
    public String printOut()
    {
        return "Nom: "+this.name+", Signe: "+this.signe+", Valeur: "+this.value;
    }
}