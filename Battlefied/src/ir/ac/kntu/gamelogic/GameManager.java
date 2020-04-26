package ir.ac.kntu.gamelogic;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    ArrayList <Soldier> teamA = new ArrayList<>();
    ArrayList <Soldier> teamB = new ArrayList<>();



    public void start(){
        System.out.println("Enter The Number of Players : ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        for(int i=0 ; i<number; i++){
            int random = RandomHelper.nextInt()%2;
            int caliber = RandomHelper.nextInt()%2;
            switch (random){
                case 0:
                    teamA.add(new Soldier(i+1, new AssaultRifle()));
                    break;
                case 1:
                    teamA.add(new Soldier(i+1, new SniperRifle(RandomHelper.nextBoolean(), caliber)));
                    break;
                default:
                    teamA.add(new Soldier(i+1, new AssaultRifle()));
                    break;
            }
        }
        for(int i=0 ; i<number; i++){
            int random = RandomHelper.nextInt()%2;
            int caliber = RandomHelper.nextInt()%2;
            switch (random){
                case 0:
                    teamB.add(new Soldier(i+1, new AssaultRifle()));
                    break;
                case 1:
                    teamB.add(new Soldier(i+1, new SniperRifle(RandomHelper.nextBoolean(),caliber)));
                    break;
                default:
                    teamB.add(new Soldier(i+1, new AssaultRifle()));
                    break;
            }
        }
        startLoop();
    }
    public void startLoop(){
        int round = 1;
        while (isAliveA() && isAliveB()){
            Soldier firstTeam = getRandomSoldier(teamA);
            Soldier secondTeam = getRandomSoldier(teamB);
            int firstShot = RandomHelper.nextInt(10)%2;
            int random = RandomHelper.nextInt(100);
            switch (firstShot){
                case 0:
                    if(firstTeam.getGun().getAccuracy() >= random){
                        secondTeam.setHealth(secondTeam.getHealth() - firstTeam.getGun().getDamage());
                        if(secondTeam.getHealth() <= 0){
                            secondTeam.setAlive(false);
                        }
                    }
                    break;
                case 1:
                    if(secondTeam.getGun().getAccuracy() >= random){
                        firstTeam.setHealth(firstTeam.getHealth() - secondTeam.getGun().getDamage());
                        if(firstTeam.getHealth() <= 0){
                            firstTeam.setAlive(false);
                        }
                    }
                    break;
                default:
                    break;
            }
            random = RandomHelper.nextInt(100);
            if(firstTeam.isAlive() && secondTeam.isAlive()){
                switch (firstShot){
                    case 1:
                        if(firstTeam.getGun().getAccuracy() >= random){
                            secondTeam.setHealth(secondTeam.getHealth() - firstTeam.getGun().getDamage());
                            if(secondTeam.getHealth() <= 0){
                                secondTeam.setAlive(false);
                            }
                        }
                        break;
                    case 0:
                        if(secondTeam.getGun().getAccuracy() >= random){
                            firstTeam.setHealth(firstTeam.getHealth() - secondTeam.getGun().getDamage());
                            if(firstTeam.getHealth() <= 0){
                                firstTeam.setAlive(false);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
            System.out.printf("----------Round %d----------\n",round++);
            System.out.println("Team A = " + firstTeam.toString());
            System.out.println("Team B = " + secondTeam.toString());

        }
        if(isAliveA()){
            System.out.println("Team A Won !!!!");
        }
        else {
            System.out.println("Team B won !!!!");
        }

    }
    public Soldier getRandomSoldier(ArrayList<Soldier> team){
        int rand = RandomHelper.nextInt(team.size());
        while (true){
            if(team.get(rand).isAlive()){
                return team.get(rand);
            }else{
                rand = RandomHelper.nextInt(team.size());
            }
        }
    }
    public boolean isAliveA(){
        for(Soldier soldier : teamA){
            if(soldier.isAlive()){
                return true;
            }
        }
        return false;
    }
    public boolean isAliveB(){
        for(Soldier soldier : teamB){
            if(soldier.isAlive()){
                return true;
            }
        }
        return false;
    }
}
