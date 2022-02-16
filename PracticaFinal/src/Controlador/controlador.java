/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Objetos;
import Modelo.Personaje;
import Modelo.batallasPersonajes;
import Modelo.conexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author usuario
 */
public class controlador {
    conexion cn = new conexion();
    
    public controlador(){
        
    }

    public ArrayList<Personaje> buscarPersonajes() {
        ArrayList<Personaje> l = new ArrayList<Personaje>();
        
        l = cn.seleccionarTodosPersonajes();
        
        
        return l;
    }

    public boolean insertarPersonaje(Personaje p) {
        boolean todook = cn.insertarPersonaje(p);
        
        if(todook){
            return true;
        }else{
            return false;
        }
        
    }

    public boolean eliminarPersonaje(int id) {
        boolean todook = cn.eliminarPersonaje(id);
        
        if(todook){
            return true;
        }else{
            return false;
        }
        
    }
    
    //@Override?
    public boolean insertarObjeto(String n, int p, String tipo) {
        Objetos o = new Objetos(n, p, tipo);
        
        boolean todoOk = cn.insertarObjeto(o);
        
        return todoOk;
    }

    public boolean insertarObjeto(String n, int p, String tipo, String dan, String arm) {
        int danyo = 0, armadura = 0;
        if(dan.length()==0){
            danyo = 0;
        }else{
            danyo = Integer.parseInt(dan);
        }
        
        if(arm.length()==0){
            armadura = 0;
        }else{
            armadura = Integer.parseInt(arm);
        }
        
        Objetos o = new Objetos(n, p, tipo, danyo, armadura);
        
        boolean todoOk = cn.insertarObjeto(o);
        
        return todoOk;        
    }

    public boolean insertarObjeto(String n, int p, String tipo, String dan, String arm, String des) {
        int danyo = 0, armadura = 0;
        
        if(dan.length()==0){
            danyo = 0;
        }else{
            danyo = Integer.parseInt(dan);
        }
        
        if(arm.length()==0){
            armadura = 0;
        }else{
            armadura = Integer.parseInt(arm);
        }
        
        Objetos o = new Objetos(n, p, tipo, danyo, armadura, des);
        
        boolean todoOk = cn.insertarObjeto(o);
        
        return todoOk; 
    }

    public String[] actualizarComboObjetos() {
        
        String[] array = cn.actualizarComboObj();
        
        
        return array;
    }

    public void agregarObjeto(String obj, int id) {
        boolean todoOk = cn.agregarObjeto(obj, id);
        
        if(todoOk)
            JOptionPane.showMessageDialog(null,"Se ha añadido el objeto");
        else
            JOptionPane.showMessageDialog(null,"Error al añadir");
    }

    public void agregarObjRandom(int id) {
        boolean todoOk = cn.agregarObjetoRandom(id);

        if(todoOk)
            JOptionPane.showMessageDialog(null,"Se ha añadido el objeto");
        else
            JOptionPane.showMessageDialog(null,"Error al añadir");
    }

    public ArrayList<Objetos> seleccionarObjetos(int id) {
        ArrayList<Objetos> lista = new ArrayList<>();
        lista = cn.seleccionarObjetosPersonaje(id);
        return lista;
    }

    public boolean actualizarPerosnaje(Personaje per) {
        boolean todoOk = cn.updatePersonaje(per);
        
        if(todoOk)
            return true;
        else            
            return false;
    }

    public void sacarPDFObjetos() {
         try {
            //Connection cn = conectar()
            Connection con = cn.conectar();
            
            
            JasperReport reporte = null;
            String path = "src\\reportes\\PDFObjetos.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null,con);
            JasperViewer v = new JasperViewer(jprint, true);
            v.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            v.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public boolean comprobarBatalla(Personaje p1, Personaje p2) {
        boolean todoOk = false;
        
        int id1 = p1.getId();
        int id2 = p2.getId();
        
        if(id1!=id2){
            return true; 
        }
                
        return todoOk;
    }

    public void comenzarBatalla(Personaje p1, Personaje p2) {

        batallasPersonajes a = new batallasPersonajes(p1, p2);
        
        int result = a.pelear();
        
        if(result==2){
            System.out.println("No se ha podido hacer o ha ocurrido un error");
        }
    }
    

}
