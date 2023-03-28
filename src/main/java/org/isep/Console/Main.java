package org.isep.Console;

import org.isep.Core.*;

import java.util.Scanner;

public class Main {
    private static final int MAX_HEALTH_POINTS = 100;


    public static void main(String[] args) {
        System.out.println("Bienvenue à Poudlard!");

        System.out.println("Tout d'abord, vous devez choisir un nom de sorcier..");
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez le nom de votre sorcier : ");
        String wizardName = sc.nextLine();

        Wizard wizard = new Wizard(wizardName);

        Wand wand = new Wand("chêne", 12, Core.randomCore());
        Core core = Core.randomCore();

        wand.setCore(core);
        System.out.println("Ta baguette t'a choisi ! C'est du bois de " + wand.getWood() + " et elle mesure " + wand.getLength() + " pouces, avec comme coeur " + wand.getCore() + ".");

        System.out.println("Il est maintenant temps de choisir votre maison de Poudlard.");
        SortingHat sortingHat = new SortingHat();
        System.out.println("Votre maison est...");
        House randomHouse = sortingHat.randomHouse();
        System.out.println(randomHouse.getName() + " : " + randomHouse.getDescription());

// Stocker la maison du joueur dans une variable pour une utilisation ultérieure




        PV pv = new PV();
        int healthPoints = pv.getHealthPoints();
        System.out.println("LE JEU PEUT ENFIN COMMENCER, TU COMMENCES AVEC " + healthPoints + " POINTS DE VIE, À 0 POINTS TU MEURTS");
        Scanner scanner = new Scanner(System.in);

        System.out.println("LA PREMIERE EPREUVE: The Philosopher’s Stone");
        // créer l'ennemi Troll

        Enemy troll = new Enemy("Troll", 20, 10, 20, 10);

        // afficher le message de combat
        System.out.println("Un Troll sauvage apparaît dans les toilettes du donjon pour le battre, tu dois soulever un objet et le relâcher lorsqu’ils se trouvent au-dessus de sa tête !");
        System.out.println("Choisi le bon sort!");

        // tableau des sorts et des points de dégâts associés
        Spell[] spells = {Spell.LUMOS, Spell.WINGARDIUM_LEVIOSA};
        int[] damages = {Spell.LUMOS.getDamagePoints(), Spell.WINGARDIUM_LEVIOSA.getDamagePoints()} ;

// boucle de combat
        while (wizard.getHealthPoints() > 0 && troll.getHealthPoints() > 0) {
            System.out.println("Le Troll attaque " + wizard.getName() + " !");
            troll.trollAttack(wizard);

            // vérifier si le joueur est mort
            if (wizard.getHealthPoints() <= 0) {
                System.out.println(wizard.getName() + " est KO !");
                break;
            }

            // choix du sort
            System.out.println(wizard.getName() + ", que voulez-vous faire ?");
            for (int i = 0; i < spells.length; i++) {
                System.out.println((i+1) + ". " + spells[i].toString());
            }
            int choix = scanner.nextInt();

            // utiliser le sort choisi
            if (choix >= 1 && choix <= spells.length) {
                Spell spell = spells[choix-1];
                int damagePoints = damages[choix-1];
                System.out.println(wizard.getName() + " lance le sort " + spell.toString() + " sur le Troll !");
                troll.loseHealthPoints(damagePoints);
                System.out.println("Les points de dégâts de " + spell.toString() + " sont : " + damagePoints);
            } else {
                System.out.println("Choix invalide.");
            }

            // vérifier si le Troll est mort
            if (troll.getHealthPoints() <= 0) {
                System.out.println("Le Troll est vaincu, il s'est évanoui grâce à l'objet que vous lui avez balancé\n !");
                int choice = 0;

                while (choice != 1 && choice != 2) {
                    System.out.println("Voulez-vous récupérer des points de vie (1) ou augmenter vos points de dégâts (2) ?");
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        int maxHealingPoints = MAX_HEALTH_POINTS - wizard.getHealthPoints();
                        System.out.println("Quel sort voulez-vous utiliser pour gagner des points de vie ?");
                        PotionType[] potionTypes = {PotionType.VULNERA_SANENTUR, PotionType.EPISKEY};
                        for (int i = 0; i < potionTypes.length; i++) {
                            System.out.println((i+1) + ". " + potionTypes[i].getName());
                        }
                        int spellChoice = scanner.nextInt();
                        while (spellChoice < 1 || spellChoice > potionTypes.length) {
                            System.out.println("Choix invalide, veuillez réessayer.");
                            spellChoice = scanner.nextInt();
                        }
                        int healingPoints = potionTypes[spellChoice-1].getHealingPower();
                        while (healingPoints > maxHealingPoints) {
                            System.out.println("Vous ne pouvez pas récupérer autant de points de vie, vous dépassez vos PV MAX.");
                            System.out.println("Quel sort voulez-vous utiliser pour gagner des points de vie ?");
                            spellChoice = scanner.nextInt();
                            healingPoints = potionTypes[spellChoice-1].getHealingPower();
                        }
                        wizard.heal(healingPoints);
                    } else if (choice == 2) {
                        System.out.println("Vous avez choisi d'augmenter vos points de dégâts.");
                        System.out.println("Quel sort voulez-vous augmenter ?");
                        Spell[] attackSpells = {Spell.INCENDIO, Spell.BOMBARDIA, Spell.ACIO};
                        for (int i = 0; i < attackSpells.length; i++) {
                            System.out.println((i+1) + ". " + attackSpells[i].getName());
                        }
                        int spellChoice = scanner.nextInt();
                        while (spellChoice < 1 || spellChoice > attackSpells.length) {
                            System.out.println("Choix invalide, veuillez réessayer.");
                            spellChoice = scanner.nextInt();
                        }
                        int damagePoints = attackSpells[spellChoice-1].getDamagePoints();
                        wizard.increaseDamage();
                        System.out.println("BRAVO VOUS AVEZ REUSSI LE PREMIER NIVEAU.");


                    }

                    System.out.println("LE DEUXIÈME NIVEAU : The Chamber of Secrets");

                // créer l'ennemi Basilic
                    Enemy basilisk = new Enemy("Basilic", 50, 20, 30, 20);

            // afficher le message de combat
                    System.out.println("Vous êtes face au terrible basilic, vous devez le vaincre pour sauver l'école de Poudlard !");

                    // boucle de combat
                    while (wizard.getHealthPoints() > 0 && basilisk.getHealthPoints() > 0) {
                        // choix de l'action
                        System.out.println(wizard.getName() + ", que voulez-vous faire ?");
                        System.out.println("1. Lancer un sort");
                        System.out.println("2. Attaquer avec l'épée légendaire de Godric Gryffindor (disponible uniquement pour les Gryffondors)");
                        int choix1 = scanner.nextInt();
                        scanner.nextLine();
                        if (choix1 == 1) {
                            // choix du sort
                            System.out.println("Quel sort voulez-vous utiliser ?");
                            for (int i = 0; i < spells.length; i++) {
                                System.out.println((i+1) + ". " + spells[i].toString());
                            }
                            int spellChoice = scanner.nextInt();
                            scanner.nextLine();

                            // utiliser le sort choisi
                            if (spellChoice >= 1 && spellChoice <= spells.length) {
                                Spell spell = spells[spellChoice-1];
                                int damagePoints = damages[spellChoice-1];
                                System.out.println(wizard.getName() + " lance le sort " + spell.toString() + " sur le basilic !");
                                basilisk.loseHealthPoints(damagePoints);
                                System.out.println("Les points de dégâts de " + spell.toString() + " sont : " + damagePoints);
                            } else {
                                System.out.println("Choix invalide.");
                            }

                        } else if (choix == 2) {
                            House joueurMaison = wizard.getHouse();
                            // Vérifier si le joueur est à Gryffondor
                            House gryffondor = sortingHat.getHouseByName("Gryffondor");
                            if (joueurMaison != null && joueurMaison.equals(gryffondor)) { // Le joueur est à Gryffondor, donc il peut utiliser l'épée légendaire
                                System.out.println(wizard.getName() + " attaque avec l'épée légendaire de Godric Gryffondor !");
                                basilisk.loseHealthPoints(50);
                                System.out.println("Les points de dégâts de l'épée légendaire sont : 50");
                            } else { // Le joueur n'est pas à Gryffondor, donc il ne peut pas utiliser l'épée légendaire
                                System.out.println("Désolé, vous ne pouvez pas utiliser l'épée légendaire car vous n'êtes pas de la maison Gryffondor.");
                            }
                        } else {
                            System.out.println("Choix invalide.");
                        }

// vérifier si le basilic est mort
                        if (basilisk.getHealthPoints() <= 0) {
                            System.out.println("Voulez-vous utiliser un de ces crocs pour détruire le journal de Tom Jedusor ?");
                            System.out.println("1. Oui");
                            System.out.println("2. Non");
                            String choix5 = scanner.nextLine();
                            if (choix5.equalsIgnoreCase("1")) {
                                wizard.destroyJournal("Journal de Tom Jedusor");
                                System.out.println("Le journal est détruit, Voldemort ne peut plus utiliser ce journal pour revenir !");
                            } else {
                                System.out.println("Le journal est toujours en vie, attention !");
                            }
                            break;
                        }

                // tour du basilic
                        System.out.println("Le basilic attaque " + wizard.getName() + " !");
                        basilisk.basiliskAttack(wizard);



                        // vérifier si le joueur est mort
                        if (wizard.getHealthPoints() <= 0) {
                            System.out.println(wizard.getName() + " est KO !");
                            break;


                        }

                    }

                    System.out.println("TROISIÈME EPREUVE: Les Détraqueurs");

// créer l'ennemi Détraqueur
                    Enemy dementor = new Enemy("Détraqueur", 30, 0, 40, 30);

                    System.out.println("Les détraqueurs sont en train de semer la terreur à Poudlard. " + wizard.getName() + " doit les vaincre pour sauver l'école des sorciers.");



// boucle de combat
                    while (wizard.getHealthPoints() > 0 && dementor.getHealthPoints() > 0) {
                        System.out.println("Les détraqueurs attaquent " + wizard.getName() + " !");
                        dementor.dementorAttack(wizard);

                        // vérifier si le joueur est mort
                        if (wizard.getHealthPoints() <= 0) {
                            System.out.println(wizard.getName() + " est KO !");
                            break;
                        }

                        // choix du sort
                        System.out.println(wizard.getName() + ", que voulez-vous faire ?");
                        for (int i = 0; i < spells.length; i++) {
                            System.out.println((i+1) + ". " + spells[i].toString());
                        }

                        int choix3 = scanner.nextInt();

                        // utiliser le sort choisi
                        if (choix3 >= 1 && choix3 <= spells.length) {
                            Spell spell = spells[choix3-1];
                            int damagePoints = damages[choix3-1];
                            System.out.println(wizard.getName() + " lance le sort " + spell.toString() + " sur les détraqueurs !");
                            dementor.loseHealthPoints(damagePoints);
                            System.out.println("Les points de dégâts de " + spell.toString() + " sont : " + damagePoints);
                        } else {
                            System.out.println("Choix invalide.");
                        }

                        // vérifier si le Détraqueur est mort
                        if (dementor.getHealthPoints() <= 0) {
                            System.out.println("Les Détraqueurs se sont enfuis");
                            int choice2 = 0;

                            while (choice2 != 1 && choice2 != 2) {
                                System.out.println("Voulez-vous récupérer des points de vie (1) ou augmenter vos points de dégâts (2) ?");
                                choice2 = scanner.nextInt();
                                if (choice2 == 1) {
                                    int maxHealingPoints = MAX_HEALTH_POINTS - wizard.getHealthPoints();                                    System.out.println("Quel sort voulez-vous utiliser pour gagner des points de vie ?");
                                    PotionType[] potionTypes = {PotionType.VULNERA_SANENTUR, PotionType.EPISKEY};
                                    for (int i = 0; i < potionTypes.length; i++) {
                                        System.out.println((i+1) + ". " + potionTypes[i].getName());
                                    }
                                    int spellChoice2 = scanner.nextInt();
                                    while (spellChoice2 < 1 || spellChoice2 > potionTypes.length)
                                    {
                                        System.out.println("Choix invalide, veuillez réessayer.");
                                        spellChoice2 = scanner.nextInt();
                                    }
                                    int healingPoints = potionTypes[spellChoice2-1].getHealingPower();
                                    while (healingPoints > maxHealingPoints) {
                                        System.out.println("Vous ne pouvez pas récupérer autant de points de vie, vous dépassez vos PV MAX.");
                                        System.out.println("Quel sort voulez-vous utiliser pour gagner des points de vie ?");
                                        spellChoice2 = scanner.nextInt();
                                        healingPoints = potionTypes[spellChoice2-1].getHealingPower();
                                    }
                                    wizard.heal(healingPoints);
                                } else if (choice2 == 2) {
                                    System.out.println("Vous avez choisi d'augmenter vos points de dégâts.");
                                    System.out.println("Quel sort voulez-vous augmenter ?");
                                    Spell[] attackSpells = {Spell.INCENDIO, Spell.BOMBARDIA};
                                    for (int i = 0; i < attackSpells.length; i++) {
                                        System.out.println((i+1) + ". " + attackSpells[i].getName());
                                    }
                                    int spellChoice2 = scanner.nextInt();
                                    while (spellChoice2 < 1 || spellChoice2 > attackSpells.length) {
                                        System.out.println("Choix invalide, veuillez réessayer.");
                                        spellChoice2 = scanner.nextInt();
                                    }
                                    int damagePoints = attackSpells[spellChoice2-1].getDamagePoints();
                                    wizard.increaseDamage();
                                    System.out.println("BRAVO VOUS AVEZ REUSSI LE TROISIEME NIVEAU.");

                                    System.out.println("QUATRIEME EPREUVE: Le gobelet de feu");


                                    // Positions des personnages
                                    int[] positionJoueur = {0, 0};
                                    int[] positionVoldemort = {10, 10};
                                    int[] positionPettigrew = {-10, -10};
                                    int[] positionPortkey = {3, 7}; // le portkey est placé à la position (3,7)

                                    System.out.println("Pour vous sortir de la utiliser le sort ACIO, Le sortilège Accio permet de faire venir un objet jusqu'au sorcier lançant le sort.");

                                    Spell[] spell = {Spell.ACIO, Spell.WINGARDIUM_LEVIOSA};
                                    int[] damage = {Spell.ACIO.getDamagePoints(), Spell.WINGARDIUM_LEVIOSA.getDamagePoints()} ;

                                    // choix du sort
                                    System.out.println(wizard.getName() + ", que voulez-vous faire ?");
                                    for (int i = 0; i < spell.length; i++) {
                                        System.out.println((i+1) + ". " + spell[i].toString());
                                    }
                                    int choix0 = scanner.nextInt();
                // Boucle de déplacement
                                    while (wizard.distance(positionJoueur, positionPortkey) > 1) {
                                        // Déplacement du joueur
                                        System.out.println("Où voulez-vous aller ?");
                                        System.out.print("x : ");
                                        int deplacementX = scanner.nextInt();
                                        System.out.print("y : ");
                                        int deplacementY = scanner.nextInt();
                                        positionJoueur[0] += deplacementX;
                                        positionJoueur[1] += deplacementY;

                                        // Déplacement de Voldemort
                                        int deplacementVoldemortX = (int)(Math.random() * 11);
                                        int deplacementVoldemortY = (int)(Math.random() * 11);
                                        if (Math.random() < 0.5) {
                                            deplacementVoldemortX *= -1;
                                        }
                                        if (Math.random() < 0.5) {
                                            deplacementVoldemortY *= -1;
                                        }
                                        positionVoldemort[0] += deplacementVoldemortX;
                                        positionVoldemort[1] += deplacementVoldemortY;

                                        // Déplacement de Peter Pettigrew
                                        int deplacementPettigrewX = (int)(Math.random() * 11);
                                        int deplacementPettigrewY = (int)(Math.random() * 11);
                                        if (Math.random() < 0.5) {
                                            deplacementPettigrewX *= -1;
                                        }
                                        if (Math.random() < 0.5) {
                                            deplacementPettigrewY *= -1;
                                        }
                                        positionPettigrew[0] += deplacementPettigrewX;
                                        positionPettigrew[1] += deplacementPettigrewY;
                                        System.out.println("Vous êtes à la position (" + positionJoueur[0] + "," + positionJoueur[1] + ")");
                                        System.out.println("Voldemort est à la position (" + positionVoldemort[0] + "," + positionVoldemort[1] + ")");
                                        System.out.println("Peter Pettigrew est à la position (" + positionPettigrew[0] + "," + positionPettigrew[1] + ")");
                                    }

                    // Attraction du portkey
                                    System.out.println("Vous êtes assez proche du Portkey !");
                                    System.out.println("Vous utilisez Accio !");
                                    System.out.println("*Le portkey vole à travers le cimetière et arrive dans votre main*");

                                }

                            }
                        }}
                }}}}}