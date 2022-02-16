/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class batallasPersonajes {
    
    private Personaje p1;
    private Personaje p2;
    private int veces8 = 3;
    
    public batallasPersonajes(){
        
    }
    
    public batallasPersonajes(Personaje per1, Personaje per2){
        this.p1 = per1;
        this.p2 = per2;
    }
    
    //devuleve 0 si gana el jugador 1, 1 para el jugador 2
    public int pelear(){
        int resultado = 2;
        final int critic = 85;
        final double multiplicador = 1.3;
        
        try{

            int vidap1 = p1.getPuntosvida();
            int vidap2 = p2.getPuntosvida();
            
            int manap1 = p1.getPuntosmana();
            int manap2 = p2.getPuntosmana();
            
            int armadurap1 = p1.getPuntosarmadura();
            int armadurap2 = p2.getPuntosarmadura();
            
            int danyop1 = p1.getPuntosdanyo();
            int danyop2 = p2.getPuntosdanyo();
            
            do{
                int dadoP2 = (int) (Math.random()*6+1);
                
                int dadoP1 = seleccionDado(dadoP2);
                
                int criticPorGolpe = (int) (Math.random()*100+1);
                
                System.out.println("|--> DADO Per2 = " + dadoP2 + "|--> DADO Per1 = " + dadoP1 + "|--> Critico  = " + criticPorGolpe);
                System.out.println("VIDA ARMADURA Per1>" + vidap1 +" " + armadurap1 + "< | VIDA ARMADURA Per2>"+ vidap2 + " " + armadurap2+"<");
                boolean atacaJ1 = true;
                int danyoTotal = 0;
                
                if(dadoP1>dadoP2){
                    atacaJ1 = true;
                    
                    
                    danyoTotal = danyoTotal + danyop1; 
                    
                    if(criticPorGolpe>critic){
                        danyoTotal=(int) ((int)danyoTotal* multiplicador);
                        
                    }
                    
                    if(armadurap2>0){
                        armadurap2 = armadurap2 - danyoTotal;
                    }else{
                        vidap2 = vidap2 - danyoTotal;
                    }
                }else{
                    atacaJ1 = false;
                    
                    
                    danyoTotal = danyoTotal + danyop1; 
                    
                    if(criticPorGolpe>critic){
                        danyoTotal=(int) ((int)danyoTotal* multiplicador);
                        
                    }
                    
                    if(armadurap1>0){
                        armadurap1 = armadurap1 - danyoTotal;
                    }else{
                        vidap1 = vidap1 - danyoTotal;
                    }
                    
                }
                
                if(atacaJ1)
                    JOptionPane.showMessageDialog(null, "Jugador 1 ha hecho daño! Cantidad Daño= "+ danyoTotal +
                                                    "\nPersonaje1: Vida-> " + vidap1 + " Armadura-> " + armadurap1 +
                                                    "\n Personaje2: Vida-> " + vidap2 + " Armadura-> " + armadurap2);
                else
                    JOptionPane.showMessageDialog(null, "Jugador 2 ha hecho daño! Cantidad Daño= "+ danyoTotal +
                                                    "\nPersonaje1: Vida-> " + vidap1 + " Armadura-> " + armadurap1 +
                                                    "\n Personaje2: Vida-> " + vidap2 + " Armadura-> " + armadurap2);                    
            }while(vidap1>0 && vidap2>0);
            
            if(vidap1>0){
                JOptionPane.showMessageDialog(null, "Jugador 1 gana");
                return 0;
            }else{
                JOptionPane.showMessageDialog(null, "Jugador 2 gana");
                return 1;
            }
        }catch(Exception e){
            e.printStackTrace(System.err);
            return 2;
        }
    }
    
    public int seleccionDado(int dadoP2){
        String[] opcionesDado = {"Dado de 6","Dado de 8"};
                
        int resp = JOptionPane.showOptionDialog(null, "El enemimgo ha sacado un " + dadoP2 + "\n ¿Que dado deseas utlizar?", "Title", JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE , null, opcionesDado, opcionesDado[0]);
                
        if(resp==1){
            veces8--;
            if(veces8<=-1){
                JOptionPane.showMessageDialog(null, "Ya no puedes utilizar mas el Dado de 8");
                seleccionDado(dadoP2);
            }
        }
        
        int dadoP1 = 0;
        if(resp==0)
            dadoP1 = (int) (Math.random()*6+1);
        else
            dadoP1 = (int) (Math.random()*8+1);
        
        return dadoP1;
    }
}
