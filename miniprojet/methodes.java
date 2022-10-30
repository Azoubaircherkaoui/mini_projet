package miniprojet;
import java.util.Scanner;
import java.util.ArrayList;
public class methodes {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employe> employes = new ArrayList<>() ;

    public static void main(String[] args) {
        Employe.menu();
        int choix = sc.nextInt();

        while (choix<1 || choix>9){
            System.out.println("Donnez un numéro entre 1 et 9");
            Employe.menu();
            choix = sc.nextInt();
        }
        while (choix>=1 && choix<=9){
            switch (choix){
                case 1:
                    ajouterEmploye();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;

                case 2 :
                    modifierEmploye();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;

                case 3 :
                    supprimerEmploye();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;

                case 4 :
                    afficherEmploye();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;

                case 5 :
                    affichertousEmploye();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;

                case 6 :
                    salaireEmploye();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;

                case 7 :
                    maxAgeEmploye();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;

                case 8 :
                    minAgeEmploye();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;

                case 9 :
                    Quitter();
                    Employe.menu();
                    choix = sc.nextInt();
                    break;


            }
        }

    }
    
    
    //1-Ajouter un employé:
    static void ajouterEmploye(){
        System.out.println("Entrez votre matricule:");
           int matricule = sc.nextInt();
        System.out.println("Entrez votre nom:");
            String nom = sc.next();
        System.out.println("Entrez votre prenom:");
            String prenom = sc.next();
        System.out.println("Entrez votre age:");
            int age = sc.nextInt();
        System.out.println("Entrez votre salaire:");
            double salaire = sc.nextDouble();
        Employe e = new Employe(matricule, nom, prenom, age, salaire);
        employes.add(e);
    }
    
    
    //2-Modifier un employé:
    static void modifierEmploye(){
        System.out.println("Entrez le matricule d'employe que vous voulez modifier:");
        int matricule = sc.nextInt();

        for (int i=0; i<employes.size(); i++){
            if (employes.get(i).getMatricule() == matricule){
                System.out.println("Modifier le nom");
                    String nom = sc.next();
                    employes.get(i).setNom(nom);
                System.out.println("Modifier le prenom");
                    String prenom = sc.next();
                    employes.get(i).setPrenom(prenom);
                System.out.println("Modifier l'âge");
                    int age = sc.nextInt();
                    employes.get(i).setAge(age);
                System.out.println("Modifier le salaire");
                    double salaire = sc.nextDouble();
                    employes.get(i).setSalaire(salaire);
            }else {
                System.out.println("matricule introuvable!!");
            }
        }

    }
    
    
    //3-Supprimer un employé:
    static void supprimerEmploye(){
        if (employes.isEmpty()){
            System.out.println("La base de données est vide:");
        }else{
            System.out.println("Entrez le matricule d'employe que vous voulez supprimer:");
            int matricule = sc.nextInt();
            for (int i=0; i<employes.size(); i++){
                if (employes.get(i).getMatricule() == matricule){
                    employes.remove(i);
                    System.out.println("employé est supprimé avec succès");
                }else{
                    System.out.println("matricule introuvable!!");
                    }
                }
            }
        }

    
    
    
    //4-Afficher un employé:
    static void afficherEmploye(){
        if (employes.isEmpty()) {
            System.out.println("La base de données est vide:");
        }else {
            System.out.println("Entrez le matricule d'employe que vous voulez afficher");
            int matricule = sc.nextInt();
            for (int i = 0; i<employes.size(); i++){
                if (employes.get(i).getMatricule() == matricule){
                    employes.get(i).afficherEmp();
                }else {
                    System.out.println("Matricule non convenable:");
                }
                }
            }
        }

    
    
    //5-Afficher tous les employés:
    static void affichertousEmploye(){
        if (employes.isEmpty()) {
            System.out.println("La base de données est vide:");
        }else{
            for (int i=0; i<employes.size(); i++){
                employes.get(i).afficherEmp();
            }
        }
    }
    
    
    
    //6-Les employés ayant un salaire qui dépasse 10000:
    static void salaireEmploye(){
        if (employes.isEmpty()) {
            System.out.println("La base de données est vide:");
        }else{
            int nombreEmploye = 0;
            for (int i=0 ; i<employes.size(); i++ )
                if (employes.get(i).getSalaire()>10000){
                    nombreEmploye++;
                }
            System.out.println(nombreEmploye);
        }
    }
    
    
    
    //7-afficher l'âge maximal:
    static void maxAgeEmploye(){
        if (employes.isEmpty()) {
            System.out.println("La base de données est vide:");
        }else{
            int max = 0;
            for (int i = 0; i<employes.size(); i++){
                if (employes.get(i).getAge()>max){
                    max = employes.get(i).getAge();
                }
            }
            System.out.println(max);
        }
    }
    
    
    
    //8-Afficher l'âge minimale:
    static void minAgeEmploye(){
        if (employes.isEmpty()) {
            System.out.println("La base de données est vide:");
        }else{
            int min = 100;
            for (int i=0; i<employes.size(); i++){
                if (employes.get(i).getAge()<min)
                    min = employes.get(i).getAge();
            }
            System.out.println(min);
        }
    }
    
    
    
    //9-Quitter le programme:
    static void Quitter(){
        System.exit(0);
    }

}

