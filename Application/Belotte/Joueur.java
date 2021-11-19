class Joueur
{
    // Définition des variables du joueur
    String name;
    int score;
    int compteur;
    Carte cartes[]; 

    // Définition du  constructeur
    public Joueur(String name)
    {
        this.name = name;
        this.score = 0;
        this.compteur = 0;
        this.cartes = new Carte[13];
    }

    // Définition de la méthode ajoutCarte()
    public void ajoutCarte(Carte carte)
    {
        this.cartes[this.compteur] = carte;
        this.compteur++;
    }

    // Définition de la méthode jouerEnPremier()
    public Carte jouerEnPremier()
    {
        if(this.compteur == 0) { return null;}
        else
        {
            int i = 0;
            Carte carteAjouer;
            while(i<13 && this.cartes[i]==null){ i++; }
            carteAjouer = this.cartes[i];
            this.cartes[i] = null;
            this.compteur--;
            return carteAjouer;
        }
    }

    // Définition de la méthode play()
    public Carte play(int signe)
    {
        for (int i = 0; i < 13; i++) 
        {
            if(this.cartes[i]!=null)
            {
                if(this.cartes[i].signe == signe)
                {
                    Carte carteAjouer = this.cartes[i];
                    this.cartes[i] = null;
                    this.compteur--;
                    return carteAjouer;
                }
            }
        }
        return this.jouerEnPremier(); // Au cas ou il ne trouve pas de carte de même signe
    }

    // Définition de la méhode tourGagnant()
    public void tourGagnant(Carte[] carte)
    {
        for (int i = 0; i < carte.length; i++) 
        {
            this.score+=carte[i].value;
        }
    }


    public void afficherCartes(){
        System.out.println("======= Les cartes de "+ this.name +"==========");
        for (int i = 0; i < this.compteur; i++) {
            if(this.cartes[i] == null){
                System.out.println("carte null");
            }else{
                System.out.println(this.cartes[i].printOut());  
            }
        }
        System.out.println("---------------------------------------------------------");

    }
    public String toString()
    {
        return  "Joueur: "+this.name+", Score: "+this.score+", Compteur: "+this.compteur;
    }

}