class Belotte
{
    public Carte cartes[];
    public Joueur joueurs[];

    // Définition du constructeur
    public Belotte()
    {
        // Création et initialisation de la table joueurs[]
        this.joueurs = new Joueur[4];
        this.joueurs[0] = new Joueur("Doudou");
        this.joueurs[1] = new Joueur("Lamine");
        this.joueurs[2] = new Joueur("Fatou");
        this.joueurs[3] = new Joueur("Dieynaba");

        // Création des cartes
        this.cartes = new Carte[52];
        int compteur=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                this.cartes[compteur] = new Carte(i, Integer.toString(j), j);
                compteur++;
            }
        }

        // Distribution des cartes
        for (int i = 0; i < this.joueurs.length; i++) 
        {
            for (int j = 0; j < 13; j++) 
            {
                int rand ;
                do
                {
                    rand = (int)(Math.random()*(52)) ;
                }while(this.cartes[rand]==null);
                
                this.joueurs[i].ajoutCarte(this.cartes[rand]);
                this.cartes[rand]=null;
            }
        }
    }

    public static void main(String[] args)
    {
        Belotte party = new Belotte();

        // On tire au hasard le premier joueur qui va jouer
        int starter = (int)(Math.random()*(4));
        int tours= 1;

        while(tours<=13)
        {
            System.out.println("   ========= Tour "+tours+" ============");
            System.out.println("-- "+party.joueurs[starter].name+" commence --");
            Carte cartesJouees[] = new Carte[4];
            cartesJouees[0] = party.joueurs[starter].jouerEnPremier();
            Carte carteGagnant = cartesJouees[0];
            Joueur joueurGagnant = party.joueurs[starter];
            System.out.println("Carte jouee: "+cartesJouees[0].printOut());
            int j = 1;
            for (int i = 0; i < 4; i++) 
            {
                if(i!=starter)
                {
                    System.out.println("-- "+party.joueurs[i].name+" joue --");
                    cartesJouees[j] = party.joueurs[i].play(cartesJouees[0].signe);
                    System.out.println("Carte jouee: "+cartesJouees[j].printOut());
                    if(cartesJouees[j].signe == carteGagnant.signe && cartesJouees[j].value>carteGagnant.value)
                    {
                        carteGagnant = cartesJouees[j];
                        joueurGagnant = party.joueurs[i];
                    }
                    j++;
                }
            }
            int pointGagne = 0;
            for (int i = 0; i < 4; i++) 
            {
                pointGagne+=cartesJouees[i].value;
            }
            System.out.println("****************************************");
            System.out.println("Carte gagant: "+carteGagnant.printOut());
            System.out.println("Joueur gagant: "+joueurGagnant.name+", Point Gagne: "+pointGagne);
            
            for (int i = 0; i < party.joueurs.length; i++) 
            {
                if(party.joueurs[i].name == joueurGagnant.name)
                {
                    party.joueurs[i].tourGagnant(cartesJouees);
                    System.out.println(party.joueurs[i].toString());
                    starter = i;
                    break;
                }
            }
            System.out.println("*****************************************");
            tours++;
        }

        for (int i = 0; i < party.joueurs.length; i++) 
        {
            System.out.println(party.joueurs[i].toString());
        }
        int maxScore=0;
        int vainqueur=0;
        for (int i = 0; i < party.joueurs.length; i++) 
        {
            if(party.joueurs[i].score > maxScore)
            {
                maxScore = party.joueurs[i].score;
                vainqueur = i;
            }
        }
        System.out.println("   ========= Le gagant de la partie est: "+party.joueurs[vainqueur].toString()+" ============");
        
    }
}