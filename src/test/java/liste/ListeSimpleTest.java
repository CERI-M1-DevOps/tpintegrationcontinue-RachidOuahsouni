package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    public void init() {
        listeATester = new ListeSimple();
    }

    @Test
    public void listeConstruiteVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    @Test
    public void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void toStringDonneTousLesNoeuds() {
        System.out.println(listeATester);
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        System.out.println(listeATester);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))",listeATester.toString());

    }

    @Test
    public void modifiePremier() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(4), Noeud(1))");
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    public void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))");
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    public void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals(listeATester.toString(),"ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(1))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(2))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    void modifiePremierVide(){
        listeATester.modifiePremier(1, 2);
        assertEquals("ListeSimple()", listeATester.toString());
    }

    @Test
    public void supprimeTousListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2))");
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    public void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    public void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    public void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    public void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
    public void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))");
    }

    @Test
    public void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3))");
    }

    @Test
    public void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))");
    }

    @Test
    public void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))");
    }

    @Test
    public void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))");
    }


    @Test
    void echangerDeuxNoeudsIdentiques() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud r1 = listeATester.tete;
        Noeud r2 = listeATester.tete;
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
    void modifierPremierTest() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);

        listeATester.modifiePremier(2, 5);
        assertEquals("ListeSimple(Noeud(3), Noeud(5), Noeud(1))", listeATester.toString());

        listeATester.modifiePremier(10, 15);
        assertEquals("ListeSimple(Noeud(3), Noeud(5), Noeud(1))", listeATester.toString());

        listeATester.modifiePremier(3, 7);
        assertEquals("ListeSimple(Noeud(7), Noeud(5), Noeud(1))", listeATester.toString());

        ListeSimple listeSingle = new ListeSimple();
        listeSingle.ajout(4);
        listeSingle.modifiePremier(4, 8);
        assertEquals("ListeSimple(Noeud(8))", listeSingle.toString());
    }


    @Test
    void supprimePremierTest() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);

        listeATester.supprimePremier(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
        assertEquals(2, listeATester.getSize());

        listeATester.supprimePremier(2);
        assertEquals("ListeSimple(Noeud(1))", listeATester.toString());
        assertEquals(1, listeATester.getSize());

        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals("ListeSimple(Noeud(4))", listeATester.toString());
        assertEquals(1, listeATester.getSize());

        listeATester.supprimePremier(10);
        assertEquals("ListeSimple(Noeud(4))", listeATester.toString());
        assertEquals(1, listeATester.getSize());

        ListeSimple emptyListe = new ListeSimple();
        emptyListe.supprimePremier(1);
        assertNull(emptyListe.tete);
        assertEquals(0, emptyListe.getSize());
    }

}

